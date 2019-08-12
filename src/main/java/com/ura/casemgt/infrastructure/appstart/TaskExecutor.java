package com.ura.casemgt.infrastructure.appstart;


import com.ura.casemgt.core.Validate;
import com.ura.casemgt.core.exception.DisplayMsgException;
import com.ura.casemgt.core.utilities.NamedConstants;
import com.ura.casemgt.core.utilities.ProcessingMutex;
import com.ura.casemgt.infrastructure.Logging.log4j.LoggerUtilities;

import java.util.concurrent.*;

/**
 * @author smallGod
 */
public class TaskExecutor {

    private ExecutorService executorService;
    private int stopDelay;
    private TimeUnit timeUnit;

    private final LoggerUtilities logger
            = new LoggerUtilities(this.getClass());

    private TaskExecutor() {
    }

    public static TaskExecutor getInstance() {
        return TaskExecutorSingletonHolder.INSTANCE;
    }

    private static class TaskExecutorSingletonHolder {
        private static final TaskExecutor INSTANCE = new TaskExecutor();
    }

    /**
     * Thread-safe configuration of a Thread pool
     * to handle server requests
     *
     * @param numOfThreads
     * @param stopDelay
     * @param timeUnit
     * @return
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    public TaskExecutor configurePool(final int numOfThreads,
                                      final int stopDelay,
                                      final TimeUnit timeUnit)
            throws NullPointerException, IllegalArgumentException {

        synchronized (ProcessingMutex.CONFIG_MUTEX) {

            if (Validate.isNull(this.executorService)) {

                this.stopDelay = stopDelay;
                this.timeUnit = timeUnit;

                this.executorService = Executors
                        .newFixedThreadPool(numOfThreads);
            }
            return this;
        }
    }

    /**
     * @param task
     * @return
     * @throws CancellationException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public String submitTask(Callable<String> task) throws
            RejectedExecutionException,
            CancellationException,
            InterruptedException,
            TimeoutException,
            ExecutionException {

        Future<String> future =
                this.executorService.submit(task);

        try {
            return future.get(NamedConstants.TASK_TIMEOUT,
                    TimeUnit.MINUTES);
        } catch (ExecutionException exception) { //throw the exception cause

            Throwable cause = exception.getCause();

            if (cause instanceof DisplayMsgException) {
                throw (DisplayMsgException) cause;
            }
            throw exception;
        }
    }

    /**
     * The following method shuts down an ExecutorService in two phases, first
     * by calling shutdown to reject incoming tasks, and then calling
     * shutdownNow, if necessary, to cancel any lingering tasks once (timeToWait
     * time) elapses.
     */
    public void shutdownPool() {

        try {

            this.executorService.shutdown(); // Disable new tasks from being submitted
            boolean terminatedOK = this.executorService
                    .awaitTermination(stopDelay, timeUnit);

            if (!terminatedOK) {

                // Wait a while for tasks to respond to being cancelled
                terminatedOK = this.executorService.
                        awaitTermination(++stopDelay, timeUnit);

                if (!terminatedOK) {
                    this.executorService.shutdownNow();
                }
            }
        } catch (InterruptedException | SecurityException exc) {
            logger.error("Error shutting down pool, attempting forced shutdown");
            this.executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
