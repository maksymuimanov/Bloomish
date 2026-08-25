package io.bloomish.api.engine.event.data.client.model.item.spec;

import io.bloomish.api.engine.event.data.client.model.block.spec.BlockModelSpec;
import io.bloomish.api.util.DeprecatedResourceUtils;
import io.bloomish.api.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BlockItemModelSpec extends ItemModelSpec {
    private final Block block;

    public BlockItemModelSpec(Holder<? extends Item> holder) {
        this(holder, RegistryUtils.getObjectId(BuiltInRegistries.ITEM, holder.value()));
    }

    public BlockItemModelSpec(Holder<? extends Item> holder, String blockId) {
        this(holder, RegistryUtils.getBlock(blockId));
    }

    public BlockItemModelSpec(Holder<? extends Item> holder, Block block) {
        super(holder);
        this.block = block;
    }

    public ResourceLocation getBlockLocation() {
        return this.getBlockLocation("");
    }

    public ResourceLocation getBlockLocation(String suffix) {
        return DeprecatedResourceUtils.parse(this.getBlockPath() + suffix);
    }

    public String getBlockPath() {
        return BlockModelSpec.getBlockPath(this.getBlock());
    }

    public Block getBlock() {
        return block;
    }
}
