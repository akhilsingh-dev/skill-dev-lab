package com.theDrake1010.student_db_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.File;
import java.util.Scanner;

public class PostgresConnector {
    
    public Connection connectToDB(){    
        Connection conn = null;
        try {
            File myObj = new File("./student_db_crud/db_cred.txt");
            Scanner myReader = new Scanner(myObj);
            final String db_url = "jdbc:postgresql://localhost/" + myReader.nextLine().toString();
            final String user = myReader.nextLine().toString();
            final String password = myReader.nextLine().toString();
            myReader.close();

            Class.forName("org.postgresql.Driver");
            
            conn = DriverManager.getConnection(db_url, user, password);
            System.out.println((conn != null) ? "Connection Successfull!" : "Connection Failed!");
        } 
        catch(SQLException sqle) {
            sqle.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void createTable(Connection conn, String tableName) {
        Statement statement;
        try {
            String query = "CREATE TABLE IF NOT EXISTS " + tableName + 
                "(prn SERIAL PRIMARY KEY," + 
                " name VARCHAR(200)," +
                " course VARCHAR(20)," +
                " institute  VARCHAR(50)," +
                " grade REAL);";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] : " + tableName + " Table Created!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertRow(Connection conn, String tableName, String name, String course, String institute, double grade) {
        Statement statement;
        try {
            String query = String.format(
                "INSERT INTO %s(" +
                    "name,course,institute,grade"+
                ") VALUES(" +
                    "'%s','%s','%s',%f)",
                tableName,name,course,institute,grade);
            
            
            System.out.println(query);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] : Student inserted succesfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void getStudents(Connection conn, String tableName) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            String query = String.format("SELECT * FROM %s;", tableName);
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("_______________________________________________________________________________");
            System.out.println("PRN\t\tName\t\tCourse\t\tInstitute\t\tGrade");
            System.out.println("_______________________________________________________________________________");
            
            while(resultSet.next()){
                System.out.print(resultSet.getInt("prn")+"\t\t");
                System.out.print(resultSet.getString("name")+"\t\t");
                System.out.print(resultSet.getString("course")+"\t\t");
                System.out.print(resultSet.getString("institute")+"\t\t");
                System.out.println(resultSet.getDouble("grade"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
