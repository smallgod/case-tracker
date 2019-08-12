package com.ura.casemgt.core.specification;

import com.ura.casemgt.domain.shared.Specification;

/**
 * NOT decorator, used to create a new specifcation that is the inverse (NOT) of the given spec.
 */
public class NotSpecification<T> extends AbstractSpecification<T> {

  private Specification<T> specification;

  /**
   * Create a new NOT specification based on another spec.
   *
   * @param specification Specification instance to not.
   */
  public NotSpecification(final Specification<T> specification) {
    this.specification = specification;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isSatisfiedBy(final T candidate) {
    return !specification.isSatisfiedBy(candidate);
  }
}
