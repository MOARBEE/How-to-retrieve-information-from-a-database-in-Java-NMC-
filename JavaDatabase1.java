package javadatabase1;
import java.sql.*;
import javax.swing.*;

public class JavaDatabase1 {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/test2","root","");
            System.out.println("Connection Successfuly");

            Statement stmt = conn.createStatement();
//retrieve items 
            String strSelect = "select * from register";
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) {
                System.out.println(rset.getString("fname") + " "
                        + rset.getString("sname") + ", "
                        + rset.getString("phone") + ", "
                        + rset.getString("address"));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Connection Failed" +e);
        }

    }

}