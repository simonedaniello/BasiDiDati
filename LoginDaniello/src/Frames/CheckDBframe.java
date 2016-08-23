package Frames;

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
	private static final JComboBox redshiftvalue = new JComboBox(alternatives);
	
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		/*--------------------------------------------------------------------------------------------------*/
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(10, 0, 0, 10);
		mainpanel.add(hgns, gbc);
		
		
		//mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.LINE_AXIS));		
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10, 0, 0, 10);
		mainpanel.add(gns, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		mainpanel.add(tfgns, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 0, 10);
		mainpanel.add(buttongns);
		
		mainpanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		/*--------------------------------------------------------------------------------------------------*/
		
		JPanel coordinate = new JPanel();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.add(mainpanel);
		this.setVisible(true);
		
	}
	
	
}
