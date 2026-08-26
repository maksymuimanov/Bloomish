package io.bloomish.api.data.client.model;

public enum RenderType {
    SOLID("minecraft:solid"),
    CUTOUT("minecraft:cutout"),
    CUTOUT_MIPPED("minecraft:cutout_mipped"),
    CUTOUT_MIPPED_ALL("minecraft:cutout_mipped_all"),
    TRANSLUCENT("minecraft:translucent"),
    TRIPWIRE("minecraft:tripwire");

    private final String path;

    RenderType(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
