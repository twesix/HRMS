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

    public static String addOrder(String uid, String customer_point_of_contact, String customer_billing_address, String products_purchased, String date)
    {
        Session session = Persistence.getSession();

        Order order = new Order();

        order.setEmployee_id(uid);
        order.setCustomer_point_of_contact(customer_point_of_contact);
        order.setCustomer_billing_address(customer_billing_address);
        order.setProducts_purchased(products_purchased);
        order.setDate(date);

        try
        {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
            return order.getOrder_id();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            return "";
        }
    }

    public static boolean deleteOrder(String uid, String order_id)
    {
        Session session = Persistence.getSession();

        Order order = session.get(Order.class, order_id);
        if(order == null)
        {
            return false;
        }
        else
        {
            if(uid.equals(order.getEmployee_id()))
            {
                try
                {
                    session.beginTransaction();
                    session.delete(order);
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
            else
            {
                return false;
            }
        }
    }
}
