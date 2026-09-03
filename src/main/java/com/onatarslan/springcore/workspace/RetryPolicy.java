package com.onatarslan.springcore.workspace;

import java.time.Duration;

public class RetryPolicy {
    private final int maxAttempts;
    private final Duration backoff;

    public RetryPolicy(int maxAttempts, Duration backoff) {
        this.maxAttempts = maxAttempts;
        this.backoff = backoff;
    }


    @Override
    public String toString() {
        return maxAttempts + " " + backoff.toString();
    }
}
