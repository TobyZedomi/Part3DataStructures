package utils;

import business.Task;

import java.util.DuplicateFormatFlagsException;
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

    public void add(String t){
        if(list.size()!=maxCapacity) {
            if(list.contains(t)){
                throw new DuplicateFormatFlagsException("The task is already present in the queue");
            }
            for (int i = 0; i < list.size(); i++) {
                if (t.compareTo(list.get(i)) < 0) {
                    list.add(i,t);
                    break;
                }
            }
            list.add(t);
        }
        else{
            throw new IllegalStateException("The list is at max capacity");
        }
    }
    public boolean offer(String t){
        if(list.size() != maxCapacity) {
            if(list.contains(t)) {
                return false;
            }
            for(int i = 0; i < list.size(); i++){
                if (t.compareTo(list.get(i)) < 0) {
                    list.add(i, t);
                    return true;
                }else{
                    list.add(t);
                    return true;
                }
            }
        }
        return false;
        }


    }
