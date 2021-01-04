/*
 * The class of running the application
 */

import java.sql.SQLException;
import java.util.Scanner;

public class Program {
	private String username;
	private String password;
	
	public Program() throws SQLException {
		// authenticating and starting connection
		authUser();
		Conn con = new Conn();
		con.setAuth(username, password);
		
		// starting the main program
		mainGUI gui = new mainGUI();
		if (gui.isMainTableExists() == false) {
			mainGUI.initScript = new SQLScript(1); // creation of main table
			gui.setMainTableExists(true);
		}
	}
	
	// authenticating the user with it's account in mysql 
    public void authUser() {
        Scanner in = new Scanner (System.in);  
        System.out.print("Please enter your username for mysql connection \n");  
        username = in.nextLine();  
        System.out.print("Please enter your password \n");  
        password = in.nextLine();
        in.close();
    }
    
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
	  Program p = new Program();
  }


}
