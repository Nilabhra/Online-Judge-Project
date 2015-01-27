
/*
 *  
 "Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. 
 And the only way to do great work is to love what you do. If you haven't found it yet, keep looking.
 Don't settle. As with all matters of the heart, you'll know when you find it."
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import user.User;

/**
 *
 * @author Rajarshee Mitra (okay)
 */
public class Account {

    Connection conn;

    public Account() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager
                .getConnection("jdbc:mysql://localhost/sample?"
                        + "user=root&password=rajunsec");
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        
        
        Account a = new Account();
        User user = new User();
        user.setUsername("rajarsheem");
        user.setPassword("rajunsec");
        user.setEmail("rajarsheem@gmail.com");
        user.setCountry("India");
        user.setName("Rajarshee Mitra");        
        //a.insertUser(user);
        System.out.println(a.userExists("rajarsheem"));
        a.close();
       
    }

    public void insertUser(User us) throws SQLException {
        String s = " insert into accounts (username, password, name, email,country, signup_date)"
                + " values (?, ?, ?, ?, ?, ?)";
        
        try(PreparedStatement preparedStmt = conn.prepareStatement(s)) {
        preparedStmt.setString(1, us.getUsername());
        preparedStmt.setString(2, us.getPassword());
        preparedStmt.setString(3, us.getName());
        preparedStmt.setString(4, us.getEmail());
        preparedStmt.setString(5, us.getCountry());
        preparedStmt.setDate(6, us.getDate());

        preparedStmt.execute();
        
        preparedStmt.close();
        }
        catch(Exception e)
        {
            if(e.toString().contains("Duplicate entry"))
                System.out.println("User exists");
        }
    }
    
    public boolean userExists(String usr) throws SQLException
    {
        boolean answer=false;
        String s = "SELECT * FROM accounts WHERE username='"+usr+"'";
        try(PreparedStatement preparedStmt = conn.prepareStatement(s);ResultSet rs = preparedStmt.executeQuery()){            
        answer = rs.next();              
        }
        catch(SQLException sqle)
        {
            System.err.println(sqle);
        }
        finally {
        return answer;
        }
    }
    void close() throws SQLException
    {
        conn.close();
    }
}
