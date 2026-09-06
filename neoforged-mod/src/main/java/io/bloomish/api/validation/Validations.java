package io.bloomish.api.validation;

import java.util.Arrays;
import java.util.Collection;

public final class Validations {
    private Validations() {
    }

    public static <T> Validation<T, ?> validateThat(T object) {
        return new Validation<>(object);
    }

    public static ModValidation validateThatMod(String modId) {
        return new ModValidation(modId);
    }

    public static StringValidation validateThatString(String string) {
        return new StringValidation(string);
    }

    public static LongValidation validateThatLong(Number number) {
        return new LongValidation(number.longValue());
    }

    public static DoubleValidation validateThatDouble(Number number) {
        return new DoubleValidation(number.doubleValue());
    }

    public static CollectionValidation validateThatArray(Object[] array) {
        return new CollectionValidation(Arrays.asList(array));
    }

    public static CollectionValidation validateThatCollection(Collection<?> collection) {
        return new CollectionValidation(collection);
    }

    public static ClassValidation validateThatClass(Class<?> clazz) {
        return new ClassValidation(clazz);
    }
}