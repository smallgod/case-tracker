package com.ura.casemgt.configuration;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;

public class ApplicationEntry implements Daemon {

    public static void main(String[] args) {
        System.out.println("Jesus Christ is LORD! Method here for just..");
    }

    @Override
    public void init(DaemonContext context) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}
