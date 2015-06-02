import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class calculator extends JFrame implements ActionListener{

	public calculator(){
		JFrame frame1 = new JFrame("Calculator");
		JLabel label1 = new JLabel("Enter expression: ");
		JPanel panel1 = new JPanel();
		JButton button1 = new JButton("Solve");
		JTextField text1 = new JTextField();
		
		panel1.add(label1);		
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(panel1);
		panel1.add(text1);
		panel1.add(button1);
		
		frame1.pack();
		
	}
	
	public static void main(String[] args){
		new calculator();
	}

	
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
}
