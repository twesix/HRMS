package com.vanging.hrms.actions;

import com.vanging.hrms.persistence.Persistence;
import com.vanging.hrms.persistence.models.Auth;
import org.hibernate.Session;

public class Occupy
{
    public static boolean id(String id)
    {
        Session session = Persistence.getSession();
        Auth auth = session.get(Auth.class, id);
        if(auth != null)
        {
            return true;
        }
        return false;
    }
}
