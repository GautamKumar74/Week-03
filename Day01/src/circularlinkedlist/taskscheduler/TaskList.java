package circularlinkedlist.taskscheduler;

class TaskList {
    Task head;
    Task tail;
    Task current = null;
    void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task t1 = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail =  t1;
            tail.next= head;
        } else {
            t1.next = head;
            head = t1;
            tail.next= head;
        }
    }
    void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task t1 = new Task(taskId, taskName, priority, dueDate);
        if (tail == null || head==null) {
            head = tail =  t1;
            tail.next= head;
        } else {
            tail.next=t1;
            tail= t1;
            tail.next = head;
        }
    }
    // Add task at a specific position
    void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task t1 = new Task(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task temp = head;
        int count = 1;
        while (count <= position-2 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        t1.next = temp.next;
        temp.next = t1;
        if (temp == tail) {
            tail = t1;
        }
        tail.next = head;
    }
    // Remove task by Task ID
    public void removeTask(int taskId) {
        if (head == null) return;
        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                    if (temp == tail) {
                        tail = prev;
                        tail.next = head;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    // View current task and move to the next task
    public void viewCurrentTask() {
        if (current == null) current = head;
        if (current != null) {
            System.out.println("Current Task: " + current.taskName + " (Priority: " + current.priority + ")");
            current = current.next;
        }
    }
    // Search for a task by priority
    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks found with priority " + priority);
    }
    void display(){
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task Id: " + temp.taskId + ", Task Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head); // Ensure we traverse circularly
    }
}
