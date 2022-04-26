package main.codetests;

import java.util.function.IntConsumer;

/**
 * Binary search tree that does not allow duplicate values. <br/>
 * Write a class that implements this interface representing a binary search tree.
 */
public interface BstQ2 {

    /**
     * Inserts the value in the tree.
     *
     * @param value the value to insert
     * @return {@code true} if the value was added and {@code false} otherwise
     */
    boolean insert(int value);

    /**
     * Returns true if the value was deleted and false otherwise.
     *
     * @param value the value to delete
     * @return {@code true} if value was deleted and {@code false} otherwise
     */
    boolean delete(int value);

    /**
     * Returns true if value exists and false otherwise.
     *
     * @param value the value to check
     * @return {@code true} if value exists in tree and {@code false} otherwise
     */
    boolean contains(int value);

    /**
     * Iterates over the tree in order. <br/>
     * For example, if the tree contains 1, 2, 5, 10 then the consumer needs to be called in that order. <br/>
     *
     * @param consumer the consumer
     */
    void iterateOrder(IntConsumer consumer);
}

