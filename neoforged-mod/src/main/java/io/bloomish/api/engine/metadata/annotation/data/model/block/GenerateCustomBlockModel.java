package io.bloomish.api.engine.metadata.annotation.data.model.block;

import io.bloomish.api.data.client.model.deprecated.RenderTypes;
import io.bloomish.api.data.client.model.deprecated.block.spec.CustomBlockModelSpec;
import io.bloomish.api.data.client.model.deprecated.block.strategy.BlockModelProviderStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateCustomBlockModel {
    Class<? extends BlockModelProviderStrategy<CustomBlockModelSpec>> strategy();
    String renderType() default RenderTypes.SOLID;
    String[] additionalData() default {};
}