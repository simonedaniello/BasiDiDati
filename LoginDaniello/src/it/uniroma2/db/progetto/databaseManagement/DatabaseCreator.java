package it.uniroma2.db.progetto.databaseManagement;

//METODO PER CREARE UNA NUOVA TABELLA NEL DATABASE

//STEP 1. Import required packages
import java.sql.*;

/*
 * creating database GALAXYSYSTEM*/
public class DatabaseCreator {
   // JDBC driver name and database URL
   //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   //static final String DB_URL = "jdbc:mysql://localhost/";
   static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb";

   //  Database credentials
   static final String USER = "superuser";
   static final String PASS = "password"; 
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("org.postgresql.Driver"); //Class.forName("org.postgresql.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS); //DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "123");

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();
      
      //CAMBIA QUI IL NOME DELLA TABELLA 
      String sql = "CREATE DATABASE GALAXYSYSTEM";
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");
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
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
