package com.ura.casemgt.core.specification;

import com.ura.casemgt.domain.shared.Specification;

/**
 * AND specification, used to create a new specifcation
 * that is the AND of two other specifications.
 */
public class AndSpecification<T>
        extends AbstractSpecification<T> {

    private Specification<T> leftCondition;
    private Specification<T> rightCondition;

    /**
     * Create a new AND specification based on two other spec.
     *
     * @param leftCondition Specification one.
     * @param rightCondition Specification two.
     */
    public AndSpecification(final Specification<T> leftCondition,
                            final Specification<T> rightCondition) {
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSatisfiedBy(final T candidate) {
        return leftCondition.isSatisfiedBy(candidate)
                && rightCondition.isSatisfiedBy(candidate);
    }
}
