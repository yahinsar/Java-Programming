package main.java.ru.sgu;

import java.sql.*;

public class MainTask {

    static final String URL = "jdbc:postgresql://localhost:5432/task7database";
    static final String USER = "postgres";
    static final String PASSWORD = "1q3wae123";

    public static void main(String[] args) {
        MainTask task = new MainTask();
        task.firstTask();
        task.secondTask();
        task.thirdTask();
    }

    public void firstTask() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT employeeName FROM employeesAge WHERE age > 20";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                System.out.println("\nСотрудники старше 20 лет:");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("employeeName"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении первого задания: " + e.getMessage());
        }
    }

    public void secondTask() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT departmentName, AVG(salary) AS averageSalary FROM departmentSalary GROUP BY departmentName";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                System.out.println("\nСредние зарплаты в каждом из отделов:");
                while (resultSet.next()) {
                    String departmentName = resultSet.getString("departmentName");
                    double averageSalary = resultSet.getDouble("averageSalary");
                    System.out.println(departmentName + " " + averageSalary);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении второго задания: " + e.getMessage());
        }
    }

    public void thirdTask() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT de.employeeName, dl.departmentName, dl.location " +
                    "FROM departmentEmployee de " +
                    "JOIN departmentLocation dl ON de.departmentId = dl.id";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                System.out.println("\nИмя отдела и локация работы сотрудников:");
                while (resultSet.next()) {
                    String employeeName = resultSet.getString("employeeName");
                    String departmentName = resultSet.getString("departmentName");
                    String location = resultSet.getString("location");
                    System.out.println(employeeName + " " + departmentName + " " + location);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении третьего задания: " + e.getMessage());
        }
    }
}
