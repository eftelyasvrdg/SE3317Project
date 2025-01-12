package view;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

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
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));;
        
        JPanel notificationPanel= new JPanel(new BorderLayout());
        notificationPanel.setBorder(BorderFactory.createTitledBorder("Notifications"));
        JList<String> notificationsList = new JList<>(new String[]{"Notification 1","Notification 2"});
        notificationPanel.add(new JScrollPane(notificationsList),BorderLayout.CENTER);

        
        frame.setVisible(true);
    }
}
