import java.util.ArrayList;
import java.util.List;

/**
 * TaskTracker хранит список задач и предоставляет методы для управления ими.
 */
public class TaskTracker {
    private List<Task> tasks;

    public TaskTracker() {
        tasks = new ArrayList<>();
    }

    public void addTask(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Ошибка: название задачи не может быть пустым.");
            return;
        }
        tasks.add(new Task(name));
        System.out.println("Задача \"" + name + "\" добавлена.");
    }

    public void printAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }
        System.out.println("=== Список задач ===");
        for (Task task : tasks) {
            System.out.println(task);
        }
        System.out.println("====================");
    }

    public void markTaskAsDone(String name) {
        Task found = findTaskByName(name);
        if (found == null) {
            System.out.println("Задача \"" + name + "\" не найдена.");
            return;
        }
        if (found.isDone()) {
            System.out.println("Задача \"" + name + "\" уже выполнена.");
        } else {
            found.markAsDone();
            System.out.println("Задача \"" + name + "\" помечена как выполненная.");
        }
    }

    public Boolean getTaskStatus(String name) {
        Task found = findTaskByName(name);
        if (found == null) {
            System.out.println("Задача \"" + name + "\" не найдена.");
            return null;
        }
        return found.isDone();
    }

    public void printStatistics() {
        int total = tasks.size();
        int done = 0;
        for (Task task : tasks) {
            if (task.isDone()) {
                done++;
            }
        }
        int open = total - done;
        System.out.println("Всего задач: " + total);
        System.out.println("Выполнено: " + done);
        System.out.println("Открыто: " + open);
    }

    private Task findTaskByName(String name) {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(name)) {
                return task;
            }
        }
        return null;
    }
}
