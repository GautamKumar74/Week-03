package circularlinkedlist.roundrobinschedulingalgorithm;

import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Time Quantum: ");
        int timeQuantum = sc.nextInt();

        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        // Adding sample processes
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        System.out.println("\nInitial Process Queue:");
        scheduler.displayProcesses();

        scheduler.executeProcesses();
    }
}
