package it.uniroma2.db.progetto.guiClass;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.uniroma2.db.progetto.guiClass.EventListeners;
import it.uniroma2.db.appStart.StartGuiController; 


@SuppressWarnings("serial")
public class UserInterface extends JFrame {
	
	private static final String titolo = "Login";
	private static final JLabel user = new JLabel("Username");
	private static final JLabel pwd = new JLabel("Password"); 
	private static final JTextField insNome = new JTextField(20);
	private static final JTextField insCognome = new JPasswordField(20);
	private static final JButton button= new JButton("OK");
	//private static final JButton buttonR= new JButton("Registrati");
	
	public UserInterface() {
		super(titolo);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	String nome = insNome.getText();
		    	String password = insCognome.getText();
		    	dispose();
		    	try {
		    		StartGuiController startGui = new StartGuiController();
					startGui.listenC(nome, password);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(user, gbc);
		

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(insNome, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(pwd, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(insCognome, gbc);
		
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(button, gbc);
		
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new UserInterface();
	}
	
}

