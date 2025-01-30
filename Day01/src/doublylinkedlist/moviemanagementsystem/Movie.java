package doublylinkedlist.moviemanagementsystem;

class Movie {
    String movieTitle;
    String director;
    int yearOfRelease;
    int rating;
    Movie next;
    Movie prev;
    Movie(String movieTitle, String director, int yearOfRelease, int rating){
        this.movieTitle= movieTitle;
        this.director= director;
        this.yearOfRelease= yearOfRelease;
        this.rating= rating;
    }
}
