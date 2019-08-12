package com.ura.casemgt.infrastructure.appstart;

import com.ura.casemgt.infrastructure.controllers.CaseFileServiceController;
import com.ura.casemgt.infrastructure.controllers.ChainProcessorBase;

/**
 * @author smallGod
 */
public interface ServiceWorkers {

    /**
     * The Services handling requests
     * in the application
     */
    ChainProcessorBase[] SERVICES = {
            new CaseFileServiceController()
    };

    /**
     * Number of services available
     */
    int NUM_OF_SERVICES = SERVICES.length;
}
