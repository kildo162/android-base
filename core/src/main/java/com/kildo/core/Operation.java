package com.kildo.core;

/**
 * @author kildo (khanhnd162@gmail.com)
 * @version 1.0.0
 * @created 3/26/21
 */
public abstract class Operation implements Runnable {

    public abstract void run();

    public void fire() {
        Engine.instance().schedule(this);
    }
}