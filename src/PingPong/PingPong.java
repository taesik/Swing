package PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PingPong extends JFrame{
	JPanel mainPanel;//가장 넓은 레이아웃
	JPanel btnPanel;//버튼이 들어갈 레이아웃
	JButton startButton;//시작버튼
	JButton colorButton;//색상변경 버튼
	Timer timer;//특정 기간마다 actionPerformed()를 실행해주는 툴
	PingPong(){
		super("공튀기기");
		Bouncing b=new Bouncing();//그림이 그려진 패널이자 액션리스너
		timer=new Timer(50,b);
		//		50/1000초마다 b.actionPerformed()실행
		mainPanel=new JPanel();//넓은 패널 생성
		btnPanel=new JPanel();//버튼이 들어갈 패널 생성
		btnPanel.setLayout(
				new BoxLayout(btnPanel, BoxLayout.X_AXIS));
		//버튼이 들어갈 패널의 배치 규칙은 가로로 컴포넌트를 넣는 방식
		startButton=new JButton("시작");//시작버튼
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("시작")) {
					timer.start();//시작버튼이 눌린 경우 타이머를 실행
					startButton.setText("정지");
				}else if(e.getActionCommand().equals("정지")) {
					timer.stop();
					startButton.setText("시작");
				}
			}
		});
		colorButton=new JButton("색변환");//색상변경 버튼
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
		//버튼 패널에 시작버튼과 색변환 버튼을 넣어줌
		mainPanel.setLayout(
				new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		//가장 큰 공간을 차지할 패널은 세로로 컴포넌트를 넣는 방식
		mainPanel.add(btnPanel);//메인패널에 버튼패널을 넣어줌
		mainPanel.add(b);//메인패널에 그림이 그려진 패널을 추가
		add(mainPanel);//프레임에 메인패널을 넣어줌
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new PingPong();
	}
}
class Bouncing extends JPanel implements ActionListener{
	int radius=10;			//공의 반지름
	int diameter=2*radius;	//공 지름
	int vX=3;				//공의 X축 이동 속도
	int vY=5;				//공의 Y축 이동 속도
	int X=radius;			//공의 시작 X좌표
	int Y=radius;			//공의 시작 Y좌표
	Color color=Color.BLACK;//공의 색상
	Bouncing(){
		
	}
	public void actionPerformed(ActionEvent e) {
		//ActionListener 인터페이스를 구현하기 위한 추상메서드 구현
		int w=getSize().width;//현재 패널의 폭을 받아옴
		int h=getSize().height;//현재 패널의 높이를 받아옴
		
		if(X>w-radius) {//지름만큼 빼주면 가로에서 튕기는 위치 조절
			X=w-radius;
			vX*=-1;
		}else if(X<0-radius) {
			X=0-radius;
			vX*=-1;
		}
		X+=vX;//X좌표를 vX만큰 변경
		System.out.println(X);
		if(Y>h-radius) {//지름만큼 빼주면 튕기는 위치를 조절 가능
			Y=h-radius;
			vY*=-1;
		}else if(Y<0-radius) {
			Y=0-radius;
			vY*=-1;
		}
		Y+=vY;//Y좌표를 vY만큼 변경
		repaint();//화면 갱신
	}
	public void paintComponent(Graphics g) {
		//그림을 그리기 위한 Component.paintComponent 오버라이드
		super.paintComponent(g);//화면 갱신시 기존의 그림을 지우는 기능
		g.setColor(color);//색상 변경
		g.fillOval(X, Y, diameter, diameter);
	}
}
