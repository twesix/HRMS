package com.vanging.hrms.persistence.actions;

import com.vanging.hrms.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class OccupyTest
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
    public void id() throws Exception
    {
        boolean result = Occupy.id("123");
        Assert.assertFalse(result);

        result = Occupy.id("0");
        Assert.assertFalse(result);
    }
}