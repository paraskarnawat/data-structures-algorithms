package com.paraskarnawat.dsa.datastructures.queue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void emptyQueueTest() {
        Queue<String> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue("Hi!");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void sizeTest() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.enqueue(3);
        assertEquals(3, queue.size());
        queue.dequeue();
        assertEquals(2, queue.size());
        queue.dequeue();
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void enqueueDequeuePeekTest() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("Hello");
        queue.enqueue("World");
        assertEquals("Hello", queue.peek());
        assertEquals("Hello", queue.dequeue());
        assertEquals("World", queue.peek());
        assertEquals("World", queue.dequeue());
    }

    @Test
    public void iteratorTest() {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new Queue<>();

        for (int i = 1; i <= 5; i++) {
            list.add(i);
            queue.enqueue(i);
        }
        for (Integer i: queue) {
            assertEquals(i, list.get(i - 1));
        }
   }

}
