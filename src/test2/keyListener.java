package test2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class keyListener extends JFrame {
	JLabel j1;
	JLabel j2;
	keyListener() {
		super("Ű �Է�");
		JPanel p =new JPanel(new GridLayout(1,2));
		j1=new JLabel("���� �Էµ� Ű�� : ");
		j1.setHorizontalAlignment(SwingConstants.CENTER);
		//�߾�����
		j2=new JLabel("����");
		j2.setHorizontalAlignment(SwingConstants.CENTER);
		j2.setFont(new Font("����", Font.BOLD, 20));
		p.add(j1);p.add(j2);
		add(p);
		
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
//				System.out.println(e);
//				j2.setText(""+e.getKeyChar());
//				j2.setText(""+e.getKeyCode());
				String str="";
				switch(e.getKeyCode()) {
				case 37 : str="��";break;
				case 38 : str="��";break;
				case 39 : str="��";break;
				case 40 : str="��";break;
				default : str=e.getKeyChar() + "";
				}
				j2.setText(str);
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new keyListener();
	}
}
