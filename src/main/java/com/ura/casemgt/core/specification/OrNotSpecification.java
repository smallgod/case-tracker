package com.ura.casemgt.core.specification;

import com.ura.casemgt.domain.shared.Specification;

/**
 * OR specification, used to create a new specifcation
 * that is the OR of two other specifications.
 */
public class OrNotSpecification<T> extends AbstractSpecification<T> {

    private Specification<T> leftCondition;
    private Specification<T> rightCondition;

    /**
     * Create a new OR specification based on two other spec.
     *
     * @param leftCondition  Specification one.
     * @param rightCondition Specification two.
     */
    public OrNotSpecification(final Specification<T> leftCondition,
                              final Specification<T> rightCondition) {
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isSatisfiedBy(final T candidate) {
        return leftCondition.isSatisfiedBy(candidate)
                || (rightCondition.isSatisfiedBy(candidate)!= true);
    }
}
