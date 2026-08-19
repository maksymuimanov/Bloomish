package io.bloomish.api.engine.config;

import io.bloomish.api.engine.LayerCustomizer;
import io.bloomish.api.engine.config.screen.ConfigShowcaser;
import io.bloomish.api.engine.config.screen.SimpleConfigShowcaser;

import java.util.List;

public class ConfigLayerCustomizer implements LayerCustomizer<ConfigLayer> {
    private static final List<ConfigShowcaser> DEFAULT_CONFIG_SHOWCASERS = List.of(new SimpleConfigShowcaser());
    private List<ConfigShowcaser> configShowcasers;

    public ConfigLayerCustomizer() {
        this.configShowcasers = DEFAULT_CONFIG_SHOWCASERS;
    }

    public ConfigLayerCustomizer configShowcasers(List<ConfigShowcaser> configShowcasers) {
        this.configShowcasers = configShowcasers;
        return this;
    }

    @Override
    public void customize(ConfigLayer layer) {
        layer.setConfigShowcasers(this.configShowcasers);
    }
}
