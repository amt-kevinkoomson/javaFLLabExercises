import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {
    private Queue<String> taskQueue;

    public TaskScheduler() {
        taskQueue = new LinkedList<>();
    }

    public void addTask(String task) {
        taskQueue.offer(task);
    }

    public void removeCompletedTask() {
        if (!taskQueue.isEmpty()) {
            String completedTask = taskQueue.poll();
            System.out.println("Completed task: " + completedTask);
        } else {
            System.out.println("No tasks in the queue.");
        }
    }

    public void displayQueueContents() {
        if (!taskQueue.isEmpty()) {
            System.out.println("Tasks in the queue:");
            for (String task : taskQueue) {
                System.out.println(task);
            }
        } else {
            System.out.println("No tasks in the queue.");
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("Task 1");
        scheduler.addTask("Task 2");
        scheduler.addTask("Task 3");

        scheduler.displayQueueContents();

        scheduler.removeCompletedTask();
        scheduler.removeCompletedTask();
        scheduler.removeCompletedTask();
        scheduler.removeCompletedTask();
    }
}
