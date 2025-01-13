package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
