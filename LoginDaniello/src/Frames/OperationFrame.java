package Frames;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import control.EventListeners;
 
/* ListDemo.java requires no other files. */
public class OperationFrame extends JPanel implements ListSelectionListener 
{
    
	private JList<String> list;
    private DefaultListModel<String> listModel;
 
    private static final String searchString = "Search";
    private static final String backString = "Back";
    
    private JButton backButton;
    private JTextField tfSearch;
 
    /*----------------------------------------------------------------------------------------------------OPERATIONFRAME()*/
    
    public OperationFrame() {
    	
        super(new BorderLayout());
 

        
        JFrame frame = new JFrame("Operation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        listModel = new DefaultListModel<String>();
 
        listModel.addElement("prova 1");  //SONO DA CANCELLARE, È SOLO UNA PROVA
        listModel.addElement("prova 2");
        
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
 

    public static void main(String[] args) {
        new OperationFrame();
    }
}
