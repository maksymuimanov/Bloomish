package io.bloomish.api.event.listener;

import net.neoforged.bus.api.EventPriority;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ListenEvent {
    EventPriority priority() default EventPriority.NORMAL;
}
