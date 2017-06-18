package com.vanging.hrms.persistence.actions;

import com.vanging.hrms.persistence.Persistence;
import com.vanging.hrms.persistence.models.Auth;
import com.vanging.hrms.persistence.models.Order;
import com.vanging.hrms.persistence.models.Profile;
import com.vanging.hrms.persistence.models.Timecard;
import org.hibernate.Session;

import java.util.Date;

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

    public static Object queryOrder(String order_id)
    {
        Session session = Persistence.getSession();

        Order order = session.get(Order.class, order_id);
        if(order == null)
        {
            return "";
        }
        else
        {
            return order;
        }
    }

    public static boolean updateOrder(String order_id, String customer_point_of_contact, String customer_billing_address, String products_purchased)
    {
        Session session = Persistence.getSession();

        Order order = session.get(Order.class, order_id);
        if(order == null)
        {
            return false;
        }
        else
        {
            order.setCustomer_point_of_contact(customer_point_of_contact);
            order.setCustomer_billing_address(customer_billing_address);
            order.setProducts_purchased(products_purchased);

            try
            {
                session.beginTransaction();
                session.save(order);
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
    }

    public static boolean setPayMethod(String id, String method, String detail)
    {
        Session session = Persistence.getSession();

        Profile profile = session.get(Profile.class, id);

        if(profile == null)
        {
            return false;
        }
        else
        {
            session.beginTransaction();
            try
            {
                profile.setPay_method(method);
                profile.setPay_detail(detail);

                session.save(profile);
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
    }

    public static boolean addTimecard(String pid, String uid, int start, int end)
    {
        Session session = Persistence.getSession();

        Timecard timecard = new Timecard();

        timecard.setProject_id(pid);
        timecard.setEmployee_id(uid);
        timecard.setStart_time(start);
        timecard.setEnd_time(end);
        timecard.setDate(new Date());

        try
        {
            session.beginTransaction();

            session.saveOrUpdate(timecard);
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
}
