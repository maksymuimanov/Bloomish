package io.bloomish.api.engine.metadata.annotation.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OnMod {
    String value();
}
