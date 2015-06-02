import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class program extends JFrame implements ActionListener{

	Timer time = new Timer(1000, this);
	JPanel panel = new JPanel();
	JButton red, orange, green, purple;
	JLabel timer = new JLabel("10");
	
	public static void main(String[] args){
		new program();
	}
	
	public program(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.setSize(400, 60);
		
		panel.add(timer);
		
		red = new JButton("Wire 1");
		red.setBackground(Color.red);
		red.setOpaque(true);
		panel.add(red);
		
		orange = new JButton("Wire 2");
		orange.setBackground(Color.orange);
		orange.setOpaque(true);
		panel.add(orange);
		
		green = new JButton("Wire 3");
		green.setBackground(Color.green);
		green.setOpaque(true);
		panel.add(green);
		
		purple = new JButton("Wire 4");
		purple.setBackground(Color.BLACK);
		purple.setOpaque(true);
		panel.add(purple);
		
		time.start();
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
}
