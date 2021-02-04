package com.theDrake1010.student_db_crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner; 


/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) throws SQLException {
        
        Scanner sc = new Scanner(System.in);

        PostgresConnector db = new PostgresConnector();
        Connection conn = db.connectToDB();
        db.createTable(conn, "student");

        
        int prn,i;
        String name, course, institute;
        double grade;

        do{
            System.out.println("========== Student Database CRUD App ==========");
            System.out.println("1. List all the Students in the DB");
            System.out.println("2. Insert a Student record in the DB");
            System.out.println("3. Update a Student's record in the DB");
            System.out.println("4. Delete a Student's record in the DB");
            System.out.println("Press any number else to exit!");
            System.out.println("Enter the number corressponding to operation: ");
            // Input a number
            i = sc.nextInt(); 
            sc.nextLine();
            switch(i){
            case 1:
                db.getStudents(conn, "student");
                break;
            case 2:
                System.out.println("Enter Student Name: ");
                name = sc.nextLine();

                System.out.println("Enter Student Course: ");
                course = sc.nextLine();

                System.out.println("Enter Student Institute: ");
                institute = sc.nextLine();

                System.out.println("Enter Student Grade: ");
                grade = sc.nextDouble();

                db.insertRow(conn, "student", name, course, institute, grade);
                break;
            case 3:
                System.out.println("404!");
                break;
            
            case 4:
                //delete student
                System.out.println("404!");
                break;
            
            default:
                System.out.println("Bye!");
                break;
            }
        }while(i < 4 && i > 0);
        // 
        
        conn.close();
    }
}