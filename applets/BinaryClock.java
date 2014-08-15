import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinaryClock extends JApplet
						implements Runnable
{
	private int hr, min, sec, q;
	private JLabel titleLabel, hoursL, minutesL, secondsL;
	private JTextField hour, minute, second;
	private JPanel h,m,s,title;
	Thread runner;


	public void init(){
		q=0;
		hoursL = new JLabel("Hours:  ");
		minutesL = new JLabel("Minutes:  ");
		secondsL = new JLabel("Seconds:  ");
		hour = new JTextField("",6);
		minute = new JTextField("",6);
		second = new JTextField("",6);
		hour.setEditable(false);
		minute.setEditable(false);
		second.setEditable(false);
		titleLabel = new JLabel("©NaW Brings You:  Binary Clock");

		title = new JPanel();
		h = new JPanel();
		m = new JPanel();
		s = new JPanel();

		Container content = getContentPane();

		content.setBackground(Color.black);
		hoursL.setBackground(Color.black);
		minutesL.setBackground(Color.black);
		secondsL.setBackground(Color.black);
		hour.setBackground(Color.black);
		minute.setBackground(Color.black);
		second.setBackground(Color.black);
		titleLabel.setBackground(Color.black);
		title.setBackground(Color.black);
		h.setBackground(Color.black);
		m.setBackground(Color.black);
		s.setBackground(Color.black);
		Color c = new Color(145,240,15);
		hoursL.setForeground(c);
		minutesL.setForeground(c);
		secondsL.setForeground(c);
		hour.setForeground(c);
		minute.setForeground(c);
		second.setForeground(c);
		titleLabel.setForeground(c);

		FlowLayout layout = new FlowLayout();

		title.setLayout(layout);
		h.setLayout(layout);
		m.setLayout(layout);
		s.setLayout(layout);
		content.setLayout(layout);

		title.add(titleLabel);
		h.add(hoursL);
		h.add(hour);
		m.add(minutesL);
		m.add(minute);
		s.add(secondsL);
		s.add(second);

		content.add(title);
		content.add(h);
		content.add(m);
		content.add(s);

	}

	public void refresh(){
		Calendar now = Calendar.getInstance();
		hr = now.get(Calendar.HOUR);
		min = now.get(Calendar.MINUTE);
		sec = now.get(Calendar.SECOND);

		String hours = Integer.toBinaryString(hr);
		String minutes = Integer.toBinaryString(min);
		String seconds = Integer.toBinaryString(sec);

		while(hours.length() <6){
			hours = "0"+hours;
		}
		while(minutes.length() <6){
					minutes = "0"+minutes;
		}
		while(seconds.length() <6){
					seconds = "0"+seconds;
		}

		hour.setText(hours);
		minute.setText(minutes);
		second.setText(seconds);
	}


	public void run(){
		while(true){
			try{
				runner.sleep(50);
			}catch(Exception e){}

			refresh();
		}

	}


	public void start(){
		if (runner == null){
			runner = new Thread (this);
            runner.start();
        }
    }

/*	   public void stop()
		{
      	if (runner != null)
			{
            	runner.stop();
            	runner = null;
      	}
    	}
*/

}

