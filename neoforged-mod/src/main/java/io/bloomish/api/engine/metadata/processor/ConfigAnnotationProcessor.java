package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;

@Processor(ConfigAnnotationProcessor.NAME)
public class ConfigAnnotationProcessor extends AbstractAnnotationProcessor {
    public static final String NAME = "default_config";

    @Override
    public void process() {
        this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, EngineContext.currentMod.getClasses());
    }
}