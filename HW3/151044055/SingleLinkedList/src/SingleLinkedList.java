/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Osman Akkus
 */
/**
 * SingleLinkedList is a class that provides some of the
 * capabilities required by the List interface using
 * a single linked list data structure.
 * Only the following methods are provided:
 * get, set, add, remove, size, toString
 * @author Koffman and Wolfgang
 */
public class SingleLinkedList<E> extends LinkedList<E>{

    /** A Node is the building block for the SingleLinkedList */
    private static class Node<E> {

        /** The data value. */
        private E data;
        /** The link */
        private Node<E> next = null;

        /**
         * Construct a node with the given data value and link
         * @param data - The data value
         * @param next - The link
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Construct a node with the given data value
         * @param data - The data value
         */
        public Node(E data) {
            this(data, null);
        }
    }


    /** A reference to the head of the list */
    private Node<E> head = null;
    /** The size of the list */
    private int size = 0;

    /**A reference the head of the deleted nodes */
    private ArrayList<Node<E>> deletedNodes = new ArrayList<>();

    /**A reference the head of the deleted nodes */
    private ArrayList<Node<E>> deletedNodesBackUp = new ArrayList<>();

    /** Insert an item as the first item of the list.
     *	@param item The item to be inserted
     */
    @Override
    public void addFirst(E item) {
        head = new Node<>(item, head);
        size++;
    }

    /**
     * Add a node after a given node
     * @param node The node which the new item is inserted after
     * @param item The item to insert
     */
    private void addAfter(Node<E> node, E item) {
        node.next = new Node<>(item, node.next);
        size++;
        if (deletedNodes.size() > 0) {
            deletedNodes.remove(deletedNodes.size()-1);
        }
    }

    /**
     * Remove the first node from the list
     * @returns The removed node's data or null if the list is empty
     */
    @Override
    public E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Remove the node after a given node
     * @param node The node before the one to be removed
     * @returns The data from the removed node, or null
     *          if there is no node to remove
     */
    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * This class overriden from LinkedList class and written by me
     * @param index
     */

    public E remove(Node<E> node){
        deletedNodes.add(node);
        E data = removeAfter(node);
        deletedNodesBackUp = deletedNodes;
        return data;
    }

    /**
     * Find the node at a specified index
     * @param index The index of the node sought
     * @returns The node at index or null if it does not exist
     */
    public Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Get the data value at index
     * @param index The index of the element to return
     * @returns The data at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     * Set the data value at index
     * @param index The index of the item to change
     * @param newValue The new value
     * @returns The data value priviously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    /**
     * Insert the specified item at the specified position in the list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indicies)
     * @param index Index at which the specified item is to be inserted
     * @param item The item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    /**
     * Append the specified item to the end of the list
     * @param item The item to be appended
     * @returns true (as specified by the Collection interface)
     */
    @Override
    public boolean add(E item) {
        add(size, item);
        return true;
    }

    /**
     * Query the size of the list
     * @return The number of objects in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Obtain a string representation of the list
     * @return A String representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public String deletedToString(){

        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (int i = 0; i < deletedNodes.size(); i++) {
            builder.append(deletedNodes.get(i).data).append("-->");
        }
        builder.append("]");

        String returned = builder.toString();

        return returned;
    }
}
