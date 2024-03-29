package it.uniroma2.db.progetto.guiClass;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.*;

import it.uniroma2.db.boundary.MainMenuBoundary;
import it.uniroma2.db.progetto.guiClass.EventListeners;

public class CheckDBframe extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -902579277770717978L;

	private static final String titolo = "DATABASE";

	private static final JButton buttonBack = new JButton("Back");

	/*------------------------------------------------------------------------------------------------FN5*/

	private static final JButton buttonGalaxyNameSearch= new JButton("Search");
	private static final JLabel hgns = new JLabel("Search by name of galaxy");
	private static final JLabel gns = new JLabel("Name of galaxy");
	private static final JTextField tfgns = new JTextField(20);

	/*------------------------------------------------------------------------------------------------FN6*/

	private static final JButton buttonray= new JButton("Search");
	private static final JLabel ray = new JLabel("Search n galaxies by coordinate");
	private static final JLabel rayn = new JLabel("n = ");;
	private static final JLabel rayrasch = new JLabel("rash = ");
	private static final JLabel rayrascm = new JLabel("rasm = ");
	private static final JLabel rayrascs = new JLabel("rascs = ");
	private static final JLabel raydecsign = new JLabel("decsign = ");
	private static final JLabel raydecmin = new JLabel("decmin = ");
	private static final JLabel raydecsec = new JLabel("decsec = ");
	private static final JLabel raydecdeg = new JLabel("decdeg = ");
	private static final JTextField tfrayn = new JTextField(2);
	private static final JTextField tfrayrasch = new JTextField(2);
	private static final JTextField tfrayrascm = new JTextField(2);
	private static final JTextField tfrayrascs = new JTextField(2);
	private static final JTextField tfraydecsign = new JTextField(2);
	private static final JTextField tfraydecmin = new JTextField(2);
	private static final JTextField tfraydecsec = new JTextField(2);
	private static final JTextField tfraydecdeg = new JTextField(2);

	/*------------------------------------------------------------------------------------------------FN7*/

	private static final JButton buttonrsh= new JButton("Search");
	private static final JLabel rsh = new JLabel("Search by value of redshift");
	private static final JLabel rshn = new JLabel("value of redshift");
	private static final JTextField tfrsh = new JTextField(5);
	private static final String[] alternatives = {"lower than", "more than", "equals"};
	private static final JComboBox<String> redshiftvalue = new JComboBox<String>(alternatives);

	/*------------------------------------------------------------------------------------------------FN8*/



	/*------------------------------------------------------------------------------------------------FN9*/



	/*--------------------------------------------------------------------------------------------------*/

	private static CheckDBframe checkDBControllerInstance = null;

	private CheckDBframe(){
//		System.out.println("00");
	}

	public static CheckDBframe getCheckDBControllerInstance(){
		if( checkDBControllerInstance == null ){
			checkDBControllerInstance = new CheckDBframe();
		}
		return checkDBControllerInstance;
	}

	public void controllerCheckDBframe(int adminuser, JFrame mainWindow){

		mainWindow.getContentPane().removeAll();
		mainWindow.getContentPane().repaint();
		mainWindow.setTitle(titolo);
		mainWindow.setSize(700, 700);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		JPanel fgns = new JPanel();

		/*--------------------------------------------------------------------------------------------------*/

		hgns.setForeground(Color.BLUE);

		fgns.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(hgns, gbc);


		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(gns, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(tfgns, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(buttonGalaxyNameSearch, gbc);



		/*-------------------------------------------------------------------------------------------------------*/

		ray.setForeground(Color.BLUE);


		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(ray, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rayn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(tfrayn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rayrasch, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(tfrayrasch, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rayrascm, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(tfrayrascm, gbc);

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rayrascs, gbc);

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(tfrayrascs, gbc);

		/*--           --              --              --           --*/

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(raydecsign, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(tfraydecsign, gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(raydecmin, gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(tfraydecmin, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(raydecsec, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(tfraydecsec, gbc);

		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(raydecdeg, gbc);

		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(tfraydecdeg, gbc);

		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(buttonray, gbc);

		/*-------------------------------------------------------------------------------------------------------*/

		rsh.setForeground(Color.BLUE);

		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(rsh, gbc);


		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rshn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		fgns.add(redshiftvalue, gbc);

		gbc.gridx = 1;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfrsh, gbc);

		gbc.gridx = 1;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(buttonrsh, gbc);

		/*-------------------------------------------------------------------------------------------------------*/

		gbc.gridx = 4;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		fgns.add(buttonBack, gbc);


		/*-------------------------------------------------------------------------------------------------------*/

		JScrollPane scrollPane = new JScrollPane(fgns);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 30, 300, 50);
		mainWindow.add(scrollPane);

		/*-------------------------------------------------------------------------------------------------------*/

		buttonGalaxyNameSearch.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				if (tfgns.getText().equals(""))
				{
					JLabel panel = new JLabel("You have to insert a String");
					JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
					JOptionPane.showMessageDialog(frame, panel, "Hey!", 0);
				}
				else 
				{
					try {

						new OperationFrame(0, tfgns.getText(), null, null, null, null, null, null, null, 
								null, null, 0, adminuser, null, null, null, null, mainWindow);
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
			}
		});

		buttonray.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				if (tfrayn.getText().equals("") || tfrayrasch.getText().equals("") || tfrayrascm.getText().equals("") || tfrayrascs.getText().equals("") || 
						tfraydecsign.getText().equals("") || tfraydecmin.getText().equals("") || tfraydecsec.getText().equals("") || tfraydecdeg.getText().equals(""))
				{
	
							JLabel panel = new JLabel("You have to insert a String");
							JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
							JOptionPane.showMessageDialog(frame, panel, "Hey!", 0);
				}
				
				else 
				{
					try {
						if (isInteger(tfrayn.getText()) && isInteger(tfrayrasch.getText()) && isInteger(tfrayrascm.getText()) 
								&& isInteger(tfrayrascs.getText()) && isInteger(tfraydecmin.getText()) && isInteger(tfraydecsec.getText()) && isInteger(tfraydecdeg.getText()))
						{
							new OperationFrame(1, tfgns.getText(), tfrayn.getText(), tfrayrasch.getText(), tfrayrascm.getText(), tfrayrascs.getText(), tfraydecsign.getText(),
									tfraydecmin.getText(), tfraydecsec.getText(), tfraydecdeg.getText(), null, 0, adminuser, null, null, null, null, mainWindow);
						} 
						else {
							JLabel panel = new JLabel("You have to insert a Number");
							JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
							JOptionPane.showMessageDialog(frame, panel, "Hey!", 0);
						}
						}catch (Exception e1) {

						e1.printStackTrace();
					}
				}	
			}
		});

		buttonrsh.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				if (tfrsh.getText().equals("") || !(isInteger(tfrsh.getText())))
				{
					JLabel panel = new JLabel("You have to insert a number");
					JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
					JOptionPane.showMessageDialog(frame, panel, "Hey!", 0);
				}
				else 
				{
					if (redshiftvalue.getSelectedItem().toString().contains("more"))
					{
						try {
							new OperationFrame(2, tfgns.getText(), null, null, null, null, null, null, null,
									null, tfrsh.getText(), 1, adminuser, null, null, null, null, mainWindow);
						} catch (Exception e1) {

							e1.printStackTrace();
						}
					}
					if (redshiftvalue.getSelectedItem().toString().contains("lower"))
					{
						try {
							new OperationFrame(2, tfgns.getText(), null, null, null, null, null, null, null,
									null, tfrsh.getText(), 0, adminuser, null, null, null, null, mainWindow);
							dispose();
						} catch (Exception e1) {

							e1.printStackTrace();
						}
					}
					if (redshiftvalue.getSelectedItem().toString().contains("equals"))
					{
						try {
							new OperationFrame(2, tfgns.getText(), null, null, null, null, null, null, 
									null, null, tfrsh.getText(), 2, adminuser, null, null, null, null, mainWindow);
						} catch (Exception e1) {

							e1.printStackTrace();
						}
					}
				}
			}
		});


		buttonBack.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				if (adminuser == 0)
				{	
//					mainWindow.getContentPane().removeAll();
//					mainWindow.getContentPane().repaint();
//					mainWindow.setVisible(false);
					new MainMenuBoundary(0, mainWindow);
				}
				else{
					mainWindow.getContentPane().removeAll();
					mainWindow.getContentPane().repaint();
					mainWindow.setVisible(false);
					new MainMenuBoundary(1, mainWindow);
				}
			}
		});

		/*-------------------------------------------------------------------------------------------------------*/

		mainWindow.setVisible(true);

	}

	public static void main(String[] args) {

		JFrame mainWindow = new JFrame();
		CheckDBframe dbFrame = getCheckDBControllerInstance();
		dbFrame.controllerCheckDBframe(1, mainWindow);
	}


	
	public static boolean isInteger(final String strInput) {
	    boolean ret = true;
	    try {
	        Integer.parseInt(strInput);
	    } catch (final NumberFormatException e) {
	        ret = false;
	    }
	    return ret;
	}
	
	
}



