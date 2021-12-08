package io.github.masamonoke.rangelib.rangeset;

public interface Set <T> {
    public T add(T value);
    public T delete(T value);
    public boolean isContains(T value);
    int size();
}
