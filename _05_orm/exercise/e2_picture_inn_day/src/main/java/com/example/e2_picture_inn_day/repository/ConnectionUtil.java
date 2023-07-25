package com.example.e2_picture_inn_day.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class ConnectionUtil {
    public static SessionFactory sessionFactory = getSessionFactory();
    public static EntityManager entityManager = getEntityManager();

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.conf.xml")
                .buildSessionFactory();
    }

    private static EntityManager getEntityManager() {
        return getSessionFactory().createEntityManager();
    }
}
