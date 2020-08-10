package data.structure.chain;

/**
 * Created by dell on 2020/7/22.
 */

class Node {
    Node next;
    int v;

    public Node(Node next, int v) {
        this.next = next;
        this.v = v;
    }
}

public class Solution {
    public static void main(String[] args) {
        Node node1 = new Node(null,1);
        Node node2 = new Node(null,2);
        Node node3 = new Node(null,2);
        Node node4 = new Node(null,4);
        Node node5 = new Node(null,5);
        Node node6 = new Node(null,6);
        node1.next = node2;
        node2.next = node5;
        node5.next = node6;

        node3.next = node4;
        node4.next = node6;
        Node nodeThis = common(node1, node3);
        System.out.println(nodeThis.next);
        System.out.println(nodeThis.v);

    }

    public static Node common(Node head1, Node head2) {
        Node tempNode1 = head1;
        Node tempNode2 = head2;
        int count1 = 0;
        int count2 = 0;
        //
        while (tempNode1 != null) {
            count1++;
            tempNode1 = tempNode1.next;
        }
        while (tempNode2 != null) {
            count2++;
            tempNode2 = tempNode2.next;
        }
        if (count1 > count2) {
            int count = count1 - count2;
            for (int i = 1; i <= count; i++) {
                head1 = head1.next;
            }
        } else if (count1 < count2) {
            int count = count2 - count1;
            for (int i = 1; i <= count; i++) {
                head2 = head2.next;
            }
        }
        Node commonNode = null;
        while (head2 != null && head1 != null) {
            if (head2 != head1) {
                head1 = head1.next;
                head2 = head2.next;
            } else {
                commonNode = head1;
                break;
            }
        }
        return commonNode;
    }
}

