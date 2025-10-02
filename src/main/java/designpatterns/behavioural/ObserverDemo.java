package designpatterns.behavioural;

// Simple Task class for demo (standalone - no import needed)
class DemoTask {
    private String name;
    private String time;
    
    public DemoTask(String name, String time) {
        this.name = name;
        this.time = time;
    }
    
    public String getName() { return name; }
    public String getTime() { return time; }
}

// Observer interface
interface TaskObserver {
    void onTaskAdded(DemoTask task);
    void onTaskRemoved(DemoTask task);
}

// Concrete Observers
class NotificationService implements TaskObserver {
    @Override
    public void onTaskAdded(DemoTask task) {
        System.out.println("NOTIFICATION: Task '" + task.getName() + "' added at " + task.getTime());
    }
    
    @Override
    public void onTaskRemoved(DemoTask task) {
        System.out.println("NOTIFICATION: Task '" + task.getName() + "' removed");
    }
}

class LoggerService implements TaskObserver {
    @Override
    public void onTaskAdded(DemoTask task) {
        System.out.println("LOG: Added task - " + task.getName());
    }
    
    @Override
    public void onTaskRemoved(DemoTask task) {
        System.out.println("LOG: Removed task - " + task.getName());
    }
}

// Subject (Observable)
class TaskManager {
    private java.util.List<TaskObserver> observers = new java.util.ArrayList<>();
    private java.util.List<DemoTask> tasks = new java.util.ArrayList<>();
    
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }
    
    public void addTask(DemoTask task) {
        tasks.add(task);
        notifyTaskAdded(task);
    }
    
    public void removeTask(DemoTask task) {
        if (tasks.remove(task)) {
            notifyTaskRemoved(task);
        }
    }
    
    private void notifyTaskAdded(DemoTask task) {
        for (TaskObserver observer : observers) {
            observer.onTaskAdded(task);
        }
    }
    
    private void notifyTaskRemoved(DemoTask task) {
        for (TaskObserver observer : observers) {
            observer.onTaskRemoved(task);
        }
    }
}

// Demo class
public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("=== Observer Pattern Demo ===");
        
        TaskManager taskManager = new TaskManager();
        
        // Register observers
        taskManager.addObserver(new NotificationService());
        taskManager.addObserver(new LoggerService());
        
        // Create and add tasks
        DemoTask task1 = new DemoTask("Morning Exercise", "07:00");
        DemoTask task2 = new DemoTask("Team Meeting", "09:00");
        
        System.out.println("\nAdding tasks:");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        
        System.out.println("\nRemoving a task:");
        taskManager.removeTask(task1);
        
        System.out.println("Observer demo completed!");
    }
}