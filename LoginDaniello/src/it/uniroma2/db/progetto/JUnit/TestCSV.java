package it.uniroma2.db.progetto.JUnit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;



public class TestCSV {

	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb";
	   
	//  Database credentials
	static final String USER = "superuser";
	static final String PASS = "password";
	Connection conn = null;
	Statement stmt = null;
	
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/

	
	
	@Test
	public void testGalaxy()  {
		
	      String sql;
	      ResultSet rs;
		
	      try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			fail("didn't manage to connect to database");
		}

	      try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			fail("didn't manage to connect to database");
		}
	      try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			fail("didn't manage to connect to database");
		}	
	      
	      /*-----------------------------TESTING INSERT--------------------------*/
	      
	      try {
		      sql = "INSERT INTO SISTEMADIGALASSIE.Galaxy " +
                 		"VALUES ('test', 'test', 'test', 'test', '123') " ;	
		      stmt.executeUpdate(sql);	      
		      }
	      catch (SQLException e){
				fail("didn't manage to insert into Galaxy");
	      }
	      
	      /*-----------------------------TESTING UPDATE--------------------------*/

	      try {
		      sql = "SELECT * FROM SISTEMADIGALASSIE.Galaxy WHERE NAME = 'test' ";
		      rs = stmt.executeQuery(sql);
		      
		      if (!rs.next())
		      {
		    	  fail("insert not works");
		      }
	      }
	      catch (SQLException e){
				fail("didn't manage to insert into Galaxy");
	      }
	      
	      /*-----------------------------TESTING DELETE--------------------------*/

	      try {
		      sql = "DELETE FROM SISTEMADIGALASSIE.Galaxy WHERE NAME = 'test' ";
		      stmt.executeUpdate(sql);
		      
	      }
	      catch (SQLException e){
				fail("didn't manage to delete from Galaxy");
	      }
	      
	
	
	}
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	
	
	
	@Test
	public void testMetallicity()  {
		
	      String sql;
	      ResultSet rs;
		
	      try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			fail("didn't manage to connect to database");
		}

	      try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			fail("didn't manage to connect to database");
		}
	      try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			fail("didn't manage to connect to database");
		}	
	      
	      /*-----------------------------TESTING INSERT--------------------------*/
	      
	      try {
		      sql = "INSERT INTO SISTEMADIGALASSIE.Galaxy " +
               		"VALUES ('test', 'test', 'test', 'test', '123') " ;	
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO SISTEMADIGALASSIE.Metallicity " +
                 		"VALUES ('test', 'test', 'test') " ;	
		      stmt.executeUpdate(sql);	      
		      }
	      catch (SQLException e){
				fail("didn't manage to insert into Metallicity");
	      }
	      
	      /*-----------------------------TESTING UPDATE--------------------------*/

	      try {
		      sql = "SELECT * FROM SISTEMADIGALASSIE.Metallicity WHERE GALAXYNAMEMET = 'test' ";
		      rs = stmt.executeQuery(sql);
		      
		      if (!rs.next())
		      {
		    	  fail("insert not works");
		      }
	      }
	      catch (SQLException e){
				fail("didn't manage to Update Metallicity");
	      }
	      
	      /*-----------------------------TESTING DELETE--------------------------*/

	      try {
	    	  
		      sql = "DELETE FROM SISTEMADIGALASSIE.Metallicity WHERE GALAXYNAMEMET = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      sql = "DELETE FROM SISTEMADIGALASSIE.Galaxy WHERE NAME = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      
	      }
	      catch (SQLException e){
				fail("didn't manage to delete from Metallicity");
	      }
	      
	
	
	}
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	
	
	
	@Test
	public void testLuminosity()  {
		
	      String sql;
	      ResultSet rs;
		
	      try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			fail("didn't manage to connect to database");
		}

	      try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			fail("didn't manage to connect to database");
		}
	      try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			fail("didn't manage to connect to database");
		}	
	      
	      /*-----------------------------TESTING INSERT--------------------------*/
	      
	      try {
		      sql = "INSERT INTO SISTEMADIGALASSIE.Galaxy " +
               		"VALUES ('test', 'test', 'test', 'test', '123') " ;	
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO SISTEMADIGALASSIE.Luminosity " +
                 		"VALUES ('test', 'test', 'test') " ;	
		      stmt.executeUpdate(sql);	      
		      }
	      catch (SQLException e){
				fail("didn't manage to insert into Luminosity");
	      }
	      
	      /*-----------------------------TESTING UPDATE--------------------------*/

	      try {
		      sql = "SELECT * FROM SISTEMADIGALASSIE.Luminosity WHERE GALAXYNAMELUM = 'test' ";
		      rs = stmt.executeQuery(sql);
		      
		      if (!rs.next())
		      {
		    	  fail("insert not works");
		      }
	      }
	      catch (SQLException e){
				fail("didn't manage to Update Luminosity");
	      }
	      
	      /*-----------------------------TESTING DELETE--------------------------*/

	      try {
	    	  
		      sql = "DELETE FROM SISTEMADIGALASSIE.Luminosity WHERE GALAXYNAMELUM = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      sql = "DELETE FROM SISTEMADIGALASSIE.Galaxy WHERE NAME = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      
	      }
	      catch (SQLException e){
				fail("didn't manage to delete from Luminosity");
	      }
	      
	
	
	}
	
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	
	
	
	@Test
	public void testHPFluxR()  {
		
	      String sql;
	      ResultSet rs;
		
	      try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			fail("didn't manage to connect to database");
		}

	      try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			fail("didn't manage to connect to database");

		}
	      try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			fail("didn't manage to connect to database");

		}	
	      
	      /*-----------------------------TESTING INSERT--------------------------*/
	      
	      try {
	    	  
		      sql = "INSERT INTO SISTEMADIGALASSIE.Galaxy " +
	               		"VALUES ('test', 'test', 'test', 'test', '123') " ;	
			      stmt.executeUpdate(sql);
			      
			      
		      sql = "INSERT INTO SISTEMADIGALASSIE.HPfluxR " +
               		"VALUES ('test', 'test', 'test', 'test', 'test', 'test') " ;	
		      stmt.executeUpdate(sql);
	      
		      }
	      catch (SQLException e){
				fail("didn't manage to insert into HPR");

	      }
	      
	      /*-----------------------------TESTING UPDATE--------------------------*/

	      try {
		      sql = "SELECT * FROM SISTEMADIGALASSIE.HPfluxR WHERE GALAXYNAMEHPR = 'test' ";
		      rs = stmt.executeQuery(sql);
		      
		      if (!rs.next())
		      {
		    	  fail("insert not works");

		      }
	      }
	      catch (SQLException e){
				fail("didn't manage to Update HPR");

	      }
	      
	      /*-----------------------------TESTING DELETE--------------------------*/

	      try {
	    	  
		      sql = "DELETE FROM SISTEMADIGALASSIE.HPfluxR WHERE GALAXYNAMEHPR = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      sql = "DELETE FROM SISTEMADIGALASSIE.Galaxy WHERE NAME = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      
	      }
	      catch (SQLException e){
				fail("didn't manage to delete from HPR");
	      }
	      
	}
	
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	
	
	
	@Test
	public void testCoordinate()  {
		
	      String sql;
	      ResultSet rs;
		
	      try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			fail("didn't manage to connect to database");
		}

	      try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			fail("didn't manage to connect to database");

		}
	      try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			fail("didn't manage to connect to database");

		}	
	      
	      /*-----------------------------TESTING INSERT--------------------------*/
	      
	      try {
	    	  
		      sql = "INSERT INTO SISTEMADIGALASSIE.Galaxy " +
	               		"VALUES ('test', 'test', 'test', 'test', '123') " ;	
			      stmt.executeUpdate(sql);
			      
			      
		      sql = "INSERT INTO SISTEMADIGALASSIE.Coordinate " +
               		"VALUES ('test', 'test', 'test', 'test', 'test', 'test', 'test', 'test') " ;	
		      stmt.executeUpdate(sql);
	      
		      }
	      catch (SQLException e){
				fail("didn't manage to insert into Coordinate");

	      }
	      
	      /*-----------------------------TESTING UPDATE--------------------------*/

	      try {
		      sql = "SELECT * FROM SISTEMADIGALASSIE.Coordinate WHERE GALAXYNAMECOO = 'test' ";
		      rs = stmt.executeQuery(sql);
		      
		      if (!rs.next())
		      {
		    	  fail("insert not works");

		      }
	      }
	      catch (SQLException e){
				fail("didn't manage to Update Coordinate");

	      }
	      
	      /*-----------------------------TESTING DELETE--------------------------*/

	      try {
	    	  
		      sql = "DELETE FROM SISTEMADIGALASSIE.Coordinate WHERE GALAXYNAMECOO = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      sql = "DELETE FROM SISTEMADIGALASSIE.Galaxy WHERE NAME = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      
	      }
	      catch (SQLException e){
				fail("didn't manage to delete from Coordinate");
	      }
	      
	}
	
	
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	
	
	
	@Test
	public void testHPFluxC()  {
		
	      String sql;
	      ResultSet rs;
		
	      try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			fail("didn't manage to connect to database");
		}

	      try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			fail("didn't manage to connect to database");

		}
	      try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			fail("didn't manage to connect to database");

		}	
	      
	      /*-----------------------------TESTING INSERT--------------------------*/
	      
	      try {
	    	  
		      sql = "INSERT INTO SISTEMADIGALASSIE.Galaxy " +
	               		"VALUES ('test', 'test', 'test', 'test', '123') " ;	
			      stmt.executeUpdate(sql);
			      
			      
		      sql = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
               		"VALUES ('test', 'test', 'test', 'test', 'test', 'test') " ;	
		      stmt.executeUpdate(sql);
	      
		      }
	      catch (SQLException e){
				fail("didn't manage to insert into HPC");

	      }
	      
	      /*-----------------------------TESTING UPDATE--------------------------*/

	      try {
		      sql = "SELECT * FROM SISTEMADIGALASSIE.HPfluxC WHERE GALAXYNAMEHPC = 'test' ";
		      rs = stmt.executeQuery(sql);
		      
		      if (!rs.next())
		      {
		    	  fail("insert not works");

		      }
	      }
	      catch (SQLException e){
				fail("didn't manage to Update HPC");

	      }
	      
	      /*-----------------------------TESTING DELETE--------------------------*/

	      try {
	    	  
		      sql = "DELETE FROM SISTEMADIGALASSIE.HPfluxC WHERE GALAXYNAMEHPC = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      sql = "DELETE FROM SISTEMADIGALASSIE.Galaxy WHERE NAME = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      
	      }
	      catch (SQLException e){
				fail("didn't manage to delete from HPC");
	      }
	      
	}
	
	
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	
	
	
	@Test
	public void testSpitzerFlux()  {
		
	      String sql;
	      ResultSet rs;
		
	      try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			fail("didn't manage to connect to database");
		}

	      try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			fail("didn't manage to connect to database");

		}
	      try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			fail("didn't manage to connect to database");

		}	
	      
	      /*-----------------------------TESTING INSERT--------------------------*/
	      
	      try {
	    	  
		      sql = "INSERT INTO SISTEMADIGALASSIE.Galaxy " +
	               		"VALUES ('test', 'test', 'test', 'test', '123') " ;	
			      stmt.executeUpdate(sql);
			      
			      
		      sql = "INSERT INTO SISTEMADIGALASSIE.Spitzerflux " +
               		"VALUES ('test', 'test', 'test', 'test', 'test', 'test') " ;	
		      stmt.executeUpdate(sql);
	      
		      }
	      catch (SQLException e){
				fail("didn't manage to insert into Spitzerflux");

	      }
	      
	      /*-----------------------------TESTING UPDATE--------------------------*/

	      try {
		      sql = "SELECT * FROM SISTEMADIGALASSIE.Spitzerflux WHERE GALAXYNAMES = 'test' ";
		      rs = stmt.executeQuery(sql);
		      
		      if (!rs.next())
		      {
		    	  fail("insert not works");

		      }
	      }
	      catch (SQLException e){
				fail("didn't manage to Update Spitzerflux");

	      }
	      
	      /*-----------------------------TESTING DELETE--------------------------*/

	      try {
	    	  
		      sql = "DELETE FROM SISTEMADIGALASSIE.Spitzerflux WHERE GALAXYNAMES = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      sql = "DELETE FROM SISTEMADIGALASSIE.Galaxy WHERE NAME = 'test' ";
		      stmt.executeUpdate(sql);
		      
		      
	      }
	      catch (SQLException e){
				fail("didn't manage to delete from Spitzerflux");
	      }
	      
	}
	
	
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	
	
	
	@Test
	public void testUser()  {
		
	      String sql;
	      ResultSet rs;
		
	      try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			fail("didn't manage to connect to database");
		}

	      try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			fail("didn't manage to connect to database");

		}
	      try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			fail("didn't manage to connect to database");

		}	
	      
	      /*-----------------------------TESTING INSERT--------------------------*/
	      
	      try {
	    	  
			      
		      sql = "INSERT INTO SISTEMADIGALASSIE.User " +
               		"VALUES ('test', 'test', 'test', 'test', 'test', 'test') " ;	
		      stmt.executeUpdate(sql);
	      
		      }
	      catch (SQLException e){
				fail("didn't manage to insert into Spitzerflux");

	      }
	      
	      /*-----------------------------TESTING UPDATE--------------------------*/

	      try {
		      sql = "SELECT * FROM SISTEMADIGALASSIE.User WHERE NOME = 'test' ";
		      rs = stmt.executeQuery(sql);
		      
		      if (!rs.next())
		      {
		    	  fail("insert not works");

		      }
	      }
	      catch (SQLException e){
				fail("didn't manage to Update Spitzerflux");

	      }
	      
	      /*-----------------------------TESTING DELETE--------------------------*/

	      try {
	    	  
		      sql = "DELETE FROM SISTEMADIGALASSIE.User WHERE NOME = 'test' ";
		      stmt.executeUpdate(sql);
		  
		      
		      
	      }
	      catch (SQLException e){
				fail("didn't manage to delete from Spitzerflux");
	      }
	      
	}


}





















