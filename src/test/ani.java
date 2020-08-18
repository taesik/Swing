package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ani extends JFrame{
	Timer timer;
	JButton btn;
	ani() {
		super("점 움직이기");
		dotted dot = new dotted();
		
		timer = new Timer(50,dot);
		
		btn = new JButton("이동");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.start();
			}
		});
		
		dot.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getX()>=dot.X && e.getX()<=dot.X+dot.size) {
					dot.trigger*=-1;
				}
			}
		});
		
		add(btn, BorderLayout.NORTH);
		add(dot, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 200);
	}
	public static void main(String[] args) {
		new ani();
	}
}
class dotted extends JPanel implements ActionListener{
	int X =10;
	int Y =10;
	int size = 20;
	int trigger =1;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(X,Y, size,size);
		//g.drawRect(X, Y, size, size);
	}
	public void actionPerformed(ActionEvent e) {
		X++;
		repaint();
	}
		
}
