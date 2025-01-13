package view.view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewTask {
    public static void main(String[] args) {

        JFrame frame = new JFrame(" Graphical User Interface");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel datePanel=new JPanel(new GridLayout(2, 2, 10, 10));
        datePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        datePanel.add(new JLabel("Day"));
        JTextField dayField= new JTextField();
        datePanel.add(dayField);

        datePanel.add(new JLabel("Date"));
        JTextField dateField=new JTextField();
        datePanel.add(dateField);

        JPanel birthdayPanel = new JPanel(new BorderLayout());
        birthdayPanel.setBorder(BorderFactory.createEmptyBorder(10,10 ,10, 10));
        birthdayPanel.add(new JLabel("Birthday Celebration Message"),BorderLayout.NORTH);
        JTextField birthdayMessageField = new JTextField();
        birthdayPanel.add(birthdayMessageField,BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new GridLayout(1,2,10,10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel notificationPanel= new JPanel(new BorderLayout());
        notificationPanel.setBorder(BorderFactory.createTitledBorder("Notifications"));
        JList<String> notificationsList = new JList<>(new String[]{" "});
        notificationPanel.add(new JScrollPane(notificationsList),BorderLayout.CENTER);

        JPanel taskListPanel = new JPanel(new BorderLayout());
        taskListPanel.setBorder(BorderFactory.createTitledBorder("Task List"));

        JPanel buttonPanel = new JPanel(new GridLayout(1,2,3,5));
        JButton addTaskButton = new JButton(new ImageIcon("add.png"));
        JButton deleteTaskButton = new JButton(new ImageIcon("delete.png"));
        JButton editTaskButton = new JButton(new ImageIcon("edit.png"));
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = JOptionPane.showInputDialog(frame, "Enter a new task:");
                if (task != null && !task.trim().isEmpty()) {
                    // Logic to add the task (e.g., add to a list or display in the UI)
                    System.out.println("Task added: " + task);
                } else {
                    JOptionPane.showMessageDialog(frame, "Task cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to delete a selected task
                // For simplicity, we can use a placeholder message
                JOptionPane.showMessageDialog(frame, "Task deleted (placeholder logic).", "Delete Task", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        editTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to edit a selected task
                // Placeholder logic for task editing
                String updatedTask = JOptionPane.showInputDialog(frame, "Edit the selected task:");
                if (updatedTask != null && !updatedTask.trim().isEmpty()) {
                    // Logic to update the task
                    System.out.println("Task updated to: " + updatedTask);
                } else {
                    JOptionPane.showMessageDialog(frame, "Updated task cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(addTaskButton);
        buttonPanel.add(deleteTaskButton);
        buttonPanel.add(editTaskButton);
        taskListPanel.add(buttonPanel,BorderLayout.NORTH);

        JList <String> taskList = new JList<>(new String[]{" "});
        taskListPanel.add(new JScrollPane(taskList),BorderLayout.CENTER);

        mainPanel.add(notificationPanel);
        mainPanel.add(taskListPanel);


        frame.add(datePanel,BorderLayout.NORTH);
        frame.add(birthdayPanel,BorderLayout.CENTER);
        frame.add(mainPanel,BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
