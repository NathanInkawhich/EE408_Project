package ee408.fall2014.finalproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
 
public class project implements ActionListener, MouseListener {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    JPanel cards;
    final static String RESUMEPANEL = "RESUME SCREEN";
    final static String RESULTSPANEL = "RESULTS SCREEN";
    final static String INFOPANEL = "INFO SCREEN";
	
	String resumeFilePath;
	
	ArrayList<JobPosting> jobsList = new ArrayList<JobPosting>();
	String [] companyNames = {"IBM","Birnie Bus","Emerson's Landscaping", "Boeing", "Google"};
	String [] jobDescriptions = {
			
			
			"The newly launched IBM Services Center"
			+ "s in Baton Rouge and East Lansing have "
			+ "immediate opportunities for a forward '"
			+ "thinking PeopleSoft Developer with a passion for growth and innovation."
			+ "Join our team and utilize leading-edge technology to develop and deliver "
			+ "next generation applications for"
			+ "Mobile, Big Data, Cloud Computing and Smarter Commerce to our clients."
			+ "You will be able to gain valuable on the job training while building in-demand technical skills."
			+ " Our clients are some of the world�s leading companies and you will be part of challenging"
			+ "projects to build and support technical solutions for their needs." , 

			"We give people rides",
			"We cut grass", 
			"We fly planes", 
			"We are the internet"};
	boolean [] jobTimes = {true,true,false, true, true};
	String [] jobTypes = {"Engineering", "Business", "Manual Labor", "Engineering", "Engineering"};
	ArrayList< Set<String> > keywordList = new ArrayList<Set<String>>();
	String [] jobURL = {"http://ibm.jobs/","http://www.birniebus.com/","http://www.amarallandscaping.com/","http://www.boeing.com/boeing/","https://www.google.com/"};
	
    JPanel topLevelPanel = new JPanel();
    //For Resume Panel
    JPanel resumePanel;
    JTextField resumeField;
    JButton browseResumeButton;
    //For College Panel
    JPanel educationPanel;
    JComboBox levelOfEducationBox;
    JTextField schoolField;
    JTextField yearOfGradField;
    JTextField majorField;
    String[] edLevel = {"No Degree","High School", "Associates", "Bachelors", "Masters", "Doctorate"};
    //For radio buttons
    JPanel typeOfPositionPanel;
    JRadioButton fullTimeButton;
    JRadioButton partTimeButton;
    //For Skills Panel
    JPanel skillsPanel;
    JTextArea skillsArea;
    //Submit panel, with field select
    JPanel submitPanel;
    JComboBox areaOfInterestBox;
    String[] jobCategories = {"Health Care","Engineering","Manual Labor","Business"};
    JButton submitResumePanelButton;
    //For results panel
    JPanel resultsPanel;
    JTextField numberOneMatchField;
    JButton backToResumePanelButton;
    
    JButton jobURL1 = new JButton();
    JButton jobURL2 = new JButton();
    JButton jobURL3 = new JButton();
   
	ArrayList<JobPosting> sortedJobs;
 
    // Info page stuff
	private String fullName;
	private String DOB;
	private String email;
	private String phoneNumber;
	
	JPanel infoPanel;
	
	JTextField firstName;
	JTextField middleName;
	JTextField lastName;

	JTextField emailField;
	JTextField phoneNumberField;
	
	JComboBox<String> dayDOB;
	JComboBox<String> monthDOB;
	JComboBox<String> yearDOB;

	JButton submit;
	
	String first;
	String middle;
	String last;
	String day;
	String month;
	String year;
    // End of Info page stuff
    JButton clearInfoButton;
	JButton backToInfoButton;
    
	 User currentUser1;//This represents the user who is filling out the application
	 
	 User currentUser;//This represents the user who is filling out the application
	 
    public void addComponentsToPane(Container pane) {
    	
    	
		//*******************INITIALIZE DATABASE
		HashSet<String> IBMKeys = new HashSet<String>();
		IBMKeys.add("IBM");
		IBMKeys.add("computers");
		IBMKeys.add("mainframes");
		IBMKeys.add("coffee");
		HashSet<String> BirnieKeys = new HashSet<String>();
		BirnieKeys.add("Birnie Bus");
		BirnieKeys.add("busses");
		BirnieKeys.add("transportation");
		BirnieKeys.add("travel");
		HashSet<String> EmersonKeys = new HashSet<String>();
		EmersonKeys.add("Emerson's Landscaping");
		EmersonKeys.add("trees");
		EmersonKeys.add("grass");
		EmersonKeys.add("lawnmowers");
		HashSet<String> BoeingKeys = new HashSet<String>();
		BoeingKeys.add("Boeing");
		BoeingKeys.add("airplane");
		BoeingKeys.add("flying");
		BoeingKeys.add("computers");
		HashSet<String> GoogleKeys = new HashSet<String>();
		GoogleKeys.add("Google");
		GoogleKeys.add("computers");
		GoogleKeys.add("java");
		GoogleKeys.add("program");
		GoogleKeys.add("C++");
		
		keywordList.add(IBMKeys);
		keywordList.add(BirnieKeys);
		keywordList.add(EmersonKeys);
		keywordList.add(BoeingKeys);
		keywordList.add(GoogleKeys);
		
		

	    jobURL1.addActionListener(this);
	    jobURL2.addActionListener(this);
	    jobURL3.addActionListener(this);
	    
	    jobURL1.addMouseListener(this);
	    jobURL2.addMouseListener(this);
	    jobURL3.addMouseListener(this);
		
		for(int i = 0; i<companyNames.length; i++){
			JobPosting jp = new JobPosting(companyNames[i],jobDescriptions[i], jobTimes[i], jobTypes[i], keywordList.get(i),jobURL[i]);
			jobsList.add(jp);
		}
		
		for(int j = 0; j<jobsList.size();j++){
			JobPosting temp = jobsList.get(j);
			System.out.println("**********");
			System.out.println(temp.getCompanyName());
			System.out.println(temp.getJobDescription());
			System.out.println(temp.getFullTime());
			System.out.println(temp.getJobType());
			System.out.print("Company Keywords: ");
			HashSet<String> tempKeys = temp.getKeywords();
			Iterator<String> itr = tempKeys.iterator();
			while(itr.hasNext()){
				System.out.print(itr.next()+" ");
			}
			System.out.println();
		}
		//************************************END DATABASE
    	
		//FOR INFO PANEL&&&&&&&&&&&&&&&&&&
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
		submit.addActionListener(this);
		firstName = new JTextField("", 10);
		lastName = new JTextField("", 10);
		middleName = new JTextField("", 10);
		dayDOB = new JComboBox<String>(days);
		monthDOB = new JComboBox<String>(months);
		yearDOB = new JComboBox<String>(years);
		emailField = new JTextField("", 10);
		phoneNumberField = new JTextField("", 10);
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel firstNameLabel = new JLabel("First Name: ");
		JLabel lastNameLabel = new JLabel("Last Name: ");
		JLabel middleNameLabel = new JLabel("Middle Name: ");
		JLabel dateOfBirth = new JLabel("Date of Birth");
		JLabel dayDOBLabel = new JLabel("Day: ");
		JLabel monthDOBLabel = new JLabel("Month: ");
		JLabel yearDOBLabel = new JLabel("Year: ");
		JLabel emailLabel = new JLabel("Email: ");
		JLabel phoneLabel = new JLabel("Phone Number: ");
		
		clearInfoButton = new JButton("Clear");
		clearInfoButton.addActionListener(this);
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
		infoPanel.add(middleNameLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		infoPanel.add(middleName, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		infoPanel.add(lastNameLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		infoPanel.add(lastName, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		infoPanel.add(dateOfBirth, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		infoPanel.add(dayDOBLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		infoPanel.add(dayDOB, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 6;
		infoPanel.add(monthDOBLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 6;
		infoPanel.add(monthDOB, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 7;
		infoPanel.add(yearDOBLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 7;
		infoPanel.add(yearDOB, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 8;
		infoPanel.add(emailLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 8;
		infoPanel.add(emailField, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 9;
		infoPanel.add(phoneLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 9;
		infoPanel.add(phoneNumberField, c);
		
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 10;
		infoPanel.add(submit, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 10;
		infoPanel.add(clearInfoButton, c);
		
		
		
		//END INFO PANEL%%%%%%%%%%%%%%%%%%%
		
		backToInfoButton = new JButton("< Back");
		
    //Set up resume Panel***********************
    	resumePanel = new JPanel(new GridBagLayout());//Panel to store the resume stuff
    	c = new GridBagConstraints();
    	//resumePanel.setPreferredSize(new Dimension(100,100));
    	JLabel resumeLabel= new JLabel("Upload your resume here:");
    	c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        resumePanel.add(resumeLabel, c);
        
    	resumeField = new JTextField(40);
    	resumeField.setEditable(false);
    	c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        resumePanel.add(resumeField, c);
    	
    	browseResumeButton = new JButton("Browse...");
    	browseResumeButton.addActionListener(this);
    	c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        resumePanel.add(browseResumeButton, c);
        resumePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    	topLevelPanel.add(resumePanel);
    	
    //For college panel***********************
    	educationPanel= new JPanel(new GridLayout(0,2));
    	JLabel college1 = new JLabel("Choose your highest level of education          ");
        levelOfEducationBox = new JComboBox(edLevel);
        levelOfEducationBox.addActionListener(this);
        JLabel college2 = new JLabel("Name of the school");
        schoolField = new JTextField();
        JLabel college3 = new JLabel("Year of graduation");
        yearOfGradField = new JTextField();//Should format this to only take integers between a certain range
        JLabel college4 = new JLabel("Official Degree Title");
        majorField = new JTextField();
        educationPanel.add(college1);
        educationPanel.add(levelOfEducationBox);
        educationPanel.add(college2);
        educationPanel.add(schoolField);
        educationPanel.add(college3);
        educationPanel.add(yearOfGradField);
        educationPanel.add(college4);
        educationPanel.add(majorField);
        educationPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        topLevelPanel.add(educationPanel);
        
    //For type of position (FT/PT)**************
        typeOfPositionPanel = new JPanel();
        JLabel positionLabel = new JLabel("What type of Position are you looking for:");
        fullTimeButton = new JRadioButton("Full Time");
        fullTimeButton.setSelected(true);
        partTimeButton = new JRadioButton("Part Time");
        ButtonGroup group = new ButtonGroup();
        group.add(fullTimeButton);
        group.add(partTimeButton);
        typeOfPositionPanel.add(positionLabel);
        typeOfPositionPanel.add(fullTimeButton);
        typeOfPositionPanel.add(partTimeButton);
        topLevelPanel.add(typeOfPositionPanel);
        
    //For Skills Area
        skillsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints s = new GridBagConstraints();
        JLabel skillsLabel1 = new JLabel("Enter your skills here.");
        s.fill = GridBagConstraints.VERTICAL;
        s.weightx = 0.5;
        s.gridx = 0;
        s.gridy = 0;
        skillsPanel.add(skillsLabel1,s);
        JLabel skillsLabel2 = new JLabel("Please enter them as a comma separated list");
        s.fill = GridBagConstraints.VERTICAL;
        s.weightx = 0.5;
        s.gridx = 0;
        s.gridy = 1;
        skillsPanel.add(skillsLabel2,s);
        JLabel skillsLabel3 = new JLabel("(i.e. Microsoft Word, Matlab, cooking, etc...)");
        s.fill = GridBagConstraints.VERTICAL;
        s.weightx = 0.5;
        s.gridx = 0;
        s.gridy = 2;
        skillsPanel.add(skillsLabel3,s);
        skillsArea = new JTextArea();
        skillsArea.setColumns(30);
        skillsArea.setRows(3);
        skillsArea.setLineWrap(true);
        skillsArea.setWrapStyleWord(true);
        JScrollPane jsp = new JScrollPane(skillsArea);
        s.fill = GridBagConstraints.VERTICAL;
        s.weightx = .5;
        s.gridx = 0;
        s.gridy = 3;
        skillsPanel.add(jsp,s);
        topLevelPanel.add(skillsPanel);
        //For submit panel
        submitPanel = new JPanel(new GridBagLayout());
        GridBagConstraints a = new GridBagConstraints();
        JLabel submitLabel1 = new JLabel("Choose your area of interest:         ");
        a.fill = GridBagConstraints.VERTICAL;
        a.weightx = 0.5;
        a.gridx = 0;
        a.gridy = 0;
        submitPanel.add(submitLabel1,a);
        areaOfInterestBox = new JComboBox(jobCategories);
        areaOfInterestBox.addActionListener(this);
        a.fill = GridBagConstraints.VERTICAL;
        a.weightx = 0.5;
        a.gridx = 1;
        a.gridy = 0;
        submitPanel.add(areaOfInterestBox,a);
        JLabel nullLabel = new JLabel(" ");
        a.fill = GridBagConstraints.VERTICAL;
        a.weightx = 0.5;
        a.gridx = 0;
        a.gridy = 1;
        submitPanel.add(nullLabel,a);
        submitResumePanelButton = new JButton("Submit");
        submitResumePanelButton.addActionListener(this);
        a.fill = GridBagConstraints.VERTICAL;
        a.weightx = 0.5;
        a.gridx = 0;
        a.gridy = 2;
        a.gridwidth = 2;
        submitPanel.add(submitResumePanelButton,a);
        
        a.weightx = 0.5;
        a.gridx = 0;
        a.gridy = 3;
        backToInfoButton.addActionListener(this);
        submitPanel.add(backToInfoButton, a);
        
        topLevelPanel.add(submitPanel);
      //End resume Panel***********************
        
        
      //FOR RESULTS CARD
        resultsPanel = new JPanel(new GridBagLayout());
        
        cards = new JPanel(new CardLayout());
        cards.add(infoPanel,INFOPANEL);
		cards.add(topLevelPanel,RESUMEPANEL);
		cards.add(resultsPanel, RESULTSPANEL);
	
		pane.add(cards);
    
    }
    public void actionPerformed(ActionEvent e) {
    
    //###############
		if (e.getSource().equals(browseResumeButton)) {
			FileFilter filter = new FileNameExtensionFilter("TextFile", "txt");
	        JFileChooser chooser = new JFileChooser();
	        //chooser.addChoosableFileFilter(filter);
	        chooser.setFileFilter(filter);
	        
	        int returnVal = chooser.showOpenDialog(null);
	        
	        if(returnVal == JFileChooser.APPROVE_OPTION){
	            
	            File myFile = chooser.getSelectedFile();
	            String text = myFile + "";
	            
	            resumeField.setText(text);
	            resumeFilePath = text;
	            System.out.println("File path to resume: " + resumeFilePath);
	        }
		}
	//###############	
		if(e.getSource().equals(submitResumePanelButton)){
			
			//PARSE THE RESUME
			if(resumeFilePath!=null){
				TextFileParser tfp = new TextFileParser();
				Set<String> temp = tfp.parseTextFile(resumeFilePath);
				
				currentUser1.setUserKeywords( temp );
				currentUser1.setAreaOfInterest( (String)areaOfInterestBox.getSelectedItem() );
				currentUser1.setFullTime( fullTimeButton.isSelected() );
				currentUser1.setLevelOfEducation( (String)levelOfEducationBox.getSelectedItem() );
				
				currentUser1.printUserInfo();
				Scoring score = new Scoring();
				sortedJobs = score.findBestMatches(currentUser1, jobsList);

				GridBagConstraints gbc = new GridBagConstraints();
				
				JLabel companyOneLabel = new JLabel("1. " + sortedJobs.get(0).getCompanyName());
				companyOneLabel.setFont(new Font("Serif",Font.BOLD,22));
				companyOneLabel.setForeground(Color.red);
				
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.gridx = 0;
				gbc.gridy = 0;
		        
		        resultsPanel.add(companyOneLabel,gbc);
		        
		        jobURL1.setText(sortedJobs.get(0).getURL());
		        
		        jobURL1.setBorderPainted(false);
		        jobURL1.setOpaque(false);
		        jobURL1.setBackground(Color.WHITE);
		        jobURL1.setFont(new Font("Serif",Font.ITALIC,18));
		        jobURL1.setForeground(Color.blue);
		        
				gbc.fill = GridBagConstraints.NONE;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.gridx = 1;
				gbc.gridy = 0;
				
				resultsPanel.add(jobURL1,gbc);
				
				JTextArea jobDesc1 = new JTextArea(sortedJobs.get(0).getJobDescription());
				jobDesc1.setLineWrap(true);
				jobDesc1.setEditable(false);
				JScrollPane scroll1 = new JScrollPane(jobDesc1);
				scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);				
				
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 3;
				gbc.weighty = 3;
				gbc.gridx = 0;
				gbc.gridy = 1;	 
				gbc.gridwidth = 2;
				
				resultsPanel.add(scroll1,gbc);
				
				JLabel companyTwoLabel = new JLabel("2. " + sortedJobs.get(1).getCompanyName());
				companyTwoLabel.setFont(new Font("Serif",Font.BOLD,22));
				companyTwoLabel.setForeground(Color.blue);
				
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.gridx = 0;
				gbc.gridy = 2;
		        
		        resultsPanel.add(companyTwoLabel,gbc);
		        
		        jobURL2.setText(sortedJobs.get(1).getURL());
		        
		        jobURL2.setBorderPainted(false);
		        jobURL2.setOpaque(false);
		        jobURL2.setBackground(Color.WHITE);
		        jobURL2.setFont(new Font("Serif",Font.ITALIC,18));
		        jobURL2.setForeground(Color.blue);
		        
				gbc.fill = GridBagConstraints.NONE;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.gridx = 1;
				gbc.gridy = 2;
				
				resultsPanel.add(jobURL2,gbc);
				
				JTextArea jobDesc2 = new JTextArea(sortedJobs.get(1).getJobDescription());
				jobDesc2.setLineWrap(true);
				jobDesc2.setEditable(false);
				JScrollPane scroll2 = new JScrollPane(jobDesc2);
				scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				
				
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 3;
				gbc.weighty = 3;
				gbc.gridx = 0;
				gbc.gridy = 3;	 
				gbc.gridwidth = 2;
				
				resultsPanel.add(scroll2,gbc);
				
				JLabel companyThreeLabel = new JLabel("3. " + sortedJobs.get(2).getCompanyName());
				companyThreeLabel.setFont(new Font("Serif",Font.BOLD,22));
				companyThreeLabel.setForeground(Color.BLACK);
				
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.gridx = 0;
				gbc.gridy = 4;
		        
		        resultsPanel.add(companyThreeLabel,gbc);
		        
		        jobURL3.setText(sortedJobs.get(2).getURL());
		        
		        jobURL3.setBorderPainted(false);
		        jobURL3.setOpaque(false);
		        jobURL3.setBackground(Color.WHITE);
		        jobURL3.setFont(new Font("Serif",Font.ITALIC,18));
		        jobURL3.setForeground(Color.blue);
		        
				gbc.fill = GridBagConstraints.NONE;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.gridx = 1;
				gbc.gridy = 4;
				
				resultsPanel.add(jobURL3,gbc);
				
				JTextArea jobDesc3 = new JTextArea(sortedJobs.get(2).getJobDescription());
				jobDesc3.setLineWrap(true);
				jobDesc2.setEditable(false);
				JScrollPane scroll3 = new JScrollPane(jobDesc3);
				scroll3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scroll3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				
				
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 3;
				gbc.weighty = 3;
				gbc.gridx = 0;
				gbc.gridy = 5;	 
				gbc.gridwidth = 2;
				
				resultsPanel.add(scroll3,gbc);
						        
		        
		        backToResumePanelButton = new JButton("< Back");
		        backToResumePanelButton.addActionListener(this);
		        
				
				gbc.fill = GridBagConstraints.NONE;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.gridx = 1;
				gbc.gridy = 6;	 
				gbc.gridwidth = 1;

		        resultsPanel.add(backToResumePanelButton,gbc);
				
				
		        
				
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, RESULTSPANEL);
			}
			else {
//				JFrame frame = new JFrame();
				System.out.println("No File selected...");
				JOptionPane.showMessageDialog(null, "No File Selected.");
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, RESUMEPANEL);
			}
		}
		
		if(e.getSource().equals(jobURL1))
		{
		     try {
				Desktop.getDesktop().browse(java.net.URI.create(sortedJobs.get(0).getURL()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		if(e.getSource().equals(jobURL2))
		{
		     try {
				Desktop.getDesktop().browse(java.net.URI.create(sortedJobs.get(1).getURL()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if(e.getSource().equals(jobURL3))
		{
		     try {
				Desktop.getDesktop().browse(java.net.URI.create(sortedJobs.get(2).getURL()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
				
//				currentUser.setUserKeywords( temp );
//				currentUser.setAreaOfInterest( (String)areaOfInterestBox.getSelectedItem() );
//				currentUser.setFullTime( fullTimeButton.isSelected() );
//				currentUser.setLevelOfEducation( (String)levelOfEducationBox.getSelectedItem() );
//				
//				currentUser.printUserInfo();
//				Scoring score = new Scoring();
//				ArrayList<JobPosting> sortedJobs = score.findBestMatches(currentUser, jobsList);
//				//System.out.println("\n\n*********PARSE THE RESUME***************");
//				//System.out.println("These are all of the unique words in the input resume: ");
//				//tfp.printSet(temp);
//			//END RESUME PARSING
			
		
	//###############	
		if(e.getSource().equals(backToResumePanelButton)){
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, RESUMEPANEL);
		}
	//###############
//		if(e.getSource().equals(submit)){//information panel submit button
//			
//			currentUser1 = new User();//Initialize user object here because this is the first stage in the application process
//			
//			//I DONT THINK THESE VARIABLES NEED GLOBAL SCOPE!!!!!!!!!!!!!
//			
//			this.first = firstName.getText();
//			this.middle = middleName.getText();
//			this.last = lastName.getText();
//			this.fullName = this.first + this.middle + this.last;
//			this.day = (String) dayDOB.getSelectedItem();
//			this.month = (String) monthDOB.getSelectedItem();
//			this.year =  (String) yearDOB.getSelectedItem();
//			this.DOB = this.day + this.month + this.year;
//			this.email = emailField.getText();
//			this.phoneNumber = phoneNumberField.getText();
//	//###############
		if(e.getSource().equals(submit)){//information panel submit button
			
			currentUser1 = new User();//Initialize user object here because this is the first stage in the application process
			
			//I DONT THINK THESE VARIABLES NEED GLOBAL SCOPE!!!!!!!!!!!!!
			 this.first = firstName.getText();
			 this.middle = middleName.getText();
			 this.last = lastName.getText();
			 this.fullName = this.first + this.middle + this.last;
			 this.day = (String) dayDOB.getSelectedItem();
			 this.month = (String) monthDOB.getSelectedItem();
			 this.year =  (String) yearDOB.getSelectedItem();
			 this.DOB = this.day + this.month + this.year;
			 this.email = emailField.getText();
			 this.phoneNumber = phoneNumberField.getText();
			 
			 currentUser1.setFullName(first+ " " + middle + " " + last);
			 
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, RESUMEPANEL);
		}
		if(e.getSource().equals(backToInfoButton)){
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, INFOPANEL);
		}
		if(e.getSource().equals(clearInfoButton)){
			firstName.setText("");
			middleName.setText("");
			lastName.setText("");
			emailField.setText("");
			phoneNumberField.setText("");
//			CardLayout cl = (CardLayout)(cards.getLayout());
//			cl.show(cards, INFOPANEL);
		}
    }
   
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Job Finder");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        project p = new project();
        //Set up the content pane.
        p.addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
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
    
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent mk) {
		if(mk.getSource().equals(jobURL1))
        jobURL1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		if(mk.getSource().equals(jobURL2))
	        jobURL2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		if(mk.getSource().equals(jobURL3))
	        jobURL3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
