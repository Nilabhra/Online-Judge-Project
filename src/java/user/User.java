
/*
 *  
"Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. 
And the only way to do great work is to love what you do. If you haven't found it yet, keep looking.
Don't settle. As with all matters of the heart, you'll know when you find it."
 */

package user;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Rajarshee Mitra (okay)
 */
public class User {

    private String username, password, email, country,name;
    private java.sql.Date date;

    
    //setters
    public void setName(String name) {
        this.name = name;
    }   

    public void setUsername(String username) {
        this.username = username;
        setDate();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    private void setDate()
    {
        Calendar calendar = Calendar.getInstance();
        date = new java.sql.Date(calendar.getTime().getTime());
    }
    //getters
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public Date getDate() {
        return date;
    }  
     
}
