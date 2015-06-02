import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class colorTeacher extends JFrame implements ActionListener{

	JPanel panel = new JPanel();
	JButton button1, button2, button3, button4;
	
	public static void main(String[] args){
		new colorTeacher();
	}
	
	public colorTeacher(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		
		button1 = new JButton();
		button1.setOpaque(true);
		button1.setBackground(Color.yellow);
		panel.add(button1);
		button1.addActionListener(this);
		
		button2 = new JButton();
		button2.setOpaque(true);
		button2.setBackground(Color.red);
		panel.add(button2);
		button2.addActionListener(this);
		
		button3 = new JButton();
		button3.setOpaque(true);
		button3.setBackground(Color.blue);
		panel.add(button3);
		button3.addActionListener(this);
		
		button4 = new JButton();
		button4.setOpaque(true);
		button4.setBackground(Color.green);
		panel.add(button4);
		button4.addActionListener(this);
		
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button1){
			System.out.println("yellow");
			speak("yellow");
		}
		if(e.getSource()==button2){
			System.out.println("red");
			speak("red");
		}
		if(e.getSource()==button3){
			System.out.println("blue");
			speak("blue");
		}
		if(e.getSource()==button4){
			System.out.println("green");
			speak("green");
		}
	}
	
	void speak(String words){
		try{
			Runtime.getRuntime().exec("say " + words); 
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
