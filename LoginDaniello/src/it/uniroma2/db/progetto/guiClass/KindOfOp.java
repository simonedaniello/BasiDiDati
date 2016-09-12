package it.uniroma2.db.progetto.guiClass;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import it.uniroma2.db.boundary.MainMenuBoundary;

public class KindOfOp {

	
	private static final String titolo = "Search Page";

	private static final JButton buttonGalaxy= new JButton("Galaxy searches");
	private static final JButton buttonFlux= new JButton("Flux Searches");
	private static final JButton buttonExit = new JButton("Exit");
	
public KindOfOp(int userAdmin, JFrame window) {
		
		window.setTitle(titolo);
		window.setSize(400,300);


		
		window.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		window.add(buttonGalaxy, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		window.add(buttonFlux, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		window.add(buttonExit, gbc);
		
//		ADMIN
		buttonGalaxy.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
//				window.getContentPane().removeAll();
//				window.getContentPane().repaint();
//		    	window.setVisible(false);
//		    	new AdminInterface(window);
		    	
		    	window.getContentPane().removeAll();
				window.getContentPane().repaint();
		    	window.setVisible(false);
				CheckDBframe dbFrame = CheckDBframe.getCheckDBControllerInstance();
				dbFrame.controllerCheckDBframe(userAdmin, window);		    
		    }});
		
//		USER
		buttonFlux.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
		    	window.getContentPane().removeAll();
				window.getContentPane().repaint();
		    	window.setVisible(false);
		    	JFrame.setDefaultLookAndFeelDecorated(true);
				CheckDBframeFlux dbFrame = CheckDBframeFlux.getCheckDBControllerInstance();
				dbFrame.controllerCheckDBframe(userAdmin, window);		    

			}
		});
		
		buttonExit.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				window.getContentPane().removeAll();
				window.getContentPane().repaint();
		    	window.setVisible(false);
				new MainMenuBoundary(userAdmin, window);
			}
		});
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
		window.setVisible(true);
	}		

public static void main(String[] args) {
	JFrame window = new JFrame();
	new KindOfOp(0, window);
	
}
	
	
}
