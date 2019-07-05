/*
 * Copyright (c) 2019. smallGod.
 * This code is provided as is and is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.ura.casemgt.infrastructure.appstart;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;

public class DaemonStart implements Daemon {

    public static void main(String[] args) {
        System.out.println("Jesus Christ is LORD of all..");
    }

    @Override
    public void init(DaemonContext context) {
    }

    @Override
    public void start() {

        System.out.println("Praise God, URA e-Case Mgt has started!");
    }

    @Override
    public void stop() {
        System.out.println("Praise God, URA e-Case Mgt has been stopped!");
    }

    @Override
    public void destroy() {
        System.out.println("Praise God, URA e-Case Mgt has been destroyed!");
    }
}
