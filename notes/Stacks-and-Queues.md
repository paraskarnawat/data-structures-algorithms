# Stacks and Queues

## Resources

- [Everything Computer Science](https://everythingcomputerscience.com/)
- [Algorithms, Part 1](https://www.coursera.org/learn/algorithms-part1)

---

## Stacks

Stack is a container of objects that are inserted and removed according to the _**last-in first-out**_ (LIFO) principle.

> A helpful analogy is to think of a stack of plates, you can only remove the top plate and only add a new plate on top.

Mainly, it supports two operations

- `push` - to push (add) an element onto the stack.
- `pop` - to remove the recently added element from the stack.

<p align="center">
    <img src="https://everythingcomputerscience.com/images/stackImg.jpg" alt="stack-visual">
</p>

Both `push` and `pop` operations require constant time, that is, **O(1)** time complexity.
However, if the underlying container (array or linked list) is a dynamic array it is **amortized** constant time.

> Amortized time is the way to express the time complexity when an algorithm has the very bad time complexity only once
> in a while besides the time complexity that happens most of time. Good example would be an ArrayList which is a data structure that contains an array and can be extended.

Implementation can be found [here](../src/main/java/dsa/datastructures/stack/Stack.java). It uses a
dynamic array as a container.

Following are some of the important applications of a Stack data structure:

- for expression evaluation.
- for parsing the syntax of expressions, program blocks etc. before translating into low level code.
- to check parenthesis matching in an expression.
- for conversion from one form of expression to another (infix, postfix, prefix).
- for compile time memory management.
- in backtracking problems.
- in several algorithms like Graham Scan (convex hull of 2D points).

## Queue

Queue is a container of objects (a linear collection) that are inserted and removed according to the _**first-in first-out**_
(FIFO) principle.

> An excellent example of queue is the line of people waiting to buy their tickets at the cinema hall. New person to a
> line is at the end of the queue, while the first person in line is given the ticket first, that is, removed from
> the queue.

It also supports two main operations:
- `enqueue` - insert an element at the back of the queue.
- `dequeue` - remove the front element (least recent).

<p align="center">
    <img src="https://everythingcomputerscience.com/images/queueImg.jpg" alt="queue-visual">
</p>

Both `enqueue` and `dequeue` operations take constant time, that is, **O(1)** depending on the implementation of the
underlying container (arrays or linked list).

Implementation is [here](../src/main/java/dsa/datastructures/queue/Queue.java). It uses linked list as a container.

This is a basic type of queue. There are several types, which will be covered later. These include:
- Deque (Double Ended Queue)
- Circular Queue
- Priority Queue

Some applications of queue include:
- keyboard buffer.
- printer spooler so that jobs can be printed in order of their arrival.
- asynchronous data transfer (data not necessarily received at same rate as sent) between two processes. Examples include IO Buffers, pipes, file IO, etc.
- resource sharing among multiple consumers. Examples include CPU scheduling, disk Scheduling.