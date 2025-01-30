package singlylinkedlist.socialmediafriendconnections;

class User {
    int userId;
    String name;
    int age;
    Friend friendList;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }

    // Add a friend to the user's friend list
    public void addFriend(int friendId) {
        Friend newFriend = new Friend(friendId);
        newFriend.next = friendList;
        friendList = newFriend;
    }

    // Remove a friend from the user's friend list
    public void removeFriend(int friendId) {
        Friend temp = friendList, prev = null;
        while (temp != null && temp.friendId != friendId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return; // Friend not found
        if (prev == null) friendList = friendList.next; // Remove first friend
        else prev.next = temp.next;
    }

    // Display the user's friends
    public void displayFriends() {
        System.out.print("Friends of " + name + " (ID: " + userId + "): ");
        Friend temp = friendList;
        if (temp == null) {
            System.out.println("No friends.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Count the number of friends
    public int countFriends() {
        int count = 0;
        Friend temp = friendList;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

