package astronautscheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    
    private ScheduleManager() {
        tasks = new ArrayList<>();
    }
    
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }
    
    public boolean addTask(Task task) {
        // Check for overlaps
        for (Task existingTask : tasks) {
            if (isOverlapping(task, existingTask)) {
                return false;
            }
        }
        tasks.add(task);
        return true;
    }
    
    public boolean removeTask(String description) {
        return tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(description));
    }
    
    public List<Task> getAllTasks() {
        return tasks.stream()
                .sorted((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()))
                .collect(Collectors.toList());
    }
    
    private boolean isOverlapping(Task newTask, Task existingTask) {
        return newTask.getStartTime().isBefore(existingTask.getEndTime()) && 
               newTask.getEndTime().isAfter(existingTask.getStartTime());
    }
    
    public void clearAllTasks() {
        tasks.clear();
    }
}