package com.vanging.hrms.actions;

import com.vanging.hrms.actions.Employee;
import com.vanging.hrms.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdminTest
{
    @BeforeClass
    public static void setUp()
    {
        Persistence.config("hibernate.test.cfg.xml");
    }

    @AfterClass
    public static void tearDown()
    {
        Persistence.getSessionFactory().close();
    }

    @Test
    public void login() throws Exception
    {
        Assert.assertFalse(Admin.login(123, "123"));
    }

    @Test
    public void addUser() throws Exception
    {
        boolean result = Admin.addEmployee(123, "123", "123", "", "hour", "123", 0, 0, 0, 0);
        Assert.assertTrue(result);
    }
}