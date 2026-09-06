package io.bloomish.api.bean.filter;

import io.bloomish.api.bean.BeanFilter;
import io.bloomish.api.engine.metadata.annotation.injection.OnMod;
import io.bloomish.api.util.ReflectionUtils;
import net.neoforged.fml.ModList;

public class OnModBeanFilter implements BeanFilter {
    @Override
    public boolean shouldRegister(Class<?> clazz) {
        OnMod onMod = ReflectionUtils.findDeepAnnotation(clazz, OnMod.class).orElseThrow();
        return ModList.get().isLoaded(onMod.value());
    }
}
