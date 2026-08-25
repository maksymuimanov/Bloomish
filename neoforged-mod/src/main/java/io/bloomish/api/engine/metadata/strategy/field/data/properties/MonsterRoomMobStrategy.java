package io.bloomish.api.engine.metadata.strategy.field.data.properties;

import io.bloomish.api.engine.event.data.server.map.ApiDataMapProvider;
import io.bloomish.api.engine.event.data.server.map.MonsterRoomMobDto;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.properties.MonsterRoomMob;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class MonsterRoomMobStrategy implements FieldAnnotationStrategy<MonsterRoomMob> {
    @Override
    public void execute(Field field, Object object, MonsterRoomMob annotation) throws Exception {
        Holder<EntityType<?>> entityType = ReflectionUtils.getFieldValue(field, object);
        MonsterRoomMobDto monsterRoomMobDto = new MonsterRoomMobDto(entityType, annotation.weight(), annotation.replace());
        ApiDataMapProvider.MONSTER_ROOM_MOBS.add(monsterRoomMobDto);
    }

    @Override
    public Class<MonsterRoomMob> getAnnotationClass() {
        return MonsterRoomMob.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
