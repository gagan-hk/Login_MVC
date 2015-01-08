/**
 * Created by Gagandeep.Singh on 1/7/2015.[
 */

import sun.net.ConnectionResetException;

import java.sql.*;

public class DatabaseConnection {
    private Connection con;
    protected void makeConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url="jdbc:mysql://localhost:3306/test";
            con = DriverManager.getConnection(url,"root", "gagan");
            System.out.println ("Connection successfully!");
        }
        catch(Exception e) {
            System.out.println("SQLException caught: " +e.getMessage());
        }
    }

    protected Connection getConnection(){
        return con;
    }
}
