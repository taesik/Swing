package CHECK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CHECK extends JFrame{
	Timer timer;//new Timer(�ð�, ActionListener.actionPerformed())
	CHECK() {
		super("�浹üũ"); 
		panel p =new panel();
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(p.barX);
				if (e.getKeyCode()==39) {
					p.barX+=p.barVX;
					//if (p.barX>=getSize().width-p.barWidth-(p.barVX*2)) {
						//p.barX=getSize().width-p.barWidth-(p.barVX*2);
					//}
					if(p.barX>=getSize().width-p.barWidth-(p.barVX*2)) {
						p.barX=getSize().width-p.barWidth-(p.barVX*2);
					}
					repaint();
				}else if (e.getKeyCode()==37) {
					System.out.println(p.barX);
					p.barX-=p.barVX;
					if (p.barX<=0) {
						p.barX=0;
					}
					repaint();
				}
			}
		});
		timer=new Timer(50, p);
		//1000���� 50�ʸ��� p.actionPerformed����
		add(p);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
		timer.start();
	}
	public static void main(String[] args) {
		new CHECK();
	}
}
class panel extends JPanel implements ActionListener{
	int barX=10;	//�簢���� ������ X ��ǥ
	int barY=530;	//�簢���� ������ Y��ǥ
	int barVX =7;	//�簢���� �̵� �ӵ�
	int barWidth=100;//�簢���� �ʺ�
	int barHeight=20;//�簢���� ����
	int ballX=10;	//���� ������ X��ǥ
	int ballY=10;	//���� ������ Y���ä�ǥ
	int ballVX=5;	//���� x�� �̵��ӵ�
	int ballVY=3;	//���� y�� �̵��ӵ�
	int ballSize=20;//���� ũ��(����)
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(barX, barY, barWidth, barHeight);//(������ǥX,������ǥY, �����ǳʺ�, �����ǳ���)
		g.setColor(Color.BLUE);
		g.fillOval(ballX, ballY, ballSize, ballSize);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int width=getSize().width; //�����г��� �ʺ�
		int height=getSize().height; // ���� �г��� ����
		ballX+=ballVX;
		if (ballX>width-ballSize) {
			ballX=width-ballSize;
			ballVX=-ballVX;
		}else if (ballX<0) {
			ballX=0;
			ballVX=-ballVX;
		}
		
		ballY+=ballVY;
		if (ballY>barY-ballSize && 
				(ballX>=barX && ballX<=barX+barWidth)) {
			ballVY=-ballVY;
		}else if (ballY<0) {
			ballY=0;
			ballVY=-ballVY;
		}else if (ballY>height) {
			setBackground(Color.RED);//������ ��������
			JOptionPane.showConfirmDialog(null, "�ٽ� �����Ͻðڽ��ϱ�");
			JOptionPane.showMessageDialog(this, "���ӿ���","���ӿ� �����ϼ̽��ϴ�.",1);
			System.exit(1);
		} 
		repaint();
		
	}
}
