package com.ura.casemgt.domain.shared;

/**
 * Specificaiton base for creating specifications, and
 * only the method {@link #isSatisfiedBy(Object)} must be implemented.
 */
public interface Specification<T> {

  /**
   * Check if {@code t} is satisfied by the specification.
   *
   * @param t Object to test.
   * @return {@code true} if {@code t} satisfies the specification.
   */
  boolean isSatisfiedBy(T t);

  /**
   * Create a new specification that is the AND operation
   * of {@code this} specification and another specification.
   * @param other Specification to AND.
   * @return A new specification.
   */
  Specification<T> and(Specification<T> other);

  /**
   * Create a new specification that is the OR operation
   * of {@code this} specification and another specification.
   * @param other Specification to OR.
   * @return A new specification.
   */
  Specification<T> or(Specification<T> other);

  /**
   * Create a new specification that is the NOT operation
   * of {@code this} specification.
   * @param other Specification to NOT.
   * @return A new specification.
   */
  Specification<T> not(Specification<T> other);

  /**
   * Create a new specification that is the AndNOT operation
   * of {@code this} specification.
   * @param other Specification to AndNot.
   * @return A new specification.
   */
  Specification<T> andNot(Specification<T> other);

  /**
   * Create a new specification that is the OrNOT operation
   * of {@code this} specification.
   * @param other Specification to OrNOT.
   * @return A new specification.
   */
  Specification<T> orNot(Specification<T> other);
}
