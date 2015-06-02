import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class pigLatin extends JFrame implements ActionListener{

	JButton button = new JButton("Translate");
	JTextField input = new JTextField(20);
	JTextField output = new JTextField(20);
	
	public pigLatin(){
		
		JFrame frame = new JFrame("Pig Latin Translator!");
		JPanel panel = new JPanel();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.add(input);
		panel.add(button);
		panel.add(output);
		
		button.addActionListener(this);
		
		frame.pack();
		
	}
	
	public String convert(String english){
		//english = (english + "ay");
		
		return english;
	}
	
	public static void main(String[] args){
		
		new pigLatin();
		
	}

	public void actionPerformed(ActionEvent arg0) { 
		
		output.setText(convert(input.getText()));
		
	}
	
}
