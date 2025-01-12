import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDAO {
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
}
