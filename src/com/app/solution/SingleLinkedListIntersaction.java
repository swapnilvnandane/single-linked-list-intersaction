package com.app.solution;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * SingleLinkedListIntersaction to check node intersects or share common node.
 *
 */
public class SingleLinkedListIntersaction {

    /**
     * Check if cycle is detected in the linked list.
     *
     * @param headNode head node of the linked list
     * @return true if cycle is detected, false otherwise
     */
    public static boolean isCycleDetected(SingleListNode headNode) {
        SingleListNode node1 = headNode;
        SingleListNode node2 = headNode;

        while (Objects.nonNull(node2) && Objects.nonNull(node2.getNext())) {
            node1 = node1.getNext();
            node2 = node2.getNext().getNext();
            if (node1.equals(node2)) {
                throw new RuntimeException("Cycle detected in the linked list");
            }
        }
        return false;
    }

    /**
     * Check if linked list intersects or share common node.
     *
     * @param nodeList list of linked list nodes
     * @return true if intersects, false otherwise
     */
    public static boolean isIntersected(List<SingleListNode> nodeList) {
        Set<SingleListNode> nodeSet = new HashSet<>();
        for (SingleListNode node : nodeList) {

            // Check if cycle is detected in the linked list
            isCycleDetected(node);

            SingleListNode current = node;

            while (Objects.nonNull(current)) {
                if (nodeSet.contains(current)) {
                    return true;
                }
                nodeSet.add(current);
                current = current.getNext();
            }
        }
        return false;
    }

    /**
     * Main method to test the implementation.
     *
     * @param args main arguments
     */
    public static void main(String[] args) {
        SingleListNode head1 = new SingleListNode(1);
        head1.setNext(new SingleListNode(2));
        head1.getNext().setNext(new SingleListNode(3));

        SingleListNode head2 = new SingleListNode(6);
        head2.setNext(new SingleListNode(7));
        // Create an intersection
        head2.getNext().setNext(head1.getNext()); // Intersection at node with value 2

        SingleListNode head3 = new SingleListNode(8);
        head3.setNext(new SingleListNode(9));

        List<SingleListNode> linkedLists = List.of(head1, head2, head3);

        try {
            boolean hasIntersection = isIntersected(linkedLists);
            System.out.println("Intersection Detected: " + hasIntersection);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
