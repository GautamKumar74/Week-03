package singlylinkedlist.studentrecordmanagement;

class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;
    Student(int rollNumber, String name, int age, char grade){
        this.rollNumber= rollNumber;
        this.name= name;
        this.age= age;
        this.grade= grade;
    }
}
