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

public static void selectionSort(int[] arr) {

    int comparisons = 0;
    int swaps = 0;

    for (int i = 0; i < arr.length - 1; i++) {

        int minIndex = i;

        for (int j = i + 1; j < arr.length; j++) {

            comparisons++;

            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        if (minIndex != i) {

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            swaps++;
        }
    }

    System.out.println("Selection Sort Complete");
    System.out.println("Comparisons: " + comparisons);
    System.out.println("Swaps: " + swaps);

    printArray(arr);
}

public static void insertionSort(int[] arr) {

    int comparisons = 0;
    int shifts = 0;

    for (int i = 1; i < arr.length; i++) {

        int key = arr[i];
        int j = i - 1;

        while (j >= 0) {

            comparisons++;

            if (arr[j] > key) {

                arr[j + 1] = arr[j];
                shifts++;
                j--
            } else {
                break;
            }
        }

        arr[j + 1] = key;
    }

    System.out.println("Insertion Sort Complete");
    System.out.println("Comparisons: " + comparisons);
    System.out.println("Shifts: " + shifts);

    printArray(arr);
}
``
public static void mergeSort(int[] arr, int left, int right) {

    if (left < right) {

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
}

private static void merge(int[] arr,
                          int left,
                          int mid,
                          int right) {

    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    for (int i = 0; i < n1; i++) {
        leftArray[i] = arr[left + i];
    }

    for (int j = 0; j < n2; j++) {
        rightArray[j] = arr[mid + 1 + j];
    }

    int i = 0;
    int j = 0;
    int k = left;

    while (i < n1 && j < n2) {

        if (leftArray[i] <= rightArray[j]) {
            arr[k++] = leftArray[i++];
        } else {
            arr[k++] = rightArray[j++];
        }
    }

    while (i < n1) {
        arr[k++] = leftArray[i++];
    }

    while (j < n2) {
        arr[k++] = rightArray[j++];
    }
}
``

public static void quicksort(int[] arr,
                             int low,
                             int high) {

    if (low < high) {

        int pivotIndex =
                partition(arr, low, high);

        quicksort(arr, low, pivotIndex - 1);
        quicksort(arr, pivotIndex + 1, high);
    }
}

private static int partition(int[] arr,
                             int low,
                             int high) {

    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {

        if (arr[j] <= pivot) {

            i++;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
}


public static void printArray(int[] arr) {

    for (int value : arr) {
        System.out.print(value + " ");
    }

    System.out.println();
}

public static void runSortingExperiment() {

    int[] sizes = {20, 50, 100, 500};

    Random random = new Random();

    System.out.println("\nALGORITHM EXPERIMENT");
    System.out.println("----------------------------------------------");

    for (int size : sizes) {

        int[] original = new int[size];

        for (int i = 0; i < size; i++) {
            original[i] = random.nextInt(1000);
        }

        testSelectionSort(original);
        testInsertionSort(original);
        testMergeSort(original);
        testQuickSort(original);

        System.out.println("----------------------------------------------");
    }
}



private static void testSelectionSort(int[] original) {

    int[] arr = original.clone();

    long start = System.nanoTime();

    selectionSort(arr);

    long end = System.nanoTime();

    System.out.println(
            "Selection Sort | Size="
            + arr.length
            + " | Time="
            + (end - start)
            + " ns");
}


private static void testInsertionSort(int[] original) {

    int[] arr = original.clone();

    long start = System.nanoTime();

    insertionSort(arr);

    long end = System.nanoTime();

    System.out.println(
            "Insertion Sort | Size="
            + arr.length
            + " | Time="
            + (end - start)
            + " ns");
}

private static void testMergeSort(int[] original) {

    int[] arr = original.clone();

    long start = System.nanoTime();

    mergeSort(arr, 0, arr.length - 1);

    long end = System.nanoTime();

    System.out.println(
            "Merge Sort | Size="
            + arr.length
            + " | Time="
            + (end - start)
            + " ns");
}


private static void testQuickSort(int[] original) {

    int[] arr = original.clone();

    long start = System.nanoTime();

    quicksort(arr, 0, arr.length - 1);

    long end = System.nanoTime();

    System.out.println(
            "Quick Sort | Size="
            + arr.length
            + " | Time="
            + (end - start)
            + " ns");
}


