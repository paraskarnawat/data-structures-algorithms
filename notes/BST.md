# Binary Search Trees

## Resources

- [Algorithms, Part 1](https://www.coursera.org/learn/algorithms-part1)
- [Geeks for Geeks](https://www.geeksforgeeks.org/binary-search-tree-data-structure/)

---

Binary Search Tree is a node-based non-linear data structure which has the following properties:

- The left subtree of a node contains only nodes with keys lesser than the node’s key.
- The right subtree of a node contains only nodes with keys greater than the node’s key.
- The left and right subtree each must also be a binary search tree.

<p align="center">
    <img src="https://cdn.programiz.com/sites/tutorial2program/files/bst-vs-not-bst.jpg" alt="bst-visual">
</p>

It supports three operations:

- `insert / add` - insert an element in the BST
- `contains / search` - check if an element is present in the BST
- `remove / delete` - remove an element from the BST

> Time complexity of all BST Operations = **O(h)**.
> Here, h = Height of binary search tree.

However, in the worst case when the insertion order is {1, 2, 3, 4, 5, 6, 7}, such as follows:

<p align="center">
    <img src="https://www.gatevidyalay.com/wp-content/uploads/2018/08/Time-Complexity-of-Binary-Search-Tree-Worst-Case.png" alt="skewed-visual">
</p>

Height of the binary search tree becomes **n**.
So, Time complexity of BST Operations = **O(n)** where **n** is the number of elements.

The best case is as follows:

<p align="center">
    <img src="https://www.gatevidyalay.com/wp-content/uploads/2018/08/Time-Complexity-of-Binary-Search-Tree-Best-Case.png" alt="balanced-bst">
</p>

The height of the balanced BST becomes **log2(N)**. So, time complexity of BST operations = **O(log2(N))**.

The drawback of BST is that it is not self-balancing. In other words, if the order of insertion is in ascending or descending sequence,
the height of the tree equals the number of elements inserted. This is no different than storing the elements in an array. To
overcome this, there are several self-balancing BSTs such as:
- AVL trees
- Red-Black trees, and more.

## Traversals

<p align="center">
    <img src="https://lh3.googleusercontent.com/proxy/oHtv1w4eSmpMdN1y6HCnvD24JnkE9KJp14kE8e9LVkrko54WwxEOJWBGi3Ltm4ufiJ3l6RaRtJQ_3ugpR6tznvhXLgRBrzgPrGUWOgKQPUpn6SI6LyZilXSCsh0sZ9iNFCWqC-hQwNI6EXz2" alt="traversal-visual">
</p>

Non-linear data structures have various ways to traverse the data structure. These include:
- **Depth First Traversal**:
    - **Inorder**: _Left - Root - Right_
    > In case of binary search trees (BST), inorder traversal gives nodes in non-decreasing order. To get nodes of BST in non-increasing order, a variation of inorder traversal where inorder traversal's reversed can be used.
    ```
        1. Traverse the left subtree
        2. Visit the root
        3. Traverse the right subtree
    ```
    - **Preorder**: _Root - Left - Right_
    > Preorder traversal is used to create a copy of the tree. It is also used to get prefix expression on of an expression tree. Please see [here](http://en.wikipedia.org/wiki/Polish_notation) to know why prefix expressions are useful.
    ```
            1. Visit the root
            2. Traverse the left subtree
            3. Traverse the right subtree
    ```
    - **Postorder**: _Left - Right - Root_
    > Postorder traversal is also useful to get the postfix expression of an expression tree. Please see [here](http://en.wikipedia.org/wiki/Reverse_Polish_notation) for the usage of postfix expression.
    ```
            1. Traverse the left subtree
            2. Traverse the right subtree
            3. Visit the root
    ```
- **Breadth First Traversal**:
    - **Level order**
    > Trees can also be traversed in level order, where every node in current level must be visited before going to the next level.

Implementation of BST and traversals is [here](../src/main/java/dsa/datastructures/trees/BST.java).