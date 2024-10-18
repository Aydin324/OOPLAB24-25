package week3.task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class task2 {
    public static void main(String[] args) {
        // Connect to the database
        DbConnect dbConnect = new DbConnect();
        Connection conn = dbConnect.getConnection();

        // Fetch all tasks from the database
        ArrayList<TaskItem> tasks = getAllTasks(conn);
        // Display the tasks
        getAllObjects(tasks);

        // Example of adding a new task
        createTask(conn, new TaskItem(5, "New Task", TaskStatus.TO_DO));

        // Example of updating a task
        updateTaskDescription(conn, 1, "Updated Task Description");

        // Fetch a specific task by ID
        TaskItem task = getTaskById(conn, 2);
        if (task != null) {
            task.printInfo();
        }

        // Close the connection
        dbConnect.closeConnection();
    }

    // Method to fetch all task entities from the database
    public static ArrayList<TaskItem> getAllTasks(Connection conn) {
        ArrayList<TaskItem> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("task_description");
                String status = rs.getString("task_status");
                tasks.add(new TaskItem(id, description, TaskStatus.valueOf(status)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    // Method to fetch a task by its ID
    public static TaskItem getTaskById(Connection conn, int id) {
        TaskItem task = null;
        String sql = "SELECT * FROM tasks WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int taskId = rs.getInt("id");
                    String description = rs.getString("task_description");
                    String status = rs.getString("task_status");
                    task = new TaskItem(taskId, description, TaskStatus.valueOf(status));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    // Method to create a new task in the database
    public static void createTask(Connection conn, TaskItem task) {
        String sql = "INSERT INTO tasks (id, task_description, task_status) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, task.getId());
            pstmt.setString(2, task.getTaskDescription());
            pstmt.setString(3, task.getTaskStatus().name());
            pstmt.executeUpdate();
            System.out.println("Task created: " + task.getTaskDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update a task description by ID
    public static void updateTaskDescription(Connection conn, int id, String newDescription) {
        String sql = "UPDATE tasks SET task_description = ? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newDescription);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Task updated: ID " + id + " | New Description: " + newDescription);
            } else {
                System.out.println("No task found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllObjects(ArrayList<TaskItem> tasks) {
        for (TaskItem t : tasks) {
            t.printInfo();
        }
    }

    public static void getByStatus(ArrayList<TaskItem> tasks, TaskStatus status) {
        for (TaskItem t : tasks) {
            if (t.getTaskStatus() == status) {
                t.printInfo();
            }
        }
    }

    public static void getByConditionalId(ArrayList<TaskItem> tasks, int id) {
        for (TaskItem t : tasks) {
            if (t.getId() >= id) {
                t.printInfo();
            }
        }
    }

    public static void getTaskDescriptions(ArrayList<TaskItem> tasks) {
        for (TaskItem t : tasks) {
            System.out.println(t.getTaskDescription());
        }
    }
}
