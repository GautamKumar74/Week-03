package doublylinkedlist.moviemanagementsystem;

class MovieList {
    Movie head;
    Movie tail;

    void addAtBeginning(String movieTitle, String director, int yearOfRelease, int rating) {
        Movie m1 = new Movie(movieTitle, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = m1;
        } else {
            m1.next = head;
            head.prev = m1;
            head = m1;
        }
    }

    void addAtEnd(String movieTitle, String director, int yearOfRelease, int rating) {
        Movie m1 = new Movie(movieTitle, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = m1;
        } else {
            Movie temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            m1.prev = tail;
            tail.next = m1;
            tail = m1;
        }
    }
    void addAtSpecificPosition(String movieTitle, String director, int yearOfRelease, int rating, int position) {
        Movie m1 = new Movie(movieTitle, director, yearOfRelease, rating);
        if (position==1) {
            addAtBeginning(movieTitle, director, yearOfRelease, rating);
        } else {
            Movie temp = head;
            for(int i=1; i<=position-2; i++){
                temp= temp.next;
            }
            m1.next= temp.next;
            m1.prev= temp;
            temp.next.prev=m1;
            temp.next= m1;
        }
    }

    Movie remove(String title) {
        Movie temp = head;
        Movie node;
        if (temp.movieTitle == title) {
            node = temp;
            head = temp.next;
            temp.next.prev = null;
            return node;
        } else {
            while (temp.next != null && temp.movieTitle != title) {
                temp = temp.next;
            }
            if (temp.next == null && temp.movieTitle == title) {
                node = temp;
                temp.prev.next = null;
                tail = temp.prev;
                return node;
            } else if (temp.next != null && temp.movieTitle == title) {
                node = temp;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return node;
            }
            else {
                return null;
            }

        }

    }

    void displayFromStart() {
        System.out.println("Displaying List from start:");
        Movie temp = head;
        while (temp != null) {
            System.out.println("Movie Title : " + temp.movieTitle + ", Director: " + temp.director + ", Year Of Release: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    void displayFromLast() {
        System.out.println("Displaying List from last:");
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Movie Title : " + temp.movieTitle + ", Director: " + temp.director + ", Year Of Release: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    Movie search(String director) {
        Movie temp = head;
        if (temp.director == director) {
            return temp;
        } else {
            while (temp.director != director) {
                temp = temp.next;
            }
            return temp;
        }
    }
    void updateRating(String title, int rating){
        Movie temp= head;
        if(temp.movieTitle==title){
            temp.rating=rating;
        }
        else{
            while (temp.movieTitle!=title){
                temp= temp.next;
            }
            if(temp.movieTitle!=title){
                return;
            }
            else{
                temp.rating= rating;
            }
        }
    }
}
