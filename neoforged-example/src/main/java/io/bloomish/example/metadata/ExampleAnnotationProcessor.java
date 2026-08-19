package io.bloomish.example.metadata;

import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;
import io.bloomish.api.engine.metadata.processor.AbstractAnnotationProcessor;

@Processor(ExampleAnnotationProcessor.NAME)
public class ExampleAnnotationProcessor extends AbstractAnnotationProcessor {
    public static final String NAME = "example";

    @Override
    public void process() {
        this.processAll(MetadataLayer.SIMPLE_STRATEGY_CONSUMER, ModContext.NEO_MOD.getClasses());
    }
}