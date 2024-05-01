import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LinkedLists {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private static Node head;

    public LinkedLists(){
        head = null;
    }

    public static void addToBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void addToEnd(int data) {
        Node node = new Node(data);
        if(head==null){
            head = node;
            return;
        }
        Node current = head;
        while(current.next!=null) {
            current = current.next;
        }
        current.next = node;
    }

    public static void addAtIndex(int data, int index) {
        Node node = new Node(data);
        if(index==0) {
            addToBeginning(data);
            return;
        }
        Node current = head;
        Node previous = head;
        while(index-- > 0){
            previous = current;
            current = current.next;
        }
        previous.next = node;
        node.next = current;
    }

    public static boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void print(){
        Node current = head;
        while (current!=null) {
            System.out.println(current.data);
            current=current.next;
        }
    }

    public static void main(String[] args) {
        addToBeginning(1);
        addToEnd(2);
        addToEnd(3);
        addAtIndex(5, 1);
        print();
        if(search(5)) System.out.println("found");
        runTests();
    }

    public static void runTests() {
        testAddToBeginning();
        testAddToEnd();
        testAddAtIndex();
        testSearch();
        testPrint();
    }

    private static void testAddToBeginning() {
        addToBeginning(1);
        addToBeginning(2);
        addToBeginning(3);
        // Verify the elements were added to the beginning
        assert head.data == 3 : "First element should be 3";
        assert head.next.data == 2 : "Second element should be 2";
        assert head.next.next.data == 1 : "Third element should be 1";
        System.out.println("addToBeginning test passed");
    }

    private static void testAddToEnd() {
        addToEnd(1);
        addToEnd(2);
        addToEnd(3);
        // Verify the elements were added to the end
        assert head.data == 1 : "First element should be 1";
        assert head.next.data == 2 : "Second element should be 2";
        assert head.next.next.data == 3 : "Third element should be 3";
        System.out.println("addToEnd test passed");
    }

    private static void testAddAtIndex() {
        addToEnd(1);
        addToEnd(2);
        addToEnd(4);
        addAtIndex(3, 2);
        // Verify the element was added at the specified index
        assert head.data == 1 : "First element should be 1";
        assert head.next.data == 2 : "Second element should be 2";
        assert head.next.next.data == 3 : "Third element should be 3";
        assert head.next.next.next.data == 4 : "Fourth element should be 4";
        System.out.println("addAtIndex test passed");
    }

    private static void testSearch() {
        addToEnd(1);
        addToEnd(2);
        addToEnd(3);
        // Verify the search method returns true for existing element and false for non-existing element
        assert search(2) : "Element 2 should be found";
        assert !search(4) : "Element 4 should not be found";
        System.out.println("search test passed");
    }

    private static void testPrint() {
        addToEnd(1);
        addToEnd(2);
        addToEnd(3);
        // Redirecting System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // Call the print method
        print();
        // Verify the printed output matches the expected output
        assert outContent.toString().equals("1\n2\n3\n") : "Printed output is incorrect";
        System.out.println("print test passed");
    }
}
