package Controller;
import javax.swing.*;
import model.TaskDAO;

public class TaskController {
    //belli bir task var
    private TaskDAO taskDAO;
    //model var
    private DefaultListModel<String> taskListModel;

    public TaskController(TaskDAO taskDAO, DefaultListModel<String> taskListModel) {
        this.taskDAO = taskDAO;
        this.taskListModel = taskListModel;
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
        taskListModel.clear();

    }

    private int parseTaskId(String taskString) {
        return Integer.parseInt(taskString.split(" ")[0]); // Simplistic example
    }
}
