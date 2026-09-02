package io.bloomish.api.assertion;

import java.util.Collection;

public final class Assertions {
    private Assertions() {
    }

    public static <T> Assertion<T, ?> assertThat(T object) {
        return new Assertion<>(object);
    }

    public static ModAssertion assertThatMod(String modId) {
        return new ModAssertion(modId);
    }

    public static StringAssertion assertThatString(String string) {
        return new StringAssertion(string);
    }

    public static LongAssertion assertThatLong(Number number) {
        return new LongAssertion(number.longValue());
    }

    public static DoubleAssertion assertThatDouble(Number number) {
        return new DoubleAssertion(number.doubleValue());
    }

    public static CollectionAssertion assertThatCollection(Collection<?> collection) {
        return new CollectionAssertion(collection);
    }
}