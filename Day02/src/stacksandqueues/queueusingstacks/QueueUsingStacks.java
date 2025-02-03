package stacksandqueues.queueusingstacks;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void enqueue(int num) {
        stack1.push(num);
        System.out.println(num + " entered into queue.");
    }

    int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int num = stack1.pop();
                stack2.push(num);
            }
        }

        int deleted = stack2.pop();
        return deleted;
    }

    int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int num = stack1.pop();
                stack2.push(num);
            }
        }

        int peeked = stack2.peek();
        return peeked;
    }
}
