import java.awt.Graphics;

public class Player {

	int width, height, x, y, speed, health;
	
	public Player(int width, int height, int x, int y, int speed, int health){	
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.health = health;
		
	}
	
	void moveUp(){
		y-=speed;
	}
	
	void moveDown(){
		y+=speed;
	}
	
	int setSpeed(int newSpeed){
		this.speed = newSpeed;
		return speed;
	}
	
	void render(Graphics g){
		g.fillRect(x, y, width, height);
	}
	
}
