package view.view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Controller.TaskController;
import model.*;

public class viewTask {
    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAO();
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        DefaultListModel<String> notificationListModel = new DefaultListModel<>();
        TaskController controller = new TaskController(taskDAO, taskListModel, notificationListModel);

        JFrame frame = new JFrame("Graphical User Interface");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel datePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        datePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        datePanel.add(new JLabel("Day"));
        JTextField dayField = new JTextField();
        dayField.setEditable(false);
        datePanel.add(dayField);

        datePanel.add(new JLabel("Date"));
        JTextField dateField = new JTextField();
        dateField.setEditable(false);
        datePanel.add(dateField);

        JPanel birthdayPanel = new JPanel(new BorderLayout());
        birthdayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        birthdayPanel.add(new JLabel("Birthday Celebration Message"), BorderLayout.NORTH);
        JTextField birthdayMessageField = new JTextField();
        birthdayMessageField.setEditable(false);
        birthdayPanel.add(birthdayMessageField, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel notificationPanel = new JPanel(new BorderLayout());
        notificationPanel.setBorder(BorderFactory.createTitledBorder("Notifications"));
        JList<String> notificationsList = new JList<>(notificationListModel);
        notificationPanel.add(new JScrollPane(notificationsList), BorderLayout.CENTER);

        JPanel taskListPanel = new JPanel(new BorderLayout());
        taskListPanel.setBorder(BorderFactory.createTitledBorder("Task List"));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 3, 5));
        JButton addTaskButton = new JButton(new ImageIcon("add.png"));
        JButton deleteTaskButton = new JButton(new ImageIcon("delete.png"));
        JButton editTaskButton = new JButton(new ImageIcon("edit.png"));

        buttonPanel.add(addTaskButton);
        buttonPanel.add(deleteTaskButton);
        buttonPanel.add(editTaskButton);
        taskListPanel.add(buttonPanel, BorderLayout.NORTH);

        JList<String> taskList = new JList<>(taskListModel);
        taskListPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        mainPanel.add(notificationPanel);
        mainPanel.add(taskListPanel);

        frame.add(datePanel, BorderLayout.NORTH);
        frame.add(birthdayPanel, BorderLayout.CENTER);
        frame.add(mainPanel, BorderLayout.SOUTH);
        frame.setVisible(true);

        controller.refreshTaskList();
        addTaskButton.addActionListener(e -> {
            controller.addTask();
            controller.refreshTaskList();
        });

        deleteTaskButton.addActionListener(e -> {
            String selectedTask = taskList.getSelectedValue();
            controller.deleteTask(selectedTask);
            controller.refreshTaskList();
        });

        editTaskButton.addActionListener(e -> {
            String selectedTask = taskList.getSelectedValue();
            controller.editTask(selectedTask);
            controller.refreshTaskList();
        });

        Timer timer = new Timer(1000, e -> {
            LocalDate today = LocalDate.now();
            dayField.setText(today.getDayOfWeek().toString());
            dateField.setText(today.toString());
            String userBirthday = "2025-01-17";

            Message baseMessage = new BasicMessage(" "," ");
            BirthdayMessageDecorator decoratedMessage = new BirthdayMessageDecorator(baseMessage, userBirthday);
            birthdayMessageField.setText(decoratedMessage.getMessage());
            controller.checkForNotifications();
        });
        timer.start();
    }
}
