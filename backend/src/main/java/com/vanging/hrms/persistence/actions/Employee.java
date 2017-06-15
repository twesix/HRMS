package com.vanging.hrms.persistence.actions;

import com.vanging.hrms.persistence.Persistence;
import com.vanging.hrms.persistence.models.Auth;
import com.vanging.hrms.persistence.models.Order;
import org.hibernate.Session;

public class Employee
{
    public static boolean login(String id, String password)
    {
        Session session = Persistence.getSession();

        Auth auth = session.get(com.vanging.hrms.persistence.models.Auth.class, id);
        if(auth == null)
        {
            return false;
        }
        else
        {
            if(auth.getPassword().equals(password))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public static String addOrder(String customer_point_of_contact, String customer_billing_address, String products_purchased, String date)
    {
        Session session = Persistence.getSession();

        Order order = new Order();

        order.setCustomer_point_of_contact(customer_point_of_contact);
        order.setCustomer_billing_address(customer_billing_address);
        order.setProducts_purchased(products_purchased);
        order.setDate(date);

        try
        {
            session.save(order);
            return order.getOrder_id();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
}
