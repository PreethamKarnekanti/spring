package com.preetham.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String username="hbstudent";
        String password ="hbStudent@10";
        try{
            System.out.println("Connecting to the database..."+url);
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("connection established");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
