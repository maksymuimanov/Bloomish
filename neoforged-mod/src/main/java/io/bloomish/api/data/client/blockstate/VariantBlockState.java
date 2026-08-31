package io.bloomish.api.data.client.blockstate;

import java.util.Map;

public record VariantBlockState(
        Map<String, Variant> variants
) implements BlockState {
    public record Variant(
            String model,
            Boolean uvlock,
            Integer x,
            Integer y
    ) {
        public static Variant of(String model) {
            return Variant.of(model, null);
        }

        public static Variant of(String model, Integer x) {
            return Variant.of(model, x, null);
        }

        public static Variant of(String model, Integer x, Integer y) {
            return new Variant(model, null, x, y);
        }
    }
}
