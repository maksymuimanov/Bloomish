package io.bloomish.api.data.client.blockstate;

public record Variant(
        String model,
        Boolean uvlock,
        Integer x,
        Integer y
) {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_90 = 90;
    public static final int ROTATION_180 = 180;
    public static final int ROTATION_270 = 270;

    public static Variant ofUvlockModel(String model) {
        return new Variant(model, true, null, null);
    }

    public static Variant ofUvlockX0(String model) {
        return ofUvlockX(model, ROTATION_0);
    }

    public static Variant ofUvlockX90(String model) {
        return ofUvlockX(model, ROTATION_90);
    }

    public static Variant ofUvlockX180(String model) {
        return ofUvlockX(model, ROTATION_180);
    }

    public static Variant ofUvlockX270(String model) {
        return ofUvlockX(model, ROTATION_270);
    }

    public static Variant ofUvlockX(String model, int x) {
        return new Variant(model, true, x, null);
    }

    public static Variant ofUvlockY0(String model) {
        return ofUvlockY(model, ROTATION_0);
    }

    public static Variant ofUvlockY90(String model) {
        return ofUvlockY(model, ROTATION_90);
    }

    public static Variant ofUvlockY180(String model) {
        return ofUvlockY(model, ROTATION_180);
    }

    public static Variant ofUvlockY270(String model) {
        return ofUvlockY(model, ROTATION_270);
    }

    public static Variant ofUvlockY(String model, int y) {
        return new Variant(model, true, null, y);
    }


    public static Variant ofUvlockX0Y0(String model) {
        return ofUvlockXY(model, ROTATION_0, ROTATION_0);
    }

    public static Variant ofUvlockX0Y90(String model) {
        return ofUvlockXY(model, ROTATION_0, ROTATION_90);
    }

    public static Variant ofUvlockX0Y180(String model) {
        return ofUvlockXY(model, ROTATION_0, ROTATION_180);
    }

    public static Variant ofUvlockX0Y270(String model) {
        return ofUvlockXY(model, ROTATION_0, ROTATION_270);
    }

    public static Variant ofUvlockX90Y0(String model) {
        return ofUvlockXY(model, ROTATION_90, ROTATION_0);
    }

    public static Variant ofUvlockX90Y90(String model) {
        return ofUvlockXY(model, ROTATION_90, ROTATION_90);
    }

    public static Variant ofUvlockX90Y180(String model) {
        return ofUvlockXY(model, ROTATION_90, ROTATION_180);
    }

    public static Variant ofUvlockX90Y270(String model) {
        return ofUvlockXY(model, ROTATION_90, ROTATION_270);
    }

    public static Variant ofUvlockX180Y0(String model) {
        return ofUvlockXY(model, ROTATION_180, ROTATION_0);
    }

    public static Variant ofUvlockX180Y90(String model) {
        return ofUvlockXY(model, ROTATION_180, ROTATION_90);
    }

    public static Variant ofUvlockX180Y180(String model) {
        return ofUvlockXY(model, ROTATION_180, ROTATION_180);
    }

    public static Variant ofUvlockX180Y270(String model) {
        return ofUvlockXY(model, ROTATION_180, ROTATION_270);
    }

    public static Variant ofUvlockX270Y0(String model) {
        return ofUvlockXY(model, ROTATION_270, ROTATION_0);
    }

    public static Variant ofUvlockX270Y90(String model) {
        return ofUvlockXY(model, ROTATION_270, ROTATION_90);
    }

    public static Variant ofUvlockX270Y180(String model) {
        return ofUvlockXY(model, ROTATION_270, ROTATION_180);
    }

    public static Variant ofUvlockX270Y270(String model) {
        return ofUvlockXY(model, ROTATION_270, ROTATION_270);
    }

    public static Variant ofUvlockXY(String model, int x, int y) {
        return new Variant(model, true, x, y);
    }

    public static Variant ofModel(String model) {
        return new Variant(model, null, null, null);
    }

    public static Variant ofX0(String model) {
        return ofX(model, ROTATION_0);
    }

    public static Variant ofX90(String model) {
        return ofX(model, ROTATION_90);
    }

    public static Variant ofX180(String model) {
        return ofX(model, ROTATION_180);
    }

    public static Variant ofX270(String model) {
        return ofX(model, ROTATION_270);
    }

    public static Variant ofX(String model, int x) {
        return new Variant(model, null, x, null);
    }

    public static Variant ofY0(String model) {
        return ofY(model, ROTATION_0);
    }

    public static Variant ofY90(String model) {
        return ofY(model, ROTATION_90);
    }

    public static Variant ofY180(String model) {
        return ofY(model, ROTATION_180);
    }

    public static Variant ofY270(String model) {
        return ofY(model, ROTATION_270);
    }

    public static Variant ofY(String model, int y) {
        return new Variant(model, null, null, y);
    }

    public static Variant ofX0Y0(String model) {
        return ofXY(model, ROTATION_0, ROTATION_0);
    }

    public static Variant ofX0Y90(String model) {
        return ofXY(model, ROTATION_0, ROTATION_90);
    }

    public static Variant ofX0Y180(String model) {
        return ofXY(model, ROTATION_0, ROTATION_180);
    }

    public static Variant ofX0Y270(String model) {
        return ofXY(model, ROTATION_0, ROTATION_270);
    }

    public static Variant ofX90Y0(String model) {
        return ofXY(model, ROTATION_90, ROTATION_0);
    }

    public static Variant ofX90Y90(String model) {
        return ofXY(model, ROTATION_90, ROTATION_90);
    }

    public static Variant ofX90Y180(String model) {
        return ofXY(model, ROTATION_90, ROTATION_180);
    }

    public static Variant ofX90Y270(String model) {
        return ofXY(model, ROTATION_90, ROTATION_270);
    }

    public static Variant ofX180Y0(String model) {
        return ofXY(model, ROTATION_180, ROTATION_0);
    }

    public static Variant ofX180Y90(String model) {
        return ofXY(model, ROTATION_180, ROTATION_90);
    }

    public static Variant ofX180Y180(String model) {
        return ofXY(model, ROTATION_180, ROTATION_180);
    }

    public static Variant ofX180Y270(String model) {
        return ofXY(model, ROTATION_180, ROTATION_270);
    }

    public static Variant ofX270Y0(String model) {
        return ofXY(model, ROTATION_270, ROTATION_0);
    }

    public static Variant ofX270Y90(String model) {
        return ofXY(model, ROTATION_270, ROTATION_90);
    }

    public static Variant ofX270Y180(String model) {
        return ofXY(model, ROTATION_270, ROTATION_180);
    }

    public static Variant ofX270Y270(String model) {
        return ofXY(model, ROTATION_270, ROTATION_270);
    }

    public static Variant ofXY(String model, int x, int y) {
        return new Variant(model, null, x, y);
    }
}
