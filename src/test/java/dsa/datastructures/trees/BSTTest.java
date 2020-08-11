package dsa.datastructures.trees;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BSTTest {

    @Test
    public void emptyTreeTest() {
        BST<Integer> tree = new BST<>();
        assertTrue(tree.isEmpty());
        tree.add(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void sizeOfTreeTest() {
        BST<Integer> tree = new BST<>();
        assertEquals(0, tree.size());
        tree.add(1);
        assertEquals(1, tree.size());
        tree.add(0);
        assertEquals(2, tree.size());
        tree.add(2);
        assertEquals(3, tree.size());
    }

    @Test
    public void addRemoveSearchTest() {
        BST<String> tree = new BST<>();
        tree.add("M");
        tree.add("H");
        tree.add("P");
        tree.add("R");
        assertTrue(tree.contains("R"));
        assertFalse(tree.contains("V"));
        tree.remove("M");
        assertFalse(tree.contains("M"));
        tree.remove("V");
    }

    @Test
    public void heightTest() {
        BST<Integer> tree = new BST<>();
        assertEquals(0, tree.height());
        tree.add(5);
        assertEquals(1, tree.height());
        tree.add(1);
        tree.add(10);
        assertEquals(2, tree.height());
        tree.add(3);
        assertEquals(3, tree.height());
        tree.add(2);
        assertEquals(4, tree.height());
    }

    @Test
    public void inorderTest() {
        BST<Integer> tree = new BST<>();
        String result = "123456789";
        tree.add(5);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(6);
        tree.add(4);

        StringBuilder testResult = new StringBuilder();
        for (Iterator<Integer> it = tree.traverse(Traversal.INORDER); it.hasNext(); ) {
            Integer i = it.next();
            testResult.append(i);
        }
        assertEquals(testResult.toString(), result);
    }

    @Test
    public void preorderTest() {
        BST<Integer> tree = new BST<>();
        /*
                 5
                /\
               /  \
              /    \
             /      \
            3       7
           /\      /\
          /  \    /  \
         2   4   6   8
        /             \
       1               9
         */
        String result = "532147689";
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        tree.add(1);

        StringBuilder testResult = new StringBuilder();
        for (Iterator<Integer> it = tree.traverse(Traversal.PREORDER); it.hasNext(); ) {
            Integer i = it.next();
            testResult.append(i);
        }
        assertEquals(testResult.toString(), result);
    }

    @Test
    public void postorderTest() {
        BST<Integer> tree = new BST<>();
        /*
                 5
                /\
               /  \
              /    \
             /      \
            3       7
           /\      /\
          /  \    /  \
         2   4   6   8
        /             \
       1               9
         */
        String result = "124369875";
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        tree.add(1);

        StringBuilder testResult = new StringBuilder();
        for (Iterator<Integer> it = tree.traverse(Traversal.POSTORDER); it.hasNext(); ) {
            Integer i = it.next();
            testResult.append(i);
        }
        assertEquals(testResult.toString(), result);
    }

    @Test
    public void levelorderTest() {
        BST<Integer> tree = new BST<>();
        /*
                 5
                /\
               /  \
              /    \
             /      \
            3       7
           /\      /\
          /  \    /  \
         2   4   6   8
        /             \
       1               9
                        \
                         10
         */
        String result = "53724681910";
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        tree.add(1);
        tree.add(10);

        StringBuilder testResult = new StringBuilder();
        for (Iterator<Integer> it = tree.traverse(Traversal.LEVEL_ORDER); it.hasNext(); ) {
            Integer i = it.next();
            testResult.append(i);
        }
        assertEquals(testResult.toString(), result);
    }

}
