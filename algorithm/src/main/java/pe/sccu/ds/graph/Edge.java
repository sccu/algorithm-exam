package pe.sccu.ds.graph;

public class Edge {

    private final int u;
    private final int v;
    private final double weight;

    public Edge(int u, int v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Edge)) {
            return false;
        }

        Edge other = (Edge) o;
        if (u == other.u && v == other.v) {
            return true;
        }

        return false;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        super.hashCode();
        return (u + 17) * 31 + v;
    }

}
