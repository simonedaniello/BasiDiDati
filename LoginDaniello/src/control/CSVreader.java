package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Frames.MyFrame;

public class CSVreader {
	
	// JDBC driver name and database URL
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	//static final String DB_URL = "jdbc:mysql://localhost/LOCATIONS";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb";
	   
	//  Database credentials
	static final String USER = "superuser";
	static final String PASS = "password";
	   
	   

    private static final char DEFAULT_SEPARATOR = ';';
    private static final char DEFAULT_QUOTE = '"';

    public CSVreader(String csvFile, int Operation) throws FileNotFoundException {
    	
		Connection conn = null;
		Statement stmt = null;

        ArrayList <String> elements = new ArrayList<String>();
        
        /*--------------------------------------------------------------------------------------------------FILE GALAXIES*/
        
        
        if (Operation == 0)
        {
		        /*
		         * 0-  Galaxy name
		         * 1-  rasch
		         * 2-  rascm
		         * 3-  rascs
		         * 4-  decsign
		         * 5-  decdeg
		         * 6-  decmin
		         * 7-  decsec
		         * 8-  redhift
		         * 9-  distance
		         * 10- reference
		         * 11- spectral classification
		         * 12- Limit
		         * 13- Luminosity absorption
		         * 14- Compton Trick
		         * 15- reference
		         * 16- Limit
		         * 17- Luminosity from Spitzer/IRS 1
		         * 18- Limit
		         * 19- Luminosity from Spitzer 2
		         * 20- Limit
		         * 21- Luminosity from Spitzer 3
		         * 22- Metallicity
		         * 23- Metallicity error
		         * 24- reference for the metallicity
		         * 25- Alternative Galaxy
		         * */
		        
		        int i = 0;
		
		        Scanner scanner = new Scanner(new File(csvFile));
		        while (scanner.hasNext()) {
		            List<String> line = parseLine(scanner.nextLine());
		            while(i <= 25)
		            {

		            		elements.add(line.get(i));
		            		i++;
		            	
		            }
		            i = 0;
		        }
		        scanner.close();
		        
				   try{
					      //STEP 2: Register JDBC driver
					      Class.forName("org.postgresql.Driver");
				
					      //STEP 3: Open a connection
					      conn = DriverManager.getConnection(DB_URL, USER, PASS);
					      //STEP 4: Execute a query
					      stmt = conn.createStatement();
					      
					      int j = 0;
					  while (j < elements.size()/26){
					      String sql = "SELECT NAME FROM SISTEMADIGALASSIE.Galaxy WHERE NAME='" + elements.get(0*j) +"'";
					      ResultSet rs = stmt.executeQuery(sql);
					      
					      //STEP 5: Extract data from result set
					      if (!rs.next() ) {    
						      String sql2 = "INSERT INTO SISTEMADIGALASSIE.Galaxy " +
					                   		"VALUES ('"	+ elements.get(9*j) +"', '" 
					                   					+ elements.get(0*j) + "', '"
					                   					+ elements.get(25*j) + "', '"
					                   					+ elements.get(11*j) + "', '"
					                   					+ elements.get(8*j) +  "')";
						      stmt.executeUpdate(sql2);
						      
						      sql2 = "INSERT INTO SISTEMADIGALASSIE.Coordinate " +
				                   		"VALUES ('"	+ elements.get(1*j) + "', '" 
				                   					+ elements.get(2*j) + "', '"
				                   					+ elements.get(3*j) + "', '"
				                   					+ elements.get(4*j) + "', '"
						                   			+ elements.get(6*j) + "', '"
								                   	+ elements.get(7*j) + "', '"
				                   					+ elements.get(5*j) +  "')";
						      
						      stmt.executeUpdate(sql2);
						      
						      
							  if (elements.get(14*j).equals("Y")){
							      sql2 = "INSERT INTO SISTEMADIGALASSIE.Luminosity " +
					                   		"VALUES ('"	+ "TRUE" + "', '" 
					                   					+ elements.get(13*j) + "', '"
					                   					+ elements.get(0*j) +  "')";
						      }
						      else{
							      sql2 = "INSERT INTO SISTEMADIGALASSIE.Luminosity " +
					                   		"VALUES ('"	+ "FALSE" + "', '" 
					                   					+ elements.get(13*j) + "', '"
					                   					+ elements.get(0*j) +  "')";
						    	  
						      }
						      stmt.executeUpdate(sql2);
						      
						      sql2 = "INSERT INTO SISTEMADIGALASSIE.Spitzerflux " +
				                   		"VALUES ('"	+ "NeV14.3" + "', '" 
				                   					+ "" 				+ "', '"
				                   					+ ""				+ "', '"
				                   					+ ""				+ "', '"
						                   			+ elements.get(17*j) + "', '"
				                   					+ elements.get(0*j) +  "')";
						      
						      stmt.executeUpdate(sql2);
						      
						      sql2 = "INSERT INTO SISTEMADIGALASSIE.Spitzerflux " +
				                   		"VALUES ('"	+ "NeV24.3" + "', '" 
				                   					+ "" 				+ "', '"
				                   					+ ""				+ "', '"
				                   					+ ""				+ "', '"
						                   			+ elements.get(19*j) + "', '"
				                   					+ elements.get(0*j) +  "')";
						      
						      stmt.executeUpdate(sql2);
						      
						      sql2 = "INSERT INTO SISTEMADIGALASSIE.Spitzerflux " +
				                   		"VALUES ('"	+ "NeV25.9" + "', '" 
				                   					+ "" 				+ "', '"
				                   					+ ""				+ "', '"
				                   					+ ""				+ "', '"
						                   			+ elements.get(21*j) + "', '"
				                   					+ elements.get(0*j) +  "')";
						      
						      stmt.executeUpdate(sql2);
						      
						      sql2 = "INSERT INTO SISTEMADIGALASSIE.Metallicity " +
				                   		"VALUES ('"	+ elements.get(22*j) + "', '" 
				                   					+ elements.get(23*j) + "', '"
				                   					+ elements.get(0*j) +  "')";
						      
						      stmt.executeUpdate(sql2);
						      
						      /*vedi bene, non ho usato 12,16,18 e 20*/
					      }
					      
					      j++;

					  }
				   }

				   
					catch(SQLException se){
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
        

        /*--------------------------------------------------------------------------------------------------FILE N*/
        
        
        
        /*--------------------------------------------------------------------------------------------------FILE HP RIGHE*/
        
        
        else if (Operation == 1)
        {
		        /*
					   1-  3 I3     --            n        Number
				0-	   5- 19 A15    --            Name     Galaxy Name
				1-	  21- 21 A1     --          l_Foiii52  Limit flag on [OIII]52 line flux
				2-	  23- 28 F6.2   10-17W/m2     Foiii52  Flux of the [OIII]52 line from Herschel/PACS
				3-	  30- 35 F6.2   10-17W/m2   e_Foiii52  Flux error for [OIII]52
				4-	  37- 37 A1     --          l_Fniii57  Limit flag on [NIII]57 line flux
				5-	  39- 45 F7.2   10-17W/m2     Fniii57  Flux of the [NIII]57 line from Herschel/PACS
				6-	  47- 52 F6.2   10-17W/m2   e_Fniii57  Flux error for [NIII]57
				7-	  54- 54 A1     --          l_Foi63    Limit flag on [OI]63 line flux
				8-	  56- 63 F8.2   10-17W/m2     Foi63    Flux of the [OI]63 line from Herschel/PACS
				9-	  65- 70 F6.2   10-17W/m2   e_Foi63    Flux error for [OI]63
				10-	  72- 72 A1     --          l_Foiii88  Limit flag on [OIII]88 line flux
				11-	  74- 80 F7.2   10-17W/m2     Foiii88  Flux of the [OIII]88 line from Herschel/PACS
				12-	  82- 86 F5.2   10-17W/m2   e_Foiii88  Flux error for [OIII]88
				13-	  88- 88 A1     --          l_Fnii122  Limit flag on [NII]122 line flux
				14-	  90- 96 F7.2   10-17W/m2     Fnii122  Flux of the [NII]122 line from Herschel/PACS
				15-	  98-102 F5.2   10-17W/m2   e_Fnii122  Flux error for [NII]122
				16-	 104-104 A1     --          l_Foi145   Limit flag on [OI]145 line flux
				17-	 106-112 F7.2   10-17W/m2     Foi145   Flux of the [OI]145 line from Herschel/PACS
				18-	 114-118 F5.2   10-17W/m2   e_Foi145   Flux error for [OI]145
				19-	 120-120 A1     --          l_Fcii158  Limit flag on [CII]158 line flux
				20-	 122-128 F7.2   10-17W/m2     Fcii158  Flux of the [CII]158 line from Herschel/PACS
				21-	 130-135 F6.2   10-17W/m2   e_Fcii158  Flux error for [CII]158
				22-	 137-139 A3     --            Aper     Aperture: 'c' central spaxel or '3x3' spaxel array
		         * */
		        
		        int i = 0;
		
		        Scanner scanner = new Scanner(new File(csvFile));
		        while (scanner.hasNext()) {
		            List<String> line = parseLine(scanner.nextLine());
		            while(i <= 22)
		            {

		            		elements.add(line.get(i));
		            		i++;
		            	
		            }
		            i = 0;
		        }
		        scanner.close();
		        
				   try{
					      //STEP 2: Register JDBC driver
					      Class.forName("org.postgresql.Driver");
				
					      //STEP 3: Open a connection
					      conn = DriverManager.getConnection(DB_URL, USER, PASS);
					      //STEP 4: Execute a query
					      stmt = conn.createStatement();
					      
					      int j = 0;
					      
					      
					  while (j < elements.size()/23){
					      String sql = "SELECT NAME FROM SISTEMADIGALASSIE.HPfluxR WHERE GALAXYNAMEHPR='" + elements.get(0*j) +"'";
					      ResultSet rs = stmt.executeQuery(sql);
					      
					      //STEP 5: Extract data from result set
					      if (!rs.next() ) {    
						      String sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxR " +
					                   		"VALUES ('"	+ "OIII-52" 		+ "' '" 
					                   					+ "3x3" 			+ "', '"
					                   					+ elements.get(2*j) + "', '"
					                   					+ elements.get(3*j) + "', '"
							                   			+ elements.get(1*j) + "', '"
					                   					+ elements.get(0*j) +  "')";
						      stmt.executeUpdate(sql2);
						      
						      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxR " +
				                   		"VALUES ('"	+ "NIII-57" 		+"', '" 
				                   					+ "3x3" 			+ "', '"
				                   					+ elements.get(5*j) + "', '"
				                   					+ elements.get(6*j) + "', '"
						                   			+ elements.get(4*j) + "', '"
				                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxR " +
			                   		"VALUES ('"	+ "OI-63" 			+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(8*j) + "', '"
			                   					+ elements.get(9*j) + "', '"
					                   			+ elements.get(7*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
				      
				      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxR " +
			                   		"VALUES ('"	+ "OIII-88" 		+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(11*j) + "', '"
			                   					+ elements.get(12*j) + "', '"
					                   			+ elements.get(10*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxR " +
			                   		"VALUES ('"	+ "NII-122" 		+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(14*j) + "', '"
			                   					+ elements.get(15*j) + "', '"
					                   			+ elements.get(13*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxR " +
			                   		"VALUES ('"	+ "OI-145" 			+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(17*j) + "', '"
			                   					+ elements.get(18*j) + "', '"
					                   			+ elements.get(16*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxR " +
			                   		"VALUES ('"	+ "CII-158" 		+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(20*j) + "', '"
			                   					+ elements.get(21*j) + "', '"
					                   			+ elements.get(19*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      }
					      
					      j++;

					  }
				   }

				   
					catch(SQLException se){
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
        

        /*--------------------------------------------------------------------------------------------------FILE N*/
        
        
        
        /*--------------------------------------------------------------------------------------------------FILE HP CONTINUO*/
        
        
        else if (Operation == 2)
        {
		        /*
						   1-  3 I3     --      n        Number
					0-	   5- 19 A15    --      Name     Galaxy Name
					1-	  21- 26 F6.2   Jy      Coiii52  Continuum flux adjacent to the [OIII]52 line from Herschel/PACS
					2-	  28- 32 F5.2   Jy    e_Coiii52  Continuum flux error for [OIII]52
					3-	  34- 40 F7.2   Jy      Cniii57  Continuum flux adjacent to the [NIII]57 line from Herschel/PACS
					4-	  42- 45 F4.2   Jy    e_Cniii57  Continuum flux error for [NIII]57
					5-	  47- 47 A1     --    l_Coi63    Limit flag on [OI]63 adjacent continuum flux
					6-	  49- 55 F7.2   Jy      Coi63    Continuum flux adjacent to the [OI]63 line from Herschel/PACS
					7-	  57- 61 F5.2   Jy    e_Coi63    Continuum flux error for [OI]63
					8-	  63- 63 A1     --    l_Coiii88  Limit flag on [OIII]88 adjacent continuum flux
					9-	  65- 71 F7.2   Jy      Coiii88  Continuum flux adjacent to the [OIII]88 line from Herschel/PACS
					10-	  73- 76 F4.2   Jy    e_Coiii88  Continuum flux error for [OIII]88
					11-	  78- 78 A1     --    l_Cnii122  Limit flag on [NII]122 adjacent continuum flux
					12-	  80- 86 F7.2   Jy      Cnii122  Continuum flux adjacent to the [NII]122 line from Herschel/PACS
					13-	  88- 91 F4.2   Jy    e_Cnii122  Continuum flux error for [NII]122
					14-	  93- 93 A1     --    l_Coi145   Limit flag on [OI]145 adjacent continuum flux
					15-	  95-100 F6.2   Jy      Coi145   Continuum flux adjacent to the [OI]145 line from Herschel/PACS
					16-	 102-105 F4.2   Jy    e_Coi145   Continuum flux error for [OI]145
					17-	 107-107 A1     --    l_Ccii158  Limit flag on [CII]158 adjacent continuum flux
					18-	 109-114 F6.2   Jy      Ccii158  Continuum flux adjacent to the [CII]158 line from Herschel/PACS
					19-	 116-120 F5.2   Jy    e_Ccii158  Continuum flux error for [CII]158
					20-	 122-122 A1     --      RefC     Reference for the continuum flux at 160 micron
					21-	 124-126 A3     --      Aper     Aperture: 'c' central spaxel or '3x3' spaxel array
		         */
		        
		        int i = 0;
		
		        Scanner scanner = new Scanner(new File(csvFile));
		        while (scanner.hasNext()) {
		            List<String> line = parseLine(scanner.nextLine());
		            while(i <= 21)
		            {

		            		elements.add(line.get(i));
		            		i++;
		            	
		            }
		            i = 0;
		        }
		        scanner.close();
		        
				   try{
					      //STEP 2: Register JDBC driver
					      Class.forName("org.postgresql.Driver");
				
					      //STEP 3: Open a connection
					      conn = DriverManager.getConnection(DB_URL, USER, PASS);
					      //STEP 4: Execute a query
					      stmt = conn.createStatement();
					      
					      int j = 0;
					      
					      
					  while (j < elements.size()/23){
					      String sql = "SELECT NAME FROM SISTEMADIGALASSIE.HPfluxR WHERE GALAXYNAMEHPC='" + elements.get(0*j) +"'";
					      ResultSet rs = stmt.executeQuery(sql);
					      
					      //STEP 5: Extract data from result set
					      if (!rs.next() ) {    
						      String sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
					                   		"VALUES ('"	+ "OIII-52" 		+ "' '" 
					                   					+ "3x3" 			+ "', '"
					                   					+ elements.get(1*j) + "', '"
					                   					+ elements.get(2*j) + "', '"
							                   			+ ""				+ "', '"
					                   					+ elements.get(0*j) +  "')";
						      stmt.executeUpdate(sql2);
						      
						      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
				                   		"VALUES ('"	+ "NIII-57" 		+"', '" 
				                   					+ "3x3" 			+ "', '"
				                   					+ elements.get(3*j) + "', '"
				                   					+ elements.get(4*j) + "', '"
						                   			+ ""				+ "', '"
				                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
			                   		"VALUES ('"	+ "OI-63" 			+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(6*j) + "', '"
			                   					+ elements.get(7*j) + "', '"
					                   			+ elements.get(5*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
				      
				      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
			                   		"VALUES ('"	+ "OIII-88" 		+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(9*j) + "', '"
			                   					+ elements.get(10*j) + "', '"
					                   			+ elements.get(8*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
			                   		"VALUES ('"	+ "NII-122" 		+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(12*j) + "', '"
			                   					+ elements.get(13*j) + "', '"
					                   			+ elements.get(11*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
			                   		"VALUES ('"	+ "OI-145" 			+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(15*j) + "', '"
			                   					+ elements.get(16*j) + "', '"
					                   			+ elements.get(14*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
			                   		"VALUES ('"	+ "CII-158" 		+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(18*j) + "', '"
			                   					+ elements.get(19*j) + "', '"
					                   			+ elements.get(17*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      }
					      
					      j++;

					  }
				   }

				   
					catch(SQLException se){
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
        

        /*--------------------------------------------------------------------------------------------------FILE N*/
        
        /*--------------------------------------------------------------------------------------------------FILE SPITZER*/
        
        
        else if (Operation == 3)
        {
		        /*
								   5- 19 A15    --          Name      Galaxy Name
				0-				  21- 21 A1     --        l_Fsiv10    Limit flag on [SIV]10.5 line flux
				1-				  23- 28 F6.2   10-17W/m2   Fsiv10    Flux of the [SIV]10.5 line from Spitzer/IRS
				2-				  30- 34 F5.2   10-17W/m2 e_Fsiv10    Flux error for [SIV]10.5
				3-				  36- 36 A1     --        l_Fneii12   Limit flag on [NeII]12.8 line flux
				4-				  38- 44 F7.2   10-17W/m2   Fneii12   Flux of the [NeII]12.8 line from Spitzer/IRS
				5-				  46- 50 F5.2   10-17W/m2 e_Fneii12   Flux error for [NeII]12.8
				6-				  52- 52 A1     --        l_Fnev14    Limit flag on [NeV]14.3 line flux
				7-				  54- 59 F6.2   10-17W/m2   Fnev14    Flux of the [NeV]14.3 line from Spitzer/IRS
				8-				  61- 65 F5.2   10-17W/m2 e_Fnev14    Flux error for [NeV]14.3
				9-				  67- 67 A1     --        l_Fneiii15  Limit flag on [NeIII]15.6 line flux
				10-				  69- 75 F7.2   10-17W/m2   Fneiii15  Flux of the [NeIII]15.6 line from Spitzer/IRS
				11-				  77- 81 F5.2   10-17W/m2 e_Fneiii15  Flux error for [NeIII]15.6
				12-				  83- 83 A1     --        l_Fsiii18   Limit flag on [SIII]18.7 line flux
				13-				  85- 90 F6.2   10-17W/m2   Fsiii18   Flux of the [SIII]18.7 line from Spitzer/IRS
				14-				  92- 96 F5.2   10-17W/m2 e_Fsiii18   Flux error for [SIII]18.7
				15-				  98- 98 A1     --        l_Fnev24    Limit flag on [NeV]24.3 line flux
				16-				 100-105 F6.2   10-17W/m2   Fnev24    Flux of the [NeV]24.3 line from Spitzer/IRS
				17-				 107-111 F5.2   10-17W/m2 e_Fnev24    Flux error for [NeV]24.3
				18-				 113-113 A1     --        l_Foiv25    Limit flag on [OIV]25.9 line flux
				19-				 115-121 F7.2   10-17W/m2   Foiv25    Flux of the [OIV]25.9 line from Spitzer/IRS
				20-				 123-127 F5.2   10-17W/m2 e_Foiv25    Flux error for [OIV]25.9
				21-				 129-129 A1     --        l_Fsiii33   Limit flag on [SIII]33.5 line flux
				22-				 131-137 F7.2   10-17W/m2   Fsiii33   Flux of the [SIII]33.5 line from Spitzer/IRS
				23-				 139-144 F6.2   10-17W/m2 e_Fsiii33   Flux error for [SIII]33.5
				24-				 146-146 A1     --        l_Fsii34    Limit flag on [SiII]34.8 line flux
				25-				 148-154 F7.2   10-17W/m2   Fsii34    Flux of the [SiII]34.8 line from Spitzer/IRS
				26-				 156-160 F5.2   10-17W/m2 e_Fsii34    Flux error for [SiII]34.8
				27-				 162-166 A5     --          Mod       IRS Mode: High spectral resolution ('HR') or low spectral resolution ('LR')
				28-				 168-183 A16    --          Ref       Reference for the Spitzer spectra
		         */
		        
		        int i = 0;
		
		        Scanner scanner = new Scanner(new File(csvFile));
		        while (scanner.hasNext()) {
		            List<String> line = parseLine(scanner.nextLine());
		            while(i <= 21)
		            {

		            		elements.add(line.get(i));
		            		i++;
		            	
		            }
		            i = 0;
		        }
		        scanner.close();
		        
				   try{
					      //STEP 2: Register JDBC driver
					      Class.forName("org.postgresql.Driver");
				
					      //STEP 3: Open a connection
					      conn = DriverManager.getConnection(DB_URL, USER, PASS);
					      //STEP 4: Execute a query
					      stmt = conn.createStatement();
					      
					      int j = 0;
					      
					      
					  while (j < elements.size()/23){
					      String sql = "SELECT NAME FROM SISTEMADIGALASSIE.Spitzerflux WHERE GALAXYNAMES='" + elements.get(0*j) +"'";
					      ResultSet rs = stmt.executeQuery(sql);
					      
					      //STEP 5: Extract data from result set
					      if (!rs.next() ) {    
						      String sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
					                   		"VALUES ('"	+ "OIII-52" 		+ "' '" 
					                   					+ "3x3" 			+ "', '"
					                   					+ elements.get(1*j) + "', '"
					                   					+ elements.get(2*j) + "', '"
							                   			+ ""				+ "', '"
					                   					+ elements.get(0*j) +  "')";
						      stmt.executeUpdate(sql2);
						      
						      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
				                   		"VALUES ('"	+ "NIII-57" 		+"', '" 
				                   					+ "3x3" 			+ "', '"
				                   					+ elements.get(3*j) + "', '"
				                   					+ elements.get(4*j) + "', '"
						                   			+ ""				+ "', '"
				                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
			                   		"VALUES ('"	+ "OI-63" 			+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(6*j) + "', '"
			                   					+ elements.get(7*j) + "', '"
					                   			+ elements.get(5*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
				      
				      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
			                   		"VALUES ('"	+ "OIII-88" 		+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(9*j) + "', '"
			                   					+ elements.get(10*j) + "', '"
					                   			+ elements.get(8*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
			                   		"VALUES ('"	+ "NII-122" 		+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(12*j) + "', '"
			                   					+ elements.get(13*j) + "', '"
					                   			+ elements.get(11*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
			                   		"VALUES ('"	+ "OI-145" 			+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(15*j) + "', '"
			                   					+ elements.get(16*j) + "', '"
					                   			+ elements.get(14*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      sql2 = "INSERT INTO SISTEMADIGALASSIE.HPfluxC " +
			                   		"VALUES ('"	+ "CII-158" 		+ "', '" 
			                   					+ "3x3" 			+ "', '"
			                   					+ elements.get(18*j) + "', '"
			                   					+ elements.get(19*j) + "', '"
					                   			+ elements.get(17*j) + "', '"
			                   					+ elements.get(0*j) +  "')";
					      stmt.executeUpdate(sql2);
						      
					      }
					      
					      j++;

					  }
				   }

				   
					catch(SQLException se){
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
        

        /*--------------------------------------------------------------------------------------------------FILE N*/
        
        
        
        

    }

    public static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }
    
	public static void main(String[] args) throws Exception {
		CSVreader prova = new CSVreader("/home/dandi/Downloads/Università/galassie.csv", 0);
	}

}
