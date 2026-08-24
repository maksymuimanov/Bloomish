package io.bloomish.api.util;

import net.minecraft.core.Holder;

import java.util.Collection;
import java.util.List;

public final class HolderUtils {
    private HolderUtils() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] unwrapToArray(Collection<Holder<T>> holders) {
        return (T[]) holders.stream()
                .map(Holder::value)
                .toArray(Object[]::new);
    }

    public static <T> List<T> unwrapToList(Collection<Holder<T>> holders) {
        return holders.stream()
                .map(Holder::value)
                .toList();
    }
}
