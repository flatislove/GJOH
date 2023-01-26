package task1;

import com.google.gson.reflect.TypeToken;
import task1.model.Author;
import task1.model.enums.Priority;
import task1.model.Task;
import task1.model.enums.Position;
import task1.service.FileOperation;
import task1.service.FileService;
import task1.service.TaskOperation;
import task1.service.TaskService;

import java.util.Date;
import java.util.List;

/**
 * Спроектировать и реализовать планировщик дел для работы с задачами разных приоритетов.
 * Файлы хранятся в пакете storage
 */
public class MainScheduler {
    public static void main(String[] args) {
        FileService fileOperation = new FileOperation();
        TaskService taskService = new TaskOperation();

        Author john = new Author("john", "smith", Position.HEAD);
        Author mike = new Author("mike", "cole", Position.DEVOPS);
        Author henry = new Author("henry", "duff", Position.QA);
        Author kurt = new Author("kurt", "cobain", Position.DEVELOPER);
        Author homer = new Author("homer", "simpson", Position.DESIGNER);

        Task task1 = new Task(1, "Priority from Integer", 4, "2023-02-01", "08:00", john);
        Task task2 = new Task(2, "Priority from String", "lower", "2023-02-23", "11:15", mike);
        Task task3 = new Task(3, "Priority from Double", 0.2, "2023-02-11", "16:45", henry);
        Task task4 = new Task(4, "Priority from Upper String", "HHIGHTTT", "2023-01-30", "10:00", kurt);
        Task task5 = new Task(5, "Priority from Priority", Priority.HIGH, "2023-02-01", "17:00", kurt);
        Task task6 = new Task(6, "Priority from other type", new Date(), "2023-02-01", "11:00", homer);
        Task task7 = new Task(7, "Priority from Priority name", Priority.LOW.name(), "2023-02-04", "08:00", john);
        Task task8 = new Task(8, "Priority from empty String", "", "2023-02-03", "77:00", homer);
        Task task9 = new Task(9, "Priority from String", "LOW", "2023-02-02", "14:25", henry);
        Task task10 = new Task(10, "Priority from Long", 1L, "2023-02-01", "17:45", mike);

        List<Task> list = List.of(task1, task2, task3, task4, task5, task6, task7, task8, task9, task10);

        fileOperation.saveToFile(list, "src/task1/storage/list.json");
        fileOperation.saveToFile(task1, "src/task1/storage/task.json");
        fileOperation.saveToFile(john, "src/task1/storage/author.json");

        Task taskFromFile = fileOperation.readFromFile("src/task1/storage/task.json", Task.class);
        Author authorFromFile = fileOperation.readFromFile("src/task1/storage/author.json", Author.class);
        List<Task> listFromFile = fileOperation.readFromFile("src/task1/storage/list.json", new TypeToken<List<Task>>() {
        }.getType());

        System.out.println();
        System.out.println("Author From File:\n" + authorFromFile);

        System.out.println();
        System.out.println("Task From File:\n" + taskFromFile);
        System.out.println(taskService.getRemainingTime(taskFromFile));

        System.out.println();
        for (Task task : listFromFile) {
            System.out.println(task);
        }

        System.out.println();
        taskService.printTasksList(listFromFile);
    }
}
