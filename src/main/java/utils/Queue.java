package utils;
import java.util.LinkedList;
public class Queue extends LinkedList{


    int maxCapacity;
    public Queue(){

        this.maxCapacity = 10;

    }

    public Queue(int maxCapacity){

        this.maxCapacity = maxCapacity;
    }


    public int size(){

        return size();
    }

    public boolean isEmpty(){

        return super.size() == 0;
    }

    public boolean isFull(){
        if (size() >= maxCapacity){
            return true;
        }

        return false;
    }


    private int calcPosition(int pos){

    if (size() < pos){


    }

    return pos;
    }

}
