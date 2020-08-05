# Union-find or Disjoint Sets

### Resources

- [Course - Algorithms, Part 1](https://www.coursera.org/learn/algorithms-part1)
- [Youtube - Abdul Bari](https://www.youtube.com/watch?v=wU6udHRIkcc)
- [Blog - Techie Delight](https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/)
---
**A disjoint-set is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-intersecting) subsets. In simple words, no item can be in more than one set. It is also called as union-find data structure as it supports the union and find operations on subsets.**

Given a set of N objects, there are two functions to be performed:
   1. **Union**: connect two objects.
   2. **Find**: who is the parent of a particular object? This can be used to find whether two objects are `connected` i.e. their parents are same.
    
![uf-visualisation " "](../images/uf.gif)

The `connected` command is an equivalence relation:
  - **Reflexive**: `p` is connected to `p`.
  - **Symmetric**: if `p` is connected to `q`, then `q` is connected to `p`.
  - **Transitive**: if `p` is connected to `q`, and `q` is connected to `r`, then `p` is connected to `r`.
 
**Connected Components**: maximal set of objects that are mutually connected.

There are several ways to implement this data structure.

![ways-to-implement-union-find " "](https://image.slidesharecdn.com/timecomplexityofunionfind-151206023623-lva1-app6892/95/time-complexity-of-union-find-7-638.jpg?cb=1449683659)

## Quick Find

This is also called as eager approach. In this method, `p` and `q` are connected if and only if they have the same id.

<p align="center">
    <img src="http://underpop.online.fr/j/java/img/01fig03.gif" alt="UF-visualization">
</p>

**Find**: Check if `p` and `q` have the same id.

**Union**: To merge components containing `p` and `q`, change all entries whose id equals `id[p]` to `id[q]`.

Code can be found [here](../src/main/java/com/paraskarnawat/dsa/datastructures/unionfind/QuickFind.java).

> Here the `find` operation is quick **_O(1)_** however `union` command is too expensive. If there are `m` union commands and `n` number of objects, then `union` will have quadratic time complexity i.e. **_O(nm)_**. The trees are flat, but too expensive to keep them flat.

## Quick Union

This is also called the lazy approach. In this approach, `id[i]` is the parent of `i`. The root of `i` is `id[id[id[id[...id[i]...]]]]`. We keep finding the root, until `id[i] == i`.

**Find**: Check if `p` and `q` have the same root.

**Union**: To merge components containing `p` and `q`, set the id of root of `p` to id of root of `q`.

<p align="center">
    <img src="https://algs4.cs.princeton.edu/15uf/images/quick-union-overview.png" alt="quick-find">
</p>

Code can be found [here](../src/main/java/com/paraskarnawat/dsa/datastructures/unionfind/QuickUnion.java).

> Here the single `union` and `find` command have time complexity of **_O(n)_** (worst case). The trees can get tall and `find` command is too expensive.


## Weighted (or Ranked) Quick Union

Modification of quick-union to avoid tall trees. Keep track of size of each tree (number of objects in each tree). Balance by linking root of smaller tree to the larger tree.

<p align="center">
    <img src="https://d33wubrfki0l68.cloudfront.net/9fb2e04ab32dd3c090f82edd2055e5f52094dbb7/8bd6f/static/weighted-quick-union-6dcb2433f67d42a6354d47340fbf4615.png" alt="quick union vs. weighted quick union">
</p>

It is same as quick-union, but we maintain an extra array of size[] to count the number of objects in the tree rooted at `i`.

**Find**: Identical to Quick Union.

**Union**: Modify the quick-union to link the root of smaller tree to root of larger tree and update the `size` array.

Code can be found [here](../src/main/java/com/paraskarnawat/dsa/datastructures/unionfind/WeightedQuickUnion.java).

> `find` takes time proportional to depth of `p` and `q`. `union` takes constant time, given roots. Moreover, depth of any node is at most `log2(N)`. Thus, both the operations have time complexity of **_O(lg N)_** for a single operation.

<p align="center">
    <img src="https://algocoding.files.wordpress.com/2014/09/uf4_union_by_rank.png" alt="weighted-quick-union">
</p>

## Weighted Quick Union Find with Path Compression

After we fetch the root of `p`, set the id of each examined node to point to that root. In simple words, everytime we get the `id[i]`, we set it the new `id[i]` to the grandparent. Thus, keeping the trees almost flat.

**Find**: same as weighted quick-union.

**Union**: same as weighted quick-union.

However, only the `root` function is changed.

<p align="center">
    <img src="https://raw.githubusercontent.com/e-maxx-eng/e-maxx-eng/master/img/DSU_path_compression.png" alt="effect of path compression">
</p>

Code can be found [here](../src/main/java/com/paraskarnawat/dsa/datastructures/unionfind/WeightedQUWithPC.java).

> This small improvement improves the time-complexity of `m` union-find operations on `n` objects to __c(n + m lg*(n))__ array accesses which is an iterative log function. If `n = 65536` then `lg*(n) = 4`. It is the number of times the logarithm function should be applied before the result is less than or equal to 1.

## Applications

1. Grid Percolation
2. Kruskal's MST algorithm to detect cycles in a graph
3. Games (Go, Hex)
4. Network Connectivity
5. Image Processing
6. Maze Generation