package ee408.fall2014.finalproject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.ActionListener;

public class LoginScreen extends JFrame implements ActionListener {

	JPanel cards; // a panel that uses CardLayout

	final static String LOGINPANEL = "LOGIN SCREEN";
	final static String MESSAGEPANEL = "LOGIN RESULT";
	final static String NEWACCOUNTPANEL = "CREATE NEW ACCOUNT";
	final static String RECOVERY = "ACCOUNT RECOVERY";

	int userCount = 7;

	int securityTest = 0;
	int recoveryTest = 0;
	
	JTextField userName = new JTextField("", 20);
	JTextField recoveryUserName = new JTextField("", 20);
	JTextField recoveryQuestionAnswer = new JTextField("", 20);
	JTextField securityQuestionAnswer2 = new JTextField("", 20);
	JTextField recoveredPassword = new JTextField("", 20);	
	JPasswordField newPassword = new JPasswordField("", 20);
	JPasswordField newPasswordCheck = new JPasswordField("", 20);
	JTextField firstName2 = new JTextField("", 20);
	JTextField lastName2 = new JTextField("", 20);
	JTextField textfield = new JTextField("", 20);
	JPasswordField passfield = new JPasswordField("", 20);
	
	

	JLabel message = new JLabel();
	
	JButton forgotPassword = new JButton("Can't Access Acount");
	JButton submit2 = new JButton("Submit");
	JButton SignIn = new JButton("Sign in");
	JButton NewUser = new JButton("New User?");
	JButton returnToLogin = new JButton("Return To Login Screen");
	JButton submitRecovery = new JButton("Submit");
	JButton returnRecovery = new JButton("Return to Login");
	
	user[] USERS = new user[100];
	

	
	private String username = "";
	private String password = "";
	
	private String formMessage(String firstname, String lastname, boolean authenticate ) {
		String mtext = new String();
		if(authenticate)
		{
		  mtext="Dear "+firstname+" "+lastname+",\n"; 
		  mtext+=  " Welcome!";
		}
		
		return mtext;

	}

	public void addComponentToPane(Container pane) {
			setResizable(false);
			
		
	//STATIC LSIT OF USER NAMES AND PASSWORDS
			String[] initialUsers = { "bkantarci", "jpsartre", "jjoyce", "owilde",
				"pmodiano", "jsaramago", "sbeckett" };
		String[] initialPasswords = { "35912", "26481", "2241", "14501",
				"357912", "15222", "1234" };

		String [] firstnames={"Burak", "Jean Paul", "James", "Oscar", "Patrick", "Jose", "Samuel"};
		String [] lastnames={"Kantarci", "Sartre", "Joyce", "Wilde", "Modiano", "Saramago", "Beckett"};
		
		String[] maidenNames = {"Kantarci", "Sartre", "Joyce", "Wilde", "Modiano", "Saramago", "Beckett"};
		//Define the users
		for (int i = 0; i < 7; i++) {
			{
				USERS[i] = new user(initialUsers[i], initialPasswords[i],maidenNames[i]);
				USERS[i].setName(firstnames[i],lastnames[i]);
			}
			
			
		}



JLabel topLabel = new JLabel();
topLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
topLabel.setForeground(Color.RED);
topLabel.setText("Welcome To Job Finders APP");
JPanel labelpane = new JPanel();
labelpane.add(topLabel);


		

// Create the "cards".
		JPanel card1 = new JPanel();
		message.setForeground(Color.BLUE);
		message.setFont(new Font("Helvetica", Font.ITALIC, 16));	
		card1.add(message);
		card1.add(returnToLogin);

		NewUser.setSize(SignIn.getSize());

		
		JPanel card2 = new JPanel();
		card2.setLayout(new BorderLayout());
		
		SignIn.addActionListener(this);
		NewUser.addActionListener(this);
		returnToLogin.addActionListener(this);
		forgotPassword.addActionListener(this);
		submitRecovery.addActionListener(this);
		returnRecovery.addActionListener(this);
		
		
		JPanel myForm = new JPanel();
		myForm.setLayout(new GridBagLayout());

		GridBagConstraints d = new GridBagConstraints();

		d.gridx = 0;
		d.gridy = 0;
		d.anchor = GridBagConstraints.EAST;

		myForm.add(new JLabel("User Name:"), d);
		d.weightx = 3;
		d.gridx = 1;
		d.gridy = 0;
		myForm.add(textfield, d);

		d.gridx = 0;
		d.gridy = 1;
		d.weightx = 1;
		myForm.add(new JLabel("Password:"), d);

		d.weightx = 3;
	
		d.gridx = 1;
		d.gridy = 1;
		myForm.add(passfield, d);

		card2.add(myForm, BorderLayout.PAGE_START);
		

		d.weightx=1;
		d.fill = 0;
		d.gridx = 1;
		d.gridy = 2;
		d.anchor = GridBagConstraints.WEST;
		JPanel signinpanel = new JPanel();
		signinpanel.add(SignIn,BorderLayout.EAST);
		myForm.add(signinpanel, d);
		
	
		d.gridx = 1;
		d.gridy = 2;
		d.anchor = GridBagConstraints.EAST;
		JPanel newUserPanel = new JPanel();
		newUserPanel.add(NewUser,BorderLayout.WEST);
		myForm.add(newUserPanel,d);
		
		

		d.gridx = 0;
		d.gridy = 2;
		signinpanel.add(SignIn,BorderLayout.EAST);
		JPanel AccesssAccountPanel = new JPanel();
		AccesssAccountPanel.add(forgotPassword,BorderLayout.WEST);
		myForm.add(AccesssAccountPanel,d);
		
		JPanel card3 = new JPanel();
		card3.setLayout(new BorderLayout());
		JPanel newAccountPanel = new JPanel();
		newAccountPanel.setLayout(new GridBagLayout());
			
		d.insets = new Insets(5,5,5,5);
		d.gridx = 0;
		d.gridy = 0;
		d.anchor = GridBagConstraints.EAST;
		newAccountPanel.add(new JLabel("First Name:"), d);
		d.weightx = 3;
		d.gridx = 1;
		d.gridy = 0;

		newAccountPanel.add(firstName2, d);
		
		d.gridx = 0;
		d.gridy = 1;		
		newAccountPanel.add(new JLabel("Last Name:"), d);
		d.weightx = 3;
		d.gridx = 1;
		d.gridy = 1;
		newAccountPanel.add(lastName2, d);
		d.gridx = 0;
		d.gridy = 2;


		newAccountPanel.add(new JLabel("User Name:"), d);
		d.weightx = 3;
		d.gridx = 1;
		d.gridy = 2;
		newAccountPanel.add(userName, d);
		
		d.gridx = 0;
		d.gridy = 3;
		newAccountPanel.add(new JLabel("Password:"), d);
		d.weightx = 3;
		d.gridx = 1;
		d.gridy = 3;
		newAccountPanel.add(newPassword, d);	
		d.gridx = 0;
		d.gridy = 4;
		newAccountPanel.add(new JLabel("Confirm Password:"), d);
		d.weightx = 3;
		d.gridx = 1;
		d.gridy = 4;	
		newAccountPanel.add(newPasswordCheck, d);	
		d.gridx = 0;
		d.gridy = 5;
		newAccountPanel.add(new JLabel("Mother's maiden name "), d);
		d.weightx = 3;
		d.gridx = 1;
		d.gridy = 5;
		newAccountPanel.add(securityQuestionAnswer2,d);
		

		d.gridx = 1;
		d.gridy = 6;
		submit2.addActionListener(this);
		newAccountPanel.add(submit2, d);
		
		card3.add(newAccountPanel, BorderLayout.PAGE_START);
		
		JPanel card4 = new JPanel();
		card4.setLayout(new BorderLayout());
		JPanel recoveryPanel = new JPanel();
		recoveryPanel.setLayout(new GridBagLayout());	
		
		
		d.gridx = 0;
		d.gridy = 0;
		recoveryPanel.add(new JLabel("Username"), d);
		d.gridx = 1;
		d.gridy = 0;
		d.weightx = 3;
		recoveryPanel.add(recoveryUserName,d);
		
		d.gridx = 0;
		d.gridy = 1;
		recoveryPanel.add(new JLabel("Mother's Maiden Name:"), d);
		d.gridx = 1;
		d.gridy = 1;
		d.weightx = 3;
		recoveryPanel.add(recoveryQuestionAnswer,d);
		
		d.gridx = 0;
		d.gridy = 5;
		recoveryPanel.add(new JLabel("Password"), d);
		d.gridx = 1;
		d.gridy = 5;
		recoveryPanel.add(recoveredPassword,d);
		
		d.gridx = 1;
		d.gridy = 4;
		recoveryPanel.add(submitRecovery,d);
		
		d.gridx = 1;
		d.gridy = 6;
		recoveryPanel.add(returnRecovery,d);
		
		
		
		
		
		
		card4.add(recoveryPanel,BorderLayout.PAGE_START);
		// Create the panel that contains the "cards".
		cards = new JPanel(new CardLayout());

		cards.add(card2, LOGINPANEL);
		cards.add(card1, MESSAGEPANEL);
		cards.add(card3, NEWACCOUNTPANEL);
		cards.add(card4, RECOVERY);

		pane.add(labelpane, BorderLayout.PAGE_START);
		pane.add(cards, BorderLayout.CENTER);

	}

	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout) (cards.getLayout());

		cl.show(cards, (String) evt.getItem());

	}

	public int userAuthenticated(String username, String password) {
	
		for(int i = 0; i < user.numOfUsers; i++)
			if(username.equals(USERS[i].username))
				if(password.equals(USERS[i].password))
					return i;

		System.out.println("Failed to authenticate" + password);
		return -1;

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(SignIn)) {

			username = textfield.getText();
			String tempString = new String(passfield.getPassword());
			password = tempString;
			int userindex = userAuthenticated(username, password);
			System.out.println(userindex);
			if(securityTest < 5){
				if (userindex >= 0) 
			
					message.setText(formMessage(USERS[userindex].firstname,USERS[userindex].lastname,true));
				else
				{
					securityTest++;
					message.setText("Login failed: Wrong user name or password!");
				}
			
					CardLayout cl = (CardLayout) (cards.getLayout());
					cl.show(cards, MESSAGEPANEL);
				
			}
		}
		if(e.getSource().equals(NewUser))
		{

			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, NEWACCOUNTPANEL);
			
		}
		if(e.getSource().equals(submit2))
			{
				boolean passwordCheck = false;
				boolean usernameCheck = false;
				String username1 = userName.getText();
				String password = newPassword.getText();
				String password2 = newPasswordCheck.getText();
				String maidenName =  securityQuestionAnswer2.getText();

			
				if(!password.equals(password2)) 			
				{
					passwordCheck = true;
					System.out.println("Passwords not equal");					
				}
							
				for(int i = 0; i < user.numOfUsers;i++)
				{
					if(this.USERS[i].username.equals(username1))
					{
						 usernameCheck = true;
						System.out.println("Usernames equal");
					}
				}
				
				if(usernameCheck == false && passwordCheck == false)
				{
					USERS[userCount] = new user(username1,password,maidenName);
					USERS[userCount].setName(firstName2.getText(), lastName2.getText());
					CardLayout cl2 = (CardLayout) (cards.getLayout());
					cl2.show(cards, LOGINPANEL);
					userCount++;
				}	
			}
			
		if(e.getSource().equals(returnToLogin))
		{
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, LOGINPANEL);	
		}
		
		if(e.getSource().equals(forgotPassword))
		{
			if(recoveryTest < 5)
			{
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, RECOVERY);	
				recoveryTest++;
		}
		}
		
		if(e.getSource().equals(returnRecovery))
		{
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, LOGINPANEL);	
		}
		if(e.getSource().equals(submitRecovery))
		{
			if(recoveryTest < 5)
			{
				String username = recoveryUserName.getText();
				String maidenName =  recoveryQuestionAnswer.getText();
				for(int i = 0; i < user.numOfUsers; i++)
					if(username.equals(USERS[i].username) && maidenName.equals(USERS[i].mothersMaidenName))
						recoveredPassword.setText(USERS[i].password);

			}
		}

	}
		
	

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.

		JFrame frame = new JFrame("Login Screen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setResizable(false);
		// Create and set up the content pane.
		LoginScreen login = new LoginScreen();
		
		login.addComponentToPane(frame.getContentPane());

		// Display the window.

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		/* Use an appropriate Look and Feel */
		try {
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		/* Turn off metal's use of bold fonts */
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}