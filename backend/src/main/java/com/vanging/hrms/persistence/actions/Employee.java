package com.vanging.hrms.persistence.actions;

import com.vanging.hrms.persistence.Persistence;
import com.vanging.hrms.persistence.models.Auth;
import org.hibernate.Session;

public class Employee
{
    static boolean login(long id, String password)
    {
        Session session = Persistence.getSession();

        Auth auth = session.get(com.vanging.hrms.persistence.models.Auth.class, id);
        return !(auth == null || !auth.getPassword().equals(password));
    }
}
