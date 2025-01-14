// Class to represent a Node in the Linked List
class Node {
    int data;   // Data part (stores a value)
    Node next;  // Pointer to the next Node

    // Constructor to initialize Node with data
    Node(int data) {
        this.data = data;
        this.next = null; // Initially, the next node is null
    }
}

// LinkedList class to manage the list of Nodes
class LinkedList {
    Node head; // Head node to mark the start of the linked list

    // Method to add a new node to the linked list
    void add(int data) {
        Node newNode = new Node(data); // Create a new node

        // If the list is empty, make this node the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse to the end of the list and add the new node
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to get the size of the linked list
    int getSize() {
        int size = 0;       // Initialize size counter
        Node current = head; // Start from the head of the list

        // Traverse through the entire list
        while (current != null) {
            size++;         // Increment size for each node
            current = current.next; // Move to the next node
        }
        return size;        // Return the total size
    }

    // Method to get the k-th element (1-based index) from the linked list
    int getKthElement(int k) {
        Node current = head; // Start from the head node
        int index = 1;       // Initialize index to 1

        // Traverse the list until we reach the k-th element or the end of the list
        while (current != null) {
            if (index == k) {
                return current.data; // Return data at k-th position
            }
            index++;               // Move to the next node
            current = current.next;
        }

        // If k is greater than the size of the list, return -1
        return -1;
    }

    // Method to insert a node at a specific position (1-based index) in the linked list
    void insertAtPosition(int data, int position) {
        Node newNode = new Node(data); // Create a new node

        // If the position is 1, insert at the beginning
        if (position == 1) {
            newNode.next = head;  // Point new node to the current head
            head = newNode;       // Update head to the new node
            return;
        }

        Node current = head;
        int index = 1;

        // Traverse to the node before the desired position
        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        // If the position is valid
        if (current != null) {
            newNode.next = current.next;  // Link new node to the next node
            current.next = newNode;       // Update the current node's next pointer
        } else {
            System.out.println("Position out of bounds");  // If position is invalid
        }
    }

    // Method to delete a node at a specific position (1-based index) in the linked list
    void deleteAtPosition(int position) {
        // If the list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If the position is 1, delete the head node
        if (position == 1) {
            head = head.next;  // Update head to point to the next node
            return;
        }

        Node current = head;
        int index = 1;

        // Traverse to the node before the desired position
        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        // If position is valid and current node is not null
        if (current != null && current.next != null) {
            current.next = current.next.next;  // Bypass the node to delete it
        } else {
            System.out.println("Position out of bounds");  // If position is invalid
        }
    }

    // Method to reverse the linked list
    void reverse() {
        Node prev = null;   // Initialize previous node as null
        Node current = head; // Start from the head
        Node next = null;    // To keep track of the next node

        // Traverse through the list and reverse the pointers
        while (current != null) {
            next = current.next;  // Save the next node
            current.next = prev;  // Reverse the current node's pointer
            prev = current;       // Move prev to the current node
            current = next;       // Move to the next node
        }

        head = prev; // Update the head to the new first node
    }

    // Method to print all nodes in the linked list
    void printList() {
        Node current = head;

        // Traverse and print each node's data
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null"); // End of list
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding nodes
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Printing the list
        System.out.println("Linked List:");
        list.printList();

        // Reversing the list
        list.reverse();
        System.out.println("Reversed Linked List:");
        list.printList();

        // Inserting at a position
        list.insertAtPosition(25, 3);
        System.out.println("After Inserting 25 at position 3:");
        list.printList();

        // Deleting a node at a position
        list.deleteAtPosition(2);
        System.out.println("After Deleting node at position 2:");
        list.printList();

        // Getting the size of the list
        System.out.println("Size of Linked List: " + list.getSize());

        // Getting k-th element
        int k = 2;
        int kthElement = list.getKthElement(k);
        if (kthElement != -1) {
            System.out.println(k + "th element is: " + kthElement);
        } else {
            System.out.println("Invalid position");
        }
    }
}
