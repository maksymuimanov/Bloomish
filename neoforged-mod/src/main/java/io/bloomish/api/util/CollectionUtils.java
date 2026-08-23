package io.bloomish.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    @SafeVarargs
    public static <T> List<T> listOf(T first, T... rest) {
        List<T> safeVarargList = rest == null ? List.of() : List.of(rest);
        List<T> list = new ArrayList<>(1 + safeVarargList.size());
        list.add(first);
        list.addAll(safeVarargList);
        return list;
    }
}
