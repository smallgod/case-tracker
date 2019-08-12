package com.ura.casemgt.infrastructure.controllers;

import com.ura.casemgt.api.service.ServiceName;
import com.ura.casemgt.core.exception.NoServiceException;

import java.util.concurrent.*;

/**
 * @author smallGod
 */
public interface ChainProcessor extends Callable<String> {

    /**
     * Call next service in chain to
     * try and handle this request
     *
     * @param currentProcessorId
     * @param request
     * @param serviceName
     * @return
     * @throws RejectedExecutionException
     * @throws CancellationException
     * @throws InterruptedException
     * @throws TimeoutException
     * @throws ExecutionException
     * @throws NoServiceException
     */
    String moveToNextInChain(int currentProcessorId,
                             String request,
                             ServiceName serviceName)

            throws RejectedExecutionException,
            CancellationException,
            InterruptedException,
            TimeoutException,
            ExecutionException,
            NoServiceException;
}
