package io.bloomish.api.engine.metadata.annotation.data.model.item;

import io.bloomish.api.data.client.model.deprecated.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.deprecated.item.spec.CustomBlockItemModelSpec;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateCustomBlockItemModel {
    Class<? extends ItemModelProviderStrategy<CustomBlockItemModelSpec>> strategy();
    String[] additionalData() default {};
}