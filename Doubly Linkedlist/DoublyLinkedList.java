class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {

    Node head;

    // -------- Traversal --------

    // Forward Traversal
    public void printList() {
        Node temp = head;

        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Backward Traversal
    public void printBackward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        // Last node tak jana
        while (temp.next != null) {
            temp = temp.next;
        }

        // Backward traversal
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("null");
    }

    // Length of Linked List
    public int length() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Search element
    public boolean search(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // -------- Insertion --------

    // Insert at beginning
    public void insertBeginning(int data) {
        Node newNode = new Node(data);

        if (head != null) {
            head.prev = newNode;
        }

        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert at specific position
    public void insertAtPosition(int data, int pos) {

        if (pos == 1) {
            insertBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert after given node
    public void insertAfter(int key, int data) {
        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node not found");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    // Insert before given node
    public void insertBefore(int key, int data) {

        if (head == null) return;

        if (head.data == key) {
            insertBeginning(data);
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node not found");
            return;
        }

        Node newNode = new Node(data);

        newNode.prev = temp.prev;
        newNode.next = temp;

        temp.prev.next = newNode;
        temp.prev = newNode;
    }

    // -------- Deletion --------

    // Delete from beginning
    public void deleteBeginning() {

        if (head == null) return;

        head = head.next;

        if (head != null) {
            head.prev = null;
        }
    }

    // Delete from end
    public void deleteEnd() {

        if (head == null) return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
    }

    // Delete by position
    public void deletePosition(int pos) {

        if (head == null) return;

        if (pos == 1) {
            deleteBeginning();
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    // Delete by value
    public void deleteValue(int key) {

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // Delete entire list
    public void deleteAll() {
        head = null;
    }

    // -------- Main Method --------

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertBeginning(10);
        list.insertBeginning(5);
        list.insertEnd(20);
        list.insertAtPosition(15,3);

        list.insertAfter(10,12);
        list.insertBefore(20,18);

        System.out.println("Forward Traversal:");
        list.printList();

        System.out.println("Backward Traversal:");
        list.printBackward();

        System.out.println("Length: " + list.length());

        System.out.println("Search 15: " + list.search(15));

        list.deleteBeginning();
        list.deleteEnd();
        list.deletePosition(2);
        list.deleteValue(12);

        System.out.println("After Deletions:");
        list.printList();

        list.deleteAll();

        System.out.println("List after deleting all:");
        list.printList();

        // Student Info
        System.out.println("\nName: Sami Siddiqui");
        System.out.println("Seat No: EB25210006084");
    }
}   