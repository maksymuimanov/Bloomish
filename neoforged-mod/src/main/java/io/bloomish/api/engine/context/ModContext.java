package io.bloomish.api.engine.context;

public interface ModContext {
    NeoMod getCurrentMod();

    void setCurrentMod(NeoMod mod);
}
