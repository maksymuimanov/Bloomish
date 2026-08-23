package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;

@Processor(InjectionAnnotationProcessor.NAME)
public class InjectionAnnotationProcessor extends AbstractAnnotationProcessor {
    public static final String NAME = "default_injection";

    @Override
    public void process() {
        this.processAll(MetadataLayer.SIMPLE_STRATEGY_CONSUMER, ModContext.currentMod.getClasses());
    }
}
