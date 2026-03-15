class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {

    Node head;

    // ---------------- Traversal ----------------

    // Print Linked List
    public void printList() {
        Node temp = head;

        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
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

    // Search Element
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

    // ---------------- Insertion ----------------

    // Insert at Beginning
    public void insertBeginning(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    // Insert at End
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
    }

    // Insert at Specific Position
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
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Insert After Given Node
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
        temp.next = newNode;
    }

    // Insert Before Given Node
    public void insertBefore(int key, int data) {

        if (head == null) return;

        if (head.data == key) {
            insertBeginning(data);
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Node not found");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // ---------------- Deletion ----------------

    // Delete from Beginning
    public void deleteBeginning() {

        if (head == null) {
            System.out.println("List empty");
            return;
        }

        head = head.next;
    }

    // Delete from End
    public void deleteEnd() {

        if (head == null) return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    // Delete by Position
    public void deletePosition(int pos) {

        if (head == null) return;

        if (pos == 1) {
            head = head.next;
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) return;

        temp.next = temp.next.next;
    }

    // Delete by Value
    public void deleteValue(int key) {

        if (head == null) return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }

        temp.next = temp.next.next;
    }

    // Delete Entire Linked List
    public void deleteAll() {
        head = null;
    }

    // ---------------- Main Method ----------------

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertBeginning(10);
        list.insertBeginning(5);
        list.insertEnd(20);
        list.insertAtPosition(15,3);

        list.insertAfter(10,12);
        list.insertBefore(20,18);

        list.printList();

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