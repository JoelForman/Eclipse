import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class testGraphics extends JFrame implements KeyListener{

	public static void main(String[] args){
		new testGraphics();
	}
	
	public testGraphics(){
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
		
		JPanel panel = new JPanel();
		this.add(panel);
		
		
		this.setVisible(true);
	}
	
	public void paint(Graphics g){
		g.drawRect(100, 100, 100, 100);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
