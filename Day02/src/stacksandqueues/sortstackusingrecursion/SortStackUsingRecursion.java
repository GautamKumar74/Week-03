package stacksandqueues.sortstackusingrecursion;

import java.util.Stack;

public class SortStackUsingRecursion {

    // Function to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Pop the top element
            int temp = stack.pop();

            // Recursively sort the remaining stack
            sortStack(stack);

            // Insert the popped element back in sorted order
            insertSorted(stack, temp);
        }
    }

    // Function to insert an element into a sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Remove the top element
        int temp = stack.pop();

        // Recursively insert the element in the correct position
        insertSorted(stack, element);

        // Push the popped element back
        stack.push(temp);
    }

    // Driver code to test the function
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}