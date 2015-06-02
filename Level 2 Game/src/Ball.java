import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball{

	int width, height, x, y, speed, xVel, yVel;
	Rectangle collisionBox;
	Random r = new Random();
	
	public Ball(int width, int height, int x, int y, int speed){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speed = speed;
		if(r.nextInt()%2==0){
			this.xVel=1;
		}else
			this.xVel=-1;
		if(r.nextInt()%2==0){
			this.yVel=1;
		}
		else
			this.yVel=-1;
		
		collisionBox = new Rectangle(x, y, width, height);
		
	}
	
	void render(Graphics g){
		g.fillOval(x, y, width, height);
	}
	
	void update(){
		x+=speed*xVel;
		y+=speed*yVel;
		collisionBox.x+=speed*xVel;
		collisionBox.y+=speed*yVel;
	}
	
	int getSpeed(){
		return speed;
	}
	
	int setSpeed(int newSpeed){
		this.speed = newSpeed;
		return speed;
	}
	
}
