package com.paraskarnawat.dsa.datastructures.unionfind;

/**
 * Union-Find data structure using weighted or ranked quick-union algorithm.
 * <p>
 * {@code find} operation takes <em>O(lg n)</em> time.
 * {@code union} operation takes <em>O(lg n)</em> time.
 *
 * The general idea is to connect the smaller tree below the larger tree to avoid tall trees.
 * <p>
 *
 * @author Paras Karnawat
 */
public class WeightedQuickUnion {
    // number of connected components
    private int numberOfComponents;

    // array to store the connected components
    private final int[] id;

    // array to store the size of each component
    private int[] sz;

    /**
     * Constructor for class WeightedQuickUnion. Initializes the required attributes.
     *
     * @param size number of elements
     */
    public WeightedQuickUnion(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0. You provided " + size);
        }
        numberOfComponents = size;
        id = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            // Initially, each component is in individual set and has only one element
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * Check bounds of the element {@code p}
     *
     * @param p an element
     */
    private void validate(int p) {
        // check the bounds with `id` array.
        if (p < 0 || p > (id.length - 1)) {
            throw new IllegalArgumentException("Provided index must be 0 <= p < " + id.length + ". You provided " + p + ".");
        }
    }

    /**
     * Finds the root of element {@code p}
     * @param p an element
     * @return root of {@code p}
     */
    private int root(int p) {
        validate(p);
        // loop until the parent is found
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * Get the number of connected components (disjoint sets)
     *
     * @return number of connected components
     */
    public int components() {
        return numberOfComponents;
    }

    /**
     * Get the number of elements
     *
     * @return number of elements
     */
    public int size() {
        return id.length;
    }

    /**
     * Get the number of elements in the set {@code p} belongs to
     *
     * @param p an element
     * @return number of elements in the set containing {@code p}
     */
    public int componentSize(int p) {
        int parent = root(p);
        return sz[parent];
    }

    /**
     * Get the parent of the component {@code p} belongs to
     *
     * @param p an element
     * @return parent of {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < size}
     */
    public int find(int p) throws IllegalArgumentException {
        validate(p);
        return root(p);
    }

    /**
     * Merge the components containing {@code p} and {@code q} together.
     *
     * @param p an element
     * @param q another element
     * @throws IllegalArgumentException unless {@code 0 <= p < size}
     */
    public void union(int p, int q) throws IllegalArgumentException {
        validate(p);
        validate(q);
        int pid = root(p);
        int qid = root(q);

        if (pid == qid) {
            return;
        }

        if (sz[pid] < sz[qid]) {
            id[pid] = qid;
            sz[qid] += sz[pid]; // update the size
        } else {
            id[qid] = pid;
            sz[pid] += sz[qid]; // update the size
        }
        numberOfComponents--;
    }

    /**
     * Check if two elements {@code p, q} belong to same component/set.
     *
     * @param p an element
     * @param q another element
     * @return {@code true} if {@code p} and {@code q} belong to same set, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= p < size}
     */
    public boolean connected(int p, int q) throws IllegalArgumentException {
        return root(p) == root(q);
    }
}
