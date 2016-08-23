package Frames;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class CheckDBframe extends JFrame{
	private static final String titolo = "DATABASE";
	
	/*------------------------------------------------------------------------------------------------FN5*/
	
	private static final JButton buttongns= new JButton("Search");
	private static final JLabel hgns = new JLabel("Search by name of galaxy");
	private static final JLabel gns = new JLabel("Name of galaxy");
	private static final JTextField tfgns = new JTextField(20);

	/*------------------------------------------------------------------------------------------------FN6*/
	
	private static final JButton buttonray= new JButton("Search");
	private static final JLabel ray = new JLabel("Search n galaxies by coordinate");
	private static final JLabel rayn = new JLabel("n = ");
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
	
	private static final JButton buttonflx= new JButton("Search");
	private static final JLabel flx = new JLabel("Search flux");
	private static final JLabel hflx = new JLabel("name of galaxy");
	private static final JTextField tfflx = new JTextField(20);	
	
	/*------------------------------------------------------------------------------------------------FN9*/
	
	private static final JButton buttonrr= new JButton("Calculate");
	private static final JLabel rr1 = new JLabel("first flux");
	private static final JLabel rr2 = new JLabel("second flux");
	private static final JLabel rrgn = new JLabel("Galaxy name");
	private static final JLabel hr = new JLabel("Ratio between fluxes");
	private static final JTextField tfrr1 = new JTextField(5);
	private static final JTextField tfrr2 = new JTextField(5);
	private static final JTextField tfrrgr = new JTextField(20);

	/*--------------------------------------------------------------------------------------------------*/
	
	public static void main(String[] args) {
	CheckDBframe frame  = new CheckDBframe();
	}
	
	public CheckDBframe(){
		
		super(titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
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
		fgns.add(buttongns, gbc);
		
		
		
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
		
		flx.setForeground(Color.BLUE);

		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(flx, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(hflx, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 14;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfflx, gbc);

		gbc.gridx = 1;
		gbc.gridy = 15;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(buttonflx, gbc);

		/*-------------------------------------------------------------------------------------------------------*/
		
		hr.setForeground(Color.BLUE);

		gbc.gridx = 0;
		gbc.gridy = 16;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(hr, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 17;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rrgn, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 17;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfrrgr, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 18;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rr1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 18;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfrr1, gbc);

		gbc.gridx = 0;
		gbc.gridy = 19;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rr2, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 19;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfrr2, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 20;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(buttonflx, gbc);

		/*-------------------------------------------------------------------------------------------------------*/
		
		
		
		this.add(fgns);
		this.pack();
		this.setVisible(true);
		
		
		

		
	}
	
	
}
