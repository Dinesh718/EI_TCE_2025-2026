package observer;

import model.Task;

public interface TaskObserver {
    void notifyConflict(Task newTask, Task existingTask);
}
