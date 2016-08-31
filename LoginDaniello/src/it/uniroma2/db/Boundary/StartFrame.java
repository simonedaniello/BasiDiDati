package it.uniroma2.db.progetto.guiClass;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import it.uniroma2.db.progetto.guiClass.EventListeners;


public class StartFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static final String titolo = "Welcome";

	
	private static final JButton buttonExit= new JButton("Exit");

	private static final JButton buttonUser= new JButton("User Area");
	private static final JButton buttonAdmin= new JButton("Administrator Area");
	
	
	
	public StartFrame() {
		
		super(titolo);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonAdmin.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	new AdminInterface();
		    	dispose();
		    }
		});
		
		buttonUser.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new UserInterface();
			}
		});
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(buttonAdmin, gbc);
		

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(buttonUser, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		this.add(buttonExit, gbc);
		

		
		this.pack();
		this.setVisible(true);
	}
	
		
	public static void main(String[] args) {
		new StartFrame();
	}
	
		
	
}
