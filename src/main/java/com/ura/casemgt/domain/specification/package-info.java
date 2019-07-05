package com.ura.casemgt.domain.specification;


/**
 * The specification pattern is a software design pattern used to codify business rules that state something about an object.
 * These simple predicates determine if an object’s state satisfies a certain business criteria.
 * They can then be combined to form composite specifications using logical operators.
 * <p>
 * Use a specification to encapsulate a business rule which does not belong inside entities or value objects,
 * but is applied to them. Use them to:
 * <p>
 * 1. make assertions (validation) about an object;
 * 2. fetch objects matching certain criteria from a collection (selection);
 * 3. specify how an object should be created (building to order).
 * <p>
 * Encapsulate the validation logic into a reusable class.
 * These classes are usually called specifications, validators or rules and are part of the domain.
 **/