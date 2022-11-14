package pl.edu.pb.todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();
    private final List<Task> tasks = new ArrayList<>();
    public static TaskStorage getInstance() {
        return taskStorage;
    }

    public Task getTask(UUID id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }


    private TaskStorage() {
        for (int i = 1; i < 101; i++) {
            Task task = new Task();
            task.setName("Zadanie " + i);
            task.setDone(false);
            if(i % 3 == 0){
                task.setCategory(Category.Studia);
            } else{
                task.setCategory(Category.Dom);
            }
            tasks.add(task);
        }
    }

    public List<Task> getTasks() {
        return  tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
