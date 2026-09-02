package io.bloomish.api.data.client.blockstate;

public record Variant(
        String model,
        Boolean uvlock,
        Integer x,
        Integer y
) {
    public static Variant ofUvlockModel(String model) {
        return new Variant(model, true, null, null);
    }

    public static Variant ofUvlockX(String model, int x) {
        return new Variant(model, true, x, null);
    }

    public static Variant ofUvlockY(String model, int y) {
        return new Variant(model, true, null, y);
    }

    public static Variant ofUvlockXY(String model, int x, int y) {
        return new Variant(model, true, x, y);
    }

    public static Variant ofModel(String model) {
        return new Variant(model, null, null, null);
    }

    public static Variant ofX(String model, int x) {
        return new Variant(model, null, x, null);
    }

    public static Variant ofY(String model, int y) {
        return new Variant(model, null, null, y);
    }

    public static Variant ofXY(String model, int x, int y) {
        return new Variant(model, null, x, y);
    }
}
