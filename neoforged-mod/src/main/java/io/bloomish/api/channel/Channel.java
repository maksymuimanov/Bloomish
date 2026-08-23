package io.bloomish.api.channel;

public record Channel(
        String name,
        Class<?> type
) {
}
