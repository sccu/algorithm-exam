package pe.sccu.algorithm.disjointset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DisjointSetTest {

    @Test
    public void test() {
        DisjointSet<Integer> a = DisjointSet.create(1);
        DisjointSet<Integer> b = DisjointSet.create(2);
        DisjointSet<Integer> c = DisjointSet.create(3);
        DisjointSet<Integer> d = DisjointSet.create(3);
        DisjointSet.union(b, c);
        DisjointSet.union(a, d);

        assertTrue(a.find() != b.find());
        assertTrue(c.find() == b.find());
        assertTrue(a.find() == d.find());
        assertEquals(2, (int) c.find().getData());
        assertEquals(2, (int) b.find().getData());
        assertEquals(1, (int) a.find().getData());
        assertEquals(1, (int) d.find().getData());
    }

}
