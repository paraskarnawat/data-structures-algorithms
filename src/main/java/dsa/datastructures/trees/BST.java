package dsa.datastructures.trees;

import dsa.datastructures.queue.Queue;
import dsa.datastructures.stack.Stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Binary Search Trees (BST) implementation.
 * <p>
 *
 * BST is ordered tree data structure. The value of all nodes in the left sub-tree is less than the value of root.
 * Similarly, the value of all nodes in the right sub-tree is greater than the value of the root. This property is
 * recursively applied to all left and right sub-trees.
 *
 * {@code add} operation takes <em>O(n)</em> time in worst-case. In general, it is <em>&Theta;(h)</em>.
 * {@code remove} operation takes <em>O(n)</em> time in worst-case. In general, it is <em>&Theta;(h)</em>.
 * {@code contains} operation takes <em>O(n)</em> time in worst-case. In general, it is <em>&Theta;(h)</em>.
 * {@code height} operation takes <em>O(n)</em> time.
 * {@code size} operation takes <em>O(1)</em> time.
 *
 * {@code h} represents the height of the tree.
 *
 * <p>
 *
 * @author Paras Karnawat
 */
public class BST<T extends Comparable<T>> {

    private int nodeCount;
    private Node root;

    private class Node {
        T data;
        Node left, right;

        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /**
     * Returns true if this tree is empty.
     *
     * @return {@code true} if this tree is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Fetch the number of nodes in this tree.
     *
     * @return the number of nodes in this tree
     */
    public int size() {
        return nodeCount;
    }

    /**
     * Check whether this tree contains the given element
     *
     * @param element the element to search for
     * @return {@code true} if present in this tree, {@code false} otherwise.
     */
    public boolean contains(T element) {
        return contains(root, element);
    }

    // checks whether the element is present in this tree
    private boolean contains(Node node, T element) {
        while (node != null) {
            int compare = element.compareTo(node.data);
            if (compare < 0) {
                node = node.left;
            } else if (compare > 0) {
                node = node.right;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Insert an element in this tree, if it is already present {@code false} is returned, otherwise,
     * the element is added to this tree and {@code true} is returned.
     *
     * @param element an element to add
     * @return {@code true} if added successfully, {@code false} otherwise.
     */
    public void add(T element) {
        if (!contains(element)) {
            root = add(root, element);
            nodeCount++;
        }
    }

    // adds the element to this tree
    private Node add(Node node, T element) {
        if (node == null) {
            return new Node(element);
        }
        Node current = node;
        while (true)
        {
            if (element.compareTo(current.data) < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node(element);
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Node(element);
                    break;
                }
            }
        }

        return node;
    }

    /**
     * Remove an element from this tree.
     *
     * @param element an element to remove
     */
    public void remove(T element) {
        if (contains(element)) {
            root = remove(root, element);
            nodeCount--;
        }
    }

    // remove the given element from this tree
    private Node remove(Node node, T element) {
        if (node == null) {
            return null;
        }

        int compare = element.compareTo(node.data);

        if (compare < 0) {
            node.left = remove(node.left, element);
        } else if (compare > 0) {
            node.right = remove(node.right, element);
        } else {
            // replace with right subtree
            if (node.left == null) {
                return node.right;
            // replace with left subtree
            } else if (node.right == null) {
                return node.left;
            // both child are not null
            } else {
                // find minimum in right sub-tree
                Node temp = findMin(node.right);
                // swap values
                node.data = temp.data;
                // remove the swapped value from the right sub-tree
                node.right = remove(node.right, temp.data);
            }
        }
        return node;
    }

    // get the minimum value in this tree
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Get the height of this tree.
     *
     * @return height of this tree
     */
    public int height() {
        return height(root);
    }

    // calculate the height
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        Queue<Node> queue = new Queue<>();
        queue.enqueue(node);

        int height = 0;
        int count;
        while (!queue.isEmpty()) {
            count = queue.size();
            if (count == 0) {
                break;
            }
            height++;
            while (count > 0) {
                Node temp = queue.dequeue();
                if (temp.left != null) {
                    queue.enqueue(temp.left);
                }
                if (temp.right != null) {
                    queue.enqueue(temp.right);
                }
                count--;
            }
        }
        return height;
    }

    /**
     * An iterator to traverse the tree in any of orders provided by {@link Traversal}
     *
     * @param order type of traversal
     * @return iterator of given traversal
     */
    public Iterator<T> traverse(Traversal order) {
        switch (order) {
            case PREORDER:
                return preorderIterator();
            case INORDER:
                return inorderIterator();
            case POSTORDER:
                return postorderIterator();
            case LEVEL_ORDER:
                return levelIterator();
            default:
                return null;
        }
    }

    // create a preorder iterator
    private Iterator<T> preorderIterator() {
        final int expectedCount = nodeCount;
        final Stack<Node> stack = new Stack<>();
        stack.push(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException("Tree was modified while traversing.");
                }
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException("Tree was modified while traversing.");
                }
                Node node = stack.pop();
                // push right child first then left so that left child is popped first
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                return node.data;
            }
        };
    }

    // create an inorder iterator
    private Iterator<T> inorderIterator() {
        final int expectedCount = nodeCount;
        final Stack<Node> stack = new Stack<>();
        stack.push(root);

        return new Iterator<T>() {

            Node curr = root;

            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException("Tree was modified while traversing.");
                }
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException("Tree was modified while traversing.");
                }
                while (curr.left != null) {
                    stack.push(curr.left);
                    curr = curr.left;
                }

                Node node = stack.pop();

                // check if right is present
                if (node.right != null) {
                    stack.push(node.right);
                    curr = node.right;
                }
                return node.data;
            }
        };
    }

    // create a postorder iterator
    private Iterator<T> postorderIterator() {
        final int expectedCount = nodeCount;
        final Stack<Node> firstStack = new Stack<>();
        final Stack<Node> secondStack = new Stack<>();
        firstStack.push(root);

        while (!firstStack.isEmpty()) {
            Node node = firstStack.pop();
            secondStack.push(node);
            if (node.left != null) {
                firstStack.push(node.left);
            }
            if (node.right != null) {
                firstStack.push(node.right);
            }
        }

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException("Tree was modified while traversing.");
                }
                return root != null && !secondStack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException("Tree was modified while traversing.");
                }
                return secondStack.pop().data;
            }
        };
    }

    // create a level order iterator
    private Iterator<T> levelIterator() {
        final int expectedCount = nodeCount;
        final Queue<Node> queue = new Queue<>();
        queue.enqueue(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException("Tree was modified while traversing.");
                }
                return root != null && !queue.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException("Tree was modified while traversing.");
                }
                Node node = queue.dequeue();
                if (node.left != null) {
                    queue.enqueue(node.left);
                }
                if (node.right != null) {
                    queue.enqueue(node.right);
                }
                return node.data;
            }
        };
    }
}
