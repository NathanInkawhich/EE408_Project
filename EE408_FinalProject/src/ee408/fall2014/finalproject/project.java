package ee408.fall2014.finalproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
 
public class project implements ActionListener {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    JPanel cards;
    final static String RESUMEPANEL = "RESUME SCREEN";
    final static String RESULTSPANEL = "RESULTS SCREEN";
	//final static String ENGINEERINGPANEL = "ENGINEERING QUESTIONNAIRE";
	//final static String MANUALLABORPANEL = "MANUAL LABOR QUESTIONNAIRE";
	//final static String HEALTHCAREPANEL = "HEALTHCARE QUESTIONNAIRE";
	//final static String BUSINESSPANEL = "BUSINESS QUESTIONNAIRE";
	
	String resumeFilePath;
	
	ArrayList<JobPosting> jobsList = new ArrayList<JobPosting>();
	String [] companyNames = {"IBM","Birnie Bus","Emerson's Landscaping"};
	String [] jobDescriptions = {"We work on computers","We give people rides","We cut grass"};
	boolean [] jobTimes = {true,true,false};
	String [] jobTypes = {"Engineering", "Business", "Manual Labor"};
	ArrayList<Set<String>> keywordList = new ArrayList<Set<String>>();
	
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
 
    public void addComponentsToPane(Container pane) {
    	
    	
		//*******************INITIALIZE DATABASE
		HashSet<String> IBMKeys = new HashSet<String>();
		IBMKeys.add("computers");
		IBMKeys.add("mainframes");
		IBMKeys.add("coffee");
		HashSet<String> BirnieKeys = new HashSet<String>();
		BirnieKeys.add("busses");
		BirnieKeys.add("transportation");
		BirnieKeys.add("travel");
		HashSet<String> EmersonKeys = new HashSet<String>();
		EmersonKeys.add("trees");
		EmersonKeys.add("grass");
		EmersonKeys.add("lawnmowers");
		
		keywordList.add(IBMKeys);
		keywordList.add(BirnieKeys);
		keywordList.add(EmersonKeys);
		
		for(int i = 0; i<companyNames.length; i++){
			JobPosting jp = new JobPosting(companyNames[i],jobDescriptions[i], jobTimes[i], jobTypes[i], keywordList.get(i));
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
    	
    //Set up resume Panel***********************
    	resumePanel = new JPanel(new GridBagLayout());//Panel to store the resume stuff
    	GridBagConstraints c = new GridBagConstraints();
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
        topLevelPanel.add(submitPanel);
      //End resume Panel***********************
        
      //FOR RESULTS CARD
        resultsPanel = new JPanel();
      
        numberOneMatchField = new JTextField("NUMBER ONE RESULT GOES HERE", 20);
        backToResumePanelButton = new JButton("< Back");
        backToResumePanelButton.addActionListener(this);
        resultsPanel.add(numberOneMatchField);
        resultsPanel.add(backToResumePanelButton);
        /*
        //Start of card two
        JPanel engineeringCard = new JPanel();
        JLabel engineeringLabel1 = new JLabel("This is the ENGINEERING panel");
        engineeringCard.add(engineeringLabel1);
      //Start of card three
        JPanel manualLaborCard = new JPanel();
        JLabel manualLaborLabel1 = new JLabel("This is the MANUAL LABOR panel");
        manualLaborCard.add(manualLaborLabel1);
      //Start of card four
        JPanel healthCareCard = new JPanel();
        JLabel healthCareLabel1 = new JLabel("This is the HEALTHCARE panel");
        healthCareCard.add(healthCareLabel1);
      //Start of card five
        JPanel businessCard = new JPanel();
        JLabel businessLabel1 = new JLabel("This is the BUSINESS panel");
        businessCard.add(businessLabel1);
        */
        
        cards = new JPanel(new CardLayout());
		cards.add(topLevelPanel,RESUMEPANEL);
		cards.add(resultsPanel, RESULTSPANEL);
		//cards.add(engineeringCard,ENGINEERINGPANEL);
		//cards.add(manualLaborCard,MANUALLABORPANEL);
		//cards.add(healthCareCard,HEALTHCAREPANEL);
		//cards.add(businessCard,BUSINESSPANEL);
        //Add topLevelPane to the container
        //pane.add(topLevelPanel);
		pane.add(cards);
    
    }
    public void actionPerformed(ActionEvent e) {
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
		if(e.getSource().equals(submitResumePanelButton)){
			
			//PARSE THE RESUME
				TextFileParser tfp = new TextFileParser();
				Set<String> temp = tfp.parseTextFile(resumeFilePath);
				System.out.println("\n\n*********PARSE THE RESUME***************");
				System.out.println("These are all of the unique words in the input resume: ");
				tfp.printSet(temp);
			//END RESUME PARSING
			
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, RESULTSPANEL);
			/*
			if(areaOfInterestBox.getSelectedItem().equals("Engineering")){
			//CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, ENGINEERINGPANEL);
			}
			if(areaOfInterestBox.getSelectedItem().equals("Manual Labor")){
				//CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, MANUALLABORPANEL);
				}
			if(areaOfInterestBox.getSelectedItem().equals("Health Care")){
				//CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, HEALTHCAREPANEL);
				}
			if(areaOfInterestBox.getSelectedItem().equals("Business")){
				//CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, BUSINESSPANEL);
				}
				*/
		}
		if(e.getSource().equals(backToResumePanelButton)){
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, RESUMEPANEL);
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
}
