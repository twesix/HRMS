package com.vanging.hrms.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Persistence
{
    private static SessionFactory sessionFactory = null;
    private static Configuration configuration = null;
    private static StandardServiceRegistry standardServiceRegistry = null;
    private static MetadataSources metadataSource = null;
    private static Metadata metadata = null;

    static
    {
        production_config();
    }

    public static void development_config()
    {
        config("hibernate.test.cfg.xml");
    }

    public static void production_config()
    {
        config("hibernate.cfg.xml");
    }

    public static void config(String config_file_path)
    {

        standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure(config_file_path)
                .build();
        try
        {
            metadataSource = new MetadataSources(standardServiceRegistry);
            metadata = metadataSource.buildMetadata();
            sessionFactory = metadata.buildSessionFactory();
        }
        catch(Exception e)
        {
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static Session getSession()
    {
        return sessionFactory.openSession();
    }
}
