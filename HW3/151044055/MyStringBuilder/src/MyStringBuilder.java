/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *This class works like String Builder Class but has some difference such as toString methods
 * @author Osman Akkus
 */
public class MyStringBuilder {

    private Integer capacity;
    private Integer size;
    private Object[] value;

    /**
     * No parameter constructor
     */
    public MyStringBuilder() {
        size = 0;
        capacity = 20;
        value = new Object[capacity];
    }

    /**
     *
     * @param item
     * @return
     */
    public MyStringBuilder append(Object item) {
        return append(String.valueOf(item));
    }

    /**
     *
     * @param item
     * @return
     */
    public MyStringBuilder append(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size < capacity) {
            getValue()[getSize()] = item;
            setSize((Integer) (getSize() + 1));
        } else {
            reSize();
            getValue()[getSize()] = item;
            setSize((Integer) (getSize() + 1));
        }
        return this;
    }

    /**
     * This toString method uses indexes and get method
     * @return
     */
    public String toStringUsesIndexAndGet() {

        String generated = "";

        for (int i = 0; i < size; i++) {
            generated = generated + String.valueOf(value[i]) + " ";
        }
        return generated;
    }

    /**
     * This toString method uses to generate the String
     * @return
     */
    public String toStringUsesIterator() {

        List<Object> temp = new ArrayList<>();
        String generated = "";

        for (int i = 0; i < getSize(); i++) {
            temp.add(value[i]);
        }

        for (Iterator<Object> iterator = temp.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            generated = generated + String.valueOf(next) + " ";
        }

        return generated;
    }

    /**
     *This toString method uses Linked List toString
     * @return
     */
    public String toStringUsesLinkedList() {
        String generated = "";
        List<Object> aList = new LinkedList<>();

        for (int i = 0; i < getSize(); i++) {
            aList.add(getValue()[i]);
        }

        return aList.toString();
    }

    /**
     * Reallocate the capacity
     */
    private void reSize() {
        int i = 0;
        Object[] temp = new Object[getCapacity()];
        temp = getValue();
        setCapacity(getCapacity() * 2);
        setValue(new Object[getCapacity()]);
        for (int j = 0; j < size; j++) {
            value[j] = temp[j];
        }
    }

    /**
     * @return the capacity
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    private void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    private void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return the value
     */
    public Object[] getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    private void setValue(Object[] value) {
        this.value = value;
    }
}
