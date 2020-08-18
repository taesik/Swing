package test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
public class BOXLAYOUT extends JFrame {
	
	String color = "white";//초기 색상 지정
	BOXLAYOUT() {
		super("박스레이아웃");
		JPanel panel = new JPanel();
		//Panel : 컴포넌트면서 다른 컴포넌트를 담을 수 있는 공간
		BoxLayout boxLayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
		
		panel.setLayout(boxLayout);
		panel.setBorder(
				new EmptyBorder(
						new Insets(150,200,150,200)));
		//위 왼쪽 아래 오른쪽
		JButton jb1 = new JButton("색상바꾸기");
		JLabel jL = new JLabel(color);
		
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//import java.awt.event.*;
				System.out.println(color);
				if (color.equals("white")) {
					panel.setBackground(Color.RED);
					color="red";
					jL.setText("red");
				}else if(color.equals("red")) {
					panel.setBackground(Color.BLUE);
					color = "blue";
					jL.setText("blue");
				}else if (color.equals("blue")) {
					panel.setBackground(Color.WHITE);
					color = "white";
					jL.setText("white");
				}
					
			}
		});
		
		panel.add(jb1);panel.add(jL);
		panel.add(jb1);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();//사이즈를 주지 않고 컴포넌트의 크기에 의존
		setVisible(true);
	}
	public static void main(String[] args) {
		new BOXLAYOUT();
	}
}
