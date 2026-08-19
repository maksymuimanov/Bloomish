package io.bloomish.api.engine.metadata.annotation.data;

import io.bloomish.api.engine.event.data.advancement.AdvancementStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GenerateAdvancement {
    Class<? extends AdvancementStrategy> value() default AdvancementStrategy.class;
}