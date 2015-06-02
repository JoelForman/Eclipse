import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener {

	JFrame frame = new JFrame("Pong V1.0.0");
	Timer timer;
	int x = 10;
	int y = 10;
	int xVel = 1;
	int yVel = 1;
	int player1Score = 0;
	int player2Score = 0;
	int startingPointx = 250;
	int startingPointy = 230;
	int counter = 0;
	boolean up = false;
	boolean down = false;
	boolean up2 = false;
	boolean down2 = false;
	Rectangle ballRect, player1Rect, player2Rect, level2Rect;
	Player p1;
	Player p2;
	Ball ball;
	Ball level2;
	Random r1 = new Random();
	Random r2 = new Random();
	int randomX;
	int randomY;
	ArrayList<Ball> BallObjects;

	public static void main(String[] args) {
		new Game();
	}

	public Game() {

		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setResizable(false);
		frame.addKeyListener(this);

		BallObjects = new ArrayList<Ball>();

		p1 = new Player(10, 100, 50, 185, 3, 100);
		p2 = new Player(10, 100, 450, 185, 3, 100);
		BallObjects.add(new Ball(20, 20, 300, 300, 2));

		player1Rect = new Rectangle(p1.x, p1.y, p1.width, p1.height);
		player2Rect = new Rectangle(p2.x, p2.y, p2.width, p2.height);

		timer = new Timer(1000 / 60, this);
		timer.start();

		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.red);
		g.fillRect(110, 2, p1.health, 20);
		g.fillRect(390, 2, p2.health, 20);
		g.setColor(Color.BLACK);
		g.drawString("Player 1 health:    " + p1.health, 10, 12);
		g.drawString("Player 2 health:    " + p2.health, 290, 12);
		p1.render(g);
		p2.render(g);
		for (Ball b : BallObjects) {
			b.render(g);
		}
		// g.drawString("Player 1:  " + Integer.toString(player1Score), 10, 15);
		// g.drawString("Player 2:  " + Integer.toString(player2Score), 420,
		// 15);

	}
	
	public void actionPerformed(ActionEvent arg0) {
		for(Ball b: BallObjects)
		{
			b.update();
		}
		if (counter==6) {
			BallObjects.add(new Ball(20, 20, 200, 200, 2));
			counter=0;
		}
		
		for (Ball b : BallObjects) {
			
			if (b.collisionBox.y >= 500 - 40 || b.collisionBox.y <= 0) {

				b.yVel *= -1;
			}

			if (b.collisionBox.intersects(player2Rect)
					|| b.collisionBox.intersects(player1Rect)) {

				counter++;

				if(b.speed<4){
					b.speed += 1;
				}
				b.xVel *= -1;
			}

			if (b.collisionBox.x >= 500 - 20) {
				// ball.x=startingPointx;
				// ball.y=startingPointy;
				// ballRect.x=startingPointx;
				// ballRect.y=startingPointy;
				b.xVel *= -1;
				
				p2.health-=10;

				player1Score++;
			}

			if (b.collisionBox.x <= 0) {
				// ball.x=startingPointx;
				// ball.y=startingPointy;
				// ballRect.x=startingPointx;
				// ballRect.y=startingPointy;

				b.xVel *= -1;

				p1.health-=10;
				
				player2Score++;
			}

		}

		if(p1.health<=0){
			System.out.println("Player 2 wins!");
			timer.stop();
			
		}
		if(p2.health<=0){
			System.out.println("Player 1 wins!");
			timer.stop();
		}
		
		if (up) {
			p1.moveUp();
			player1Rect.y -= p1.speed;
		}
		if (down) {
			p1.moveDown();
			player1Rect.y += p1.speed;
		}
		if (up2) {
			p2.moveUp();
			player2Rect.y -= p1.speed;
		}
		if (down2) {
			p2.moveDown();
			player2Rect.y += p1.speed;
		}


		repaint();

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up2 = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down2 = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up2 = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down2 = false;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

}