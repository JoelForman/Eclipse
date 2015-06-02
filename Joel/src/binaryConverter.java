import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class binaryConverter extends JFrame implements ActionListener{

	JButton button = new JButton("Convert");
	JTextField input = new JTextField(20);
	JTextField answer = new JTextField(20);
	
	public binaryConverter(){
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.add(input);
		panel.add(button);
		panel.add(answer);
		
		button.addActionListener(this);
		
		frame.pack();
	}
	
	String convert(String binary) {
	   	 int asciiValue = Integer.parseInt(binary, 2);
	   	 //char theLetter = (char) asciiValue;
	   	 return "" + asciiValue;
	    }
	
	public static void main(String[] args){
		
		new binaryConverter();
		
	}

	public void actionPerformed(ActionEvent e) {
		
		answer.setText(convert(input.getText()));
		
	}
	
}
