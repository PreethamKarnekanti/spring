package com.preetham.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestJDBC")
public class TestJDBC extends HttpServlet {
    public static final long serialVersionUID=1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        String user="springstudent";
        String pass="Preetham@10";
        String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver="com.mysql.jdbc.Driver";

        try{
            PrintWriter out = response.getWriter();
            out.println("Connecting to the database"+ url);
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pass);
            out.println("connected");
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }

}
