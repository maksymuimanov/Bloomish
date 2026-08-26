package io.bloomish.api.data.client.model.deprecated.item.spec;

import io.bloomish.api.data.client.model.deprecated.block.spec.BlockModelSpec;
import io.bloomish.api.util.DeprecatedRegistryUtils;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DependantBlockItemModelSpec extends BlockItemModelSpec {
    private final Block dependencyBlock;

    public DependantBlockItemModelSpec(Holder<? extends Item> holder, String dependencyBlockId) {
        this(holder, DeprecatedRegistryUtils.getBlock(dependencyBlockId));
    }

    public DependantBlockItemModelSpec(Holder<? extends Item> holder, Block dependencyBlock) {
        super(holder);
        this.dependencyBlock = dependencyBlock;
    }

    public ResourceLocation getDependencyBlockLocation() {
        return this.getDependencyBlockLocation("");
    }

    public ResourceLocation getDependencyBlockLocation(String suffix) {
        return DeprecatedResourceUtils.parse(this.getDependencyBlockPath() + suffix);
    }

    public String getDependencyBlockPath() {
        return BlockModelSpec.getBlockPath(this.getDependencyBlock());
    }

    public Block getDependencyBlock() {
        return dependencyBlock;
    }
}
