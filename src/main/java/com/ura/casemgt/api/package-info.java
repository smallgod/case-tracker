package com.ura.casemgt.api;

/**
 * API acts as the entry point to the domain, using terms and objects from the domain.
 * Wade notes that the API should only expose immutable objects to prevent developers
 * from using the exposed objects to gain access to the underlying domain, thus manipulating the domain.
 * The API is were Wade often will starting writing his code,
 * a method as a skeleton with a high level functional test around it,
 * thereafter adding logic to make the tests pass thus driving the implementation of the domain.
 *
 * This is same as the Application services layer but certainly different from the DDD concept of Services layer
 **/