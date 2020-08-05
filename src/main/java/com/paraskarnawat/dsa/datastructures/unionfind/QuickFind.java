package com.paraskarnawat.dsa.datastructures.unionfind;

/**
 * Union-Find data structure using quick-find algorithm (eager approach).
 * <p>
 * {@code find} operation takes <em>O(1)</em> time.
 * {@code union} operation takes <em>O(n)</em> time.
 *
 * This is an expensive algorithm, but easy to implement.
 * <p>
 *
 * @author Paras Karnawat
 */
public class QuickFind {

    // number of connected components
    private int numberOfComponents;

    // array to store the connected components
    private int[] id;

    /**
     * Constructor for class QuickFind. Initializes the required attributes.
     *
     * @param size number of elements
     */
    public QuickFind(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0. You provided " + size);
        }
        numberOfComponents = size;
        id = new int[size];
        for (int i = 0; i < size; i++) {
            // Initially, each component is in individual set
            id[i] = i;
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
     * Get the canonical element of the component {@code p} belongs to
     *
     * @param p an element
     * @return parent of {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < size}
     */
    public int find(int p) throws IllegalArgumentException {
        validate(p);
        return id[p];
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
        int pid = id[p];
        int qid = id[q];

        if (pid == qid) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
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
        return find(p) == find(q);
    }

}
