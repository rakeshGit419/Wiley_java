import java.util.*;
class LinkedList {
    Node head;
    int size;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    // -----------------------insertion----------------------------
    public void insertAtFirst(int val) {
        size++;
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public void insertLast(int val) {
        if (head == null) {
            insertAtFirst(val);
            return;
        }
        size++;
        Node node = new Node(val);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void insertAt(int idx, int val) {
        if (idx < 0 || size > idx) {
            System.out.println(idx + " is an Invalid Index");
            return;
        }
        if (head == null || idx == 0) {
            insertAtFirst(val);
            return;
        }
        if (size == idx) {
            insertLast(val);
            return;
        }
        size++;
        Node node = new Node(val);
        Node temp = head;
        for (int i = 0; i < (idx - 1); i++)
            temp = temp.next;
        node.next = temp.next;
        temp.next = node;
    }

    // -----------------------deletion----------------------------
    public void deleteFirst() {
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }
        if (size == 1) {
            deleteFirst();
            return;
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void deleteAtIdx(int idx) {
        if (size <= idx || idx < 0) {
            System.out.println(idx + " is an Invalid Index");
            return;
        }
        if (idx == 0) {
            deleteFirst();
            return;
        }
        if (size - 1 == idx) {
            deleteLast();
            return;
        }
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    void getLast(){
        if(head == null){System.out.println("Collection is Empty");return;}
        Node temp = head;
        for(int i=0;i<size-1;i++){
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
// ----------------display for stack application-----------------------
    public void displayStack() {
        int[] arr = new int[size];
        int i=0;
        Node temp = head;
        while (temp != null && i<size) {
            arr[i++] = temp.data;
            temp = temp.next;
        }
        for(int j=arr.length-1;j>=0;j--){
            System.out.print(arr[j]+" ");
        }
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Stack{
    LinkedList LL;
    Stack(){
        LL = new LinkedList();
    }

    void push(int val){
        LL.insertAtFirst(val);
    }

    void pop(){
        LL.deleteFirst();
    }

    void peek(){
        LL.getLast();
    }

    void printStack(){
        LL.display();
    }
}


public class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAt(0, 1);
        ll.insertAt(1, 2);
        ll.insertAt(2, 3);
        ll.insertAt(1,45);
        ll.display();
        
        


















        // LinkedList ll = new LinkedList();

        // ll.insertAtFirst(1);
        // ll.insertAt(1, 5);
        // ll.insertLast(6);
        // // System.out.println("length of Linked List - "+ll.size);
        // // ll.display();
        // // System.out.println("\"Deleting first Node\"");
        // // ll.deleteFirst();
        // // ll.deleteLast();
        // // ll.deleteAtIdx(2);
        // System.out.println("length of Linked List - " + ll.size);
        // ll.display();
    }
}