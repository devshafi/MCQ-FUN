import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface implements ActionListener {
	
	    // declaring frame and container
	    Container container;
	    static JFrame appFrame = new JFrame("Intelligent MCQ Test");
	    
	    TimeCounter timeCounter = new TimeCounter();
	    DigitalClock digitalClock = new DigitalClock();
	    

	    // Declaring and initializing the objects
	    
	    JLabel nameLabel = new JLabel("Enter Your Name : ");
	    JLabel idLabel = new JLabel("Enter Your ID : ");
	    static JTextField nameField = new JTextField();
	    static JTextField idField = new JTextField();
	    
	    JButton enterButton = new JButton("Enter");
	    JButton editButton = new JButton("Edit");
	    
	    JLabel counterLabel = new JLabel("TIMER");
	    JButton startButton = new JButton("Start Exam");	    
	    static JLabel examInProgLabel = new JLabel("EXAM IS IN PROGRESS");
	    static JLabel examEndLabel = new JLabel("Exam Ended");
	    
	    JLabel welcomeLabel = new JLabel("Welcome to the MCQ test program. Test your skill now !");
	    
	    static JButton nextButton = new JButton("NEXT");
	    
	    
	    JLabel questionLabel = new JLabel();
	    JRadioButton optionOne = new JRadioButton();
	    JRadioButton optionTwo = new JRadioButton();
	    JRadioButton optionThree = new JRadioButton();
	    JRadioButton optionFour = new JRadioButton();
	    
	    //dummy radio button
	    JRadioButton optionDummy = new JRadioButton("Dummy");
	    
	    // Declaring button group and initializing it
	    private ButtonGroup buttonGroup = new ButtonGroup();
	    
	    static int count;
	    static int current=0;
	    
	    //main method
	    public static void main(String[] args) {
	    
	    	// use nimbuss look for the interface
	    	try 
	        { 
	            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	        } 
	        catch(Exception e){ 
	        }
	    	
	         new MainInterface();
			
			
	    	}
			
		
	    
	    // empty constructor
	    public MainInterface() {
	    	settingBssicThings();
			setQuestion();
			isTimeOver();

		}
	    
	    
	    //method for initializing objects
	    void settingBssicThings(){
	    	
	    	            timeCounter = new TimeCounter();
	    				// Exit the software when it is closed
	    		        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		        //appFrame.setSize(400,400);
	    				Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\DMALL\\Desktop\\project_icon\\mcq.png");
	    			    appFrame.setIconImage(icon);
	    		       
	    		        // setting the size
	    		        appFrame.setSize(600,400);
	    		        
	    		        // changing the background color
	    		        
	    		        container = appFrame.getContentPane();
	    		        container.setBackground(Color.decode("#669999"));
	    		        
	    		        // appFrame.getContentPane().setBackground(Colo);
	    		        appFrame.setResizable(false);
	    		        appFrame.setLayout(null);
	    		         
	    		        
	    		        
	    		        //setting bound to nameLabel,nameTextField and enter button
	    		        nameLabel.setBounds(50,42,400,25);
	    		        nameLabel.setForeground(Color.WHITE);
	    		        
	    		        //adding icon to nameLabel
	    		        Icon nameIcon = new ImageIcon("H:\\ProjectFolder\\Eclipse Project\\resource\\mcq_test\\name_icon.png");
	    		        nameLabel.setIcon(nameIcon);

	    		        
	    		        nameField.setBounds(190,40,200,25);
	    		        
	    		       
	    		        idLabel.setBounds(50,72,400,20);
	    		        idLabel.setForeground(Color.WHITE);
	    		        
	    		        //adding icon to idLabel
	    		        Icon idIcon = new ImageIcon("H:\\ProjectFolder\\Eclipse Project\\resource\\mcq_test\\student-id-icon.png");
                        idLabel.setIcon(idIcon);
	    		        idField.setBounds(190,70,200,25);
	    		        
	    		        //setting enterButton and editButton
	    		        enterButton.setBounds(188,100,80,25);
	    		        enterButton.addActionListener(this);
	    		        editButton.setBounds(270,100,80,25);
	    		        editButton.addActionListener(this);
	    		        
	    		        
	    		        
	    		        //setting  welcome label
	    		        welcomeLabel.setBounds(120,10,390,20);
	    		        welcomeLabel.setFont(new Font("Sherif",Font.BOLD,14));
	    		        welcomeLabel.setOpaque(true);
	    		        welcomeLabel.setBackground(Color.ORANGE);
	    		        
	    		        // setting bounds for counter label
	    		        counterLabel.setBounds(480,65, 50,20);
	    		        
	    		        // setting bounds for for start Button
	    		        startButton.setBounds(440,150,120,35);
	    		        startButton.setEnabled(false);
	    		        startButton.addActionListener(this);
	    		       
	    		        // setting bounds to exam is in progress label
	    		        examInProgLabel.setBounds(435,55,300,200);
	    		        examInProgLabel.setVisible(false);
	    		        
	    		        examEndLabel.setBounds(465,55,300,200);
	    		        examEndLabel.setForeground(Color.RED);
	    		        examEndLabel.setVisible(false);
	    		        
	    		        //setting bound and selecting question to JLabel (Question label)
	    		        questionLabel.setBounds(50,120,450,40);
	    		        questionLabel.setFont(new Font("",Font.BOLD,12));
	    		        questionLabel.setForeground(Color.WHITE);
	    			    
	    		        //questionLabel.setText(QuestionAndOption.questionList[0]);
	    			    
	    			    // setting bound to all the radio button
	    			    optionOne.setBounds(50,160,300,20);
	    			    optionOne.setForeground(Color.WHITE);
	    			    optionOne.setFont(new Font("",Font.BOLD,13));
	    			    optionOne.setEnabled(false);
	    			    optionTwo.setBounds(50,190,300,20);
	    			    optionTwo.setForeground(Color.WHITE);
	    			    optionTwo.setFont(new Font("",Font.BOLD,13));
	    			    optionTwo.setEnabled(false);
	    			    optionThree.setBounds(50,220,300,20);
	    			    optionThree.setForeground(Color.WHITE);
	    			    optionThree.setFont(new Font("",Font.BOLD,13));
	    			    optionThree.setEnabled(false);
	    			    optionFour.setBounds(50,250,300,20);
	    			    optionFour.setForeground(Color.WHITE);
	    			    optionFour.setFont(new Font("",Font.BOLD,13));
	    			    optionFour.setEnabled(false);
	    			    // adding all the radio button to the button group
	    			    buttonGroup.add(optionOne);
	    			    buttonGroup.add(optionTwo);
	    			    buttonGroup.add(optionThree);
	    			    buttonGroup.add(optionFour);
	    			    buttonGroup.add(optionDummy);
	    			    
	    			    //setting bound to next button
	    			    nextButton.setBounds(190,280,120,40);
	    			    nextButton.addActionListener(this);
	    			    // making nextButton disable before starting exam
	    			    nextButton.setEnabled(false);
	    			    nextButton.setForeground(Color.WHITE);
	    			    nextButton.setBackground(Color.darkGray);
	    			    
	    			   
	    			    
	    			    // adding all the component to the frame
	    			    appFrame.getContentPane().setLayout(null);
	    			    appFrame.getContentPane().add(welcomeLabel);
	    			    appFrame.getContentPane().add(questionLabel);
	    			    appFrame.getContentPane().add(optionOne);
	    			    appFrame.getContentPane().add(optionTwo);
	    			    appFrame.getContentPane().add(optionThree);
	    			    appFrame.getContentPane().add(optionFour);
	    			    appFrame.getContentPane().add(nextButton);
	    			    appFrame.getContentPane().add(nameLabel);
	    			    appFrame.getContentPane().add(nameField);
	    			    appFrame.getContentPane().add(idLabel);
	    			    appFrame.getContentPane().add(idField);
	    			    appFrame.getContentPane().add(enterButton);
	    			    appFrame.getContentPane().add(editButton);
	    			    appFrame.getContentPane().add(counterLabel);
	    			    appFrame.getContentPane().add(timeCounter.counterButton);
	    			    appFrame.getContentPane().add(startButton);
	    			    appFrame.getContentPane().add(examInProgLabel);
	    			    appFrame.getContentPane().add(examEndLabel);
	    			    appFrame.getContentPane().add(digitalClock.clockPanel);
	    			    
	    			    
	    			    
	    			    //making the frame visible
	    		        appFrame.setVisible(true);
	    			    
	    			    // setQuestion();
	    			    
	    			    // isCorrectAnswer();
	    			    
	    			    startingInfo();
	    	
	    }
	    
	    
	    
	    void setQuestion(){
	    	
	    	// making dummy 
	    	optionDummy.setSelected(true);
	    	
	    	if(current==0){
	    		
	    		questionLabel.setText(QuestionAndOption.questionList[0]);
	    		optionOne.setText(QuestionAndOption.optionList1[0]);
	    		optionTwo.setText(QuestionAndOption.optionList1[1]);
	    		optionThree.setText(QuestionAndOption.optionList1[2]);
	    		optionFour.setText(QuestionAndOption.optionList1[3]);
	    	}
	    	
	    	else if(current==1){
	    		questionLabel.setText(QuestionAndOption.questionList[1]);
	    		optionOne.setText(QuestionAndOption.optionList2[0]);
	    		optionTwo.setText(QuestionAndOption.optionList2[1]);
	    		optionThree.setText(QuestionAndOption.optionList2[2]);
	    		optionFour.setText(QuestionAndOption.optionList2[3]);
	    	}
	    	else if(current==2){
	    		questionLabel.setText(QuestionAndOption.questionList[2]);
	    		optionOne.setText(QuestionAndOption.optionList3[0]);
	    		optionTwo.setText(QuestionAndOption.optionList3[1]);
	    		optionThree.setText(QuestionAndOption.optionList3[2]);
	    		optionFour.setText(QuestionAndOption.optionList3[3]);
	    	}
	    	else if(current==3){
	    		questionLabel.setText(QuestionAndOption.questionList[3]);
	    		optionOne.setText(QuestionAndOption.optionList4[0]);
	    		optionTwo.setText(QuestionAndOption.optionList4[1]);
	    		optionThree.setText(QuestionAndOption.optionList4[2]);
	    		optionFour.setText(QuestionAndOption.optionList4[3]);
	    	}
	    	else if(current==4){
	    		questionLabel.setText(QuestionAndOption.questionList[4]);
	    		optionOne.setText(QuestionAndOption.optionList5[0]);
	    		optionTwo.setText(QuestionAndOption.optionList5[1]);
	    		optionThree.setText(QuestionAndOption.optionList5[2]);
	    		optionFour.setText(QuestionAndOption.optionList5[3]);
	    	}
	    	else if(current==5){
	    		questionLabel.setText(QuestionAndOption.questionList[5]);
	    		optionOne.setText(QuestionAndOption.optionList6[0]);
	    		optionTwo.setText(QuestionAndOption.optionList6[1]);
	    		optionThree.setText(QuestionAndOption.optionList6[2]);
	    		optionFour.setText(QuestionAndOption.optionList6[3]);
	    	}
	    	
	    	else if(current==6){
	    		questionLabel.setText(QuestionAndOption.questionList[6]);
	    		optionOne.setText(QuestionAndOption.optionList7[0]);
	    		optionTwo.setText(QuestionAndOption.optionList7[1]);
	    		optionThree.setText(QuestionAndOption.optionList7[2]);
	    		optionFour.setText(QuestionAndOption.optionList7[3]);
	    	}
	    	else if(current==7){
	    		questionLabel.setText(QuestionAndOption.questionList[7]);
	    		optionOne.setText(QuestionAndOption.optionList8[0]);
	    		optionTwo.setText(QuestionAndOption.optionList8[1]);
	    		optionThree.setText(QuestionAndOption.optionList8[2]);
	    		optionFour.setText(QuestionAndOption.optionList8[3]);
	    	}
	    	
	    	else if(current==8){
	    		questionLabel.setText(QuestionAndOption.questionList[8]);
	    		optionOne.setText(QuestionAndOption.optionList9[0]);
	    		optionTwo.setText(QuestionAndOption.optionList9[1]);
	    		optionThree.setText(QuestionAndOption.optionList9[2]);
	    		optionFour.setText(QuestionAndOption.optionList9[3]);
	    	}
	    	else if(current==9){
	    		questionLabel.setText(QuestionAndOption.questionList[9]);
	    		optionOne.setText(QuestionAndOption.optionList10[0]);
	    		optionTwo.setText(QuestionAndOption.optionList10[1]);
	    		optionThree.setText(QuestionAndOption.optionList10[2]);
	    		optionFour.setText(QuestionAndOption.optionList10[3]);
	    	}
	    	
	    	
	    	
	    }
	    
	    // method for checking whether selected answer is right or not
	    boolean isCorrectAnswer(){
	    	
	    	if(current==0){
	    		return optionOne.isSelected();
	    	}
	    	else if(current==1){
	        	return optionFour.isSelected();	
	        }
	    	else if (current==2) {
				return optionTwo.isSelected();
			}
	    	else if(current==3){
	    		return optionThree.isSelected();
	    	}
	    	else if(current==4){
	    		return optionFour.isSelected();
	    	}
	    	else if(current==5){
	    		return optionOne.isSelected();
	    	}
	    	else if(current==6){
	    		return optionThree.isSelected();
	    	}
	    	else if(current==7){
	    		return optionThree.isSelected();
	    	}
	    	else if(current==8){
	    		return optionFour.isSelected();
	    	}
	    	else if(current==9){
	    		return optionFour.isSelected();
	    	}
			return false;
	      }
	    
	    // check whether none of radio button is selected
	    boolean isNoteSelected(){
			
	    	  if(!optionOne.isSelected() && !optionTwo.isSelected() && !optionThree.isSelected() && !optionFour.isSelected())
	    			 return true;
	    	return false;
	    	
	      }

	    
	    // button listener action
	    
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// enter button operation
			if(e.getSource()==enterButton){
				
				
				
				if(!nameField.getText().isEmpty() && !idField.getText().isEmpty()){
				
					nameField.setFocusable(false);
					idField.setFocusable(false);
					startButton.setEnabled(true);
					
				}
				
				else {
					JOptionPane.showMessageDialog(appFrame,"Name or ID may not be given !","Missing Name or ID",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
			
			
			//actions for edit button
			else if(e.getSource()==editButton){
			  
				nameField.setFocusable(true);
				idField.setFocusable(true);
				startButton.setEnabled(false);
				
			}
			
			//start button operation
			else if(e.getSource()==startButton){
				 
				 
				//making necessary objects visible and enabled
				
				optionOne.setEnabled(true);
				optionTwo.setEnabled(true);
				optionThree.setEnabled(true);
				optionFour.setEnabled(true);
				 
			    startButton.setVisible(false);
				examInProgLabel.setVisible(true);
				nextButton.setEnabled(true);
				timeCounter.t.start();
				 
			 }
			
			
			// checking whether nameField or idField is blank or not
			else if(nameField.getText().isEmpty() || idField.getText().isEmpty()){
				
				JOptionPane.showMessageDialog(appFrame,"Name or ID may not be given !","Missing Name or ID",JOptionPane.WARNING_MESSAGE);
			}
			
			else{
				
				//checking whether none of radio button is selected
				if(isNoteSelected()){
					JOptionPane.showMessageDialog(appFrame,"You didn't choose any option :(");
				}
				
				// else goto next question
				else {
					
					if(e.getSource()==nextButton){
						
						
					    if(isCorrectAnswer()){
							
							
							count++;
						}
						current++;
						setQuestion();
		                
						// If all questions are completed, Show the Score
						if(current>9){
							
							nextButton.setEnabled(false);
							showResult();
						}
					}
				}
			}
		}
		
	
		public void isTimeOver(){
			
			if(timeCounter.minutes==2){
				
			  nextButton.setEnabled(false);
			}
		}
		
		
		//show for showing result after exam
		static void showResult(){
			
			JOptionPane.showMessageDialog(appFrame,"Name :"+nameField.getText()+"\n"+"ID : "+idField.getText()+"\n"+"Your Score is: "+String.valueOf(count),"Thanks for participating",JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		void startingInfo(){
			
			JOptionPane.showMessageDialog(appFrame,"There will be 10 questions.\nYou will get 2 minutes for the exam.\nAt first give your name and ID.\nClick the start button to start exam.","Basic Instructions",JOptionPane.PLAIN_MESSAGE);
			
			// JOptionPane.showMessageDialog(appFrame, message, title, messageType);
		}
		
		


}

