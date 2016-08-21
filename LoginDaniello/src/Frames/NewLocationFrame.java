package Frames;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.EventListeners;

public class NewLocationFrame extends JFrame {

	private JLabel lName;
	private JTextField tfName;
	private JLabel lNameError;

	private JLabel lLastName;
	private JTextField tfLastName;
	private JLabel lLastNameError;

	private JCheckBox dogsCheck = new JCheckBox("Dogs admitted");
	private JCheckBox bathroomCheck = new JCheckBox("Bathroom in hotel room");
	

	private JButton submitButton;
	private JButton backButton;

	
	public NewLocationFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();


		this.lName = new JLabel("Address :");
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


		this.lNameError = new JLabel("Please insert address.");
		this.lNameError.setForeground(Color.RED);
		this.lNameError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.lNameError, gbc);


		this.lLastName = new JLabel("Location Name:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		this.add(this.lLastName, gbc);


		this.tfLastName = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.tfLastName, gbc);


		this.lLastNameError = new JLabel("Please insert location name.");
		this.lLastNameError.setForeground(Color.RED);
		this.lLastNameError.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.lLastNameError, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.dogsCheck, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.bathroomCheck, gbc);


		this.submitButton = new JButton("Submit");
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(25, 0, 0, 10);

		this.add(this.submitButton, gbc);
		
		submitButton.addActionListener(new EventListeners() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	dispose();
		    }
		});
		
		
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
				MyFrame newframe = new MyFrame();
			}
		});
		
		
		this.pack();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		int control = 0;
		
		lNameError.setVisible(false);
		lLastNameError.setVisible(false);
		
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

		if (control == 0){

		}
	}
	

}
