import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Gagandeep.Singh on 1/7/2015.
 */
public class LoginBean {
    private String name,password;
    private String role;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean validate(){
        String userid = name;
        String pwd = password;
        DatabaseConnection db = new DatabaseConnection();
        db.makeConnection();
        Connection con = db.getConnection();
        try {
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
            //System.out.print(cnt);

            if(cnt > 0) {
                return true;
            }
        }
        catch(Exception e) {
            System.out.println("SQLException caught: " +e.getMessage());
        }
        return false;
    }

    public boolean register(){
        String userid = name;
        String pwd = password;
        DatabaseConnection db = new DatabaseConnection();
        db.makeConnection();
        Connection con = db.getConnection();
        try {
            Statement stat = con.createStatement();
            String query = "Select * from USERS where name='"+userid+"'";
            //query = "select * from users where name = 'gagan' and pwd = 'gagan'";
            ResultSet rs = stat.executeQuery(query);
            int cnt = 0;
            while(rs.next()){
                cnt++;
                //String an = rs.getString(1);
                //out.println(an);
            }
            //System.out.print(cnt);

            if(cnt > 0) {
                return false;
            }
            System.out.println("ggn");
            query = "Insert into USERS values ('" + userid + "','" +pwd+ "')";
            int affected = stat.executeUpdate(query);
            System.out.println(affected);
        }
        catch(Exception e) {
            System.out.println("SQLException caught: " +e.getMessage());
        }
        return true;
    }
}