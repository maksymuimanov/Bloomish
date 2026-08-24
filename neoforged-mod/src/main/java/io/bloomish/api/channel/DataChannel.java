package io.bloomish.api.channel;

import java.util.UUID;

public record DataChannel(
        String name
) {
    public static DataChannel create() {
        return new DataChannel(UUID.randomUUID().toString());
    }
}
