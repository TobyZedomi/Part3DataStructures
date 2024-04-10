package utils;

import business.Task;

import java.util.LinkedList;

public class Queue {

    private LinkedList<String> list;

    int maxCapacity;

    public Queue() {
        list = new LinkedList<>();
        this.maxCapacity = 10;

    }

    public Queue(int maxCapacity) {
        list = new LinkedList<>();
        this.maxCapacity = maxCapacity;
    }


    public int size() {
        return size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public boolean isFull() {
        if (size() >= maxCapacity) {
            return true;
        }
        return false;
    }


    private int calcPosition(String t) {
        for (int i = 0; i < list.size(); i++) {
            if (t.compareTo(list.get(i)) < 0) {
                return i;
            }
        }
        return -1;
    }

}
