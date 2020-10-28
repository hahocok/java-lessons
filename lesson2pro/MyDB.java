package com.company;

import java.sql.*;

public class MyDB {
    private static Connection con;
    private static Statement stmt;

    public static void main(String[] args) throws SQLException {

        try {
            connection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS workers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "lastname TEXT," +
                "surname TEXT," +
                "price INTEGER)");

        stmt.executeUpdate("DELETE FROM workers");

        con.setAutoCommit(false);

        stmt.executeUpdate("INSERT INTO workers (lastname, name, surname, price)\n" +
                "VALUES ('Иванов', 'Иван', 'Иванович', 30000)");
        stmt.executeUpdate("INSERT INTO workers (lastname, name, surname, price)\n" +
                "VALUES ('Петров', 'Петр', 'Петрович', 27500)");
        stmt.executeUpdate("INSERT INTO workers (lastname, name, surname, price)\n" +
                "VALUES ('Дмитриев', 'Дмитрий', 'Дмитриевич', 32750)");

        con.commit();
        con.setAutoCommit(true);

        stmt.executeUpdate("UPDATE workers SET surname = 'Алексеевич' WHERE lastname = 'Иванов'");

        ResultSet rs = stmt.executeQuery("SELECT id, name, lastname, surname, price FROM workers");

        while (rs.next()) {
            System.out.println("id = " + rs.getString("id") +
                    " Имя = " + rs.getString("name") +
                    " Фамилия = " + rs.getString("lastname") +
                    " Отчество = " + rs.getString("surname") +
                    " Зарплата = " + rs.getDouble("price")
            );
        }

        disconnect();
    }

    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:src/com/company/myDB.db");
        stmt = con.createStatement();
    }

    public static void disconnect() throws SQLException {
        con.close();
    }
}
