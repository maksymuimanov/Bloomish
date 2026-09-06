package io.bloomish.api.bean;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.CONSTRUCTOR})
public @interface BeanCandidate {
    String value() default "";
}