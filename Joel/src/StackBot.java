import java.util.Stack;


public class StackBot {
	
	String distance, values, direction;
	final int NORTH = 0;
	final int SOUTH = 1;
	final int EAST = 2;
	final int WEST = 3;
	
	Stack<String> instructions = new Stack<String>();
	
	public static void main(String[] args){
		new StackBot();
	}
	
	public StackBot(){
		instructions.push("34.2m W");
		values = instructions.pop();
		distance = values.substring(0, 3);
		direction = values.substring(5);
		checkDirection();
		
	}
	
	public int checkDirection(){
		if(direction.equals("W")){
			return WEST;
		}else if(direction.equals("E")){
			return EAST;
		}else if(direction.equals("N")){
			return NORTH;
		}else
			return SOUTH;
	}
	
}