public class Main {
    public static void main(String[] args) {
        TaskTracker tracker = new TaskTracker();

        // Добавляем задачи
        tracker.addTask("Проверить авторизацию");
        tracker.addTask("Написать отчет");
        tracker.addTask("Проверить регистрацию");
        tracker.addTask("Оптимизировать запросы");

        // Выводим все задачи
        tracker.printAllTasks();

        // Помечаем задачу как выполненную
        tracker.markTaskAsDone("Проверить авторизацию");

        // Получаем статус задачи
        Boolean status = tracker.getTaskStatus("Написать отчет");
        if (status != null) {
            System.out.println("Статус задачи \"Написать отчет\": " + (status ? "выполнена" : "не выполнена"));
        }

        // Выводим статистику
        tracker.printStatistics();

        // Повторно выводим все задачи, чтобы увидеть изменения
        tracker.printAllTasks();

        // Дополнительно: попробуем пометить несуществующую задачу
        tracker.markTaskAsDone("Несуществующая задача");
    }
}