import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class whackamole extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel label;
	int x, y;
	int counter = 0;
	JButton mole;
	Random r = new Random();
	JButton[][] buttons = new JButton[5][5];
	Timer time;
	
	public whackamole(){
		panel = new JPanel(new GridLayout(5,5));
		time = new Timer(500, this);
		
		this.setSize(500, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		drawButtons(mole);
		
		this.add(panel);
		this.setVisible(true);
		time.start();
	}
	
	void drawButtons(JButton mole){
		for(int i = 0; i < buttons.length; i++){
			for(int j = 0; j < buttons.length; j++){
				buttons[i][j]= new JButton();
				buttons[i][j].addActionListener(this);
				panel.add(buttons[i][j]);
			}
		}
		

		x = r.nextInt(5);
		y = r.nextInt(5);
		mole = buttons[x][y];
		this.mole = mole;
		//mole.addActionListener(this);
		mole.setText("Mole");
	}
	
	void clearButtons(){
		for (int i = 0; i < buttons.length; i++){
			for (int j = 0; j < buttons.length; j++){
				panel.remove(buttons[i][j]);
			}
		}
	}
	
	void speak(String words) {
		try {
		Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	
	public static void main(String[] args){
		new whackamole();
	}
	
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()!=buttons[x][y]){
			//speak("You missed!");
			System.out.println("you missed");
		}else if(e.getSource()==buttons[x][y]){
			counter++;
			System.out.println("Total moles whacked: " + counter);
			if(counter % 10 == 0){
				endGame();
			}
		}
		if(e.getSource()==time){
			clearButtons();
			drawButtons(mole);
		}
	}
	
	private void endGame() {
		JOptionPane.showMessageDialog(null, "You whacked 10 moles! You win!");
		
		}

}
