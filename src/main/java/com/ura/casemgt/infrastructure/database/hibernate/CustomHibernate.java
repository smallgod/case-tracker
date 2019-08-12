package com.ura.casemgt.infrastructure.database.hibernate;

import com.ura.casemgt.core.exception.DatabaseException;
import com.ura.casemgt.core.utilities.ProcessingMutex;
import com.ura.casemgt.infrastructure.Logging.log4j.LoggerUtilities;

import org.apache.commons.lang.exception.ExceptionUtils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author smallGod
 */
public final class CustomHibernate {

    private static final LoggerUtilities logger
            = new LoggerUtilities(CustomHibernate.class);

    private SessionFactory sessionFactory;
    private Configuration configuration;

    private CustomHibernate() {
    }

    public static CustomHibernate getInstance() {
        return CustomHibernateSingletonHolder.INSTANCE;
    }

    private static class CustomHibernateSingletonHolder {
        private static final CustomHibernate INSTANCE = new CustomHibernate();
    }

    /**
     * Close the hibernate session factory after use
     */
    public void shutdown() throws HibernateException {

        if (!(sessionFactory == null || sessionFactory.isClosed())) {
            sessionFactory.close();
        }
    }

    /**
     * Build a new session Factory if not found.
     * with given properties
     *
     * @param propertiesFile
     * @throws NullPointerException
     * @throws FileNotFoundException
     * @throws HibernateException
     */
    public CustomHibernate addSessionFactory(final String propertiesFile)
            throws NullPointerException, FileNotFoundException, HibernateException {

        synchronized (ProcessingMutex.SESS_FACTORY_MUTEX) {

            if (propertiesFile == null) {
                throw new NullPointerException("No Properties file, " +
                        "re-create instance .withPropertiesFile(file)");
            }

            if (sessionFactory == null
                    || sessionFactory.isClosed()) {

                File file = new File(propertiesFile);
                if (!file.exists()) {
                    throw new FileNotFoundException("No Hibernate properties file found");
                }

                this.configuration = new Configuration();
                this.configuration.configure(file);
                this.configuration.setInterceptor(new AuditTrailInterceptor());

                this.sessionFactory = configuration.buildSessionFactory();
            }
            return this;
        }
    }

    private SessionFactory getSessionFactory()
            throws IllegalStateException {

        if (sessionFactory == null || sessionFactory.isClosed()) {
            throw new IllegalStateException("No session-factory found, re-build it");
        }
        return sessionFactory;
    }

    /**
     * Get a Hibernate database session
     *
     * @return a new or existing database session
     * @throws DatabaseException
     */
    public Session getSession() throws DatabaseException {

        try {

            Session session = this.getSessionFactory()
                    .getCurrentSession();

            if (!session.isOpen()) {
                session = this.getSessionFactory().openSession();
            }
            return session;

        } catch (NullPointerException
                | IllegalStateException
                | HibernateException exception) {
            throw new DatabaseException(exception);
        }
    }


    /**
     * Get a sessionless Hibernate database session
     *
     * @return a new or existing sessionless database session
     * @throws DatabaseException
     */
    public StatelessSession getStatelessSession()
            throws DatabaseException {

        try {

            return this.getSessionFactory()
                    .openStatelessSession();

        } catch (NullPointerException
                | IllegalStateException
                | HibernateException exception) {
            throw new DatabaseException(exception);
        }
    }

    public void closeSession(Session session) {

        if (session != null) {

            try {

                if (session.isConnected()) {
                    session.disconnect();
                }
                if (session.isOpen()) {
                    session.close();
                }

            } catch (HibernateException hbe) {
                logger.error("Error, closing session");
                logger.error(ExceptionUtils.getFullStackTrace(hbe));
            }
        }
    }

    public void closeSession(StatelessSession statelessSession) {

        if (statelessSession != null) {
            statelessSession.close();
        }
    }
}