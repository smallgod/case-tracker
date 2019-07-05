package com.ura.casemgt.infrastructure.database.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class HibernateRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
