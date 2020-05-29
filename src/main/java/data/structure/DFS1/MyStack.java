package data.structure.DFS1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dell on 2020/5/29.
 */
public class MyStack<T> {

    private LinkedList<T> list = new LinkedList<T>();

    /**
     * 入站
     * @param e
     * @return
     */
    void push(T e){
        list.addFirst(e);
    }

    T pop(){
       return list.removeFirst();
    }
    int size(){
        return list.size();
    }
}
