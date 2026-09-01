package io.bloomish.api.data.client.blockstate;

public record Variant(
        String model,
        Boolean uvlock,
        Integer x,
        Integer y
) {
    public Variant(String model) {
        this(model, null, null);
    }

    public Variant(String model, Integer x, Integer y) {
        this(model, null, x, y);
    }

    public static Variant ofUvlockX(String model, int x) {
        return ofUvlock(model, x, null);
    }

    public static Variant ofUvlockY(String model, int y) {
        return ofUvlock(model, null, y);
    }

    public static Variant ofUvlock(String model) {
        return ofUvlock(model, null, null);
    }

    public static Variant ofUvlock(String model, Integer x, Integer y) {
        return new Variant(model, true, x, y);
    }

    public static Variant ofX(String model, int x) {
        return new Variant(model, x, null);
    }

    public static Variant ofY(String model, int y) {
        return new Variant(model, null, y);
    }
}
