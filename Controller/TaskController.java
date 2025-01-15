package Controller;
import javax.swing.*;
import model.TaskDAO;

import java.util.List;

public class TaskController {
    //belli bir task var
    private TaskDAO taskDAO;
    //model var
    private DefaultListModel<String> taskListModel;
    private DefaultListModel<String> notificationListModel;

    public TaskController(TaskDAO taskDAO, DefaultListModel<String> taskListModel, DefaultListModel<String> notificationListModel) {
        this.taskDAO = taskDAO;
        this.taskListModel = taskListModel;
        this.notificationListModel = notificationListModel;
    }

    public void addTask() {
        //bunlardan emin değilim JOption isimlerine bakabilir misin
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String description = JOptionPane.showInputDialog("Enter Description:");
        String category = JOptionPane.showInputDialog("Enter Category:");
        String deadline = JOptionPane.showInputDialog("Enter Deadline:");
        taskDAO.addTask(taskName, description, category, deadline);
        refreshTaskList();
    }

    public void deleteTask(String selectedTask) {
        if (selectedTask != null) {
            int taskId = parseTaskId(selectedTask);
            taskDAO.deleteTask(taskId);
            refreshTaskList();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a task to delete.");
        }
    }

    public void editTask(String selectedTask) {
        if (selectedTask != null) {
            int taskId = parseTaskId(selectedTask);
            String taskName = JOptionPane.showInputDialog("Edit Task Name:");
            String description = JOptionPane.showInputDialog("Edit Description:");
            String category = JOptionPane.showInputDialog("Edit Category:");
            String deadline = JOptionPane.showInputDialog("Edit Deadline:");
            taskDAO.editTask(taskId, taskName, description, category, deadline);
            refreshTaskList();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a task to edit.");
        }
    }

    public void refreshTaskList() {
        taskListModel.clear(); // Clear the existing list
        List<String> tasks = taskDAO.getAllTasks(); // Fetch all tasks
        for (String task : tasks) {
            taskListModel.addElement(task); // Add each task to the task list model
        }
    }

    private int parseTaskId(String taskString) {
        return Integer.parseInt(taskString.split(" ")[0]); // Simplistic example
    }


    public void checkForNotifications() {
        List<String> notifications = taskDAO.getTasksWithNearDeadline();
        for (String notification : notifications) {
            notificationListModel.addElement(notification);
        }
    }

}
