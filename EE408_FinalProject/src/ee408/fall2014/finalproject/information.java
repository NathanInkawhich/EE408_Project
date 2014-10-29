package ee408.fall2014.finalproject;

import java.awt.*;
import javax.swing.*;


public class information {
	private String fullName;
	private String DOB;
	
	JPanel infoPanel;
	
	JTextField firstName;
	JTextField lastName;

	JComboBox<String> dayDOB;
	JComboBox<String> monthDOB;
	JComboBox<String> yearDOB;

	JButton submit;
	
	String first;
	String last;
	
	public void addComponentsToPane(Container pane){
		String[] days = {
				"1",
				"2",
				"3",
				"4",
				"5",
				"6",
				"7",
				"8",
				"9",
				"10",
				"11",
				"12",
				"13",
				"14",
				"15",
				"16",
				"17",
				"18",
				"19",
				"20",
				"21",
				"22",
				"23",
				"24",
				"25",
				"26",
				"27",
				"28",
				"29",
				"30",
				"31"
		};
		String[] months = {
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December"
		};
		String[] years = {
				"2014",
				"2013",
				"2012",
				"2011",
				"2010",
				"2009",
				"2008",
				"2007",
				"2006",
				"2005",
				"2004",
				"2003",
				"2002",
				"2001",
				"2000",
				"1999",
				"1998",
				"1997",
				"1996",
				"1995",
				"1994",
				"1993",
				"1992",
				"1991",
				"1990",
				"1989",
				"1988",
				"1987",
				"1986",
				"1985",
				"1984",
				"1983",
				"1982",
				"1981",
				"1980"
				// Come back here and add more years if needed
		};
		
		infoPanel = new JPanel(new GridBagLayout());
		submit = new JButton("Submit");
		firstName = new JTextField("", 10);
		lastName = new JTextField("", 10);
		dayDOB = new JComboBox<String>(days);
		monthDOB = new JComboBox<String>(months);
		yearDOB = new JComboBox<String>(years);
	
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel firstNameLabel = new JLabel("First Name: ");
		JLabel lastNameLabel = new JLabel("Last Name: ");
		JLabel dateOfBirth = new JLabel("Date of Birth");
		JLabel dayDOBLabel = new JLabel("Day: ");
		JLabel monthDOBLabel = new JLabel("Month: ");
		JLabel yearDOBLabel = new JLabel("Year: ");

		// Beginning of Info Panel
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		infoPanel.add(firstNameLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		infoPanel.add(firstName, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		infoPanel.add(lastNameLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		infoPanel.add(lastName, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		infoPanel.add(dateOfBirth, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		infoPanel.add(dayDOBLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		infoPanel.add(dayDOB, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		infoPanel.add(monthDOBLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		infoPanel.add(monthDOB, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 6;
		infoPanel.add(yearDOBLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 6;
		infoPanel.add(yearDOB, c);
		
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 7;
		infoPanel.add(submit, c);
		
		pane.add(infoPanel);
		// End of Info Panel		
	}
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Information");
        frame.setPreferredSize(new Dimension(450, 250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        information p = new information();
        //Set up the content pane.
        p.addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	/*
	 * Insert a function that retrieves the values from the first/last name fields, concatenates them and assigns them to fullName variable
	 * Also retrieves day/month/year and concatenates and assigns them to DOB variable  
	 */
	
	public String getFullName(){
		return this.fullName;
	}
	
	public String getDOB(){
		return this.DOB;
	}
	
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
