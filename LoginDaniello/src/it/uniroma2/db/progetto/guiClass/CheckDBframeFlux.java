
package it.uniroma2.db.progetto.guiClass;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.*;

import it.uniroma2.db.boundary.MainMenuBoundary;
import it.uniroma2.db.progetto.guiClass.EventListeners;

public class CheckDBframeFlux extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -902579277770717978L;

	private static final String titolo = "DATABASE";

	private static final JButton buttonBack = new JButton("Back");

	/*------------------------------------------------------------------------------------------------FN5*/



	/*------------------------------------------------------------------------------------------------FN6*/



	/*------------------------------------------------------------------------------------------------FN7*/

	private static final JButton buttonSpec= new JButton("Search");
	private static final JLabel spec = new JLabel("Search flux");
	private static final JLabel hspec = new JLabel("name of Spectral Classification");
	private static final JLabel hap = new JLabel("Aperture (Optional)");
	private static final JTextField tfap = new JTextField(20);
	private static final JTextField tfspec = new JTextField(20);	

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
	
	/*------------------------------------------------------------------------------------------------FNBOH*/

	private static final JButton buttonI7= new JButton("Calculate");
	private static final JLabel JLi7 = new JLabel("first flux");
	private static final JLabel JLi72 = new JLabel("second flux");
	private static final JLabel JLi73 = new JLabel("Ratio between fluxes (continuous)");
	private static final JTextField tfJLi7 = new JTextField(5);
	private static final JTextField tfJLi72 = new JTextField(5);

	/*--------------------------------------------------------------------------------------------------*/

	private static CheckDBframeFlux checkDBControllerInstance = null;

	private CheckDBframeFlux(){
//		System.out.println("00");
	}

	public static CheckDBframeFlux getCheckDBControllerInstance(){
		if( checkDBControllerInstance == null ){
			checkDBControllerInstance = new CheckDBframeFlux();
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


		fgns.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		

		/*-------------------------------------------------------------------------------------------------------*/

		flx.setForeground(Color.BLUE);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(flx, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(hflx, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfflx, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(buttonflx, gbc);
		

		/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
		
		JLi73.setForeground(Color.BLUE);

		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(JLi73, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(JLi7, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfJLi7, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(JLi72, gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfJLi72, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(buttonI7, gbc);

		/*-------------------------------------------------------------------------------------------------------*/

		hr.setForeground(Color.BLUE);

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(hr, gbc);

		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rrgn, gbc);

		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfrrgr, gbc);

		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rr1, gbc);

		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfrr1, gbc);

		gbc.gridx = 0;
		gbc.gridy =11;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(rr2, gbc);

		gbc.gridx = 1;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfrr2, gbc);


		gbc.gridx = 1;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(buttonrr, gbc);



		/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */

		spec.setForeground(Color.BLUE);

		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.anchor = GridBagConstraints.PAGE_START;
		fgns.add(spec, gbc);

		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(hspec, gbc);

		gbc.gridx = 1;
		gbc.gridy = 14;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfspec, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(hap, gbc);

		gbc.gridx = 1;
		gbc.gridy = 14;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(tfap, gbc);

		gbc.gridx = 1;
		gbc.gridy = 15;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		fgns.add(buttonSpec, gbc);
		
		
		gbc.gridx = 4;
		gbc.gridy = 15;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		fgns.add(buttonBack, gbc);

		/*-------------------------------------------------------------------------------------------------------*/

		JScrollPane scrollPane = new JScrollPane(fgns);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 30, 300, 50);
		mainWindow.add(scrollPane);

		/*-------------------------------------------------------------------------------------------------------*/

		
		buttonflx.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				if (tfflx.getText().equals(""))
				{
					JLabel panel = new JLabel("You have to insert a String");
					JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
					JOptionPane.showMessageDialog(frame, panel, "Hey!", 0);
				}
				else 
				{
					try {
						new OperationFrame(3, tfflx.getText().replaceAll("\\s",""), null, null, null, null, 
								null, null, null, null, null, 0, adminuser, null, null, null, null, mainWindow);
						dispose();
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
			}
		});

		buttonrr.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				if (tfrr1.getText().equals("") || tfrr2.getText().equals("") || tfrrgr.getText().equals(""))
				{
					JLabel panel = new JLabel("You have to insert a String");
					JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
					JOptionPane.showMessageDialog(frame, panel, "Hey!", 0);
				}
				else 
				{
					try {
						new OperationFrame(7, null, null, null, null, null, null, null, null, null, null, 0, adminuser,
								tfJLi7.getText().replaceAll("\\s","") ,tfJLi72.getText().replaceAll("\\s",""), null, null, mainWindow);
						dispose();
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		
		buttonI7.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				if (tfJLi7.getText().equals("") || tfJLi72.getText().equals("") )
				{
					JLabel panel = new JLabel("You have to insert a String");
					JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
					JOptionPane.showMessageDialog(frame, panel, "Hey!", 0);
				}
				else 
				{
					try {
						new OperationFrame(4, null, null, null, null, null, null, null, null, null, null, 0, adminuser,
								tfrr1.getText().replaceAll("\\s","") ,tfrr2.getText().replaceAll("\\s",""), null, null, mainWindow);
						dispose();
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		
		buttonSpec.addActionListener(new EventListeners() {
			public void actionPerformed(ActionEvent e)
			{
				if (tfspec.getText().equals("")  )
				{
					JLabel panel = new JLabel("You have to insert a String");
					JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
					JOptionPane.showMessageDialog(frame, panel, "Hey!", 0);
				}
				else if(tfap.getText().equals(""))
				{
					try {
						new OperationFrame(5, null, null, null, null, null, null, null, null, null, null, 0, adminuser,
								null ,null, null, tfspec.getText(), mainWindow);
						dispose();
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
				else 
				{
					try {
						new OperationFrame(6, null, null, null, null, null, null, null, null, null, null, 0, adminuser,
								null ,null, tfap.getText(), tfspec.getText(), mainWindow);
						dispose();
					} catch (Exception e1) {

						e1.printStackTrace();
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
		CheckDBframeFlux dbFrame = getCheckDBControllerInstance();
		dbFrame.controllerCheckDBframe(1, mainWindow);
	}


}
