package io.bloomish.api.channel;

import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.EventPriority;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
public @interface ProduceToObjectChannel {
    String value();

    Class<? extends ObjectTransformer> transformer() default ObjectTransformer.class;

    EventTrigger[] eventTrigger() default @EventTrigger(event = Event.class);

    @interface EventTrigger {
        Class<? extends Event> event();

        EventPriority priority() default EventPriority.HIGHEST;
    }
}
