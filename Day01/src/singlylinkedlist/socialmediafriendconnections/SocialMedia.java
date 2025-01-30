package singlylinkedlist.socialmediafriendconnections;

import java.util.ArrayList;
import java.util.List;

class SocialMedia {
    private User head;

    // Add a new user to the network
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            newUser.next = head;
            head = newUser;
        }
    }

    // Find a user by ID
    private User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: " + temp.name + " (ID: " + temp.userId + "), Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.addFriend(userId2);
        user2.addFriend(userId1);
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.removeFriend(userId2);
        user2.removeFriend(userId1);
        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            user.displayFriends();
        } else {
            System.out.println("User not found.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.print("Mutual Friends: ");
        Friend f1 = user1.friendList;
        List<Integer> mutuals = new ArrayList<>();

        while (f1 != null) {
            Friend f2 = user2.friendList;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    mutuals.add(f1.friendId);
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }

        if (mutuals.isEmpty()) {
            System.out.println("None");
        } else {
            for (int id : mutuals) {
                System.out.print(id + " ");
            }
            System.out.println();
        }
    }

    // Display all users and their friend count
    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " (ID: " + temp.userId + ") has " + temp.countFriends() + " friends.");
            temp = temp.next;
        }
    }
}

