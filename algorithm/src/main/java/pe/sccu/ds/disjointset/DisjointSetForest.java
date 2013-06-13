package pe.sccu.ds.disjointset;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetForest<T> {

    private final Map<T, DisjointSet<T>> map = new HashMap<T, DisjointSet<T>>();

    public void add(T x) {
        map.put(x, DisjointSet.create(x));
    }

    public boolean isJoined(T x, T y) {
        DisjointSet<T> s1 = map.get(x);
        DisjointSet<T> s2 = map.get(y);
        return s1.find() == s2.find();
    }

    public void union(T x, T y) {
        DisjointSet<T> s1 = map.get(x);
        DisjointSet<T> s2 = map.get(y);
        DisjointSet.union(s1, s2);
    }
}
