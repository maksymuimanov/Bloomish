package io.bloomish.api.engine.context;

public class NeoModException extends RuntimeException {
    public NeoModException(String message) {
        super(message);
    }

    public NeoModException(String message, Throwable cause) {
        super(message, cause);
    }
}
