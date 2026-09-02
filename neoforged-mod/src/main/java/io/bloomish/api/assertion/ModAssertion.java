package io.bloomish.api.assertion;

import io.bloomish.api.engine.context.ModContext;
import net.neoforged.fml.ModList;

import java.util.function.Supplier;

public class ModAssertion extends Assertion<String, ModAssertion> {
    protected ModAssertion(String object) {
        super(object);
    }

    public ModAssertion isLoaded(Supplier<String> message) {
        return this.assertTrue(ModList.get().isLoaded(this.getObject()), message);
    }

    public ModAssertion isNotLoaded(Supplier<String> message) {
        return this.assertFalse(ModList.get().isLoaded(this.getObject()), message);
    }

    public ModAssertion isCurrent(Supplier<String> message) {
        return this.isEqual(ModContext.getModId(), message);
    }

    public ModAssertion isNotCurrent(Supplier<String> message) {
        return this.isNotEqual(ModContext.getModId(), message);
    }
}
