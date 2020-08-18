package PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PingPong extends JFrame{
	JPanel mainPanel;//���� ���� ���̾ƿ�
	JPanel btnPanel;//��ư�� �� ���̾ƿ�
	JButton startButton;//���۹�ư
	JButton colorButton;//���󺯰� ��ư
	Timer timer;//Ư�� �Ⱓ���� actionPerformed()�� �������ִ� ��
	PingPong(){
		super("��Ƣ���");
		Bouncing b=new Bouncing();//�׸��� �׷��� �г����� �׼Ǹ�����
		timer=new Timer(50,b);
		//		50/1000�ʸ��� b.actionPerformed()����
		mainPanel=new JPanel();//���� �г� ����
		btnPanel=new JPanel();//��ư�� �� �г� ����
		btnPanel.setLayout(
				new BoxLayout(btnPanel, BoxLayout.X_AXIS));
		//��ư�� �� �г��� ��ġ ��Ģ�� ���η� ������Ʈ�� �ִ� ���
		startButton=new JButton("����");//���۹�ư
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("����")) {
					timer.start();//���۹�ư�� ���� ��� Ÿ�̸Ӹ� ����
					startButton.setText("����");
				}else if(e.getActionCommand().equals("����")) {
					timer.stop();
					startButton.setText("����");
				}
			}
		});
		colorButton=new JButton("����ȯ");//���󺯰� ��ư
		colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b.color==Color.BLACK) {
					b.color=Color.RED;
					repaint();
				}else if(b.color==Color.RED) {
					b.color=Color.BLUE;
					repaint();
				}else if(b.color==Color.BLUE) {
					b.color=Color.BLACK;
					repaint();
				}
			}
		});
		
		btnPanel.add(startButton);btnPanel.add(colorButton);
		//��ư �гο� ���۹�ư�� ����ȯ ��ư�� �־���
		mainPanel.setLayout(
				new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		//���� ū ������ ������ �г��� ���η� ������Ʈ�� �ִ� ���
		mainPanel.add(btnPanel);//�����гο� ��ư�г��� �־���
		mainPanel.add(b);//�����гο� �׸��� �׷��� �г��� �߰�
		add(mainPanel);//�����ӿ� �����г��� �־���
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new PingPong();
	}
}
class Bouncing extends JPanel implements ActionListener{
	int radius=10;			//���� ������
	int diameter=2*radius;	//�� ����
	int vX=3;				//���� X�� �̵� �ӵ�
	int vY=5;				//���� Y�� �̵� �ӵ�
	int X=radius;			//���� ���� X��ǥ
	int Y=radius;			//���� ���� Y��ǥ
	Color color=Color.BLACK;//���� ����
	Bouncing(){
		
	}
	public void actionPerformed(ActionEvent e) {
		//ActionListener �������̽��� �����ϱ� ���� �߻�޼��� ����
		int w=getSize().width;//���� �г��� ���� �޾ƿ�
		int h=getSize().height;//���� �г��� ���̸� �޾ƿ�
		
		if(X>w-radius) {//������ŭ ���ָ� ���ο��� ƨ��� ��ġ ����
			X=w-radius;
			vX*=-1;
		}else if(X<0-radius) {
			X=0-radius;
			vX*=-1;
		}
		X+=vX;//X��ǥ�� vX��ū ����
		System.out.println(X);
		if(Y>h-radius) {//������ŭ ���ָ� ƨ��� ��ġ�� ���� ����
			Y=h-radius;
			vY*=-1;
		}else if(Y<0-radius) {
			Y=0-radius;
			vY*=-1;
		}
		Y+=vY;//Y��ǥ�� vY��ŭ ����
		repaint();//ȭ�� ����
	}
	public void paintComponent(Graphics g) {
		//�׸��� �׸��� ���� Component.paintComponent �������̵�
		super.paintComponent(g);//ȭ�� ���Ž� ������ �׸��� ����� ���
		g.setColor(color);//���� ����
		g.fillOval(X, Y, diameter, diameter);
	}
}
