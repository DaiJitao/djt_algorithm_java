package demo;


class Node<T>{
    private T value;
    private Node next;
    private Node pre;

    public Node(T value, Node next, Node up){
        this.value = value;
        this.pre = up;
        this.next = next;
    }
}

public class Linklist<T> {
    private T value;

    public Linklist(T v) {
        this.value = v;
    }

    public void println() {
        System.out.println(this.value);
    }
}

class Main {


    public static void main(String[] args) {
        Node<Double> head = null;

    }
}
