import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FortuneCookie extends JFrame implements ActionListener{

	JLabel label = new JLabel();
	
	String[] array = new String[20];
	
	Random r = new Random();
	
	
	public FortuneCookie(){
		
		array[0] = "You will die!";
		array[1] = "You will trip!";
		array[2] = "You will win!";
		array[3] = "You will kill!";
		array[4] = "You will fall!";
		array[5] = "You will sneeze!";
		
		JFrame frame = new JFrame("Fortune Cookie!");
		JPanel panel = new JPanel();
		
		JButton button = new JButton("Get a Fortune!");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(panel);
		
		button.addActionListener(this);
		
		panel.add(button);
		panel.add(label);
		
		frame.pack();
		
	}
	
	public static void main(String[] args){
		
		new FortuneCookie();
		
	}

	public void actionPerformed(ActionEvent arg0) {
		label.setText(array[r.nextInt(6)]);
		
	}
	
}
