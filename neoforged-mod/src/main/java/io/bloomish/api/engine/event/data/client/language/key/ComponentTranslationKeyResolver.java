package io.bloomish.api.engine.event.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.network.chat.Component;

@Injected
public class ComponentTranslationKeyResolver implements TranslationKeyResolver<Component> {
    @Override
    public boolean supports(Object object) {
        return object instanceof Component;
    }

    @Override
    public String resolve(Component component) {
        return component.getContents().type().id();
    }
}
