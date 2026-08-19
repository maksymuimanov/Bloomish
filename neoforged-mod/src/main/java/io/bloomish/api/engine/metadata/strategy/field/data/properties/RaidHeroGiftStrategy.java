package io.bloomish.api.engine.metadata.strategy.field.data.properties;

import io.bloomish.api.engine.event.data.map.ApiDataMapProvider;
import io.bloomish.api.engine.event.data.map.RaidHeroGiftDto;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.properties.RaidHeroGift;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.npc.VillagerProfession;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class RaidHeroGiftStrategy implements FieldAnnotationStrategy<RaidHeroGift> {
    @Override
    public void execute(Field field, Object object, RaidHeroGift annotation) throws Exception {
        Holder<VillagerProfession> villagerProfession = ReflectionUtils.getFieldValue(field, object);
        RaidHeroGiftDto raidHeroGiftDto = new RaidHeroGiftDto(villagerProfession, annotation.lootTablePath(), annotation.replace());
        ApiDataMapProvider.RAID_HERO_GIFTS.add(raidHeroGiftDto);
    }

    @Override
    public Class<RaidHeroGift> getAnnotationClass() {
        return RaidHeroGift.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
