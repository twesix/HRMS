package com.vanging.hrms.persistence.actions;

import com.vanging.hrms.persistence.Persistence;
import com.vanging.hrms.persistence.models.Administrator;
import com.vanging.hrms.persistence.models.Auth;
import com.vanging.hrms.persistence.models.Profile;
import com.vanging.hrms.persistence.models.Timecard;
import com.vanging.hrms.restful.response.SystemReport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Admin
{
    static
    {
        addAdministrator("admin", "admin");
    }
    public static boolean addAdministrator(String id, String password)
    {
        Session session = Persistence.getSession();

        Administrator administrator = new Administrator();

        administrator.setId(id);
        administrator.setPassword(password);

        session.beginTransaction();
        try
        {
            session.saveOrUpdate(administrator);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public static boolean login(String id, String password)
    {
        Session session = Persistence.getSession();
        Administrator administrator = session.get(Administrator.class, id);

        if(administrator == null)
        {
            return false;
        }
        else
        {
            if(password.equals(administrator.getPassword()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public static boolean addEmployee(String id, String password, String username, String usertype, String tel, float salary_per_hour, float salary_fixed, float salary_rate, int hour_limit)
    throws Exception
    {
        Session session = Persistence.getSession();
        Transaction transaction = session.getTransaction();

        Auth auth = new Auth();
        auth.setId(id);
        auth.setPassword(password);

        Profile profile = new Profile();
        profile.setId(id);
        profile.setUsername(username);
        profile.setUsertype(usertype);
        profile.setTel(tel);
        profile.setSalary_per_hour(salary_per_hour);
        profile.setSalary_fixed(salary_fixed);
        profile.setSalary_rate(salary_rate);
        profile.setHour_limit(hour_limit);

        try
        {
            transaction.begin();
            session.save(auth);
            session.save(profile);
            transaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        return true;
    }

    public static boolean deleteEmployee(String id)
    {
        Session session = Persistence.getSession();
        Transaction transaction = session.getTransaction();

        Auth auth = session.get(Auth.class, id);
        if(auth == null)
        {
            return false;
        }
        else
        {
            Profile profile = session.get(Profile.class, id);

            transaction.begin();
            try
            {
                session.delete(auth);
                session.delete(profile);
                transaction.commit();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                transaction.rollback();
                return false;
            }
        }
        return true;
    }

    public static Profile queryEmployee(String id)
    {
        Session session = Persistence.getSession();

        Profile profile = session.get(Profile.class, id);

        return profile;
    }

    public static boolean updateEmployee
            (
                    String id,
                    String username,
                    String usertype,
                    String tel,
                    float salary_per_hour,
                    float salary_fixed,
                    float salary_rate,
                    int hour_limit
            )
    {
        Session session = Persistence.getSession();

        Profile profile = session.get(Profile.class, id);

        if(profile == null)
        {
            return false;
        }
        else
        {

            profile.setUsername(username);
            profile.setUsertype(usertype);
            profile.setTel(tel);
            profile.setSalary_per_hour(salary_per_hour);
            profile.setSalary_fixed(salary_fixed);
            profile.setSalary_rate(salary_rate);
            profile.setHour_limit(hour_limit);

            Transaction transaction = session.getTransaction();
            transaction.begin();
            try
            {
                session.save(profile);
                session.flush();
                transaction.commit();
                session.close();
                return true;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                transaction.rollback();
                return false;
            }
        }
    }

    public static int worktime(String id, long start_num, long end_num)
    {
        int work_hours = 0;
        Date start = new Date(start_num);
        Date end = new Date(end_num);
        System.out.println(start);
        System.out.println(end);

        String hql = "from Timecard where employee_id = :id and date between :the_start and :the_end";

        Session session = Persistence.getSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.setParameter("the_start", start);
        query.setParameter("the_end", end);
        List<Timecard> timecards = query.list();
        if(timecards == null)
        {
            return work_hours;
        }
        for(Timecard timecard : timecards)
        {
            work_hours += timecard.getEnd_time() - timecard.getStart_time();
        }
        return work_hours;
    }

    public static float salary(String id, long start_num, long end_num)
    {
        float salary = 0;
        Session session = Persistence.getSession();
        Profile profile = session.get(Profile.class, id);
        if(profile == null)
        {
            return salary;
        }
        String usertype = profile.getUsertype();
        if(usertype.equals("hour"))
        {
            int worktime = Admin.worktime(id, start_num, end_num);
            salary += worktime * profile.getSalary_per_hour();
        }

        return salary;
    }
}
