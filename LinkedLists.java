public class LinkedLists {
    public static void main(String...args){
        LinkedLists linkedLists = new LinkedLists();
        Node node = new Node(5);
    }
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;

    public LinkedLists(){
        this.head = null;
    }

    public void addToBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addToEnd(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.next!=null){
            current = current.next;
        }
        current.next = node;
    }

    public void addAtIndex(int data, int index) {
        if(index == 0) {
            addToBeginning(data);
            return;
        }
        if(index < 0) return;
        Node newNode = new Node(data);
        // get node at index
        int count = 0;
        Node current = head;
        while (count < index-1 && current.next!=null) {
            // get previous node
            // get next node
            current = current.next;
            count++;
        }
        // previous.next point to newNode
        current.next = newNode;
        // newNode.next point to next node
        newNode.next = current;
    }

    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }}
