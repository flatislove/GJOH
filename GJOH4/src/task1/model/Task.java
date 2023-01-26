package task1.model;

import task1.model.enums.Priority;
import task1.service.TaskOperation;
import task1.service.TaskService;

import java.util.Date;

/**
 * Class contains Task model
 */
public class Task {
    private final int id;
    private final String description;
    private final Priority priority;
    private final Date addingData;
    private final Date addingTime;
    private final Date deadlineData;
    private final Date deadlineTime;
    private final Author author;

    public <P> Task(int id, String description, P priority, String deadlineData, String deadlineTime, Author author) {
        TaskService taskService = new TaskOperation();
        this.id = id;
        this.description = description;
        this.priority = taskService.getFormalPriority(priority);
        Date[] currDates = taskService.getCurrentDateTime();
        this.addingData = currDates[0];
        this.addingTime = currDates[1];
        this.author = author;
        Date[] dates = taskService.getDateFromString(deadlineData, deadlineTime);
        this.deadlineData = dates[0];
        this.deadlineTime = dates[1];
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getAddingData() {
        return addingData;
    }

    public Date getAddingTime() {
        return addingTime;
    }

    public Date getDeadlineData() {
        return deadlineData;
    }

    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        TaskService taskService = new TaskOperation();
        return "Task:" +
                "\n    Id: " + id +
                "\n    Priority: " + priority +
                "\n    AddingData: " + taskService.getFormatDate(addingData) +
                "\n    AddingTime: " + taskService.getFormatTime(addingTime) +
                "\n    DeadlineData=" + taskService.getFormatDate(deadlineData) +
                "\n    DeadlineTime='" + taskService.getFormatTime(deadlineTime) +
                "\n    " + author;
    }
}
