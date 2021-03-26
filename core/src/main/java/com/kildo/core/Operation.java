package com.kildo.core;

/**
 * @author kildo (khanhnd162@gmail.com)
 * @version 1.0.0
 * @created 3/26/21
 */
abstract public class Operation implements Runnable {
    private int attempt = 0;
    private final int MAXIMUM_RETRY = 5;

    abstract public void run();

    public void fire() {
        if (getRetry() < MAXIMUM_RETRY) {
            Engine.instance().schedule(this);
        } else {
            maximumRetry();
        }
    }

    public abstract void maximumRetry();

    public int getRetry() {
        return attempt;
    }

    public void setRetry() {
        this.attempt = getRetry() + 1;
    }

    public void retry() {
        if (getRetry() < MAXIMUM_RETRY) {
            setRetry();
            fire();
        } else {
            maximumRetry();
        }
    }
}