package it.uniroma2.db.progetto.guiClass;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import it.uniroma2.db.Boundary.UserInterface;
import it.uniroma2.db.progetto.guiClass.EventListeners;
import it.uniroma2.db.progetto.guiClass.userAdder; 



public class RegisInterface extends JFrame implements ActionListener {
	

	/**
	 * 
	 */
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

	
	public RegisInterface() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

/*---------------------------------------------------------------------------*/
		
		this.lName = new JLabel("First Name:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		this.add(this.lName, gbc);


		this.tfName = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.tfName, gbc);


		this.lNameError = new JLabel("Please insert your First Name.");
		this.lNameError.setForeground(Color.RED);
		this.lNameError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.lNameError, gbc);


/*---------------------------------------------------------------------------*/

		this.lLastName = new JLabel("Last Name:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		this.add(this.lLastName, gbc);


		this.tfLastName = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.tfLastName, gbc);


		this.lLastNameError = new JLabel("Please insert your last name.");
		this.lLastNameError.setForeground(Color.RED);
		this.lLastNameError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.lLastNameError, gbc);

/*---------------------------------------------------------------------------*/
	
		this.lemail = new JLabel("e-mail:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);;
		this.add(this.lemail, gbc);
		
		this.tfemail = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.tfemail, gbc);


		this.lemailError = new JLabel("Please insert your email.");
		this.lemailError.setForeground(Color.RED);
		this.lemailError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.lemailError, gbc);

/*---------------------------------------------------------------------------*/


		this.lUser = new JLabel("Username:");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		this.add(this.lUser, gbc);


		this.tfUser= new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.tfUser, gbc);


		this.lUserError = new JLabel("Please insert your username.");
		this.lUserError.setForeground(Color.RED);
		this.lUserError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.lUserError, gbc);


/*---------------------------------------------------------------------------*/

		this.lpwdCode = new JLabel("Password");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		this.add(this.lpwdCode, gbc);


		this.tfpwdCode = new JPasswordField(15);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.tfpwdCode, gbc);


		this.lpwdCodeError = new JLabel("Please insert your password");
		this.lpwdCodeError.setForeground(Color.RED);
		this.lpwdCodeError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.lpwdCodeError, gbc);


/*---------------------------------------------------------------------------*/
		

		this.lpwdCode = new JLabel("re-insert password");
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		this.add(this.lpwdCode, gbc);


		this.tfrepwdCode = new JPasswordField(15);
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.tfrepwdCode, gbc);


		this.lrepwdCodeError = new JLabel("Please re-insert your password");
		this.lrepwdCodeError.setForeground(Color.RED);
		this.lrepwdCodeError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.lrepwdCodeError, gbc);
		
		this.lrepwdCodeError2 = new JLabel("the password seems different");
		this.lrepwdCodeError2.setForeground(Color.RED);
		this.lrepwdCodeError2.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.lrepwdCodeError2, gbc);

/*---------------------------------------------------------------------------*/
		
		
		this.submitButton = new JButton("Submit");
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(25, 0, 0, 10);

		this.add(this.submitButton, gbc);
		
		submitButton.addActionListener(this);

/*---------------------------------------------------------------------------*/
		
		
		this.backButton = new JButton("Back");
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(25, 0, 0, 10);

		this.add(this.backButton, gbc);
		
		backButton.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new UserInterface();
			}
		});
		
		
		this.pack();
		this.setVisible(true);
	}
	

/*---------------------------------------------------------------------------*/
	
	public void actionPerformed(ActionEvent e){
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
	}

	
}

	
	
