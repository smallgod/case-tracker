package com.ura.casemgt.infrastructure;

/**
 * Infrastructure is the outermost layer containing adapters for various technologies such as databases,
 * user interface and external services. It has access to all the inner layers but most operations should go through the API,
 * one exception being domain interfaces with infrastructure implementations.
 *
 * An important concept is dependencies, an outer layer can see an inner layer
 * but an inner layer has no knowledge of any outer layer.
 *
 * One way of verifying a design is to test different scenarios,
 * e.g. what happens if a new database or user interface technology is asked for.
 * By carefully following DDD and the Onion architecture principles Wade thinks
 * it will be possible to accommodate these kinds of changes.
 *
 **/