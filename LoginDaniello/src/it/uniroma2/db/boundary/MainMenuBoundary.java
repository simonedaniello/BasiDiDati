package it.uniroma2.db.boundary;

import javax.swing.*;

import it.uniroma2.db.progetto.guiClass.CSVchooser;
import it.uniroma2.db.progetto.guiClass.CheckDBframeFlux;
import it.uniroma2.db.progetto.guiClass.EventListeners;
import it.uniroma2.db.progetto.guiClass.KindOfOp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;


public class MainMenuBoundary extends JFrame {
	
	private static final long serialVersionUID = 5374772073176018844L;

	private static final String titolo = "Welcome!";
	
	private static final JButton buttonCheck = new JButton("Check Database");

	private static final JButton buttonCsv = new JButton("Import .CSV file");

	private static final JButton buttonExit = new JButton("Exit");

	private static final JButton buttonRegister = new JButton("Register New User");

	public MainMenuBoundary(int UserAdmin, JFrame mainWindow){
		
		mainWindow.getContentPane().removeAll();
		mainWindow.getContentPane().repaint();
		mainWindow.setTitle(titolo);
		mainWindow.setSize(300, 300);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		mainWindow.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 15, 15);


		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(buttonCheck, gbc);
		
		int i = 0;
		
		if (UserAdmin == 1)
		{
			gbc.gridy = 5;
			gbc.anchor = GridBagConstraints.LINE_START;
			mainWindow.add(buttonCsv, gbc);
			i++;
		}
		
		if (UserAdmin == 1)
		{
			gbc.gridy = 6;
			gbc.anchor = GridBagConstraints.LINE_START;
			mainWindow.add(buttonRegister, gbc);
			i++;
		}
		
		gbc.gridy = 5+i;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(buttonExit, gbc);		


		buttonExit.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				mainWindow.getContentPane().removeAll();
				mainWindow.getContentPane().repaint();
		    	mainWindow.setVisible(false);
		    	new StartBoundary();
			}
		});
		
		buttonRegister.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				mainWindow.getContentPane().removeAll();
				mainWindow.getContentPane().repaint();
		    	mainWindow.setVisible(false);
				new RegBoundary(mainWindow);
			}
		});

		buttonCsv.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileChooser = new JFileChooser();
				
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) 
				{
					File selectedFile = fileChooser.getSelectedFile();
					if (selectedFile != null)
					{
						mainWindow.getContentPane().removeAll();
						mainWindow.getContentPane().repaint();
				    	mainWindow.setVisible(false);
				    	
						new CSVchooser(selectedFile.getAbsolutePath(), mainWindow);
					}
					else 
					{
						mainWindow.getContentPane().removeAll();
						mainWindow.getContentPane().repaint();
				    	mainWindow.setVisible(false);
						new MainMenuBoundary(UserAdmin, mainWindow);
					}
					
				}
				else
				{
					//BISOGNA ASSOLUTAMENTE CAPIRE COME METTERE UN MESSAGGIO DI ERRORE
				}
			}
		});

		buttonCheck.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				mainWindow.getContentPane().removeAll();
				mainWindow.getContentPane().repaint();
		    	mainWindow.revalidate();
				mainWindow.setVisible(false);
				mainWindow.setSize(800, 800);
				
		    	/*dispose();
		    	
		    	JFrame newWindow = new JFrame();
		    	newWindow.setSize(700, 700);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				newWindow.setLocation(dim.width/2-newWindow.getSize().width/2, dim.height/2-newWindow.getSize().height/2);
				*/
				
				new KindOfOp(UserAdmin, mainWindow);
			}
		});

		mainWindow.setVisible(true);
	}
	
	public static void main(String[] args) {

		JFrame mainWindow = new JFrame();
		MainMenuBoundary dbFrame = new MainMenuBoundary(0, mainWindow);
	}



}
