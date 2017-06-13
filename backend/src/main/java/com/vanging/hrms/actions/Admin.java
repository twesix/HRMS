package com.vanging.hrms.actions;

import com.vanging.hrms.persistence.Persistence;
import com.vanging.hrms.persistence.models.Administrator;
import com.vanging.hrms.persistence.models.Auth;
import com.vanging.hrms.persistence.models.Profile;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Admin
{
    public static boolean login(long id, String password)
    {
        Session session = Persistence.getSession();
        Administrator administrator = session.get(Administrator.class, id);

        return !(administrator == null || ! administrator.getPassword().equals(password));
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
}
