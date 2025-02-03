package stacksandqueues.queueusingstacks;

public class Main {
    public static void main(String[] args) {
        QueueUsingStacks q= new QueueUsingStacks();
        q.enqueue(2);
        int n1 = q.dequeue();
        System.out.println(n1 + " is deleted from queue");
        q.enqueue(3);
        q.enqueue(7);
        int n2 = q.dequeue();
        System.out.println(n2 + " is deleted from queue");
        q.enqueue(8);
        q.enqueue(5);
        int n3 = q.peek();
        System.out.println(n3 + " is peeked from front of queue");
    }
}
