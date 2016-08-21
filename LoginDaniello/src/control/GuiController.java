package control;
import java.sql.*;
import Frames.MainMenu;
import javax.swing.*;

import Frames.MyFrame;
import Frames.RegisInterface;

public class GuiController {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/LOCATIONS";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	   
	   
	public static void main(String[] args) {
	MyFrame myFrm = new MyFrame();
	}
	
	public static void listenC(String User, String Pwd){
		Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      
		      //STEP 4: Execute a query
		      stmt = conn.createStatement();

		      String sql = "SELECT user, pwd  FROM UTENTI WHERE user='" + User + "' AND pwd='" + Pwd +"'" ;
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      if (!rs.next() ) {    
		    	  JLabel panel = new JLabel("User Not Found");
		    	  JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
		    	  JOptionPane.showMessageDialog(frame, panel, "Ops!", 0);
		    	  MyFrame myFrm = new MyFrame();
		    	}
		      else {
		    	  MainMenu benvenuto = new MainMenu();
		      }
		      
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}
	
	public static void listenR(){
		RegisInterface registrati = new RegisInterface();
	}
}