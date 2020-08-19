package CHECK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CHECK extends JFrame{
	Timer timer;//new Timer(시간, ActionListener.actionPerformed())
	CHECK() {
		super("충돌체크"); 
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
		//1000분의 50초마다 p.actionPerformed실행
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
	int barX=10;	//사각형의 기준점 X 좌표
	int barY=530;	//사각형의 기준점 Y좌표
	int barVX =7;	//사각형의 이동 속도
	int barWidth=100;//사각형의 너비
	int barHeight=20;//사각형의 높이
	int ballX=10;	//공의 기준점 X좌표
	int ballY=10;	//공의 기준점 Y조ㅓㅏ표
	int ballVX=5;	//공의 x축 이동속도
	int ballVY=3;	//공의 y축 이동속도
	int ballSize=20;//공의 크기(지름)
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(barX, barY, barWidth, barHeight);//(기준좌표X,기준좌표Y, 도형의너비, 도형의높이)
		g.setColor(Color.BLUE);
		g.fillOval(ballX, ballY, ballSize, ballSize);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int width=getSize().width; //현재패널의 너비
		int height=getSize().height; // 현재 패널의 높이
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
			setBackground(Color.RED);//배경색을 빨강으로
			JOptionPane.showConfirmDialog(null, "다시 도전하시겠습니까");
			JOptionPane.showMessageDialog(this, "게임오버","게임에 실패하셨습니다.",1);
			System.exit(1);
		} 
		repaint();
		
	}
}
