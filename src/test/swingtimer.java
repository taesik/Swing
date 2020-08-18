package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class swingtimer extends JFrame {
	
	static JProgressBar jb;
	int min =0;
	int max = 100;
	JButton btn;
	int interval =100;
	Timer timer;
	static int pro =0;
	swingtimer() {
		super("타이머");
		//setLayout(null);
		testTimer tt = new testTimer();
		timer = new Timer(1000,tt); //Timer(시간,액션리스너);
//		timer = new Timer()
//		timer.start();
		btn = new JButton("start");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn.getText().equals("start")) {
					timer.start();
					btn.setText("stop");
				}else if (btn.getText().equals("정지")) {
					timer.stop();
					btn.setText("start");
				}
			}
		});
		jb = new JProgressBar(min,max);
		jb.setStringPainted(true);
		
		add(btn,BorderLayout.NORTH);
		add(jb,BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200,200,600,200);
		setVisible(true);
	}
	public static void main(String[] arg) {
		new swingtimer();
	}
}
class testTimer implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("활동중");
		swingtimer.pro++;
		swingtimer.jb.setValue(swingtimer.pro);
	}
}
