package io.github.masamonoke.rangelib.rangeset;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import io.github.masamonoke.rangelib.BST;
import io.github.masamonoke.rangelib.Range;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class RangeSet <T extends Comparable<T>> implements Set<Range<T>> {
    final BST<Range<T>> tree = new BST<>();

    @Override
    public Range<T> add(Range<T> value) {
        return tree.add(value);
    }

    @Override
    public Range<T> delete(Range<T> value) {
        return tree.deleteNode(value);
    }

    @Override
    public boolean isContains(Range<T> value) {
        return tree.isContainsNode(value);
    }

    @Override
    public int size() {
        return tree.getSize();
    }

    @Override
    public String toString() {
        return tree.toString();
    }
}
