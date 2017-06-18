package com.vanging.hrms.persistence.actions;

import com.vanging.hrms.persistence.Persistence;
import com.vanging.hrms.persistence.models.Profile;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdminTest
{
    @BeforeClass
    public static void setUp()
    {
        Persistence.development_config();
    }

    @AfterClass
    public static void tearDown()
    {
        Persistence.getSessionFactory().close();
    }

    @Test
    public void login()
    {
        Assert.assertTrue(Admin.login("admin", "admin"));
    }

    @Test
    public void addEmployee() throws Exception
    {
        boolean result = Admin.addEmployee
                (
                        "123",
                        "123",
                        "中文名",
                        "hour",
                        "1234567890",
                        100,
                        200,
                        10,
                        24
                );
        Assert.assertTrue(result);
    }

    @Test
    public void deleteEmployee()
    {
        boolean result = Admin.deleteEmployee("53140821");
        Assert.assertTrue(result);

        result = Admin.deleteEmployee("53140820");
        Assert.assertTrue(result);
    }

    @Test
    public void queryEmployee()
    {
        Profile profile = Admin.queryEmployee("123");
        Assert.assertNull(profile);

        try
        {
            addEmployee();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return;
        }

        profile = Admin.queryEmployee("123");
        String username = profile.getUsername();
        Assert.assertNotNull(username);
    }

    @Test
    public void updateEmployee() throws Exception
    {
        addEmployee();
        boolean result = Admin.updateEmployee
                (
                        "123",
                        "中文名",
                        "hour",
                        "1234567890000",
                        0,
                        0,
                        0,
                        0
                );
        Assert.assertTrue(result);

        result = Admin.updateEmployee
                (
                        "12",
                        "中文名",
                        "hour",
                        "1234567890000",
                        0,
                        0,
                        0,
                        0
                );
        Assert.assertFalse(result);
    }

    @Test
    public void worktime()
    {
        Employee.addTimecard("123", "123", 2, 4);
        int worktime = Admin.worktime("123", 1397702660303L, 1597702660303L);
        Assert.assertEquals(2, worktime);
    }

    @Test
    public void salary() throws Exception
    {
        Employee.addTimecard("123", "123", 2, 4);
        float salary = Admin.salary("123", 1397702660303L, 1597702660303L);
        System.out.println(salary);
    }
}