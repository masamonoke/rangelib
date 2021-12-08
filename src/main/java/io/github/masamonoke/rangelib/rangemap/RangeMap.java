package io.github.masamonoke.rangelib.rangemap;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import io.github.masamonoke.rangelib.BST;
import io.github.masamonoke.rangelib.Range;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class RangeMap <K extends Comparable<K>, V> implements Map<Range<K>, V> {
    final BST<Entry<Range<K>, V>> tree = new BST<>();


    @Override
    public V get(Range<K> key) {
        Entry<Range<K>, V> entry = tree.get((Entry<Range<K>, V>) new Entry<>(key, null));
        return entry == null ? null : entry.value;
    }

    @Override
    public V put(Range<K> key, V value) {
        Entry<Range<K>, V> entry = tree.add(new Entry<>(key, value));
        return entry == null ? null : entry.value;
    }

    @Override
    public void update(Range<K> key, V value) {
        Entry<Range<K>, V> entry = tree.get((Entry<Range<K>, V>) new Entry<>(key, null));
        if (entry != null) {
            entry.value = value;
        }
    }

    @Override
    public V remove(Range<K> key) {
        Entry<Range<K>, V> entry = tree.deleteNode((Entry<Range<K>, V>) new Entry<>(key, null));
        return entry == null ? null : entry.value;
    }

    @Override
    public boolean isContainsKey(Range<K> key) {
        return tree.isContainsNode((Entry<Range<K>, V>) new Entry<>(key, null));
    }
}
