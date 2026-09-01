package io.bloomish.api.data.client.blockstate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record VariantBlockState(
        Map<String, Variant> variants
) implements BlockState {
    public static VariantBlockState of(Map<Map<String, String>, Variant> variants) {
        Map<String, Variant> resolvedVariants = variants.entrySet()
                .stream()
                .map(entry -> {
                    List<String> conditions = entry.getKey()
                            .entrySet()
                            .stream()
                            .map(conditionEntry ->
                                    conditionEntry.getKey() + "=" + conditionEntry.getValue())
                            .toList();
                    return Map.entry(String.join(",", conditions), entry.getValue());
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new VariantBlockState(resolvedVariants);
    }
}
