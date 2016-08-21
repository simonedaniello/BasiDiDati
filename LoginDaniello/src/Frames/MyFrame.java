package Frames;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.EventListeners;
import control.GuiController; 


public class MyFrame extends JFrame {
	
	private static final String titolo = "Login";
	private static final JLabel user = new JLabel("Username");
	private static final JLabel pwd = new JLabel("Password"); 
	private static final JTextField insNome = new JTextField(20);
	private static final JTextField insCognome = new JPasswordField(20);
	private static final JButton button= new JButton("OK");
	private static final JButton buttonR= new JButton("Registrati");
	
	public MyFrame() {
		super(titolo);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	String nome = insNome.getText();
		    	String password = insCognome.getText();
		    	dispose();
		    	GuiController.listenC(nome, password);
		    }
		});
		//co
		buttonR.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				GuiController.listenR();
			}
		});
		//bla bla bla
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(this.user, gbc);
		

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(this.insNome, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(this.pwd, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(this.insCognome, gbc);
		
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(this.button, gbc);
			
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(this.buttonR, gbc);
		
		this.pack();
		this.setVisible(true);
	}
	

	
}
