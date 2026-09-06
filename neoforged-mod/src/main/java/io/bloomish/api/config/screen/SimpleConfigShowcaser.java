package io.bloomish.api.config.screen;

import io.bloomish.api.bean.Bean;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Bean
public class SimpleConfigShowcaser implements ConfigShowcaser {
    private final ModContainer modContainer;

    public SimpleConfigShowcaser(ModContainer modContainer) {
        this.modContainer = modContainer;
    }

    @Override
    public void showcase() {
        this.modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
