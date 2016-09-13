package it.uniroma2.db.progetto.guiClass;


import javax.swing.*;

import it.uniroma2.db.boundary.MainMenuBoundary;
import it.uniroma2.db.progetto.csvManagement.CSVreader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class CSVchooser extends JFrame{


	private static final long serialVersionUID = 5374772073176018844L;

	private static final String titolo = "Choose .csv";
	
	private static final JButton buttonGeneral = new JButton("Import general .csv");

	private static final JButton buttonHP = new JButton("Import HP flux .csv");

	private static final JButton buttonHP2 = new JButton("Import HP flux (different pixels)");

	private static final JButton buttonSpitzer = new JButton("Import Spitzer flux");

	private static final JButton buttonHP3 = new JButton("Import cazzoneso flux");
	
	private static final JButton buttonExit = new JButton("Back");

	public CSVchooser(int useradmin, String filename, JFrame mainWindow){
		mainWindow.setTitle(titolo); 
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(500,200);
		mainWindow.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 15, 15);


		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(buttonGeneral, gbc);

		
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(buttonHP, gbc);


		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(buttonHP2, gbc);

		
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(buttonSpitzer, gbc);
		
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(buttonHP3, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_END;
		mainWindow.add(buttonExit, gbc);
		
		/*--------------------------------------------------------------BUTTON ACTIONS*/
		
		buttonGeneral.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	try 
		    	{
					mainWindow.getContentPane().removeAll();
					mainWindow.getContentPane().repaint();
			    	mainWindow.setVisible(false);
					new CSVreader(filename, 0);
			    	new MainMenuBoundary(useradmin, mainWindow); //----------------------------------------------------------------------------DA CAMBIARE ASSOLUTAMENTE

				} 
		    	catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		buttonHP.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	try 
		    	{
					mainWindow.getContentPane().removeAll();
					mainWindow.getContentPane().repaint();
			    	mainWindow.setVisible(false);
					new CSVreader(filename, 1);
			    	new MainMenuBoundary(useradmin, mainWindow); //----------------------------------------------------------------------------DA CAMBIARE ASSOLUTAMENTE

				} 
		    	catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		buttonHP2.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	try 
		    	{
					mainWindow.getContentPane().removeAll();
					mainWindow.getContentPane().repaint();
			    	mainWindow.setVisible(false);
					new CSVreader(filename, 2);
			    	new MainMenuBoundary(useradmin, mainWindow); //----------------------------------------------------------------------------DA CAMBIARE ASSOLUTAMENTE

				} 
		    	catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		buttonSpitzer.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	try 
		    	{
					mainWindow.getContentPane().removeAll();
					mainWindow.getContentPane().repaint();
			    	mainWindow.setVisible(false);
					new CSVreader(filename, 3);
			    	new MainMenuBoundary(useradmin, mainWindow); //----------------------------------------------------------------------------DA CAMBIARE ASSOLUTAMENTE

				} 
		    	catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		buttonExit.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
				mainWindow.getContentPane().removeAll();
				mainWindow.getContentPane().repaint();
		    	mainWindow.setVisible(false);
		    	new MainMenuBoundary(useradmin, mainWindow); //----------------------------------------------------------------------------DA CAMBIARE ASSOLUTAMENTE
		    }
		});
		
		mainWindow.setVisible(true);
	}
	

}
