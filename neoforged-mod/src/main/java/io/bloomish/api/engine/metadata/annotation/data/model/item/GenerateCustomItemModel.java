package io.bloomish.api.engine.metadata.annotation.data.model.item;

import io.bloomish.api.engine.event.data.client.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.client.model.item.spec.CustomItemModelSpec;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateCustomItemModel {
    Class<? extends ItemModelProviderStrategy<CustomItemModelSpec>> strategy();
    String[] additionalData() default {};
}