package it.uniroma2.db.boundary;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import it.uniroma2.db.progetto.guiClass.EventListeners;


public class StartBoundary extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final JFrame mainWindow = new JFrame();
//	public static final JPanel mainWindow = new JPanel();
	
	private static final String titolo = "Welcome";

	private static final JButton buttonUser= new JButton("User Area");
	private static final JButton buttonAdmin= new JButton("Administrator Area");
	private static final JButton buttonRegister = new JButton("Register");
	
	
	
	
//	**** MAIN START ****
	public static void main(String[] args) {
		new StartBoundary();
	}
	
	
	public StartBoundary() {
		
		setTitle(titolo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		mainWindow.setTitle(titolo);
//		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		ADMIN
		buttonAdmin.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
//				mainWindow.getContentPane().removeAll();
//				mainWindow.getContentPane().repaint();
//		    	mainWindow.setVisible(false);
//		    	new AdminInterface(mainWindow);
		    	
		    	mainWindow.getContentPane().removeAll();
				mainWindow.getContentPane().repaint();
		    	mainWindow.setVisible(false);
		    	new AdminLoginBoundary(mainWindow);
		    }
		});
		
//		USER
		buttonUser.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
		    	mainWindow.getContentPane().removeAll();
				mainWindow.getContentPane().repaint();
		    	mainWindow.setVisible(false);
				new UserLoginBoundary(mainWindow);
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
		
		mainWindow.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		mainWindow.add(buttonAdmin, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		mainWindow.add(buttonUser, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		mainWindow.add(buttonRegister, gbc);
		
//		mainWindow.setResizable(true);
		setResizable(true);
		mainWindow.setSize(400, 200);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainWindow.setLocation(dim.width/2-mainWindow.getSize().width/2, dim.height/2-mainWindow.getSize().height/2);
		mainWindow.setVisible(true);
	}		
	
}
