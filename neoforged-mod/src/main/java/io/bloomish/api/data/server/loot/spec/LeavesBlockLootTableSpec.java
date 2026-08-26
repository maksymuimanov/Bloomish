package io.bloomish.api.data.server.loot.spec;

import io.bloomish.api.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class LeavesBlockLootTableSpec extends BlockLootTableSpec {
    private final Block saplingBlock;
    private final List<Float> chances;

    public LeavesBlockLootTableSpec(Holder<? extends Block> holder, String saplingBlockId) {
        this(holder, saplingBlockId, new ArrayList<>());
    }

    public LeavesBlockLootTableSpec(Holder<? extends Block> holder, String saplingBlockId, List<Float> chances) {
        this(holder, RegistryUtils.getBlock(saplingBlockId), chances);
    }

    public LeavesBlockLootTableSpec(Holder<? extends Block> holder, Block saplingBlock) {
        this(holder, saplingBlock, new ArrayList<>());
    }

    public LeavesBlockLootTableSpec(Holder<? extends Block> holder, Block saplingBlock, List<Float> chances) {
        super(holder);
        this.saplingBlock = saplingBlock;
        this.chances = chances;
    }

    @SuppressWarnings("unchecked")
    public <T extends Block> T getSaplingBlock() {
        return (T) saplingBlock;
    }

    public List<Float> getChances() {
        return chances;
    }
}