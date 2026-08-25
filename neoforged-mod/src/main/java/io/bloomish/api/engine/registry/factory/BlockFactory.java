package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockFactory extends AbstractObjectFactory<Block> {
    private final ItemFactory itemFactory;

    public BlockFactory() {
        this(DefaultObjectRegistry.getFromInstance("$Blocks"));
    }

    public BlockFactory(BloomishRegister<Block> register) {
        this(register, DefaultObjectRegistry.getFromInstance(ItemFactory.class));
    }

    public BlockFactory(BloomishRegister<Block> register, ItemFactory itemFactory) {
        super(register);
        this.itemFactory = itemFactory;
    }

    public DeferredBlock<Block> createWithoutItem(String name, BlockBehaviour.Properties properties) {
        return this.createWithoutItem(name, properties, Block::new);
    }

    public <T extends Block> DeferredBlock<T> createWithoutItem( String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, T> function) {
        return (DeferredBlock<T>) this.create(name, () -> function.apply(properties));
    }

    public DeferredBlock<Block> create(String name, BlockBehaviour.Properties properties) {
        return this.create(name, properties, Block::new);
    }

    public DeferredBlock<Block> create(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        return this.create(name, properties, Block::new, itemProperties);
    }

    public <T extends Block> DeferredBlock<T> create(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, T> function) {
        return this.create(name, properties, function, new Item.Properties());
    }

    public <T extends Block> DeferredBlock<T> create(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, T> function, Item.Properties itemProperties) {
        DeferredBlock<T> block = (DeferredBlock<T>) this.create(name, () -> function.apply(properties));
        itemFactory.create(name, itemProperties, props -> new BlockItem(block.value(), props));
        return block;
    }

    public <T extends Block> DeferredBlock<T> create(String name, Supplier<T> supplier, Item.Properties itemProperties) {
        DeferredBlock<T> block = (DeferredBlock<T>) this.create(name, supplier);
        itemFactory.create(name, itemProperties, props -> new BlockItem(block.value(), props));
        return block;
    }
}
