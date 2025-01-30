package singlylinkedlist.studentrecordmanagement;

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentList s = new StudentList();
        s.addAtBeginning(1, "Neeraj", 20, 'A');
//        Student s1= new Student(1,"Neeraj", 20, 'A');
//        s.addAtBeginning(s1);
        s.display();
        System.out.println("---------------------------------------------------------");
        s.addAtEnd(2, "Gautam", 21, 'A');
        s.display();
        System.out.println("---------------------------------------------------------");
        s.addAtSpecificPosition(3, "Harshit", 21, 'A', 2);
        s.display();
        System.out.println("---------------------------------------------------------");
        s.addAtBeginning(4, "Naveen", 22, 'A');
        s.display();
        System.out.println("---------------------------------------------------------");
        s.addAtSpecificPosition(5, "Harsh", 21, 'A', 5);
        s.display();
        System.out.println("---------------------------------------------------------");
        Student s3 = s.delete(4);
        System.out.println("Roll number: " + s3.rollNumber + " deleted." + " Name: " + s3.name + " deleted.");
        System.out.println("---------------------------------------------------------");
        System.out.println("After deleting roll number :" + s3.rollNumber + ", full student list: ");
        s.display();
        System.out.println("---------------------------------------------------------");
        try {
            Student s4 = s.search(1);
            System.out.println("After searching roll number :" + s4.rollNumber + ": ");
            System.out.println("Roll number: " + s4.rollNumber + ". name: " + s4.name + ". age: " + s4.age + ". grade: " + s4.grade);
        } catch (Exception e) {
            System.out.println("Roll number is not found");
        }
        System.out.println("---------------------------------------------------------");
        try {
            Student s5 = s.updateGrade(5,'C');
            System.out.println("After updating grade of roll number :" + s5.rollNumber + ": ");
            System.out.println("Roll number: " + s5.rollNumber + ". name: " + s5.name + ". age: " + s5.age + ". grade: " + s5.grade);
            System.out.println("Displaying full table: ");
            s.display();
        } catch (Exception e) {
            System.out.println("Roll number is not found");
        }
    }
}
