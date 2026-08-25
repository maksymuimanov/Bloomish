package io.bloomish.api.util;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

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
    public static <T> List<T> arrayListOf(T first, T... rest) {
        List<T> safeVarargList = listFromNullableArray(rest);
        List<T> list = new ArrayList<>(1 + safeVarargList.size());
        list.add(first);
        list.addAll(safeVarargList);
        return list;
    }

    @SafeVarargs
    public static <T> Queue<T> concurrentLinkedQueueOf(T first, T... rest) {
        List<T> safeVarargList = rest == null ? List.of() : List.of(rest);
        Queue<T> queue = new ConcurrentLinkedQueue<>();
        queue.add(first);
        queue.addAll(safeVarargList);
        return queue;
    }

    @SafeVarargs
    public static <K, V> Map<K, V> hashMapOf(K key, V value, Map.Entry<K, V>... rest) {
        List<Map.Entry<K, V>> safeVarargList = rest == null ? List.of() : List.of(rest);
        Map<K, V> map = new HashMap<>();
        map.put(key, value);
        safeVarargList.forEach(entry -> map.put(entry.getKey(), entry.getValue()));
        return map;
    }

    private static <T> List<T> listFromNullableArray(T[] rest) {
        return rest == null ? List.of() : List.of(rest);
    }
}
