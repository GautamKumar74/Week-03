package circularlinkedlist.roundrobinschedulingalgorithm;

class Process {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}