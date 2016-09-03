package it.uniroma2.db.progetto.guiClass;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import it.uniroma2.db.Boundary.StartFrame;
import it.uniroma2.db.progetto.guiClass.EventListeners;
import it.uniroma2.db.progetto.guiClass.userAdder; 



public class RegisInterface extends JFrame implements ActionListener {
	


	private static final long serialVersionUID = 1L;

	
	private JLabel lName;
	private JTextField tfName;
	private JLabel lNameError;

	private JLabel lLastName;
	private JTextField tfLastName;
	private JLabel lLastNameError;
	
	private JLabel lemail;
	private JTextField tfemail;
	private JLabel lemailError;

	private JLabel lUser;
	private JTextField tfUser;
	private JLabel lUserError;

	private JLabel lpwdCode;
	private JPasswordField tfpwdCode;
	private JLabel lpwdCodeError;
	
	private JPasswordField tfrepwdCode;
	private JLabel lrepwdCodeError;
	private JLabel lrepwdCodeError2;

	private JButton submitButton;
	private JButton backButton;

	
	public RegisInterface(JFrame mainWindow) {
		
		mainWindow.getContentPane().removeAll();
		mainWindow.getContentPane().repaint();
		mainWindow.setTitle("Registration Interface");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(400, 400);
		
		mainWindow.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

/*---------------------------------------------------------------------------*/
		
		lName = new JLabel("First Name:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		mainWindow.add(lName, gbc);


		tfName = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(tfName, gbc);


		lNameError = new JLabel("Please insert your First Name.");
		lNameError.setForeground(Color.RED);
		lNameError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(lNameError, gbc);


/*---------------------------------------------------------------------------*/

		lLastName = new JLabel("Last Name:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		mainWindow.add(lLastName, gbc);


		tfLastName = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(tfLastName, gbc);


		lLastNameError = new JLabel("Please insert your last name.");
		lLastNameError.setForeground(Color.RED);
		lLastNameError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(lLastNameError, gbc);

/*---------------------------------------------------------------------------*/
	
		lemail = new JLabel("e-mail:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);;
		mainWindow.add(lemail, gbc);
		
		tfemail = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(tfemail, gbc);


		lemailError = new JLabel("Please insert your email.");
		lemailError.setForeground(Color.RED);
		lemailError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(lemailError, gbc);

/*---------------------------------------------------------------------------*/


		lUser = new JLabel("Username:");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		mainWindow.add(lUser, gbc);


		tfUser= new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(tfUser, gbc);


		lUserError = new JLabel("Please insert your username.");
		lUserError.setForeground(Color.RED);
		lUserError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(lUserError, gbc);


/*---------------------------------------------------------------------------*/

		lpwdCode = new JLabel("Password");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		mainWindow.add(lpwdCode, gbc);


		tfpwdCode = new JPasswordField(15);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(tfpwdCode, gbc);


		lpwdCodeError = new JLabel("Please insert your password");
		lpwdCodeError.setForeground(Color.RED);
		lpwdCodeError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(lpwdCodeError, gbc);


/*---------------------------------------------------------------------------*/
		

		lpwdCode = new JLabel("re-insert password");
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		mainWindow.add(lpwdCode, gbc);


		tfrepwdCode = new JPasswordField(15);
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(tfrepwdCode, gbc);


		lrepwdCodeError = new JLabel("Please re-insert your password");
		lrepwdCodeError.setForeground(Color.RED);
		lrepwdCodeError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(lrepwdCodeError, gbc);
		
		lrepwdCodeError2 = new JLabel("the password seems different");
		lrepwdCodeError2.setForeground(Color.RED);
		lrepwdCodeError2.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainWindow.add(lrepwdCodeError2, gbc);

/*---------------------------------------------------------------------------*/
		
		
		submitButton = new JButton("Submit");
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(25, 0, 0, 10);

		mainWindow.add(submitButton, gbc);
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				int control = 0;
				
				lNameError.setVisible(false);
				lLastNameError.setVisible(false);
				lpwdCodeError.setVisible(false);
				lUserError.setVisible(false);
				lrepwdCodeError.setVisible(false);
				lrepwdCodeError2.setVisible(false);
				lemailError.setVisible(false);
				
				if (tfName.getText().equals(""))
				{
					lNameError.setVisible(true);
					control = 1;
				}
				if (tfLastName.getText().equals(""))
				{
					lLastNameError.setVisible(true);
					control = 1;
				}
				
				if (tfemail.getText().equals(""))
				{
					lemailError.setVisible(true);
					control = 1;
				}
				
				if (tfUser.getText().equals(""))
				{
					lUserError.setVisible(true);
					control = 1;
				}
				if (tfpwdCode.getPassword().equals(""))
				{
					lpwdCodeError.setVisible(true);
					control = 1;
				}
				
				if (tfrepwdCode.getPassword().equals(""))
				{
					lrepwdCodeError.setVisible(true);
					control = 1;
				}
				
				if (!tfrepwdCode.getPassword().equals(tfpwdCode.getPassword()) && !tfrepwdCode.getPassword().equals(""))
				{
					lrepwdCodeError2.setVisible(true);
					control = 1;
				}
				
				
				if (control == 0){
					userAdder costruttore = new userAdder();
					costruttore.adder(tfUser.getText(), tfpwdCode.getPassword().toString(), tfName.getText(), tfLastName.getText(), tfemail.getText());
					mainWindow.getContentPane().removeAll();
					mainWindow.getContentPane().repaint();
			    	mainWindow.setVisible(false);
			    	new StartFrame();
				}
			}
		});

/*---------------------------------------------------------------------------*/
		
		
		backButton = new JButton("Back");
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(25, 0, 0, 10);

		mainWindow.add(backButton, gbc);
		
		backButton.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				mainWindow.getContentPane().removeAll();
				mainWindow.getContentPane().repaint();
		    	mainWindow.setVisible(false);
				new StartFrame();
			}
		});
		
		
		mainWindow.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		JFrame mainWindow = new JFrame(); 
		new RegisInterface(mainWindow);
	}

/*---------------------------------------------------------------------------*/
	
	/*public void actionPerformed(ActionEvent e){
		int control = 0;
		
		lNameError.setVisible(false);
		lLastNameError.setVisible(false);
		lpwdCodeError.setVisible(false);
		lUserError.setVisible(false);
		lrepwdCodeError.setVisible(false);
		lrepwdCodeError2.setVisible(false);
		lemailError.setVisible(false);
		
		if (tfName.getText().equals(""))
		{
			lNameError.setVisible(true);
			control = 1;
		}
		if (tfLastName.getText().equals(""))
		{
			lLastNameError.setVisible(true);
			control = 1;
		}
		
		if (tfemail.getText().equals(""))
		{
			lemailError.setVisible(true);
			control = 1;
		}
		
		if (tfUser.getText().equals(""))
		{
			lUserError.setVisible(true);
			control = 1;
		}
		if (tfpwdCode.getPassword().equals(""))
		{
			lpwdCodeError.setVisible(true);
			control = 1;
		}
		
		if (tfrepwdCode.getPassword().equals(""))
		{
			lrepwdCodeError.setVisible(true);
			control = 1;
		}
		
		if (!tfrepwdCode.getPassword().equals(tfpwdCode.getPassword()) && !tfrepwdCode.getPassword().equals(""))
		{
			lrepwdCodeError2.setVisible(true);
			control = 1;
		}
		
		
		if (control == 0){
			userAdder costruttore = new userAdder();
			costruttore.adder(tfUser.getText(), tfpwdCode.getPassword().toString(), tfName.getText(), tfLastName.getText(), tfemail.getText());
			dispose();
			new UserInterface();
		}
	}*/

	
}

	
	
