package doublylinkedlist.librarymanagementsystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addAtEnd(1, "The Alchemist", "Paulo Coelho", "Fiction", true);
        library.addAtEnd(2, "1984", "George Orwell", "Dystopian", true);
        library.addAtBeginning(3, "To Kill a Mockingbird", "Harper Lee", "Classic", true);

        System.out.println("Library Books (Forward Order):");
        library.displayForward();

        System.out.println("\nLibrary Books (Reverse Order):");
        library.displayReverse();

        System.out.println("\nTotal Books in Library: " + library.countBooks());
    }
}