package com.ura.casemgt.infrastructure.controllers;

import com.ura.casemgt.api.service.ServiceName;
import com.ura.casemgt.core.exception.NoServiceException;
import com.ura.casemgt.core.exception.ProcessingException;
import com.ura.casemgt.infrastructure.appstart.ServiceWorkers;
import com.ura.casemgt.infrastructure.appstart.TaskExecutor;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author smallGod
 */
public abstract class ChainProcessorBase
        implements ChainProcessor {

    private final TaskExecutor taskExecutor
            = TaskExecutor.getInstance();

    protected int currentProcessorId;
    protected String request;
    protected ServiceName serviceName;

    public ChainProcessorBase() {
    }

    /**
     * Tries to handle request and moves to next processor
     * if un-handled by this processor
     *
     * @param currentProcessorId
     * @return true if we should move to next processor in chain
     */
    @Override
    public String moveToNextInChain(int currentProcessorId,
                                    String request,
                                    ServiceName serviceName) throws
            RejectedExecutionException,
            CancellationException,
            ProcessingException,
            //InterruptedException,
            //TimeoutException,
            //ExecutionException,
            NoServiceException {

        currentProcessorId += 1; // move to next ID

        this.currentProcessorId = currentProcessorId;
        this.request = request;
        this.serviceName = serviceName;

        if (currentProcessorId >= ServiceWorkers.NUM_OF_SERVICES) {
            throw new NoServiceException();

        } else {

            ChainProcessorBase processor
                    = ServiceWorkers.SERVICES[currentProcessorId];

            processor.request = request;
            processor.serviceName = serviceName;
            processor.currentProcessorId = currentProcessorId;

            try {

                return taskExecutor.submitTask(processor);

            } catch (InterruptedException | TimeoutException | ExecutionException exception) {
                throw new ProcessingException(exception);
            }
        }
    }
}
