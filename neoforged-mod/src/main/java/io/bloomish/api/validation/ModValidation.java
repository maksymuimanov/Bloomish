package io.bloomish.api.validation;

import io.bloomish.api.context.ModContext;
import net.neoforged.fml.ModList;

import java.util.function.Supplier;

public class ModValidation extends Validation<String, ModValidation> {
    protected ModValidation(String object) {
        super(object);
    }

    public ModValidation isLoaded() {
        return this.isLoaded(() -> "Expected mod " + this.getActual() + " to be loaded");
    }

    public ModValidation isLoaded(String message) {
        return this.isLoaded(() -> message);
    }

    public ModValidation isLoaded(Supplier<String> message) {
        return this.assertTrue(ModList.get().isLoaded(this.getActual()), message);
    }

    public ModValidation isNotLoaded() {
        return this.isNotLoaded(() -> "Expected mod " + this.getActual() + " not to be loaded");
    }

    public ModValidation isNotLoaded(String message) {
        return this.isNotLoaded(() -> message);
    }

    public ModValidation isNotLoaded(Supplier<String> message) {
        return this.assertFalse(ModList.get().isLoaded(this.getActual()), message);
    }

    public ModValidation isCurrent() {
        return this.isCurrent(() -> "Expected mod to be current");
    }

    public ModValidation isCurrent(String message) {
        return this.isCurrent(() -> message);
    }

    public ModValidation isCurrent(Supplier<String> message) {
        return this.isEqual(ModContext.getModId(), message);
    }

    public ModValidation isNotCurrent() {
        return this.isNotCurrent(() -> "Expected mod not to be current");
    }

    public ModValidation isNotCurrent(String message) {
        return this.isNotCurrent(() -> message);
    }

    public ModValidation isNotCurrent(Supplier<String> message) {
        return this.isNotEqual(ModContext.getModId(), message);
    }
}
