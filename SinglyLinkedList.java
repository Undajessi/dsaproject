public class SinglyLinkedList {
    private Node head;    
    private int size;    

    private class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insertAtBeginning(Student student) {
        if (student == null) {
            System.out.println("ERROR: Cannot insert null student");
            return;
        }

        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("✓ " + student.getName() + " inserted at beginning");
    }

    
    public void insertAtEnd(Student student) {
        if (student == null) {
            System.out.println("ERROR: Cannot insert null student");
            return;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("✓ " + student.getName() + " inserted at end");
    }

    public void insertAtPosition(Student student, int position) {
        if (student == null) {
            System.out.println("ERROR: Cannot insert null student");
            return;
        }

        if (position < 1 || position > size + 1) {
            System.out.println("ERROR: Invalid position. List size is " + size);
            return;
        }

        if (position == 1) {
            insertAtBeginning(student);
            return;
        }

        Node newNode = new Node(student);
        Node current = head;

        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("✓ " + student.getName() + " inserted at position " + position);
    }

    public void deleteStudent(String studentNumber) {
        if (head == null) {
            System.out.println("ERROR: List is empty");
            return;
        }

        // If student is at the head
        if (head.data.getStudentNumber().equals(studentNumber)) {
            head = head.next;
            size--;
            System.out.println("✓ Student #" + studentNumber + " deleted");
            return;
        }

        // Search for student in the rest of the list
        Node current = head;
        while (current.next != null) {
            if (current.next.data.getStudentNumber().equals(studentNumber)) {
                current.next = current.next.next;
                size--;
                System.out.println("✓ Student #" + studentNumber + " deleted");
                return;
            }
            current = current.next;
        }

        System.out.println("ERROR: Student #" + studentNumber + " not found");
    }

    public Student searchStudent(String studentNumber) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data.getStudentNumber().equals(studentNumber)) {
                System.out.println("✓ Found: " + current.data + " at position " + position);
                return current.data;
            }
            current = current.next;
            position++;
        }

        System.out.println("ERROR: Student #" + studentNumber + " not found");
        return null;
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("\n--- STUDENT SERVICE RECORDS ---");
        System.out.println("Total students: " + size);

        Node current = head;
        int position = 1;
        while (current != null) {
            System.out.println("  " + position + ". " + current.data);
            current = current.next;
            position++;
        }
        System.out.println();
    }

    public void displayWithLinks() {
        if (head == null) {
            System.out.println("NULL (empty list)");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data.getName() + " → ");
            current = current.next;
        }
        System.out.println("NULL");
    }

  
    public int getSize() {
        return size;
    }

  
    public boolean isEmpty() {
        return size == 0;
    }
}

