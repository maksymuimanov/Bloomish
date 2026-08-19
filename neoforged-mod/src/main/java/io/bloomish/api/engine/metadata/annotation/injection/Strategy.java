package io.bloomish.api.engine.metadata.annotation.injection;

import io.bloomish.api.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Strategy {
    String value();
    Class<? extends AnnotationStrategy> override() default AnnotationStrategy.class;
}
