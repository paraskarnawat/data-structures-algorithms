package com.paraskarnawat.dsa.datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of Queue.
 *
 * <p>
 * Queue is a FIFO (First In First Out) data structure. It usually supports <em>enqueue</em> and
 * <em>dequeue</em> operations along with peeking the first item, checking is queue is empty and fetching the
 * number of elements in the queue.
 *
 * {@code enqueue, dequeue, size, is-empty, peek} operations all take constant time in worst case.
 * </p>
 *
 * @author Paras Karnawat
 */
public class Queue<T> implements Iterable<T> {

    private int numberOfElements;
    private Node<T> front;
    private Node<T> rear;

    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E element) {
            data = element;
            next = null;
        }
    }

    public Queue() {
        front =  null;
        rear = null;
        numberOfElements = 0;
    }

    /**
     * Is the queue empty?
     *
     * @return {@code true} if queue is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Number of elements in the queue
     *
     * @return number of elements in the queue
     */
    public int size() {
        return numberOfElements;
    }

    /**
     * Add an element to the queue in FIFO order
     *
     * @param element element to be added
     */
    public void enqueue(T element) {
        Node<T> node = new Node<>(element);
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        numberOfElements++;
    }

    /**
     * Remove and return the element that was added least recently
     *
     * @return least recently added element
     * @throws NoSuchElementException if queue is empty
     */
    public T dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue underflow. No element is present in this queue.");
        }
        T element = front.data;
        front = front.next;
        numberOfElements--;
        if (isEmpty()) {
            rear = null;
        }
        return element;
    }

    /**
     * Returns but does not remove the least recently added element
     *
     * @return least recently added element
     * @throws NoSuchElementException if queue is empty
     */
    public T peek() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue underflow. No element is present in this queue.");
        }
        return front.data;
    }

    /**
     * Returns an iterator to iterate the queue in FIFO order
     *
     * @return the queue iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator(front);
    }

    // queue iterator class
    private class QueueIterator implements Iterator<T> {
        private Node<T> current;

        public QueueIterator(Node<T> first) {
            current = first;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Queue underflow. No element is present in this queue.");
            }
            T elem = current.data;
            current = current.next;
            return elem;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
    }
}
