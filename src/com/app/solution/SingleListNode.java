package com.app.solution;

import java.util.Objects;

/**
 * SingleListNode to represent a single linked list node.
 *
 */
public class SingleListNode {
    private int data;
    private SingleListNode next;

    /**
     * Constructors
     *
     * @param data data of the node
     */
    public SingleListNode(int data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Constructors
     *
     * @param data data of the node
     * @param next next node
     */
    public SingleListNode(int data, SingleListNode next) {
        this.data = data;
        this.next = next;
    }

    // Default constructors
    public SingleListNode() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }
}
