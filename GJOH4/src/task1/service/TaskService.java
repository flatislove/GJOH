package task1.service;

import task1.model.Task;
import task1.model.enums.Priority;

import java.util.Date;
import java.util.List;

/**
 * service interface for working with a file, uses generics
 */
public interface TaskService {

    <P> Priority getFormalPriority(P priority);

    String getRemainingTime(Task task);

    void printTasksList(List<Task> list);

    Date[] getDateFromString(String date, String time);

    String getFormatDate(Date date);

    String getFormatTime(Date date);

    Date[] getCurrentDateTime();
}
