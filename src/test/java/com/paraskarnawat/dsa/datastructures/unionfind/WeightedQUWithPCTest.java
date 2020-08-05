package com.paraskarnawat.dsa.datastructures.unionfind;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class WeightedQUWithPCTest {

    @Test
    public void testNumberOfComponents() {
        WeightedQUWithPC uf = new WeightedQUWithPC(10);
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
        WeightedQUWithPC uf = new WeightedQUWithPC(5);
        assertEquals(5, uf.size());
        uf.union(1, 2);
        assertEquals(5, uf.size());
    }

    @Test
    public void testComponentSize() {
        WeightedQUWithPC uf = new WeightedQUWithPC(5);
        assertEquals(1, uf.componentSize(1));
        uf.union(1, 2);
        assertEquals(2, uf.componentSize(2));
        uf.union(2, 1);
        assertEquals(2, uf.componentSize(1));
        uf.union(2, 3);
        uf.union(1, 4);
        uf.union(0, 4);
        assertEquals(5, uf.componentSize(4));
        assertEquals(5, uf.componentSize(0));
    }

    @Test
    public void testFindAndConnected() {
        WeightedQUWithPC uf = new WeightedQUWithPC(5);

        assertEquals(1, uf.find(1));
        assertFalse(uf.connected(1, 2));

        uf.union(1, 2);
        assertEquals(1, uf.find(1));
        uf.union(1, 3);
        assertEquals(1, uf.find(3));
        assertTrue(uf.connected(1, 2));
        assertFalse(uf.connected(1, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroElements() {
        new WeightedQUWithPC(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeElements() {
        new WeightedQUWithPC(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfBounds() {
        WeightedQUWithPC uf = new WeightedQUWithPC(5);
        uf.connected(1, 9);
    }

}
