import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class playVideo extends JFrame implements ActionListener{

	JButton button1 = new JButton("Ducks");
	JButton button2 = new JButton("Frog");
	JButton button3 = new JButton("Fluffy Unicorns");
	
	public playVideo(){
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		frame.pack();
		
	}
	
	public static void main(String[] args){
		new playVideo();
	}
	
	void showDucks() {
		playVideo("T0Rne4KbZSE");
	}

	void showFrog() {
		playVideo("aSjCb-FfxhI");
	}
	
	void showFluffyUnicorns() {
		playVideo("qRC4Vk6kisY");
	}

	void playVideo(String videoID) {
		try {
			URI uri = new URI("https://www.youtube.com/v/" + videoID + "?autoplay=1");
			java.awt.Desktop.getDesktop().browse(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == button1){
			showDucks();
		}
		if(arg0.getSource() == button2){
			showFrog();
		}
		if(arg0.getSource() == button3){
			showFluffyUnicorns();
		} 
		
	}

	
}
