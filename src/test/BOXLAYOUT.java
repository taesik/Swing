package test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
public class BOXLAYOUT extends JFrame {
	
	String color = "white";//�ʱ� ���� ����
	BOXLAYOUT() {
		super("�ڽ����̾ƿ�");
		JPanel panel = new JPanel();
		//Panel : ������Ʈ�鼭 �ٸ� ������Ʈ�� ���� �� �ִ� ����
		BoxLayout boxLayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
		
		panel.setLayout(boxLayout);
		panel.setBorder(
				new EmptyBorder(
						new Insets(150,200,150,200)));
		//�� ���� �Ʒ� ������
		JButton jb1 = new JButton("����ٲٱ�");
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
		pack();//����� ���� �ʰ� ������Ʈ�� ũ�⿡ ����
		setVisible(true);
	}
	public static void main(String[] args) {
		new BOXLAYOUT();
	}
}
