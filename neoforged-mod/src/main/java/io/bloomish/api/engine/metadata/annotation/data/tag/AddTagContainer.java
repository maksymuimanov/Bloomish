package io.bloomish.api.engine.metadata.annotation.data.tag;

import io.bloomish.api.engine.metadata.constant.TagContainerType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AddTagContainer {
    TagContainerType value();
}