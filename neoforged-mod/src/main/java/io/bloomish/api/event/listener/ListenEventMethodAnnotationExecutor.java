package io.bloomish.api.event.listener;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.event.subscriber.EventSubscriber;
import io.bloomish.api.metadata.executor.MethodAnnotationExecutor;
import io.bloomish.api.util.ReflectionUtils;
import io.bloomish.api.validation.Validations;
import net.neoforged.bus.api.Event;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Bean
public class ListenEventMethodAnnotationExecutor implements MethodAnnotationExecutor<ListenEvent> {
    private final EventSubscriber eventSubscriber;

    public ListenEventMethodAnnotationExecutor(EventSubscriber eventSubscriber) {
        this.eventSubscriber = eventSubscriber;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(ListenEvent annotation, Method method, Object bean) {
        Parameter[] parameters = method.getParameters();
        Validations.validateThatArray(parameters)
                .hasSize(1, "Method annotated with @ListenEvent must have exactly one parameter");
        Parameter eventParameter = parameters[0];
        Validations.validateThatClass(eventParameter.getType())
                .isSubtypeOf(Event.class, "Method annotated with @ListenEvent must have a parameter of type Event or a subclass");
        Class<? extends Event> eventType = (Class<? extends Event>) eventParameter.getType();
        this.eventSubscriber.subscribe(eventType, event -> ReflectionUtils.invokeMethod(method, bean, event), annotation.priority());
    }

    @Override
    public Class<ListenEvent> annotationType() {
        return ListenEvent.class;
    }
}
