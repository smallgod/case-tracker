/*
 * Copyright (c) 2019. smallGod.
 * This code is provided as is and is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.ura.casemgt.infrastructure.database;

/**
 * @author smallgod
 */
public interface Auditable {

    /**
     * Get system user-name of user performing given database action
     * for audit trail purposes.
     *
     * @return System user-name for user performing this action
     */
    String getUsername();
}

