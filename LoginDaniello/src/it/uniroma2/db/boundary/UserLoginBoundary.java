package it.uniroma2.db.boundary;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.uniroma2.db.controller.LoginController;
//import it.uniroma2.db.entity.User;
import it.uniroma2.db.progetto.guiClass.EventListeners; 


public class UserLoginBoundary extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7193850415434472203L;
	
	private static final String titolo = "Login";
	private static final JLabel user = new JLabel("Username");
	private static final JLabel pwd = new JLabel("Password"); 
	private static final JTextField insNome = new JTextField(20);
	private static final JTextField insCognome = new JPasswordField(20);
	private static final JButton btnConfirm = new JButton("OK");
	//private static final JButton buttonR= new JButton("Registrati");
	
	public UserLoginBoundary(JFrame mainWindow) {
		mainWindow.getContentPane().removeAll();
//		mainWindow.getContentPane().repaint();
		mainWindow.setTitle(titolo);
		mainWindow.setSize(400, 300);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		mainWindow.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		mainWindow.add(user, gbc);
		

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		mainWindow.add(insNome, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		mainWindow.add(pwd, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		mainWindow.add(insCognome, gbc);
		
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		mainWindow.add(btnConfirm, gbc);
		
		btnConfirm.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {	
		    	LoginController loginController = LoginController.getGuiControllerInstance(mainWindow);
				String username = insNome.getText();
		    	String password = insCognome.getText();
//		    	dispose();
		    	
		    	try {
		    		loginController.loginUserController(username, password, mainWindow);
		    		//new MainMenuBoundary(userLogin.getAccountType(), mainWindow);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		
		mainWindow.setVisible(true);
	}
	
}

