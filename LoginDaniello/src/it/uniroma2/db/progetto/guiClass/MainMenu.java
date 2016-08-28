package it.uniroma2.db.progetto.guiClass;

import javax.swing.*;

import it.uniroma2.db.progetto.guiClass.EventListeners;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5374772073176018844L;

	private static final String titolo = "Welcome!";
	private static final JButton buttonCheck = new JButton("Check Database");

	private static final JButton buttonCsv = new JButton("Import .CSV file");

	private static final JButton buttonExit = new JButton("Exit");


	public MainMenu(){
		super(titolo); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 15, 15);


		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(buttonCheck, gbc);

		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(buttonCsv, gbc);

		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(buttonExit, gbc);		


		buttonExit.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});

		buttonCsv.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) 
				{
					File selectedFile = fileChooser.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());
					JLabel panel = new JLabel("File imported");
					JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
					JOptionPane.showMessageDialog(frame, panel, "It's all right", 1);
				}
				else
				{
					JLabel panel = new JLabel("error");
					JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
					JOptionPane.showMessageDialog(frame, panel, "Hey!", 0);
				}
			}
		});

		buttonCheck.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				new CheckDBframe();
				dispose();
			}
		});


		this.pack();
		this.setVisible(true);
	}

	int i = 0;

}
