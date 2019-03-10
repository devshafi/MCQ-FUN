import javax.swing.*;
import java.awt.*;


public class TimeCounter implements Runnable{   
	JFrame f;
	JButton counterButton = new JButton();	
    Thread t=null;  
    String timeString = "00:00:00";
    int hours, minutes, seconds;  

  
TimeCounter(){  

    t = new Thread(this);   
    counterButton.setBounds(450,90,100,50);
    counterButton.setBackground(Color.BLACK);
    counterButton.setForeground(Color.GREEN);
    counterButton.setFont(new Font("",Font.BOLD,18));
  }
  
 public void run() { 
	 
	  try{
	   while(true){
            
           // making some necessary changes after the bound time is over
		   if(minutes==2){
			   
			   MainInterface.nextButton.setEnabled(false);
			   MainInterface.examInProgLabel.setVisible(false);
			   MainInterface.examEndLabel.setVisible(true);
			   MainInterface.showResult();
			   seconds=-1;
			   t.interrupt();
		   }
		   
		   // making some necessary changes after answering all the questions
		   // which means exam is over
		   if(MainInterface.current>9){
			   
			   MainInterface.examInProgLabel.setVisible(false);
			   MainInterface.examEndLabel.setVisible(true);
			   t.interrupt();
		   }
		   
		    // controlling the time of timer
            if(seconds==59){
            	minutes++;
            	seconds=-1;
            }
            seconds++;
            timeString = String.format("%d:%02d:%02d",hours,minutes,seconds); 
            counterButton.setText(timeString);
            Thread.sleep(1000);
           } 
	     }
	    catch (InterruptedException e) {
			// TODO: handle exception
		}
      }  
}  
