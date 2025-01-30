package singlylinkedlist.socialmediafriendconnections;

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        // Adding users
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 28);
        sm.addUser(4, "David", 22);

        // Adding friendships
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(2, 4);

        // Displaying all users and friend count
        sm.displayAllUsers();

        // Display friends of a specific user
        sm.displayFriends(1);

        // Finding mutual friends
        sm.findMutualFriends(1, 2);
        sm.findMutualFriends(1, 4);

        // Searching for a user
        sm.searchUser("Alice", -1);
        sm.searchUser("", 3);

        // Removing a friend connection
        sm.removeFriendConnection(1, 3);

        // Displaying friends after removal
        sm.displayFriends(1);
    }
}