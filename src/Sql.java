import java.sql.*;
import java.util.Scanner;

public class Sql {
    public static final String url = "jdbc:mysql://localhost:3306/testdatabase";
    public static final String user = "root";
    public static final String password = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement estmt = conn.createStatement();
            ResultSet ers = estmt.executeQuery("SELECT * FROM users");

            while (ers.next()) {
                System.out.println(ers.getInt("id") + " - " + ers.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       // InsertA();
        //UpdateA();
        //DeleteA(); // додали виклик
       // FindUser("Ivan");
        JoinSql();
        ShowAvg();
    }

    public static void InsertA() {
        String sql1 = "INSERT INTO users (name, age, Lastname) VALUES ('igor', 25, 'STR')";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement stmp1 = conn.prepareStatement(sql1);
            stmp1.executeUpdate();
            stmp1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateA() {
        String sql2 = "UPDATE users SET name='newName' WHERE id=12";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement stmp1 = conn.prepareStatement(sql2);
            int rowsCall = stmp1.executeUpdate();
            System.out.println("Оновлено строк: " + rowsCall);
            stmp1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void DeleteA() {
        String sql3 = "DELETE FROM users WHERE id=7";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement stmp1 = conn.prepareStatement(sql3);
            int rowsDeleted = stmp1.executeUpdate();
            //int rowsAffected = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Рядок успішно видалено.");
            } else {
                System.out.println("Нічого не видалено. Можливо, ID не існує.");
            }
//            if (rowsDeleted.next()) {
//                System.out.println("ID: " + rowsDeleted.getInt("id"));
//                System.out.println("Ім’я: " + rowsDeleted.getString("name"));
//                System.out.println("Email: " + rowsDeleted.getString("email"));
//            } else {
//                System.out.println("Користувача з таким ID не знайдено.");
//            }
            System.out.println("Видалено строк: " + rowsDeleted);
            stmp1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void FindUser(String name) {
        String xname;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vvedit name пошуку");
        xname = scanner.nextLine();
        String sql = "SELECT * FROM  users WHERE name ='" + xname + "'";
        // String sql= "SELECT users.name as UserName,orders.name as OrdrsName,users.id,orders.Price FROM orders INNER JOIN users ON orders.UserId=users.id;";
        System.out.println(sql);
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement stmp1 = conn.prepareStatement(sql);
            ResultSet ers = stmp1.executeQuery();
            System.out.println(!ers.isBeforeFirst());
            if (!ers.isBeforeFirst()) {
                System.out.println("Not found");
            } else {
                System.out.println(ers);
            }

            while (ers.next()) {
                System.out.println(ers.getInt("id") + " - " + ers.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void JoinSql() {
        // String sql= "SELECT * FROM  users WHERE name ='" + xname+"'";
        String sql = "SELECT users.name as UserName,orders.name as OrdrsName,users.id,orders.Price FROM orders INNER JOIN users ON orders.UserId=users.id;";
        System.out.println(sql);
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement stmp1 = conn.prepareStatement(sql);
            ResultSet ers = stmp1.executeQuery();
            System.out.println(!ers.isBeforeFirst());
            if (!ers.isBeforeFirst()) {
                System.out.println("Not found");
            } else {
                System.out.println(ers);
            }

            while (ers.next()) {
                System.out.println(ers.getInt("id") + " - " + ers.getString("UserName")+" - " +ers.getString("Price")+ " - "+ers.getString("OrdrsName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ShowAvg() {
        String Sql = "SELECT student_id, AVG(grade) AS avg FROM grades GROUP BY student_id";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement stmp = conn.prepareStatement(Sql);
            ResultSet rs = stmp.executeQuery();

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                double avgGrade = rs.getDouble("avg"); // треба зберегти в змінну
                System.out.println("Student ID: " + studentId + ", Average Grade: " + avgGrade);
            }

            rs.close();     // Закриваємо ResultSet
            stmp.close();   // Закриваємо PreparedStatement

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}






