package it.uniroma2.db.progetto.guiClass;


import javax.swing.*;

import it.uniroma2.db.progetto.CSVManagement.CSVreader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class CSVchooser extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5374772073176018844L;

	private static final String titolo = "Choose .csv";
	
	private static final JButton buttonGeneral = new JButton("Import general .csv");

	private static final JButton buttonHP = new JButton("Import HP flux .csv");

	private static final JButton buttonHP2 = new JButton("Import HP flux (different pixels)");

	private static final JButton buttonSpitzer = new JButton("Import Spitzer flux");

	private static final JButton buttonHP3 = new JButton("Import cazzoneso flux");
	
	private static final JButton buttonExit = new JButton("Back");

	public CSVchooser(String filename){
		super(titolo); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 15, 15);


		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(buttonGeneral, gbc);

		
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(buttonHP, gbc);


		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(buttonHP2, gbc);

		
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(buttonSpitzer, gbc);
		
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(buttonHP3, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(buttonExit, gbc);
		
		/*--------------------------------------------------------------BUTTON ACTIONS*/
		
		buttonGeneral.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	try 
		    	{
					new CSVreader(filename, 0);
				} 
		    	catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
		    	dispose();
		    }
		});
		
		buttonHP.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	try 
		    	{
					new CSVreader(filename, 1);
				} 
		    	catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
		    	dispose();
		    }
		});
		
		buttonHP2.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	try 
		    	{
					new CSVreader(filename, 2);
				} 
		    	catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
		    	dispose();
		    }
		});
		
		buttonSpitzer.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	try 
		    	{
					new CSVreader(filename, 3);
				} 
		    	catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
		    	dispose();
		    }
		});
		
		buttonExit.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	new MainMenu(1); //----------------------------------------------------------------------------DA CAMBIARE ASSOLUTAMENTE
		    	dispose();
		    }
		});
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CSVchooser("1");
	}
	

}
