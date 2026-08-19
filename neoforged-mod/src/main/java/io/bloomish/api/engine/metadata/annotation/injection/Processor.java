package io.bloomish.api.engine.metadata.annotation.injection;

import io.bloomish.api.engine.metadata.processor.AnnotationProcessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Processor {
    String value();
    Class<? extends AnnotationProcessor> override() default AnnotationProcessor.class;
}
