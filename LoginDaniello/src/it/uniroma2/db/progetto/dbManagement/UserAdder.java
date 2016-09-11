package it.uniroma2.db.progetto.dbManagement;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UserAdder {


	   static final String JDBC_DRIVER = "org.postgresql.Driver";  
	   static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb";
	   
	   //  Database credentials
	   static final String USER = "superuser";
	   static final String PASS = "password";
	   
	   JLabel panel;
	   JFrame frame;
	   
	   public void adder(String user, String cs, String nome, String cognome, String email) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("org.postgresql.Driver");
	
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
		      
		      String sql = "SELECT USERID FROM SISTEMADIGALASSIE.User WHERE USERID='" + user +"'";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      //STEP 5: Extract data from result set
		      if (!rs.next() ) {    
			      String sql2 = "INSERT INTO SISTEMADIGALASSIE.User " +
		                   		"VALUES ('"+ nome +"', '" +cognome + "', '"+ user + "', '" + cs + "', '"+ email + "', FALSE )";
			      stmt.executeUpdate(sql2);
		    	  panel = new JLabel("You have been registered !!");
		    	  frame = new JFrame("JOptionPane showMessageDialog component example");
		    	  JOptionPane.showMessageDialog(frame, "it's all right");
		      }
		      else {
		    	  panel = new JLabel("User Already Exists");
		    	  frame = new JFrame("JOptionPane showMessageDialog component example");
		    	  JOptionPane.showMessageDialog(frame, panel, "Stop!", 0);
		      }
		      /**/


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
