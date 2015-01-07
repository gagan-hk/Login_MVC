/**
 * Created by Gagandeep.Singh on 1/7/2015.[
 */

import java.sql.*;

public class DatabaseConnection {
    protected boolean validate(String userid , String pwd) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url="jdbc:mysql://localhost:3306/test";
            Connection con = DriverManager.getConnection(url,"root", "gagan");
            System.out.println ("Connection successfully!");
            Statement stat = con.createStatement();
            String query = "Select * from USERS where name='"+userid+"' AND pwd='"+pwd+"'";
            //query = "select * from users where name = 'gagan' and pwd = 'gagan'";
            ResultSet rs = stat.executeQuery(query);
            int cnt = 0;
            while(rs.next()){
                cnt++;
                //String an = rs.getString(1);
                //out.println(an);
            }
            System.out.print(cnt);

            if(cnt > 0) {
                return true;
            }
        }
        catch(Exception e) {
            System.out.println("SQLException caught: " +e.getMessage());
        }
        return false;
    }
}
