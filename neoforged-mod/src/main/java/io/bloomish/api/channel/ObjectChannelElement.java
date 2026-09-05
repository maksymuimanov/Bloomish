package io.bloomish.api.channel;

import io.bloomish.api.channel.transformer.ObjectTransformer;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.EventPriority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
public @interface ObjectChannelElement {
    String channelId();

    Class<? extends ObjectTransformer> transformer() default ObjectTransformer.class;

    EventTrigger[] eventTrigger() default @EventTrigger(event = Event.class);

    @interface EventTrigger {
        Class<? extends Event> event();

        EventPriority priority() default EventPriority.HIGHEST;
    }
}
