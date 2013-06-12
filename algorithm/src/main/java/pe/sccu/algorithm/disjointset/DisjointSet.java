package pe.sccu.algorithm.disjointset;

public class DisjointSet<T> {

    public static <T> DisjointSet<T> create(T x) {
        return new DisjointSet<T>(x);
    }

    public static <T> void union(DisjointSet<T> x, DisjointSet<T> y) {
        DisjointSet<T> xRoot = x.find();
        DisjointSet<T> yRoot = y.find();
        if (xRoot.rank > yRoot.rank) {
            yRoot.parent = xRoot;
        } else if (xRoot.rank < yRoot.rank) {
            xRoot.parent = yRoot;
        } else if (xRoot != yRoot) {
            yRoot.parent = xRoot;
            xRoot.rank = xRoot.rank + 1;
        }
    }

    private final T data;

    private DisjointSet<T> parent;

    private int rank = 0;

    private DisjointSet(T data) {
        this.data = data;
        this.parent = this;
    }

    public DisjointSet<T> find() {
        if (parent != this) {
            parent = parent.find();
        }
        return parent;
    }

    public T getData() {
        return data;
    }
}
