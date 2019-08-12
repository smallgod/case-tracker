package com.ura.casemgt.infrastructure.database.hibernate;

import com.ura.casemgt.infrastructure.Logging.log4j.LoggerUtilities;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.hibernate.Transaction;

import javax.persistence.RollbackException;

/**
 * @author smallGod
 */
public class Utils {

    private static final LoggerUtilities logger
            = new LoggerUtilities(Utils.class);

    public static void rollBack(Transaction transaction) {
        if (transaction != null) {
            try {
                transaction.rollback();
            } catch (IllegalStateException | RollbackException exc) {
                logger.error("Error, rolling back failed transaction");
                logger.error(ExceptionUtils.getFullStackTrace(exc));
            }
        }
    }
}
