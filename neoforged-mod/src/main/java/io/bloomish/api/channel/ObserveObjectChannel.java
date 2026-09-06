package io.bloomish.api.channel;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ObserveObjectChannel {
    String value();

    ReturnType returnType() default ReturnType.DETACHED_STREAM;

    enum ReturnType {
        STREAM, DETACHED_STREAM, QUEUE
    }
}
