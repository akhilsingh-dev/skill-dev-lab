package com.theDrake1010.student_db_crud;

import java.sql.Connection;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        PostgresConnector db = new PostgresConnector();
        Connection conn = db.connectToDB();
        System.out.println(conn);

    }
}
