package io.bloomish.api.engine.context;

import java.util.Set;

public record NeoMod(
        String name,
        Class<?> modClass,
        String modId,
        Set<Class<?>> classes
) {
    public boolean matchesModId(String modId) {
        return this.modId.equals(modId);
    }
}
