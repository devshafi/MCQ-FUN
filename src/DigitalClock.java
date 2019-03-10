import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.util.*;
import java.text.*;
 
public class DigitalClock {
	
	   JPanel clockPanel = new JPanel();
	
	public DigitalClock() {
		
		clockPanel.setBounds(480,310,100,50);
		clockPanel.setBackground(Color.decode("#669999"));
		clockPanel.setLayout(new GridLayout(3,1));
		  
	    ClockLabel dateLable = new ClockLabel("date");
	    ClockLabel timeLable = new ClockLabel("time");
	    ClockLabel dayLable = new ClockLabel("day");
	 
	    clockPanel.add(dateLable);
	    clockPanel.add(timeLable);
	    clockPanel.add(dayLable);
	    //clockPanel.setBackground(Color.MAGENTA);
	
	}
 
	class ClockLabel extends JLabel implements ActionListener {
		 
		  String type;
		  SimpleDateFormat sdf;
		 
		  public ClockLabel(String type) {
		    this.type = type;
		    setForeground(Color.white);
		 
		    switch (type) {
		      case "date" : sdf = new SimpleDateFormat("MMMM dd yyyy");
		                    setFont(new Font("sans-serif", Font.PLAIN,12));
		                    setHorizontalAlignment(SwingConstants.CENTER);
		                    break;
		      case "time" : sdf = new SimpleDateFormat("hh:mm:ss a");
		                    setFont(new Font("sans-serif", Font.PLAIN,14));
		                    setHorizontalAlignment(SwingConstants.CENTER);
		                    break;
		      case "day"  : sdf = new SimpleDateFormat("EEEE");
		                    setFont(new Font("sans-serif", Font.PLAIN,12));
		                    setHorizontalAlignment(SwingConstants.CENTER);
		                    break;
		      default     : sdf = new SimpleDateFormat();
		                    break;
		    }
		 
		    Timer t = new Timer(1000, this);
		    t.start();
		  }
		 
		  public void actionPerformed(ActionEvent ae) {
		    Date d = new Date();
		    setText(sdf.format(d));
		  }
		}
    
  }


 

