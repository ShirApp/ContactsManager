/*
 * The class contains the main scripts of creating the tables for the application
 */

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLScript {

	public SQLScript(int numOfScript) throws SQLException {
		switch (numOfScript) {
			case 1: execStatement(initContactTable);
			//case 2: execStatement(initLoggerTable);
			default:
		}	
	}
	
	// Executing the relevant SQL script
	public void execStatement(String sql) throws SQLException {
        Conn con = new Conn();
        PreparedStatement st = con.connection.prepareStatement(sql);
		int rs = st.executeUpdate();
		st.close();
        con.connection.close();
	}
	
	// the main table of contacts
	public String initContactTable = 
				"CREATE TABLE contable( \n" + 
				"name VARCHAR (50) NOT NULL, \n" + 
				"lastName VARCHAR (50), \n" + 
				"phone VARCHAR (50) NOT NULL, \n" + 
				"email VARCHAR (50), \n" + 
				"street VARCHAR (50), \n" + 
				"city VARCHAR (50), \n" + 
				"state VARCHAR (50), \n" + 
				"postalCode VARCHAR(50), \n" + 
				"date DATETIME, \n" + 
				"PRIMARY KEY (name, phone) \n" + 
				");";

	
	// the logs table
	public String initLoggerTable = 
				"CREATE TABLE ContactLogs ( \n" + 
				"name VARCHAR (50) NOT NULL, \n" + 
				"changeDate DATETIME NOT NULL, \n" + 
				"command VARCHAR (6) NOT NULL, \n" + 
				"PRIMARY KEY (name, changeDate) \n" + 
				");";
	

}
