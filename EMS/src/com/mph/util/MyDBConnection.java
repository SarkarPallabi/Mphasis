package com.mph.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyDBConnection {
    static Connection con;
    public static Connection myDBConnection()
    {
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","qwerty");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String[] args) {
        System.out.println(myDBConnection());
    }
}