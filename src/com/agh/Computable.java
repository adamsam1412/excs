package com.agh;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Computable<K, V, T> {
    Set<T> intersection(Set<T> set1, Set<T> set2);
    Map<K, V> mapIntersection(Map<K, V> map1, Map<K, V> map2);
}
