/*
 * The class creates a connection to the DB in mysql (for use in the application)
 */

import java.sql.*;
import java.util.Scanner;  

public class Conn{
    public Connection connection;
    private Statement statement;
    protected static String username = "";
    protected static String password = "";
    
    public Conn(){  
    	connect();
    }  
    
    // setting the username & password of object for connecting the DB
    public void setAuth(String username, String password) {
    	Conn.username = username;
    	Conn.password = password;
    }
    
    // implementing the connection
    public void connect() {
        try{
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",username, password);    
        	statement = connection.createStatement(); 
        }catch(SQLException e){ 
            System.out.println(e);
        }  
    }
    

}  