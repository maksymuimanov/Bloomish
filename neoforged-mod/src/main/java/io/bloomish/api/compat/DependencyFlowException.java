package io.bloomish.api.compat;

public class DependencyFlowException extends RuntimeException {
    public DependencyFlowException(Throwable cause) {
        super(cause);
    }

    public DependencyFlowException(String message, Throwable cause) {
        super(message, cause);
    }
}
