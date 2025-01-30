package circularlinkedlist.taskscheduler;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskList t= new TaskList();
        t.addAtBeginning(1234,"Buy Groceries",3,"Today");
        t.addAtBeginning(5336,"Run",1,"Today");
        t.addAtEnd(5337,"Exercise",2,"Today");
        t.addTaskAtPosition(5338,"Study",4,"Today", 2);
        t.display();
        System.out.println("\nRemoving by Task ID ");
        t.removeTask(5337);
        t.display();

        System.out.println("\nCurrent Task:");
        t.viewCurrentTask();
        t.viewCurrentTask();

        System.out.println("\nSearch by Priority 1:");
        t.searchByPriority(1);
    }
}
