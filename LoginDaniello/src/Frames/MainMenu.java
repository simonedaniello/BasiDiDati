package Frames;

import javax.swing.*;

import control.EventListeners;
import control.GuiController;

import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
	
	private static final String titolo = "Welcome!";
	private static final JButton buttonCheck= new JButton("Check Database");

	private static final JButton buttonCsv= new JButton("Import .CSV file");
	
	private static final JButton buttonExit= new JButton("Exit");
	
	
	public MainMenu(){
		super(titolo); //piccolo cambio per il commit
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 15, 15);

		
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.buttonCheck, gbc);
			
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(this.buttonCsv, gbc);
		
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.buttonExit, gbc);		
		
		
		buttonExit.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	dispose();
		    }
		});
		
		buttonCsv.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	NewLocationFrame inserisci = new NewLocationFrame();
		    	dispose();
		    }
		});
		
		buttonCheck.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	dispose();
		    }
		});
		
		
		this.pack();
		this.setVisible(true);
	}
	
	int i = 0;
	
	
}
