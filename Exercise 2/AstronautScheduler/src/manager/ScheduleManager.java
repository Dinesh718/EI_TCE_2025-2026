package manager;

import model.Task;
import observer.TaskObserver;
import exception.TaskConflictException;
import exception.TaskNotFoundException;

import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<TaskObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            synchronized (ScheduleManager.class) {
                if (instance == null) {
                    instance = new ScheduleManager();
                }
            }
        }
        return instance;
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void addTask(Task newTask) throws TaskConflictException {
        for (Task t : tasks) {
            if (!(newTask.getEndTime().isBefore(t.getStartTime()) || newTask.getStartTime().isAfter(t.getEndTime()))) {
                for (TaskObserver obs : observers) {
                    obs.notifyConflict(newTask, t);
                }
                throw new TaskConflictException("Task conflict detected.");
            }
        }
        tasks.add(newTask);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        System.out.println("Task added successfully. No conflicts.");
    }

    public void removeTask(String description) throws TaskNotFoundException {
        Optional<Task> taskToRemove = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();

        if (taskToRemove.isPresent()) {
            tasks.remove(taskToRemove.get());
            System.out.println("Task removed successfully.");
        } else {
            throw new TaskNotFoundException("Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            tasks.forEach(System.out::println);
        }
    }
}
