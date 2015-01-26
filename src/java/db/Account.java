
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
        a.insertUser(user);
        a.close();
       
    }

    void insertUser(User us) throws SQLException {
        String s = " insert into accounts (username, password, name, email,country, signup_date)"
                + " values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = conn.prepareStatement(s);
        preparedStmt.setString(1, us.getUsername());
        preparedStmt.setString(2, us.getPassword());
        preparedStmt.setString(3, us.getName());
        preparedStmt.setString(4, us.getCountry());
        preparedStmt.setDate(5, us.getDate());

        preparedStmt.execute();
        preparedStmt.close();
    }
    
    void close() throws SQLException
    {
        conn.close();
    }
}
