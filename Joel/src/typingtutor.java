import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class typingtutor extends JFrame implements KeyListener{

	JPanel panel;
	JLabel label;
	char currentLetter;
	String letter;
	int counter = 0;
	
	public typingtutor(){
		this.setSize(250, 250);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.addKeyListener(this);
		
		panel = new JPanel();
		label = new JLabel();
		
		panel.add(label);
		
		currentLetter = generateRandomLetter();
		letter = "" + currentLetter;
		
		label.setFont(label.getFont().deriveFont(96.0f));
		label.setHorizontalAlignment(JLabel.CENTER);	
		label.setText(letter);
		
		this.add(panel);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new typingtutor();
	}
	
	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	public void keyPressed(KeyEvent arg0) {

		
	}

	public void keyReleased(KeyEvent arg0) {
		
		System.out.println("You typed: " + arg0.getKeyChar());
		
		if(arg0.getKeyChar()==currentLetter){
			panel.setBackground(Color.green);
			currentLetter = generateRandomLetter();
			counter++;
		}else{
			panel.setBackground(Color.red);
			currentLetter = generateRandomLetter();
		}
		
		System.out.println(currentLetter);
		letter = "" + currentLetter;
		label.setText(letter);
		
		if(counter%10==0){
			showTypingSpeed(counter);
		}
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
		Date timeAtEnd = new Date();
		long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
		long gameInSeconds = (gameDuration / 1000) % 60;
		double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
		int charactersPerMinute = (int) (charactersPerSecond * 60);
		JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	}
	Date timeAtStart = new Date();

}
