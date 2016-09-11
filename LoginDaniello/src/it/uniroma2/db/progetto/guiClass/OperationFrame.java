package it.uniroma2.db.progetto.guiClass;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import it.uniroma2.db.progetto.dbManagement.DataSource;
import it.uniroma2.db.progetto.guiClass.EventListeners;

/* ListDemo.java requires no other files. */
public class OperationFrame extends JPanel implements ListSelectionListener 
{

	private static final long serialVersionUID = -6450089667541569250L;

	private JList<String> list;
	private DefaultListModel<String> listModel;

	private static final String searchString = "Search";
	private static final String backString = "Back";

	private JButton backButton;
	private JTextField tfSearch;


	/*----------------------------------------------------------------------------------------------------OPERATIONFRAME()*/

	/*
	 * morelessequal -> 0 less, 1 more, 2 equals*/
	public OperationFrame(int operationNumber, String galaxyName, 
			String rayn, String rayrasch, String rayrascm, String rayrascs, String raydecsign, String raydecmin, String raydecsec, String raydecdeg, 
			String redshift, int morelessequals, 
			int userAdmin, 
			String fluxname1, String fluxname2, String pixel, 
			String spectralClassification,
			JFrame mainWindow) throws Exception {
		
		mainWindow.getContentPane().removeAll();
		mainWindow.getContentPane().repaint();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainWindow.setLocation(dim.width/2-mainWindow.getSize().width/2, dim.height/2-mainWindow.getSize().height/2);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DataSource dataSource = DataSource.getDataSourceInstance();
		Statement stmt = null;

//		Class.forName("org.postgresql.Driver");
//		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Connection conn = dataSource.getConnection();
		stmt = conn.createStatement();

		String sql;
		ResultSet rs;

		/*
		 * numero operazione -> ritorna 
		 * 
		 * i = 0 v 			 -> nome galassia, posizione, distanza , redshift, luminosità, errore, metallicità, errore
		 * 
		 * i = 1 v			 -> nome delle prime n galassie all'interno di un raggio data una determinata posizione spaziale (ordinato rispetto al centro del raggio)
		 * 
		 * i = 2 v			 -> nome delle prime n galassie con valore minore, maggiore o uguale a un determinato valore di redshift
		 * 
		 * i = 3 v			 -> nome della galassia con relativo flusso delle righe 
		 * 
		 * i = 4 v			 -> nome della galassia con rapporto tra due flussi differenti (per ogni galassia)
		 * 
		 * i = 5 			 -> media, deviazione standard, mediana e deviazione media assoluta del rapporto tra due flussi all'interno di un gruppo spettrale
		 * 
		 * i = 6 v			 -> idem i = 5 ma potendo scegliere una particolare apertura (unito al 5, magari unasre una combobox ???)
		 * 
		 * i = 7			 -> nome galassia con rapporto tra flusso delle righe e fulsso continuo
		 */
		

		String maintitle;
		if (operationNumber == 0)
		{
			maintitle = "Generic Galaxy Search";
		}
		else if (operationNumber == 1)
		{
			maintitle = "Search by Distance";
		}
		else if (operationNumber == 2)
		{
			maintitle = "Search by redshift";
		}
		else if (operationNumber == 3)
		{
			maintitle = "Search Raw Flux";
		}
		else if (operationNumber == 4)
		{
			maintitle = "Ratio between fluxes";
		}
		else if (operationNumber == 5)
		{
			maintitle = "Specific Flux Search";
		}
		else if (operationNumber == 6)
		{
			maintitle = "Specific Flux Search";
		}
		else
		{
			maintitle = "Ratio between fluxes";
		}
		
		mainWindow.setTitle(maintitle);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		listModel = new DefaultListModel<String>();
		String spaces = "             ";	

		/*---------------------------------------------------------------------------------------------------------OPERATIONNUMBER = 0*/

		if (operationNumber == 0)
		{
			sql = "SELECT NAME, DISTANCE, REDSHIFT, RASCH, RASCM, RASCS, DECSIGN, DECMIN, DECSEC, DECDEG, ABSORPTION, VALUEMET, ERRORM"
					+  " FROM SISTEMADIGALASSIE.Galaxy, SISTEMADIGALASSIE.Coordinate, SISTEMADIGALASSIE.Luminosity, SISTEMADIGALASSIE.Metallicity "
					+  " WHERE NAME='" + galaxyName +"' AND NAME = GALAXYNAMEMET AND NAME = GALAXYNAMELUM AND NAME = GALAXYNAMECOO";

			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				listModel.addElement("Galaxy name :          " + rs.getString("NAME"));
				listModel.addElement("Galaxy distance :      " + rs.getString("DISTANCE"));
				listModel.addElement("Galaxy redshift :      " + rs.getString("REDSHIFT"));
				listModel.addElement("Galaxy RASCH :         " + rs.getString("RASCH"));
				listModel.addElement("Galaxy RASCM :         " + rs.getString("RASCM"));
				listModel.addElement("Galaxy RASCS :         " + rs.getString("RASCS"));
				listModel.addElement("Galaxy DECSIGN :       " + rs.getString("DECSIGN"));
				listModel.addElement("Galaxy DECMIN :        " + rs.getString("DECMIN"));
				listModel.addElement("Galaxy DECSEC :        " + rs.getString("DECSEC"));
				listModel.addElement("Galaxy DECDEG :        " + rs.getString("DECDEG"));
				listModel.addElement("Galaxy absorption :    " + rs.getString("ABSORPTION"));
				listModel.addElement("Galaxy value met. :    " + rs.getString("VALUEMET"));
				listModel.addElement("Galaxy error met. :    " + rs.getString("ERRORM"));
			}
		}
		
		

		/*---------------------------------------------------------------------------------------------------------OPERATIONNUMBER = 1*/


		if (operationNumber == 1)
		{
			
			/*
			 * come calcolare il raggio : 
			 * 
			 * d = arccos(sin(ra1)*sin(ra2)+cos(ra1)*cos(ra2)*cos(dec1-dec2))
			 * dec = + or - (DD + MM/60 + SS/3600)
			 * ra = 15 * (HH + MM/60 + SS/3600)
			 * 
			 * 
					 	CREATE TABLE SISTEMADIGALASSIE.Coordinate(
						RASCH 	VARCHAR	, 
						RASCM	VARCHAR	,
						RASCS	VARCHAR	,
						DECSIGN	VARCHAR	,
						DECMIN	VARCHAR	,
						DECSEC	VARCHAR	,
						DECDEG	VARCHAR	,
						GALAXYNAMECOO 	VARCHAR
										REFERENCES SISTEMADIGALASSIE.Galaxy(NAME),
						PRIMARY KEY (GALAXYNAMECOO)
					);

			 */
			
			ArrayList<String>definitiveArray = new ArrayList<String>();
			
			double d;
			double ra;
			double ra2 = 15*(Double.parseDouble(rayrasch)+Double.parseDouble(rayrascm)/60 + Double.parseDouble(rayrascs)/3600);
			double dec;
			double dec2;
			
			if (raydecsign.contains("+"))
			{
				dec2 = (Double.parseDouble(raydecdeg)+Double.parseDouble(raydecmin)/60 + Double.parseDouble(raydecsec)/3600);
			}
			else
			{
				dec2 = -(Double.parseDouble(rayrasch)+Double.parseDouble(rayrascm)/60 + Double.parseDouble(rayrascs)/3600);
			}
						
			
			sql = 		"SELECT GALAXYNAMECOO, RASCH, RASCM, RASCS, DECSIGN, DECMIN, DECSEC, DECDEG"
					+  " FROM SISTEMADIGALASSIE.Coordinate";

			rs = stmt.executeQuery(sql);
						
			
			while(rs.next())
			{
				ra = 15*(Double.parseDouble(rs.getString("RASCH"))+Double.parseDouble(rs.getString("RASCM"))/60 + Double.parseDouble(rs.getString("RASCS"))/3600);
				if (rs.getString("DECSIGN").contains("+"))
				{
					dec = (Double.parseDouble(rs.getString("DECDEG"))+Double.parseDouble(rs.getString("DECMIN"))/60 + Double.parseDouble(rs.getString("DECSEC"))/3600);
				}
				else
				{
					dec = -(Double.parseDouble(rs.getString("DECDEG"))+Double.parseDouble(rs.getString("DECMIN"))/60 + Double.parseDouble(rs.getString("DECSEC"))/3600);
				}
				
				d = Math.acos(Math.sin(ra)*Math.sin(ra2)+Math.cos(ra)*Math.cos(ra2)*Math.cos(dec-dec2));
				
				definitiveArray.add(rs.getString("GALAXYNAMECOO"));
				definitiveArray.add(Double.toString(d));
				
				
			}
			
			/*BUBBLESORT*/
			
			int i, j;
			boolean flag = true;
			String dimension, galaxyname;
			while (flag == true)
			{
				flag = false;
				for (j = 0; j < (definitiveArray.size()/2)-1; j++)
				{
					if (Float.parseFloat(definitiveArray.get(2*j+1))>Float.parseFloat(definitiveArray.get(2*j+3)))
					{
						dimension = definitiveArray.get(2*j+1); 
						definitiveArray.set(2*j+1, definitiveArray.get(2*j+3));
						definitiveArray.set(2*j+3, dimension);
						
						galaxyname = definitiveArray.get(2*j); 
						definitiveArray.set(2*j, definitiveArray.get(2*j+2));
						definitiveArray.set(2*j+2, galaxyname);
					
						
						flag = true;
					}
				}
			}
			
						
			
			i = 0;
			flag = false;
			
			while (i < Integer.parseInt(rayn) && flag == false)
			{
				if ((2*i + 1) < definitiveArray.size())
				{
					listModel.addElement("Galaxy name :        "+ definitiveArray.get(2*i) + spaces + "distance :        " + definitiveArray.get(2*i + 1)); 
				}
				else
				{
					flag = true;
				}
				i++;
			}

		}


		
		

		/*---------------------------------------------------------------------------------------------------------OPERATIONNUMBER = 2*/


		if (operationNumber == 2)
		{

			if (morelessequals == 0)
			{
				sql = "SELECT NAME, REDSHIFT"
						+  " FROM SISTEMADIGALASSIE.Galaxy "
						+  " WHERE REDSHIFT < "+ Float.parseFloat(redshift)
						+  " ORDER BY REDSHIFT;";

			}
			else if (morelessequals == 1)
			{
				sql = "SELECT NAME, REDSHIFT"
						+  " FROM SISTEMADIGALASSIE.Galaxy "
						+  " WHERE REDSHIFT > "+ Float.parseFloat(redshift)
						+  " ORDER BY REDSHIFT;";

			}
			else 
			{
				sql = "SELECT NAME, REDSHIFT"
						+  " FROM SISTEMADIGALASSIE.Galaxy "
						+  " WHERE REDSHIFT = "+ Float.parseFloat(redshift)
						+  " ORDER BY REDSHIFT;";


			}
			rs = stmt.executeQuery(sql);


			while(rs.next())
			{
				listModel.addElement("Galaxy name :          " + rs.getString("NAME") + spaces + "Galaxy redshift :      " + rs.getString("REDSHIFT"));

			}
		}

		/*---------------------------------------------------------------------------------------------------------OPERATIONNUMBER = 3*/

		if (operationNumber == 3)
		{

			sql = "SELECT NAME, NAMEHPR, PIXELR, VALUER, ERRORR, FLAGULR"
					+  " FROM SISTEMADIGALASSIE.Galaxy, SISTEMADIGALASSIE.HPfluxR "
					+  " WHERE NAME='" + galaxyName +"' AND NAME = GALAXYNAMEHPR ";

			rs = stmt.executeQuery(sql);
			if(rs.next())
			{

				listModel.addElement("Galaxy name :          " + rs.getString("NAME"));
				listModel.addElement("Atom :      " + rs.getString("NAMEHPR"));
				listModel.addElement("Pixel :      " + rs.getString("PIXELR"));
				listModel.addElement("Value :         " + rs.getString("VALUER"));
				listModel.addElement("Error :         " + rs.getString("ERRORR"));
				listModel.addElement("FLAG :         " + rs.getString("FLAGULR"));
				listModel.addElement(spaces);

			}
		}
		
		/*---------------------------------------------------------------------------------------------------------OPERATIONNUMBER = 4*/

		/*
		CREATE TABLE SISTEMADIGALASSIE.HPfluxR(
			NAMEHPR			VARCHAR, 
			PIXELR 			VARCHAR,
			VALUER			VARCHAR,
			ERRORR			VARCHAR,
			FLAGULR			VARCHAR,
			GALAXYNAMEHPR 	VARCHAR
							REFERENCES SISTEMADIGALASSIE.Galaxy(NAME),
			PRIMARY KEY(NAMEHPR, PIXELR, GALAXYNAMEHPR)
		)
	*/
		if (operationNumber == 4)
		{

			sql = "SELECT HP1.GALAXYNAMEHPR as gn1, HP1.NAMEHPR as hp1, HP2.NAMEHPR as hp2, HP1.VALUER as v1, HP2.VALUER as v2, HP1.FLAGULR as f1, HP2.FLAGULR as f2"
					+  " FROM SISTEMADIGALASSIE.HPfluxR as HP1, SISTEMADIGALASSIE.HPfluxR as HP2 "
					+  " WHERE HP1.GALAXYNAMEHPR = HP2.GALAXYNAMEHPR AND HP1.NAMEHPR = '" + fluxname1 +"' AND HP2.NAMEHPR = '" + fluxname2 +"' AND HP1.VALUER <> '' AND HP2.VALUER <> ''";

			rs = stmt.executeQuery(sql);
			

			
			while(rs.next())
			{

				listModel.addElement("Galaxy name :          " + rs.getString("gn1"));
				listModel.addElement("First Atom :      " + rs.getString("hp1"));
				listModel.addElement("Second Atom :      " + rs.getString("hp2"));				
				
				listModel.addElement("Ratio :         " + Float.parseFloat(rs.getString("v1"))/Float.parseFloat(rs.getString("v2")));
				if (rs.getString("f1").contains("<"))
				{
					listModel.addElement("the value of the first flux is an upper bound");
				}
				if (rs.getString("f2").contains("<"))
				{
					listModel.addElement("the value of the second flux is an upper bound");
				}
				listModel.addElement(spaces);

			}
		}
		
		
		
		
		/*---------------------------------------------------------------------------------------------------------OPERATIONNUMBER = 5*/

		if (operationNumber == 5)
		{
			

			ArrayList<Float> numbers = new ArrayList<Float>();
			ArrayList<String> atomname = new ArrayList<String>();
			

			sql = 		"SELECT NAMEHPR"
					+  " FROM SISTEMADIGALASSIE.HPfluxR , SISTEMADIGALASSIE.Galaxy "
					+  " WHERE GALAXYNAMEHPR = NAME AND SPECTRALCLASSIFICATION= '"+ spectralClassification +"'"
					+  " GROUP BY NAMEHPR";

			rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				atomname.add(rs.getString("NAMEHPR"));
			}
			int j;
			
			

			for(j = 0; j < atomname.size(); j++)
			{

				sql = 		"SELECT VALUER, PIXELR, NAMEHPR"
						+  " FROM SISTEMADIGALASSIE.HPfluxR , SISTEMADIGALASSIE.Galaxy "
						+  " WHERE GALAXYNAMEHPR = NAME AND NAMEHPR = '" + atomname.get(j) + "' AND SPECTRALCLASSIFICATION= '"+ spectralClassification +"'" ;

				rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					if (!rs.getString("VALUER").equals(""))
					{
						numbers.add(Float.parseFloat(rs.getString("VALUER")));
					}
				}		

				listModel.addElement("Atom name            :        " + atomname.get(j));
				listModel.addElement("Average              :        " + average(numbers));
				listModel.addElement("Standard Deviation   :        " + standardDeviation(numbers));
				listModel.addElement("MAD				   :        " + standardDeviation(numbers)*0.6745);
				listModel.addElement("Median   			   :        " + median(numbers));
				listModel.addElement(spaces);	
				

				numbers.clear();
			}
			
		}
		/*---------------------------------------------------------------------------------------------------------OPERATIONNUMBER = 6*/

		if (operationNumber == 6)
		{
			
			ArrayList<Float> numbers = new ArrayList<Float>();

			sql = 		"SELECT VALUER"
					+  " FROM SISTEMADIGALASSIE.HPfluxR "
					+  " WHERE NAMEHPR='" + fluxname1 +"' AND PIXELR = '"+ pixel +"'";

			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				if (!rs.getString("VALUER").equals(""))
				{
					numbers.add(Float.parseFloat(rs.getString("VALUER")));
				}
			}			
			listModel.addElement("Atom name            :        " + fluxname1);
			listModel.addElement("Pixels               :        " + pixel);
			listModel.addElement("Average              :        " + average(numbers));
			listModel.addElement("Standard Deviation   :        " + standardDeviation(numbers));
			listModel.addElement("MAD				   :        " + standardDeviation(numbers)*0.6745);
			listModel.addElement("Median   			   :        " + median(numbers));
			listModel.addElement(spaces);

		}

		
		
		
		/*---------------------------------------------------------------------------------------------------------OPERATIONNUMBER = 7*/

		/*
		CREATE TABLE SISTEMADIGALASSIE.HPfluxR(
			NAMEHPR			VARCHAR, 
			PIXELR 			VARCHAR,
			VALUER			VARCHAR,
			ERRORR			VARCHAR,
			FLAGULR			VARCHAR,
			GALAXYNAMEHPR 	VARCHAR
							REFERENCES SISTEMADIGALASSIE.Galaxy(NAME),
			PRIMARY KEY(NAMEHPR, PIXELR, GALAXYNAMEHPR)
		)
		
		
		CREATE TABLE SISTEMADIGALASSIE.HPfluxC(
			NAMEHPC			VARCHAR, 
			PIXELC 			VARCHAR,
			VALUEC			VARCHAR,
			ERRORC			VARCHAR,
			FLAGULC			VARCHAR,
			GALAXYNAMEHPC 	VARCHAR
							REFERENCES SISTEMADIGALASSIE.Galaxy(NAME),
			PRIMARY KEY(NAMEHPC, PIXELc, GALAXYNAMEHPC)
		);

	*/
		if (operationNumber == 7)
		{

			sql = "SELECT HP1.GALAXYNAMEHPR as gn1, HP1.NAMEHPR as hp1, HP2.NAMEHPC as hp2, HP1.VALUER as v1, HP2.VALUEC as v2, HP1.FLAGULR as f1, HP2.FLAGULC as f2"
					+  " FROM SISTEMADIGALASSIE.HPfluxR as HP1, SISTEMADIGALASSIE.HPfluxC as HP2 "
					+  " WHERE HP1.GALAXYNAMEHPR = HP2.GALAXYNAMEHPC AND HP1.NAMEHPR = '" + fluxname1 +"' AND HP2.NAMEHPC = '" + fluxname2 +"' AND HP1.VALUER <> '' AND HP2.VALUEC <> ''";

			rs = stmt.executeQuery(sql);
			

			
			while(rs.next())
			{

				listModel.addElement("Galaxy name :          " + rs.getString("gn1"));
				listModel.addElement("First Atom :      " + rs.getString("hp1"));
				listModel.addElement("Second Atom :      " + rs.getString("hp2"));				
				
				listModel.addElement("Ratio :         " + Float.parseFloat(rs.getString("v1"))/Float.parseFloat(rs.getString("v2")));
				if (rs.getString("f1").contains("<"))
				{
					listModel.addElement("the value of the first flux is an upper bound");
				}
				if (rs.getString("f2").contains("<"))
				{
					listModel.addElement("the value of the second flux is an upper bound");
				}
				listModel.addElement(spaces);

			}
		}
		
		
		/*---------------------------------------------------------------------------------------------------------FINE OPERAZIONI*/

		//Create the list and put it in a scroll pane.
		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(10);
		JScrollPane listScrollPane = new JScrollPane(list);

		JButton SearchButton = new JButton(searchString);
		SearchListener SearchListener = new SearchListener(SearchButton);
		SearchButton.setActionCommand(searchString);
		SearchButton.addActionListener(SearchListener);
		SearchButton.setEnabled(false);

		backButton = new JButton(backString);
		backButton.setActionCommand(backString);

		tfSearch = new JTextField(10);
		tfSearch.addActionListener(SearchListener);
		tfSearch.getDocument().addDocumentListener(SearchListener);
		/*String name = listModel.getElementAt(
                              list.getSelectedIndex()).toString();*/

		//Create a panel that uses BoxLayout.
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane,
				BoxLayout.LINE_AXIS));


		buttonPane.add(backButton);
		buttonPane.add(Box.createHorizontalStrut(5));
		buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
		buttonPane.add(Box.createHorizontalStrut(5));
		buttonPane.add(tfSearch);
		buttonPane.add(SearchButton);
		buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

		mainWindow.add(listScrollPane, BorderLayout.CENTER);
		mainWindow.add(buttonPane, BorderLayout.PAGE_END);

		//Create and set up the content pane.
		/*  JComponent newContentPane = new OperationFrame();
        newContentPane.setOpaque(true); //content panes must be opaque
        mainWindow.setContentPane(newContentPane);*/

		//Display the window.
		mainWindow.pack();
		mainWindow.setVisible(true);

		backButton.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				mainWindow.getContentPane().removeAll();
				mainWindow.getContentPane().repaint();
		    	mainWindow.setVisible(false);
		    	
		    	CheckDBframe checkDBFrame = CheckDBframe.getCheckDBControllerInstance();
				checkDBFrame.controllerCheckDBframe(userAdmin, mainWindow);
			}
		});
	
	

	}


	/*---------------------------------------------------------------------------------------------------SEARCHLISTENER()*/

	//This listener is shared by the text field and the Search button.
	class SearchListener implements ActionListener, DocumentListener {
		private boolean alreadyEnabled = false;
		private JButton button;

		public SearchListener(JButton button) {
			this.button = button;
		}

		//Required by ActionListener.
		public void actionPerformed(ActionEvent e) {
			String name = tfSearch.getText();

			int i = 0;
			new ArrayList<String>();
			while(i < list.getModel().getSize())
			{
				if(!listModel.get(i).toString().contains(name)){
					listModel.remove(i);
					i--;
				}
				i++;
			}
		}

		//This method tests for string equality. You could certainly
		//get more sophisticated about the algorithm.  For example,
		//you might want to ignore white space and capitalization.
		protected boolean alreadyInList(String name) {
			return listModel.contains(name);
		}

		//Required by DocumentListener.
		public void insertUpdate(DocumentEvent e) {
			enableButton();
		}

		//Required by DocumentListener.
		public void removeUpdate(DocumentEvent e) {
			handleEmptyTextField(e);
		}

		//Required by DocumentListener.
		public void changedUpdate(DocumentEvent e) {
			if (!handleEmptyTextField(e)) {
				enableButton();
			}
		}

		private void enableButton() {
			if (!alreadyEnabled) {
				button.setEnabled(true);
			}
		}

		private boolean handleEmptyTextField(DocumentEvent e) {
			if (e.getDocument().getLength() <= 0) {
				button.setEnabled(false);
				alreadyEnabled = false;
				return true;
			}
			return false;
		}
	}

	//This method is required by ListSelectionListener.
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

			if (list.getSelectedIndex() == -1) {
				//No selection, disable back button.
				backButton.setEnabled(false);

			} else {
				//Selection, enable the back button.
				backButton.setEnabled(true);
			}
		}
	}
	
	
	/*----------------------------------------------------MEDIA*/

	public float average(ArrayList <Float> numbers)
	{
		int size = numbers.size();
		int j ;
		float average = 0;
		for (j = 0; j < size; j++)
		{
			average += numbers.get(j);
		}
		return average/size;
		
	}
	
	/*---------------------------------------------DEVIAZIONE STANDARD*/  //RICONTROLLA, FA SEMPRE 1

	/*ricorda che la deviazione media assoluta è uguale a 
	  			
	  			MAD = square*0.6745
	
	*/
	
	public float standardDeviation(ArrayList <Float> numbers)
	{
		float average = average(numbers);
		int size = numbers.size(), j;
		float var = 0;
		float square, power;
		for(j = 0; j < size; j++)
		{
			power =(float) Math.pow((numbers.get(j)-average), 2); 
			var += power;
		}
		square = (float) Math.pow(var/size, 0.5);
		return square;
	}
	
	/*--------------------------------------------------MEDIANA*/
	public float median(ArrayList <Float> numbers)
	{
		
		/*BUBBLESORT*/
		
		int j, size = numbers.size();
		boolean flag = true;
		float dimension;
		while (flag == true)
		{
			flag = false;
			for (j = 0; j < size-1; j++)
			{
				if (numbers.get(j)>numbers.get(j+1))
				{
					dimension = numbers.get(j+1); 
					numbers.set(j+1, numbers.get(j));
					numbers.set(j, dimension);
					
					flag = true;
				}
			}
		}
		
		if (size % 2 == 0)
		{
			return numbers.get(size/2-1);
		}
		else 
		{
			return numbers.get((size+1)/2 -1);
		}
	}

	
	/*
	 * 	public OperationFrame(int operationNumber, String galaxyName, 
			String rayn, String rayrasch, String rayrascm, String rayrascs, String raydecsign, String raydecmin, String raydecsec, String raydecdeg, 
			String redshift, int morelessequals, 
			int userAdmin, 
			String fluxname1, String fluxname2, String pixel, 
			String spectralClassification) throws Exception 
	 */

	public static void main(String[] args) throws Exception {
		
		JFrame mainWindow = new JFrame();
		//new OperationFrame(0, "Mrk334", "5", "1", "1", "1", "+", "1", "1", "1", "1", 0, 1, "NIII-57", "NII-122", "3x3", "S2");
		//new OperationFrame(1, "Mrk334", "5", "1", "1", "1", "+", "1", "1", "1", "1", 0, 1, "NIII-57", "NII-122", "3x3", "S2");
		//new OperationFrame(2, "Mrk334", "5", "1", "1", "1", "+", "1", "1", "1", "1", 0, 1, "NIII-57", "NII-122", "3x3", "S2");
		//new OperationFrame(3, "Mrk334", "5", "1", "1", "1", "+", "1", "1", "1", "1", 0, 1, "NIII-57", "NII-122", "3x3", "S2");
		//new OperationFrame(4, "Mrk334", "5", "1", "1", "1", "+", "1", "1", "1", "1", 0, 1, "NIII-57", "NII-122", "3x3", "S2");
		//new OperationFrame(5, "Mrk334", "5", "1", "1", "1", "+", "1", "1", "1", "1", 0, 1, "NIII-57", "NII-122", "3x3", "S2");
		//new OperationFrame(6, "Mrk334", "5", "1", "1", "1", "+", "1", "1", "1", "1", 0, 1, "NIII-57", "NII-122", "3x3", "S2");
		new OperationFrame(7, "Mrk334", "5", "1", "1", "1", "+", "1", "1", "1", "1", 0, 1, "NIII-57", "NII-122", "3x3", "S2", mainWindow);


	}


}
