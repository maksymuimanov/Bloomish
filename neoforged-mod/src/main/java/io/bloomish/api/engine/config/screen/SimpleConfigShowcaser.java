package io.bloomish.api.engine.config.screen;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public class SimpleConfigShowcaser implements ConfigShowcaser {
    @Override
    public void showcase() {
        ModContainer modContainer = DefaultObjectRegistry.getFromInstance(ModContainer.class);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
