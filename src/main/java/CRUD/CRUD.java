package CRUD;

import java.sql.*;

public class CRUD {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) {
        try {
            connect();
            createDB();
            addNew("Орлов", 200, "10-10-1891");
            promote("Орлов", 201);
            printDB();
            fireFromDB("Орлов");
            printDB();
            disconnect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createDB() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS workers");

        stmt.executeUpdate("CREATE TABLE workers " +
                "( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(45) not null, salary int not null, date_of_birth DATE not null)");

        connection.setAutoCommit(false);

        stmt.execute("INSERT INTO workers (name, salary, date_of_birth)\n" +
                "values ('Петров', 100, '15-03-1991')");
        stmt.execute("INSERT INTO workers (name, salary, date_of_birth)\n" +
                "values ('Иванов', 110, '15.04.1992')");
        stmt.execute("INSERT INTO workers (name, salary, date_of_birth)\n" +
                "values ('Сидоров', 115, '15.05.1993')");

        connection.setAutoCommit(true);
    }

    public static void addNew(String newName, int newSalary, String dateOfBirth) throws SQLException {
        String sql = String.format("INSERT INTO workers (name, salary, date_of_birth)" +
                " values ('%s', %d, '$s')", newName, newSalary, dateOfBirth);
        stmt.executeUpdate(sql);
    }

    public static void promote(String name, int salary) throws SQLException {
        String sql = String.format("UPDATE workers SET salary = %d where name = '%s'", salary, name);
        stmt.executeUpdate(sql);
    }

    public static void printDB() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM workers");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " получает " + rs.getInt("salary"));
        }
    }

    public static void updateDB(String id, String newValue) throws SQLException {
        String sql = String.format("UPDATE students SET score = %s where id = %s", newValue, id);
        stmt.executeUpdate(sql);
    }

    public static void fireFromDB(String name) throws SQLException {
        String sql = String.format("DELETE FROM workers WHERE name = '%s'", name);
        stmt.executeUpdate(sql);

        System.out.println("\n" + name + " уволен!\n");
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:workers.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() throws SQLException{
        connection.close();
    }
}

//            ResultSet rs = stmt.executeQuery("SELECT * FROM students where id > 0");
//            ResultSetMetaData rsmd = rs.getMetaData();
//
//            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i));
//            }
//
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString("name"));
//            }
//            stmt.executeUpdate("CREATE TABLE students " +
//                    "( id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "name TEXT," +
//                    "score TEXT)");
//
//            long t = System.currentTimeMillis();
//            for (int i = 0; i < 1000; i++) {
//                stmt.addBatch("INSERT INTO students (name, score)\n" +
//                        "values ('unknow', 100)");
//            }
//            stmt.executeBatch();
//
//            connection.setAutoCommit(true);

//            System.out.println(System.currentTimeMillis() - t);

//            pstmt = connection.prepareStatement("INSERT INTO students (name, score)\n" +
//                    "values (?,?)");
//
//            for (int i = 0; i < 10; i++) {
//                pstmt.setString(1, "Bob" + (i));
//                pstmt.setString(2, " " + (i * 10));
//                pstmt.addBatch();
//            }
//            pstmt.executeBatch();


//            stmt.executeUpdate("INSERT INTO students (name, score)\n" +
//                    "values ('Bob1', 10)");
//
//            Savepoint sp = connection.setSavepoint();
//
//
//            stmt.executeUpdate("INSERT INTO students (name, score)\n" +
//                    "values ('Bob2', 20)");
//
//            connection.rollback(sp);
//            connection.setAutoCommit(true);
//
//            stmt.executeUpdate("INSERT INTO students (name, score)\n" +
//                    "values ('Bob3', 30)");

//            try {
//                readFile();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            // DELETE - удаляет
//            // DROP - удаляет таблицу
//            // TRUNCATE - удаляет (транзакция)

//        ResultSetMetaData rsmd = rs.getMetaData();
//        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//            System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i));
//        }


//    public static void readFile() throws FileNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream("D:\\Users\\Artem\\Desktop\\test\\update.txt");
//        Scanner scanner = new Scanner(fileInputStream);
//
//        while (scanner.hasNext()) {
//            String[] mass = scanner.nextLine().split(" ");
//            try {
//                updateDB(mass[0], mass[1]);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }