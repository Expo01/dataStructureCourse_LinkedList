package datastructures.linkedlist;


import java.util.ArrayList;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public MyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }


    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast(){
        if (length == 0) return null; //if list has no items, returns null

        //if list has length, both temporary variables 'pre' and 'temp' set to value of the 'head' pointer
        Node temp = head;
        Node pre = head;
        while(temp.next != null) { //while there is a next item in the list, the while loop continues
            pre = temp; // pre is set to temp
            temp = temp.next; // temp set to next
            // so now, after the first node where both pre and temp are assigned to head, temp will always be one in
            //front of pre
        }
        //when temp reaches the final node and the loop realizes there is no next, tail pointer is set to pre which
        // is pointing to the second to last Node
        tail = pre;
        tail.next = null; //tail pointer points to null and effectively breaks off the final node from the list.
        // note that temp still points to the final Node value, but the Node is no longer a part of the list
        length--; // length of list decremented. the problem here is that if the list was only one Node in length, then
        //temp.next would be null, the while loop would be skipped, both pre and temp variables would still point to head
        // and the lenngth would decrement despite the one Node still remaining

        //fina segment here retests for the single node conition and says if we decremented the length to zero, then head
        // and tail must equal null and no longer point to the single Node
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp; // still set to value of null from while loop

    }
}






