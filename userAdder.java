package control;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class userAdder {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/LOCATIONS";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public void adder(String user, String pwd) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
	
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
		      
		      String sql = "SELECT user, pwd  FROM UTENTI WHERE user='" + user + "' AND pwd='" + pwd +"'" ;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      //STEP 5: Extract data from result set
		      if (!rs.next() ) {    
			      String sql2 = "INSERT INTO UTENTI " +
		                   		"VALUES ('" + user + "', '" + pwd + "' )";
			      stmt.executeUpdate(sql2);
		      }
		      else {
		    	  JLabel panel = new JLabel("User Already Exists");
		    	  JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
		    	  JOptionPane.showMessageDialog(frame, panel, "Stop!", 0);
		      }


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
		}//end main
}
