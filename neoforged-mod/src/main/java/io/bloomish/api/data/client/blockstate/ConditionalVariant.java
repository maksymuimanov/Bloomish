package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.data.client.blockstate.property.BlockStateProperty;
import io.bloomish.api.util.CollectionUtils;

import java.util.List;

public record ConditionalVariant(
        Variant variant,
        List<BlockStateCondition> conditions
) {
    public static ConditionalVariant of(Variant variant, BlockStateProperty property, BlockStateProperty... properties) {
        List<BlockStateCondition> conditions = CollectionUtils.arrayListOf(property, properties)
                .stream()
                .map(BlockStateCondition::fromProperty)
                .toList();
        return new ConditionalVariant(variant, conditions);
    }

    public static ConditionalVariant of(Variant variant, BlockStateCondition condition, BlockStateCondition... conditions) {
        return new ConditionalVariant(variant, CollectionUtils.arrayListOf(condition, conditions));
    }
}
