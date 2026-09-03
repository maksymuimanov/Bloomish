package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record VariantBlockState(
        Map<String, Variant> variants
) implements BlockState {
    public static VariantBlockState ofConditionalVariants(ConditionalVariant variant, ConditionalVariant... variants) {
        Map<String, Variant> resolvedVariants = CollectionUtils.arrayListOf(variant, variants)
                .stream()
                .map(entry -> {
                    List<String> conditions = entry.conditions()
                            .stream()
                            .map(BlockStateCondition::toString)
                            .toList();
                    return Map.entry(String.join(",", conditions), entry.variant());
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new VariantBlockState(resolvedVariants);
    }
}
