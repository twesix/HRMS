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

    public static void addUser
            (
                    long id,
                    String password,
                    String username,
                    String pay_method,
                    String usertype,
                    String mailing_address,
                    String tel,
                    float hourly_rate,
                    float salary,
                    float commission_rate,
                    int hour_limit
            )
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
        profile.setPay_method(pay_method);
        profile.setUsertype(usertype);
        profile.setMailing_address(mailing_address);
        profile.setTel(tel);
        profile.setHourly_rate(hourly_rate);
        profile.setSalary(salary);
        profile.setCommission_rate(commission_rate);
        profile.setHour_limit(hour_limit);

        transaction.begin();
        session.save(auth);
        session.save(profile);
        transaction.commit();
    }
}
