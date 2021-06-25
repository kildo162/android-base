package com.kildo.core.connection;

import com.kildo.core.Operation;

/**
 * @author kildo (khanhnd162@gmail.com)
 * @version 1.0.0
 * @created 6/25/21
 */
public abstract class BaseOperation extends Operation {

    private int attempt = 0;
    private final int MAXIMUM_RETRY = 5;

    public void send() {
        if (getRetry() < MAXIMUM_RETRY) {
            fire();
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
