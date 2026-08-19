package io.bloomish.api.engine.event.client;

import java.util.List;

public interface ClientSetup<T> {
    void setup(List<T> source);
}
