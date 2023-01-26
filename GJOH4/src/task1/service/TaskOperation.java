package task1.service;

import task1.model.Task;
import task1.model.enums.Priority;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * service class for working with tasks, uses generics
 */
public class TaskOperation implements TaskService {

    public <P> Priority getFormalPriority(P priority) {
        if (priority instanceof Priority) {
            return (Priority) priority;
        } else if (priority instanceof Number) {
            if (((Number) priority).intValue() >= 3) {
                return Priority.HIGH;
            } else if (((Number) priority).intValue() <= 1) {
                return Priority.LOW;
            } else {
                return Priority.NORMAL;
            }
        } else if (priority instanceof String) {
            if (((String) priority).contains("low") || ((String) priority).contains("LOW")) {
                return Priority.LOW;
            } else if (((String) priority).contains("high") || ((String) priority).contains("HIGH")) {
                return Priority.HIGH;
            } else {
                return Priority.NORMAL;
            }
        } else {
            return Priority.NORMAL;
        }
    }

    @Override
    public String getRemainingTime(Task task) {
        String addingString = getFormatDate(task.getAddingData()) + " " + getFormatTime(task.getAddingTime());
        String deadlineString = getFormatDate(task.getDeadlineData()) + " " + getFormatTime(task.getDeadlineTime());
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date adding;
        Date deadline;
        try {
            adding = formatDate.parse(addingString);
            deadline = formatDate.parse(deadlineString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long minutes = ((deadline.getTime() - adding.getTime()) % 3600000) / 60000;
        long hours = (deadline.getTime() - adding.getTime()) / 3600000;
        return "Remaining time: " + hours + " hours and " + minutes + " minutes";
    }

    @Override
    public void printTasksList(List<Task> list) {
        String format = "| %-4s | %-30s | %-10s | %-15s | %-10s | %-15s | %-10s | %-25s | %-43s |%n";
        System.out.format("+------+--------------------------------+------------+-----------------+------------+-----------------+------------+---------------------------+---------------------------------------------+%n");
        System.out.printf("| %-4s | %-30s | %-10s | %-15s | %-10s | %-15s | %-10s | %-25s | %-43s |%n",
                "Id", "Description", "Priority", "Adding Date", "Add Time", "Deadline Date", "Dead Time", "Author", "Remaining Time");
        System.out.format("+------+--------------------------------+------------+-----------------+------------+-----------------+------------+---------------------------+---------------------------------------------+%n");
        for (Task task : list) {
            System.out.format(format, task.getId(), task.getDescription(), task.getPriority().name(), getFormatDate(task.getAddingData()),
                    getFormatTime(task.getAddingTime()), getFormatDate(task.getDeadlineData()),
                    getFormatTime(task.getDeadlineTime()), task.getAuthor().getFirstname() + " " + task.getAuthor().getLastname(), getRemainingTime(task));
        }
        System.out.format("+------+--------------------------------+------------+-----------------+------------+-----------------+------------+---------------------------+---------------------------------------------+%n");
    }

    @Override
    public Date[] getDateFromString(String date, String time) {
        Date[] dates = new Date[2];
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
        try {
            dates[0] = formatDate.parse(date);
            dates[1] = formatTime.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            return dates;
        }
        return dates;
    }

    @Override
    public Date[] getCurrentDateTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        String cDate = currentTime.toString();
        int pos = cDate.indexOf("T");
        String date = currentTime.toString().substring(0, pos);
        cDate = cDate.substring(pos);
        String time = cDate.split("\\.")[0].substring(1, 6);
        return getDateFromString(date, time);
    }

    @Override
    public String getFormatDate(Date date) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        return outputFormat.format(date);
    }

    @Override
    public String getFormatTime(Date date) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");
        return outputFormat.format(date);
    }
}
