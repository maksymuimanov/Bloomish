package io.bloomish.api.assertion;

import io.bloomish.api.engine.context.ModContext;
import net.neoforged.fml.ModList;

import java.util.function.Supplier;

public class ModAssertion extends Assertion<String, ModAssertion> {
    protected ModAssertion(String object) {
        super(object);
    }

    public ModAssertion isLoaded() {
        return this.isLoaded(() -> "Expected mod " + this.getActual() + " to be loaded");
    }

    public ModAssertion isLoaded(Supplier<String> message) {
        return this.assertTrue(ModList.get().isLoaded(this.getActual()), message);
    }

    public ModAssertion isNotLoaded() {
        return this.isNotLoaded(() -> "Expected mod " + this.getActual() + " not to be loaded");
    }

    public ModAssertion isNotLoaded(Supplier<String> message) {
        return this.assertFalse(ModList.get().isLoaded(this.getActual()), message);
    }

    public ModAssertion isCurrent() {
        return this.isCurrent(() -> "Expected mod to be current");
    }

    public ModAssertion isCurrent(Supplier<String> message) {
        return this.isEqual(ModContext.getModId(), message);
    }

    public ModAssertion isNotCurrent() {
        return this.isNotCurrent(() -> "Expected mod not to be current");
    }

    public ModAssertion isNotCurrent(Supplier<String> message) {
        return this.isNotEqual(ModContext.getModId(), message);
    }
}
