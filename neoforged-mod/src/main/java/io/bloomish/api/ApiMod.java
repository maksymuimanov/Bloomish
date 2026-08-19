package io.bloomish.api;

import com.mojang.logging.LogUtils;
import io.bloomish.api.core.engine.context.ModContext;
import io.bloomish.api.core.util.ReflectionUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ApiMod.MOD_ID)
public class ApiMod {
    public static final String MOD_ID = "temporalapi";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ApiMod(IEventBus modEventBus, ModContainer modContainer) {
        ModContext.ALL_CLASSES.addAll(ReflectionUtils.getApiDependentsClasses());
    }
}
