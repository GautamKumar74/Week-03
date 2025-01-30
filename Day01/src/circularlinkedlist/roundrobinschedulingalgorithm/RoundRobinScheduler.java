package circularlinkedlist.roundrobinschedulingalgorithm;

class RoundRobinScheduler {
    private Process head, tail;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    // Add a new process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular link
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular link
        }
    }

    // Remove a process after execution
    private void removeProcess(Process prev, Process toRemove) {
        if (head == tail && head == toRemove) { // Only one process left
            head = tail = null;
        } else {
            if (toRemove == head) {
                head = head.next;
                tail.next = head;
            } else if (toRemove == tail) {
                prev.next = head;
                tail = prev;
            } else {
                prev.next = toRemove.next;
            }
        }
    }

    // Simulate round-robin scheduling
    public void executeProcesses() {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        int totalProcesses = 0, totalWaitingTime = 0, totalTurnaroundTime = 0;
        Process current = head, prev = tail;
        int time = 0;

        System.out.println("\nExecuting processes using Round Robin with Time Quantum = " + timeQuantum);

        while (head != null) {
            if (current.remainingTime > 0) {
                int executeTime = Math.min(current.remainingTime, timeQuantum);
                time += executeTime;
                current.remainingTime -= executeTime;

                if (current.remainingTime == 0) {
                    int turnaroundTime = time;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalWaitingTime += waitingTime;
                    totalTurnaroundTime += turnaroundTime;
                    totalProcesses++;

                    System.out.println("Process " + current.processId + " completed. Turnaround Time: " + turnaroundTime + ", Waiting Time: " + waitingTime);
                    removeProcess(prev, current);
                    current = prev.next;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        }

        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / totalProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / totalProcesses);
    }

    // Display process queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.println("Current Process Queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}