package it.uniroma2.db.progetto.guiClass;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import it.uniroma2.db.progetto.guiClass.EventListeners;
 
/* ListDemo.java requires no other files. */
@SuppressWarnings("serial")
public class OperationFrame extends JPanel implements ListSelectionListener 
{
    
	private JList<String> list;
    private DefaultListModel<String> listModel;
 
    private static final String searchString = "Search";
    private static final String backString = "Back";
    
    private JButton backButton;
    private JTextField tfSearch;
    
	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb";
	   
	//  Database credentials
	static final String USER = "superuser";
	static final String PASS = "password";
 
    /*----------------------------------------------------------------------------------------------------OPERATIONFRAME()*/
    
	/*
	 * morelessequal -> 0 less, 1 more, 2 equals*/
    public OperationFrame(int operationNumber, String galaxyName, 
    		String rayn, String rayrasch, String rayrascm, String rayrascs, String raydecsign, String raydecmin, String raydecsec, String raydecdeg, 
    		String redshift, int morelessequals) throws Exception {
    	
        super(new BorderLayout());
 
		Connection conn = null;
		Statement stmt = null;
		

	    Class.forName("org.postgresql.Driver");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    stmt = conn.createStatement();
	      

	    String sql;
	    ResultSet rs;
	    
	    /*
	     * numero operazione -> ritorna 
	     * 
	     * i = 0 			 -> nome galassia, posizione, distanza , redshift, luminosità, errore, metallicità, errore
	     * 
	     * i = 1			 -> nome delle prime n galassie all'interno di un raggio data una determinata posizione spaziale (ordinato rispetto al centro del raggio)
	     * 
	     * i = 2 			 -> nome delle prime n galassie con valore minore, maggiore o uguale a un determinato valore di redshift
	     * 
	     * i = 3			 -> nome della galassia con relativo flusso delle righe 
	     * 
	     * i = 4 			 -> nome della galassia con rapporto tra due flussi differenti (per ogni galassia)
	     * 
	     * i = 5			 -> media, deviazione standard, mediana e deviazione media assoluta del rapporto tra due flussi all'interno di un gruppo spettrale
	     * 
	     * i = 6			 -> idem i = 5 ma potendo scegliere una particolare apertura
	     * 
	     * i = 7			 -> nome galassia con rapporto tra flusso delle righe e flsso continuo
	    */
        
        JFrame frame = new JFrame("Operation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
		    	  System.out.println("sono dentro");
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
      
        /*---------------------------------------------------------------------------------------------------------OPERATIONNUMBER = 2*/
        
        
        if (operationNumber == 2)
        {
        	
        	System.out.println(redshift);
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

	    	  System.out.println("sono dentro2");
		      sql = "SELECT NAME, NAMEHPR, PIXELR, VALUER, ERRORR, FLAGULR"
		      	+  " FROM SISTEMADIGALASSIE.Galaxy, SISTEMADIGALASSIE.HPfluxR "
		      	+  " WHERE NAME='" + galaxyName +"' AND NAME = GALAXYNAMEHPR ";
		      
		      rs = stmt.executeQuery(sql);
		      if(rs.next())
		      {
		    	  System.out.println("sono dentro");
			      listModel.addElement("Galaxy name :          " + rs.getString("NAME"));
			      listModel.addElement("Atom :      " + rs.getString("NAMEHPR"));
			      listModel.addElement("Pixel :      " + rs.getString("PIXELR"));
			      listModel.addElement("Value :         " + rs.getString("VALUER"));
			      listModel.addElement("Error :         " + rs.getString("ERRORR"));
			      listModel.addElement("FLAG :         " + rs.getString("FLAGULR"));
			      listModel.addElement(spaces);

		      }
        }
      
        /*---------------------------------------------------------------------------------------------------------OPERATIONNUMBER = N*/
                	
        	
        //listModel.addElement("prova 1");  //SONO DA CANCELLARE, È SOLO UNA PROVA
        //listModel.addElement("prova 2");
        
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
 
        frame.add(listScrollPane, BorderLayout.CENTER);
        frame.add(buttonPane, BorderLayout.PAGE_END);

        //Create and set up the content pane.
      /*  JComponent newContentPane = new OperationFrame();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);*/

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        backButton.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	new CheckDBframe();
		    	frame.dispose();
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
 

    public static void main(String[] args) throws Exception {
       new OperationFrame(3, "Mrk334", null, null, null, null, null, null, null, null, "0.5", 0);
    }
}
