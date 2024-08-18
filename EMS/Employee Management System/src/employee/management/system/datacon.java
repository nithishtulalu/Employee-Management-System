
package employee.management.system;
import java.sql.*;

public class datacon {
    Connection c;
    Statement s;
    public datacon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:///EMS","root","nithish@1123");
            s=c.createStatement();
          
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
