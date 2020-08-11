package dsa.datastructures.stack;

import dsa.datastructures.stack.Stack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackTest {

    @Test
    public void emptyStackTest() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void sizeTest() {
        Stack<String> stack = new Stack<>();
        assertEquals(0, stack.size());
        for (int i = 0; i < 100; i++) {
            stack.push(String.valueOf(i));
            assertEquals(i + 1, stack.size());
        }
        for (int i = 0; i < 100; i++) {
            stack.pop();
            assertEquals(100 - i - 1, stack.size());
        }
        assertEquals(0, stack.size());
    }

    @Test
    public void pushPopPeekTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        assertEquals(1, stack.size());
        int i = stack.peek();
        stack.pop();
        assertEquals(0, i);
        stack.push(2);
        stack.push(3);
        stack.push(42);
        i = stack.pop();
        assertEquals(42, i);
        i = stack.pop();
        assertEquals(3, i);
        i = stack.pop();
        assertEquals(2, i);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void iteratorTest() {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= 5; i++) {
            list.add(i);
            stack.push(i);
        }
        Collections.reverse(list);
        int k = 0;
        for (Integer i: stack) {
            assertEquals(i, list.get(k));
            k++;
        }
    }
}
