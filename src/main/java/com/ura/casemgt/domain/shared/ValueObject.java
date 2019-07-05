package com.ura.casemgt.domain.shared;

import java.io.Serializable;

/**
 * @author smallGod
 **/
public interface ValueObject<T> extends Serializable {

    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     * And they are immutable!
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    boolean isSameAs(T other);

}
