package com.paraskarnawat.dsa.datastructures.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of Stack
 * <p>
 * Generic LIFO (Last In First Out) data structure - Stack.
 * It usually supports <em>push</em> and <em>pop</em> operations, along with methods
 * to peek the top item, check if stack is empty and iterating in LIFO order.
 *
 * {@code push, pop} operations take constant amortized time. This is because it doubles the underlying array when
 * it is full and halves the underlying array when it is 25 percent (one-quarter) full.
 * {@code size, peek, is-empty} operations take constant time in worst case.
 *
 * </p>
 * @author Paras Karnawat
 */
public class Stack<T> implements Iterable<T> {
    private int top;
    private T[] array;

    @SuppressWarnings("unchecked")
    public Stack() {
        top = 0;
        array = (T[]) new Object[2];
    }

    /**
     * Is this stack empty?
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Returns the number of items in the stack.
     *
     * @return the number of items in the stack
     */
    public int size() {
        return top;
    }

    // resize the array to new capacity
    private void resize(int capacity) {
        assert capacity >= top;
        array = Arrays.copyOf(array, capacity);
    }

    /**
     * Add an element to the stack
     *
     * @param element the element to add
     */
    public void push(T element) {
        if (top == array.length) {
            resize(array.length * 2);
        }
        array[top++] = element;
    }

    /**
     * Removes and returns the last element added to this stack
     *
     * @return the recently added element
     * @throws NoSuchElementException if stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow. No element in the stack.");
        }
        T element = array[top - 1];
        array[top - 1] = null;
        top--;

        if (top > 0 && top == (array.length / 4)) {
            resize(array.length / 2);
        }
        return element;
    }

    /**
     * Returns but does not remove the last element added to this stack
     *
     * @return the recently added element
     * @throws NoSuchElementException if stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow. No element in the stack.");
        }
        return array[top - 1];
    }

    /**
     * Return an iterator to this stack which iterates this stack in LIFO order
     * @return an iterator of this stack in LIFO order
     */
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    // iterator class; doesn't implement remove
    private class StackIterator implements Iterator<T> {

        private int i;

        public StackIterator() {
            i = top - 1;
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Stack underflow. No element in the stack.");
            }
            return array[i--];
        }
    }
}
