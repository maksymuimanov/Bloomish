package io.bloomish.api.data.client.model.block.spec;

import io.bloomish.api.util.DeprecatedResourceUtils;
import io.bloomish.api.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class DependantBlockModelSpec extends BlockModelSpec {
    private final Block dependencyBlock;

    public DependantBlockModelSpec(Holder<? extends Block> holder, String dependencyBlockId) {
        this(holder, null, dependencyBlockId);
    }

    public DependantBlockModelSpec(Holder<? extends Block> holder, String renderType, String dependencyBlockId) {
        this(holder, renderType, RegistryUtils.getBlock(dependencyBlockId));
    }

    public DependantBlockModelSpec(Holder<? extends Block> holder, Block dependencyBlock) {
        this(holder, null, dependencyBlock);
    }

    public DependantBlockModelSpec(Holder<? extends Block> holder, String renderType, Block dependencyBlock) {
        super(holder, renderType);
        this.dependencyBlock = dependencyBlock;
    }

    public ResourceLocation getDependencyLocation() {
        return this.getDependencyLocation("");
    }

    public ResourceLocation getDependencyLocation(String suffix) {
        return DeprecatedResourceUtils.parse(this.getDependencyPath() + suffix);
    }

    public String getDependencyPath() {
        return getBlockPath(this.getDependencyBlock());
    }

    @SuppressWarnings("unchecked")
    public <T extends Block> T getDependencyBlock() {
        return (T) dependencyBlock;
    }
}
