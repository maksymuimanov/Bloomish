package io.bloomish.api.channel;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

@Injected
public class SimpleKeyedMapChannelBus implements KeyedMapChannelBus {
    private final Map<DataChannel, Map<Object, Map<?, ?>>> channels;

    public SimpleKeyedMapChannelBus() {
        this.channels = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, K1, V1> void send(DataChannel channel, K key, K1 dataKey, V1 data) {
        this.channels.compute(channel, (keyedQueueChannel, multiMap)  -> {
            if (multiMap == null) {
                return CollectionUtils.hashMapOf(key, CollectionUtils.hashMapOf(dataKey, data));
            }
            ((Map<K1, V1>) multiMap.get(key)).put(dataKey, data);
            return multiMap;
        });
    }

    @Override
    public <K, K1, V1> void forEach(DataChannel channel, BiConsumer<? super K, Map<K1, V1>> consumer) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, K1, V1> Stream<KeyedMapChannelEntry<K, K1, V1>> stream(DataChannel channel) {
        return this.channels.getOrDefault(channel, new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new KeyedMapChannelEntry<>(
                                (K) entry.getKey(),
                                (Map<K1, V1>) entry.getValue()
                        )
                );
    }

    @Override
    public <K, K1, V1> void forEachDrain(DataChannel channel, BiConsumer<? super K, Map<K1, V1>> consumer) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, K1, V1> Stream<KeyedMapChannelEntry<K, K1, V1>> drain(DataChannel channel) {
        return Optional.ofNullable(this.channels.remove(channel))
                .orElse(new HashMap<>())
                .entrySet()
                .stream()
                .map(entry ->
                        new KeyedMapChannelEntry<>(
                                (K) entry.getKey(),
                                (Map<K1, V1>) entry.getValue()
                        )
                );
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public <K, V> void send(DataChannel channel, K key, V data) {
//        this.channels.compute(channel, (keyedQueueChannel, queueMap)  -> {
//            if (queueMap == null) {
//                Map<Object, Queue<?>> map = new HashMap<>();
//                map.put(key, CollectionUtils.concurrentLinkedQueueOf(data));
//                return map;
//            }
//            ((Queue<V>) queueMap.get(key)).add(data);
//            return queueMap;
//        });
//    }
//
//    @Override
//    public <K, V> void forEach(DataChannel channel, BiConsumer<? super K, Queue<V>> consumer) {
//        this.<K, V>stream(channel).forEach(entry -> consumer.accept(entry.key(), entry.value()));
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public <K, V> Stream<KeyedQueueChannelEntry<K, V>> stream(DataChannel channel) {
//        return this.channels.getOrDefault(channel, new HashMap<>())
//                .entrySet()
//                .stream()
//                .map(entry ->
//                        new KeyedQueueChannelEntry<>(
//                                (K) entry.getKey(),
//                                (Queue<V>) entry.getValue()
//                        )
//                );
//    }
//
//    @Override
//    public <K, V> void forEachDrain(DataChannel channel, BiConsumer<? super K, Queue<V>> consumer) {
//        this.<K, V>drain(channel).forEach(entry -> consumer.accept(entry.key(), entry.value()));
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public <K, V> Stream<KeyedQueueChannelEntry<K, V>> drain(DataChannel channel) {
//        return Optional.ofNullable(this.channels.remove(channel))
//                .orElse(new HashMap<>())
//                .entrySet()
//                .stream()
//                .map(entry ->
//                        new KeyedQueueChannelEntry<>(
//                                (K) entry.getKey(),
//                                (Queue<V>) entry.getValue()
//                        )
//                );
//    }
//


}
