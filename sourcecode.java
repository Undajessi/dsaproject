import java.util.*;

class Student {
    private String studentNo;
    private String name;
    private String serviceType;
    private int serviceTime;

    public Student(String studentNo, String name,
                   String serviceType, int serviceTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return studentNo + " | " + name +
                " | " + serviceType +
                " | " + serviceTime + " mins";
    }
}


class Queue {
    private LinkedList<Student> queue = new LinkedList<>();

    public void enqueue(Student student) {
        queue.addLast(student);
    }

    public Student dequeue() {
        if (isEmpty()) return null;
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getSize() {
        return queue.size();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        for (Student s : queue) {
            System.out.println(s);
        }
    }
}


class StudentNode {
    Student data;
    StudentNode next;

    StudentNode(Student data) {
        this.data = data;
    }
}

class SinglyLinkedList {

    private StudentNode head;

    public void insertAtBeginning(Student student) {
        StudentNode node = new StudentNode(student);
        node.next = head;
        head = node;
    }

    public void insertAtEnd(Student student) {
        StudentNode node = new StudentNode(student);

        if (head == null) {
            head = node;
            return;
        }

        StudentNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }

    public void insertAtPosition(Student student, int position) {

        if (position <= 1 || head == null) {
            insertAtBeginning(student);
            return;
        }

        StudentNode node = new StudentNode(student);

        StudentNode current = head;

        for (int i = 1; current.next != null &&
                i < position - 1; i++) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;
    }

    public void deleteStudent(String studentNo) {

        if (head == null)
            return;

        if (head.data.getStudentNo().equals(studentNo)) {
            head = head.next;
            System.out.println("Record deleted.");
            return;
        }

        StudentNode current = head;

        while (current.next != null &&
                !current.next.data.getStudentNo().equals(studentNo)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Record deleted.");
        }
    }

    public void searchStudent(String studentNo) {

        StudentNode current = head;

        while (current != null) {

            if (current.data.getStudentNo()
                    .equals(studentNo)) {

                System.out.println("Student Found:");
                System.out.println(current.data);
                return;
            }

            current = current.next;
        }

        System.out.println("Student not found.");
    }

    public void displayStudents() {

        if (head == null) {
            System.out.println("No records available.");
            return;
        }

        StudentNode current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int[] getServiceTimes() {

        ArrayList<Integer> list = new ArrayList<>();

        StudentNode current = head;

        while (current != null) {
            list.add(current.data.getServiceTime());
            current = current.next;
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}

// ===================== SORTING =============
