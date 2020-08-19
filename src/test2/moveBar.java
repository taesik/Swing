package test2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class moveBar extends JFrame{
	moveBar() {
		super("바 이동");
		bar b=new bar();//make object which extends JPanel
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {

			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==37) {
					b.X-=10;
				}else if (e.getKeyCode()==39) {
					b.X+=10;
				}
				repaint();//화면 갱신
			}
		});
		add(b);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new moveBar();
	}
}
class bar extends JPanel {
	int X = 10;
	int Y = 530;
	int barWidth =100;
	int barHeight =20;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(X, Y, barWidth, barHeight);
	}
}