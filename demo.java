import model.TaskDAO;

public class demo {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("tolga");
        System.out.println("efto1");

        TaskDAO taskDAO = new TaskDAO();

        String taskName = "Complete Report";
        String description = "Finish the financial report for Q4.";
        String category = "Work";
        String deadline = "2025-01-15";

        taskDAO.addTask(taskName, description, category, deadline);
    }
}
