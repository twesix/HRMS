package com.vanging.hrms.actions;

import com.vanging.hrms.actions.Employee;
import com.vanging.hrms.persistence.Persistence;
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

    @Test
    public void login() throws Exception
    {
        Assert.assertFalse(Admin.login(123, "123"));
    }

    @Test
    public void addUser() throws Exception
    {
        Admin.addUser
                (123,
                        123,
                        null,
                        null,
                        null,
                        null,
                        null,
0,
                        0,
                        0
                        );
    }
}