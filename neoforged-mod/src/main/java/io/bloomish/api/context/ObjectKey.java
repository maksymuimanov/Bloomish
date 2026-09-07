package io.bloomish.api.context;

public record ObjectKey<T>(
        String name,
        Class<T> clazz,
        boolean primary
) {
}
