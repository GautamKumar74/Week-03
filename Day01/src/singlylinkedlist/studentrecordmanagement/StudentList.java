package singlylinkedlist.studentrecordmanagement;

class StudentList {
    Student head;

    void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Student s = new Student(rollNumber, name, age, grade);
        s.next = head;
        head = s;
    }
//    void addAtBeginning(Student s) {
//        new Student(s.rollNumber, s.name, s.age, s.grade);
//        s.next = head;
//        head = s;
//    }

    void addAtEnd(int rollNumber, String name, int age, char grade) {
        Student s = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = s;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = s;
    }

    //insert at specific position
    void addAtSpecificPosition(int rollNumber, String name, int age, char grade, int pos) {
        Student s = new Student(rollNumber, name, age, grade);
        if (pos == 1) {
            s.next = head;
            head = s;
            return;
        }
        Student temp = head;
        for (int i = 1; i <= pos - 2; i++) {
            temp = temp.next;
        }
        s.next = temp.next;
        temp.next = s;
    }

    void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll number: " + temp.rollNumber + ". name: " + temp.name + ". age: " + temp.age + ". grade: " + temp.grade);
            temp = temp.next;
        }
    }

    Student delete(int rollNumber) {
        Student temp = head;
        Student node;
        if (temp.rollNumber == rollNumber) {
            node = temp;
            head = head.next;
            return node;
        }
        while (temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        node = temp.next;
        temp.next = temp.next.next;
        return node;
    }

    Student search(int rollNumber) {
        Student temp = head;
        Student node;

        if (temp.rollNumber == rollNumber) {
            node = temp;
            return node;
        }
        while (temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        node = temp.next;
        return node;
    }

    Student updateGrade(int rollNumber, char grade){
        Student temp = head;
        Student node;

        if (temp.rollNumber == rollNumber) {
            temp.grade= grade;
            node = temp;
            return node;
        }
        while (temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        temp.next.grade= grade;
        node = temp.next;
        return node;
    }

}
