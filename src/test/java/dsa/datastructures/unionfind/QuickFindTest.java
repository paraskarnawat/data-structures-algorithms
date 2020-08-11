package dsa.datastructures.unionfind;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class QuickFindTest {

    @Test
    public void testNumberOfComponents() {
        QuickFind uf = new QuickFind(10);
        assertEquals(10, uf.components());

        uf.union(0, 1);
        assertEquals(9, uf.components());

        uf.union(1, 0);
        assertEquals(9, uf.components());

        uf.union(6, 9);
        uf.union(9, 0);
        assertEquals(7, uf.components());

        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(3, 4);
        uf.union(4, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(7, 8);
        assertEquals(1, uf.components());
    }

    @Test
    public void testSize() {
        QuickFind uf = new QuickFind(10);
        assertEquals(10, uf.size());
        uf.union(1, 2);
        assertEquals(10, uf.size());
    }

    @Test
    public void testFindAndConnected() {
        QuickFind uf = new QuickFind(5);

        assertEquals(1, uf.find(1));
        assertFalse(uf.connected(1, 2));

        uf.union(1, 2);
        assertEquals(2, uf.find(1));
        assertTrue(uf.connected(1, 2));
        assertFalse(uf.connected(1, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroElements() {
        new QuickFind(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeElements() {
        new QuickFind(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfBounds() {
        QuickFind uf = new QuickFind(5);
        uf.connected(1, 9);
    }

}
