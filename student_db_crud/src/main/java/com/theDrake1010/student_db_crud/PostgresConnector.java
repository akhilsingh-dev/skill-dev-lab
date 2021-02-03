package com.theDrake1010.student_db_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresConnector {
    private final String db_name = "test";
    private final String db_url = "jdbc:postgresql://localhost/" + db_name;
    private final String user = "postgres";
    private final String password = "akhil@2017";

    // private static final String createTableSQL = "CREATE TABLE IF NOT EXISTS students " +
    //     "(ID INT PRIMARY KEY ," +
    //     " NAME TEXT, " +
    //     " EMAIL VARCHAR(50), " +
    //     " COUNTRY VARCHAR(50), ";

    public Connection connectToDB(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(db_url, user, password);
            System.out.println((conn != null) ? "Connection Successfull!" : "Connection Failed!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public 
}
