public class ServiceCentreDemonstration {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║     NUST CAMPUS SERVICE CENTRE SIMULATION              ║");
        System.out.println("║     Task A1: Queue Implementation                      ║");
        System.out.println("║     Task A2: Singly Linked List Implementation         ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        // Create data structures
        Queue waitingQueue = new Queue();
        SinglyLinkedList serviceRecords = new SinglyLinkedList();

        // ===================== TASK A1: QUEUE DEMONSTRATION =====================
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              TASK A1: QUEUE DEMONSTRATION               ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        // Create 6+ students
        Student maria = new Student("221045678", "Maria", "Registration", 12);
        Student tomas = new Student("222034512", "Tomas", "Student Card", 5);
        Student ndapewa = new Student("223041876", "Ndapewa", "Fees", 8);
        Student simon = new Student("221067341", "Simon", "Documents", 4);
        Student alice = new Student("221098765", "Alice", "Academic Enquiry", 10);
        Student bob = new Student("221087654", "Bob", "Other Services", 6);

        System.out.println("--- 6+ STUDENTS ARRIVING (ENQUEUEING) ---");
        waitingQueue.enqueue(maria);
        waitingQueue.enqueue(tomas);
        waitingQueue.enqueue(ndapewa);
        waitingQueue.enqueue(simon);
        waitingQueue.enqueue(alice);
        waitingQueue.enqueue(bob);

        // Display queue status
        waitingQueue.displayQueue();

        // Peek at front
        System.out.println("--- PEEK OPERATION (view front without removing) ---");
        Student nextStudent = waitingQueue.peek();
        System.out.println("Next student to be served: " + nextStudent.getName());

        // Check if empty
        System.out.println("\n--- isEmpty() CHECK ---");
        System.out.println("Is queue empty? " + waitingQueue.isEmpty());
        System.out.println("Queue size: " + waitingQueue.getSize());

        // ================== SERVICE 3 STUDENTS (DEQUEUE) ==================
        System.out.println("\n--- SERVICE 3 STUDENTS (DEQUEUEING) ---");

        System.out.println("\nTeller 1 now available...");
        Student served1 = waitingQueue.dequeue();
        serviceRecords.insertAtEnd(served1);  // Add to records

        System.out.println("\nTeller 2 now available...");
        Student served2 = waitingQueue.dequeue();
        serviceRecords.insertAtEnd(served2);  // Add to records

        System.out.println("\nTeller 1 becomes available again...");
        Student served3 = waitingQueue.dequeue();
        serviceRecords.insertAtEnd(served3);  // Add to records

        // Display remaining queue
        waitingQueue.displayQueue();

        // ===================== TASK A2: LINKED LIST DEMONSTRATION =====================
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║       TASK A2: SINGLY LINKED LIST DEMONSTRATION        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        System.out.println("--- CURRENT SERVICE RECORDS (from dequeued students) ---");
        serviceRecords.displayStudents();
        System.out.println("List structure: ");
        serviceRecords.displayWithLinks();

        // ================== INSERTION AT BEGINNING ==================
        System.out.println("\n--- INSERTION AT BEGINNING ---");
        Student charlie = new Student("221076543", "Charlie", "Appeal", 15);
        serviceRecords.insertAtBeginning(charlie);
        serviceRecords.displayStudents();
        System.out.println("List structure: ");
        serviceRecords.displayWithLinks();

        // ================== INSERTION AT END ==================
        System.out.println("\n--- INSERTION AT END ---");
        Student diana = new Student("221065432", "Diana", "Transcript", 3);
        serviceRecords.insertAtEnd(diana);
        serviceRecords.displayStudents();
        System.out.println("List structure: ");
        serviceRecords.displayWithLinks();

        // ================== INSERTION AT POSITION ==================
        System.out.println("\n--- INSERTION AT POSITION 3 ---");
        Student eve = new Student("221054321", "Eve", "Exemption", 7);
        serviceRecords.insertAtPosition(eve, 3);
        serviceRecords.displayStudents();
        System.out.println("List structure: ");
        serviceRecords.displayWithLinks();

        // ================== BEFORE & AFTER: INSERTION DIAGRAM ==================
        System.out.println("\n--- BEFORE & AFTER: INSERTION OPERATION ---");
        System.out.println("BEFORE insertion of Eve at position 3:");
        System.out.println("Charlie → Maria → Tomas → Ndapewa → Diana → NULL");
        System.out.println("\nAFTER insertion of Eve at position 3:");
        System.out.println("Charlie → Maria → Eve → Tomas → Ndapewa → Diana → NULL");
        System.out.println("          (links adjusted: previous.next = Eve, Eve.next = Tomas)");

        // ================== SEARCH OPERATION ==================
        System.out.println("\n--- SEARCH OPERATION ---");
        System.out.println("Searching for student #223041876 (Ndapewa)...");
        Student found = serviceRecords.searchStudent("223041876");

        System.out.println("\nSearching for student #999999999 (not in list)...");
        Student notFound = serviceRecords.searchStudent("999999999");

        // ================== TRAVERSAL/DISPLAY ==================
        System.out.println("\n--- TRAVERSAL (display all records) ---");
        serviceRecords.displayStudents();

        // ================== DELETION OPERATION ==================
        System.out.println("\n--- DELETION OPERATION ---");
        System.out.println("Deleting student #223041876 (Ndapewa)...");
        serviceRecords.deleteStudent("223041876");
        serviceRecords.displayStudents();

        System.out.println("List structure after deletion:");
        serviceRecords.displayWithLinks();

        // ================== BEFORE & AFTER: DELETION DIAGRAM ==================
        System.out.println("\n--- BEFORE & AFTER: DELETION OPERATION ---");
        System.out.println("BEFORE deletion of Ndapewa:");
        System.out.println("Charlie → Maria → Eve → Tomas → Ndapewa → Diana → NULL");
        System.out.println("\nAFTER deletion of Ndapewa:");
        System.out.println("Charlie → Maria → Eve → Tomas → Diana → NULL");
        System.out.println("          (Tomas.next now points directly to Diana, skipping Ndapewa)");

      
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║                    FINAL STATISTICS                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        System.out.println("Queue Status:");
        System.out.println("  - Students still waiting: " + waitingQueue.getSize());
        System.out.println("  - Is queue empty? " + waitingQueue.isEmpty());
        waitingQueue.displayQueue();

        System.out.println("Service Records Status:");
        System.out.println("  - Total students in records: " + serviceRecords.getSize());
        System.out.println("  - Is list empty? " + serviceRecords.isEmpty());
        serviceRecords.displayStudents();

        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║          DEMONSTRATION COMPLETED SUCCESSFULLY           ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
