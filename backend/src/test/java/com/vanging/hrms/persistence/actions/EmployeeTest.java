package com.vanging.hrms.persistence.actions;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    @Before
    public void setUp() throws Exception
    {
        Persistence.development_config();
    }

    @After
    public void tearDown() throws Exception
    {
        Persistence.destroySessionFactory();
    }

    @Test
    public void login() throws Exception
    {
        boolean result = Employee.login("123", "123");
        Assert.assertFalse(result);
    }

    @Test
    public void addOrder() throws Exception
    {
        String order_id = Employee.addOrder("uid","customer point of contact", "customer billing address", "products purchased", "date");
        Assert.assertNotEquals(order_id, "");
        System.out.println(order_id);
    }

    @Test
    public void deleteOrder() throws Exception
    {
        String order_id = Employee.addOrder("uid","customer point of contact", "customer billing address", "products purchased", "date");
        boolean result = Employee.deleteOrder("uid", order_id);
        Assert.assertTrue(result);
        result = Employee.deleteOrder("uid", "order_id");
        Assert.assertFalse(result);
    }

    @Test
    public void queryOrder()
    {
        String order_id = Employee.addOrder("uid","customer point of contact", "customer billing address", "products purchased", "date");
        Object order = Employee.queryOrder(order_id);
        Assert.assertNotEquals(order, "");
        System.out.println(JSON.toJSONString(order));
    }

    @Test
    public void updateOrder()
    {
        String order_id = Employee.addOrder("uid","customer point of contact", "customer billing address", "products purchased", "date");
        boolean result = Employee.updateOrder(order_id, "contact", "address", "products");
        Assert.assertTrue(result);
    }

    @Test
    public void setPayMethod()
    {
        boolean result = Employee.setPayMethod("id", "method", "detail");
        Assert.assertFalse(result);
    }

    @Test
    public void addTimecard()
    {
        boolean result = Employee.addTimecard("pid", "uid",4, 6);
        Assert.assertTrue(result);
        result = Employee.addTimecard("pid", "uid",4, 8);
        Assert.assertTrue(result);
    }
}