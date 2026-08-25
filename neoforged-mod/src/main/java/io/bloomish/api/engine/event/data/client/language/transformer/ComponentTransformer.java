package io.bloomish.api.engine.event.data.client.language.transformer;

import net.minecraft.network.chat.Component;

public class ComponentTransformer implements KeyTransformer<Component> {
    @Override
    public String transform(Component component) {
        return component.getContents().type().id();
    }
}
