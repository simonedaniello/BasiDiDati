package Frames;

import javax.swing.*;

public class CheckDBframe extends JFrame{
	private static final String titolo = "DATABASE";
	
	/*------------------------------------------------------------------------------------------------FN5*/
	
	private static final JButton buttongns= new JButton("Search");
	private static final JLabel gns = new JLabel("Search by name of galaxy");
	private static final JLabel hgns = new JLabel("Name of galaxy");
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
	private static final JComboBox redshiftvalue = new JComboBox(alternatives);
	
	/*------------------------------------------------------------------------------------------------FN8*/
	
	private static final JButton buttonflx= new JButton("Search");
	private static final JLabel flx = new JLabel("Search flux");
	private static final JLabel hflx = new JLabel("name of galaxy");
	private static final JTextField tfflx = new JTextField(20);	
	
	/*------------------------------------------------------------------------------------------------FN8*/
	
	private static final JButton buttonrr= new JButton("Ratio between fluxes");
	private static final JLabel rr = new JLabel("Search flux");
	private static final JLabel hr = new JLabel("name of galaxy");
	private static final JTextField tfrr = new JTextField(20);
	
	
}
