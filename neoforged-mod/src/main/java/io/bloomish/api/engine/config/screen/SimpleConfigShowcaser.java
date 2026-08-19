package io.bloomish.api.engine.config.screen;

import io.bloomish.api.engine.context.EngineContext;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public class SimpleConfigShowcaser implements ConfigShowcaser {
    @Override
    public void showcase() {
        ModContainer modContainer = EngineContext.getObject(ModContainer.class);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
