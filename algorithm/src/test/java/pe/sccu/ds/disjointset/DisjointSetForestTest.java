package pe.sccu.ds.disjointset;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DisjointSetForestTest {

    @Test
    public void test() {
        DisjointSetForest<Integer> forest = new DisjointSetForest<Integer>();
        forest.add(1);
        forest.add(2);
        forest.union(1, 2);
        forest.add(3);

        assertTrue(forest.isJoined(1, 2));
        assertTrue(!forest.isJoined(1, 3));
        assertTrue(!forest.isJoined(2, 3));
    }

}
