package com.vanging.hrms.persistence.actions;

import com.vanging.hrms.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

}