package utils;

import business.Task;

import java.util.DuplicateFormatFlagsException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue {

    private LinkedList<String> list;

    int maxCapacity;

    public Queue() {
        /// list is equal to LinkedList
        list = new LinkedList<>();
        /// maxCapacity is set to 10
        this.maxCapacity = 10;

    }

    public Queue(int maxCapacity) {
        /// list is equal to LinkedList
        list = new LinkedList<>();
        /// maxCapacity is set to number entered in parameter
        this.maxCapacity = maxCapacity;
    }


    /**
     * Getting the amount of elements in the queue
     *
     * @return the amount of elements in the queue
     */
    public int size() {

        /// getting the amount of values in the queue
        return list.size();
    }

    /**
     * Checking if Queue is empty or not
     *
     * @return true if queue is empty and false if not
     */
    public boolean isEmpty() {

        /// if the queue has nothing in it, it will return true
        return list.size() == 0;
    }


    /**
     * Checking if queue is full or not
     *
     * @return true if full and false if not
     */
    public boolean isFull() {

        /// if the size of the queue is greater than or equal or maxCapacity
        if (size() >= maxCapacity) {
            //return true
            return true;
        }

        // return false if not full
        return false;
    }


    /**
     * Puts where the task should be put in the queue
     *
     * @param t is the element being searched
     * @return the position of where task should be in the queue
     */
    private int calcPosition(String t) {

        /// loop through the entire list
        for (int i = 0; i < list.size(); i++) {
            /// compare to method is used to compare the strng sin aplbetical ascending order. the string parameter is compared to everything in the list until it finds its position
            if (t.compareTo(list.get(i)) < 0) {

                /// return the position
                return i;
            }
        }
        /// return -1 if not found
        return -1;
    }


    /**
     * Add the element to the end of the queue
     *
     * @param t is the element being added
     */
    public void add(String t) {

        /// if the list is full
        if (isFull()) {
            /// it will throw and exception saying the list is at max capacity
            throw new IllegalStateException("The list is at max capacity");
        }

        /// if the parameter being entered is already in the list
        if (list.contains(t)) {
            /// it will throw a duplicate exception saying the task is already present in the queue
            throw new DuplicateFormatFlagsException("The task is already present in the queue");
        }


        list.add(t);

    }


    /**
     * Add element to the end of the queue
     *
     * @param t is the value being added
     * @return true if added and false if not
     */
    public boolean offer(String t) {

        /// if the list is full
        if (isFull()) {
            /// it will return false
            return false;
        }

        /// if the parameter being entered is already in the list
        if (list.contains(t)) {
            /// it will return false
            return false;
        }

        /// add the parameter entered to the end of the list
        list.add(t);
        /// return true
        return true;
    }

    /**
     * Gets the first value in the queue
     *
     * @return the first value in the queue
     */
    public String element() {

        /// if the list is empty
        if (isEmpty()) {
            /// throw an exception saying the queue is empty
            throw new NoSuchElementException("Queue is empty");
        }

        /// return the first value in the queue
        return list.get(0);
    }


    /**
     * Gets the first value in the queue
     *
     * @return the first value in the queue
     */
    public String peek() {

        /// if the list is empty
        if (isEmpty()) {
            /// it will return null
            return null;
        }

        /// return the first value in the queue
        return list.get(0);
    }


    /**
     * Removing the first value in the queue
     *
     * @return the first value in the queue to be deleted
     */
    public String remove() {

        /// if the list is empty
        if (isEmpty()) {
            /// throw an exception saying queue is empty
            throw new NoSuchElementException("Queue is empty");
        }

        /// return the first value in the queue to be deleted
        return list.remove(0);

    }

    /**
     * Remove the first value in the queue
     *
     * @return the first value in the queue to be deleted
     */
    public String poll() {


        /// if the list is empty
        if (isEmpty()) {
            /// null will be returned
            return null;
        }

        /// return the first value in the queue to be deleted
        return list.remove(0);
    }


}



