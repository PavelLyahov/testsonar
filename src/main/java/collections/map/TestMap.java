package collections.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(Map.of("key1", "Value1", "Key2", "Value2"));
        map.put(null, "value4");
        map.put("key5", null);
        System.out.println(map);

        String str = map.entrySet().stream()
                .filter(e -> e.getValue().equals("Value2"))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(RuntimeException::new);
        System.out.println(str);

    }

}


/*
    public interface Map<K, V> {
        int size();
        boolean isEmpty();
        boolean containsKey(Object key);
        boolean containsValue(Object value);
        void putAll(java.util.Map<? extends K, ? extends V> m);
        void clear();
        Set<K> keySet();
        Collection<V> values();
        Set<java.util.Map.Entry<K, V>> entrySet();
        interface Entry<K, V> {
            public static <K extends Comparable<? super K>, V> Comparator<java.util.Map.Entry<K, V>> comparingByKey()
            public static <K, V extends Comparable<? super V>> Comparator<java.util.Map.Entry<K, V>> comparingByValue()
            public static <K, V> Comparator<java.util.Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp)
            public static <K, V> Comparator<java.util.Map.Entry<K, V>> comparingByValue(Comparator<? super V> cmp)
        default V getOrDefault(Object key, V defaultValue)
        default void forEach(BiConsumer<? super K, ? super V> action)
        default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        default V putIfAbsent(K key, V value)
        default boolean remove(Object key, Object value)
        default boolean replace(K key, V oldValue, V newValue)
        default V replace(K key, V value)
        default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
        default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction);
        default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
        static <K, V> java.util.Map<K, V> ofEntries(java.util.Map.Entry<? extends K, ? extends V>... entries)
        static <K, V> java.util.Map.Entry<K, V> entry(K k, V v);
        static <K, V> java.util.Map<K, V> copyOf(java.util.Map<? extends K, ? extends V> map) ;
    */
