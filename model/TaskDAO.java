package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//database ile ilgili tüm çekme ekleme editleme işlemleri
public class TaskDAO {
    //add
    public void addTask(String taskName, String description, String category, String deadline) {
        String sql = "INSERT INTO Tasks (task_name, description, category, deadline) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, taskName);
            statement.setString(2, description);
            statement.setString(3, category);
            statement.setString(4, deadline);
            statement.executeUpdate();
            System.out.println("Task added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete
    public void deleteTask(int taskId) {
        String sql = "DELETE FROM Tasks WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, taskId);
            statement.executeUpdate();
            System.out.println("Task deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //edit
    public void editTask(int taskId, String taskName, String description, String category, String deadline) {
        String sql = "UPDATE Tasks SET task_name = ?, description = ?, category = ?, deadline = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, taskName);
            statement.setString(2, description);
            statement.setString(3, category);
            statement.setString(4, deadline);
            statement.setInt(5, taskId);
            statement.executeUpdate();
            System.out.println("Task updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //sayıyı artırıyor
    private void markNotificationSent(int taskId) {
        String sql = "UPDATE Tasks SET notification_sent = 1 WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, taskId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //tarih kıyaslaması ve atılmış atılmamış kıyaslaması
    public List<String> getTasksWithNearDeadline() {
        //notif sayısının 0 olduklarını alıyor (daha gönderilmemiş yani)
        String sql = "SELECT id, task_name, deadline FROM Tasks WHERE DATEDIFF(deadline, CURDATE()) = 1 AND notification_sent = 0";
        List<String> notifications = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int taskId = resultSet.getInt("id");
                String taskName = resultSet.getString("task_name");
                Date deadline = resultSet.getDate("deadline");

                String notification = "Task '" + taskName + "' is due on " + deadline + ".";
                notifications.add(notification);
                markNotificationSent(taskId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }
}
