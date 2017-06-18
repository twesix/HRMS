package com.vanging.hrms.persistence;

import org.junit.After;
import org.junit.Before;

public class PersistenceTest
{
    @Before
    public void setUp() throws Exception {
        Persistence.development_config();
    }

    @After
    public void tearDown() throws Exception {
        Persistence.destroySessionFactory();
    }
}