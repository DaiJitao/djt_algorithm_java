package data.structure.DFS;

/**
 * Created by dell on 2020/4/26.
 */
/***
 建立栈
 ***/
class StackX{

    private final int SIZE = 100;
    private int[] st;
    private int top;
    public StackX(){
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j){
        st[++top] = j;
    }

    public int pop(){
        return st[top--];
    }

    public int peek(){
        return st[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top + 1;
    }

}