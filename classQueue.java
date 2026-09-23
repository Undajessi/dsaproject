public class Queue {
    private Node front;  
    private Node rear;     
    private int size;      

    // Node class for queue (inner class)
    private class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * Add a student to the rear of the queue
     * Time Complexity: O(1)
     */
    public void enqueue(Student student) {
        if (student == null) {
            System.out.println("ERROR: Cannot enqueue null student");
            return;
        }

        Node newNode = new Node(student);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("✓ " + student.getName() + " added to queue");
    }

    /**
     * Remove and return the student from the front of the queue
     * Time Complexity: O(1)
     */
    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("ERROR: Queue is empty, cannot dequeue");
            return null;
        }

        Student student = front.data;
        front = front.next;
        size--;

        if (isEmpty()) {
            rear = null;
        }

        System.out.println("✓ " + student.getName() + " removed from queue");
        return student;
    }

    /**
     * View the student at the front without removing
     * Time Complexity: O(1)
     */
    public Student peek() {
        if (isEmpty()) {
            System.out.println("ERROR: Queue is empty");
            return null;
        }
        return front.data;
    }

    /**
     * Check if queue is empty
     * Time Complexity: O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    
    public int getSize() {
        return size;
    }


    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("\n--- QUEUE STATUS ---");
        System.out.println("Students waiting: " + size);
        System.out.println("Order of service:");

        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.println("  " + position + ". " + current.data);
            current = current.next;
            position++;
        }
        System.out.println();
    }
}
