package pe.sccu.ds.disjointset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pe.sccu.ds.disjointset.DisjointSet;

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
        assertEquals(2, (int) c.find().get());
        assertEquals(2, (int) b.find().get());
        assertEquals(1, (int) a.find().get());
        assertEquals(1, (int) d.find().get());
    }

}
