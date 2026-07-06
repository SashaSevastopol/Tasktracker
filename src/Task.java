public class Task {
    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false; // по умолчанию задача не выполнена
    }

    public void markAsDone() {
        isDone = true;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return (isDone ? "[x] " : "[] ") + name;
    }
}