package io.bloomish.api.engine.metadata.annotation.data.model.block;

import io.bloomish.api.data.client.model.RenderTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateCrossBlockModel {
    String renderType() default RenderTypes.CUTOUT;
}