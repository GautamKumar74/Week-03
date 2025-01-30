package singlylinkedlist.socialmediafriendconnections;

class Friend {
    int friendId;
    Friend next;

    public Friend(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}