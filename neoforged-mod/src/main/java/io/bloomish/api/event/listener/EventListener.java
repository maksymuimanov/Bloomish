package io.bloomish.api.event.listener;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.neoforged.bus.api.EventPriority;

import java.lang.annotation.*;

@Injected
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EventListener {
    EventPriority priority() default EventPriority.NORMAL;
}
