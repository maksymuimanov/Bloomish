package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.engine.event.EventHandler;

public abstract class AbstractEventHandlerAnnotationProcessorAdapter extends AbstractAnnotationProcessor implements EventHandler {
    @Override
    public void process() {
        this.handle();
    }
}
