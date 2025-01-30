package doublylinkedlist.moviemanagementsystem;

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList m1= new MovieList();
        m1.addAtBeginning("Pushpa 2", "ABCD", 2002, 4);
        m1.addAtEnd("Kgf","Neeraj",2024,6);
        m1.addAtEnd("Marcos","Harsh",2024,6);
        m1.addAtSpecificPosition("I","Harsh Raj",2024,8,2);
        m1.addAtBeginning("Pushpa", "ABCD", 2002, 5);
        m1.displayFromStart();
        System.out.println("---------------------------------------------");
        m1.displayFromLast();
        System.out.println("---------------------------------------------");
        try{
            Movie m= m1.remove("Pushpa 2");
            System.out.println("Movie with title: "+ m.movieTitle + " deleted.");
        }
        catch (Exception e){
            System.out.println("movie not found");
        }
        System.out.println("---------------------------------------------");
        m1.displayFromStart();
        System.out.println("---------------------------------------------");
        m1.displayFromLast();
        System.out.println("---------------------------------------------");
        try {
            Movie m2= m1.search("Neeraj");
            System.out.println("Movie found with director name " + m2.director + ", Movie title is: " + m2.movieTitle);
        }
        catch (Exception e){
            System.out.println("movie not found");
        }
        System.out.println("---------------------------------------------");
        System.out.println("After Rating Updation: ");
        m1.updateRating("Marcos",7);
        m1.displayFromStart();
    }
}
