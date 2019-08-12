package com.ura.casemgt.infrastructure.database.hibernate;

import com.ura.casemgt.core.Validate;
import com.ura.casemgt.core.exception.DatabaseException;
import com.ura.casemgt.core.exception.DisplayMsgException;
import com.ura.casemgt.core.exception.DuplicateTransactionException;

import com.ura.casemgt.infrastructure.database.hibernate.dto.BaseEntity;
import com.ura.casemgt.infrastructure.database.hibernate.dto.CaseFileDTO;
import org.hibernate.*;
import org.hibernate.QueryTimeoutException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.mapping.RootClass;

import javax.persistence.*;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PessimisticLockException;
import javax.persistence.criteria.*;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author smallGod
 */
public abstract class HibernateRepository<T> {

    private CustomHibernate database;

    public HibernateRepository() {
        this.database = CustomHibernate.getInstance();
    }

    /**
     * Save an entity to a database
     *
     * @param entity
     * @return
     * @throws DuplicateTransactionException
     * @throws DatabaseException
     */
    protected Number save(BaseEntity entity)
            throws DuplicateTransactionException,
            DatabaseException,
            NumberFormatException {

        Session session = database.getSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            Number entityId = (Number) session.save(entity);
            transaction.commit();

            return entityId;

        } catch (ConstraintViolationException cve) {

            Utils.rollBack(transaction);
            throw new DuplicateTransactionException(cve);

        } catch (HibernateException he) {

            Utils.rollBack(transaction);
            throw new DatabaseException(he);

        } catch (RollbackException pe) {

            Utils.rollBack(transaction);
            throw new DatabaseException(pe);

        } catch (PersistenceException pe) {

            Utils.rollBack(transaction);
            throw new DatabaseException(pe);

        } finally {
            System.out.println("----------------- closing db session ----------");
            database.closeSession(session);
        }
    }

    /**
     * Find an entity
     *
     * @param id
     * @return
     */
    //@Override
    protected BaseEntity find(Object id) {
        return null;
    }

    /**
     * Return all these entities
     *
     * @return
     */
    //@Override
    protected List<BaseEntity> findAll() {
        return null;
    }


    /**
     * Get max Column
     *
     * @param entityType
     * @param columnToCheck
     * @return
     * @throws DatabaseException
     */
    protected Number getMaxColumn(
            Class<BaseEntity> entityType,
            String columnToCheck)
            throws DatabaseException {

        Session session = database.getSession();
        Transaction transaction = null;
        DisplayMsgException err = null;
        Number maxRow = null;

        try {

            transaction = session.beginTransaction();

            DetachedCriteria maxCriteria = DetachedCriteria.forClass(entityType);
            maxCriteria.setProjection(Projections.max(columnToCheck));

            List<Number> oneRecordList = maxCriteria
                    .getExecutableCriteria(session).list();

            if (!oneRecordList.isEmpty()) {
                maxRow = oneRecordList.get(0);
                transaction.commit();
            }

        } catch (SQLGrammarException | NoResultException
                | IllegalArgumentException exception) {

            Utils.rollBack(transaction);
            err = new DatabaseException(exception);

        } catch (HibernateException he) {

            Utils.rollBack(transaction);
            err = new DatabaseException(he);

        } catch (RollbackException pe) {

            Utils.rollBack(transaction);
            err = new DatabaseException(pe);

        } catch (PersistenceException pe) {

            Utils.rollBack(transaction);
            err = new DatabaseException(pe);

        } finally {
            database.closeSession(session);
        }

        if (Validate.isNotNull(err)) {
            throw err;
        }
        return maxRow;
    }




    /**
     * Get max row
     *
     * @param entityType
     * @param columnToCheck
     * @return
     * @throws DatabaseException
     */
    protected BaseEntity getMostRecentRecord(
            Class<? extends BaseEntity> entityType,
            String columnToCheck)
            throws DatabaseException {

        Session session = database.getSession();
        Transaction transaction = null;
        DisplayMsgException err = null;
        BaseEntity result = null;

        try {

            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = builder.createQuery(entityType);

            Subquery<Long> sq = criteriaQuery.subquery(Long.class);
            Root<CaseFileDTO> root = sq.from(CaseFileDTO.class);
            sq.select(builder.max(root.<Long> get(columnToCheck)));

            Predicate predicate = builder.equal(root.<Long> get(columnToCheck), sq);

//            Parameter<Long> keyParameter = builder.parameter(Long.class);
//            Predicate idPredicate = builder.equal(root.<Long> get(MyEntity_.id), keyParameter);
//

            criteriaQuery
                    .select(root)
                    .where(predicate);

            TypedQuery<BaseEntity> query = session.createQuery(criteriaQuery);

            System.out.println(query.getResultList());
            result = query.getSingleResult();

            transaction.commit();

        } catch (NoResultException exception) {
            return null; //nothing to return

        } catch (SQLGrammarException
                | NonUniqueResultException
                | IllegalArgumentException
                | QueryTimeoutException
                | TransactionRequiredException
                | PessimisticLockException exception) {

            Utils.rollBack(transaction);
            err = new DatabaseException(exception);

        } catch (HibernateException he) {

            Utils.rollBack(transaction);
            err = new DatabaseException(he);

        } catch (RollbackException pe) {

            Utils.rollBack(transaction);
            err = new DatabaseException(pe);

        } catch (PersistenceException pe) {

            Utils.rollBack(transaction);
            err = new DatabaseException(pe);

        } finally {
            database.closeSession(session);
        }

        if (Validate.isNotNull(err)) {
            throw err;
        }
        return result;
    }
}
