import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;


public class StackBot {
	
	String distance, values, direction;
	final int NORTH = -1;
	final int SOUTH = 1;
	final int EAST = -1;
	final int WEST = 1;
	
	double totalNorth = 0;
	double totalSouth = 0;
	double totalEast = 0;
	double totalWest = 0;
	
	double totalLongitude = 0;
	double totalLatitude = 0;
	
	Stack<String> instructions = new Stack<String>();
	
	public static void main(String[] args){
		new StackBot();
	}
	
	public StackBot(){
		//instructions.push("34.2m W");
		
		try {
			
			FileReader fr = new FileReader("/Users/Guest/Desktop/Eclipse/Joel/src/stackbot.txt");
			
			int counter = 0;
			char c;
			String line = "";
			while((c = (char) fr.read())!=(char)-1){
				
				line += c;

				if(c=='\n'){
					instructions.push(line);
					values = instructions.pop();
					distance = values.substring(0, 4);
					direction = values.substring(6, 7);
					if(direction.equals("N"))
						totalNorth += Double.parseDouble(distance);
					if(direction.equals("S"))
						totalSouth += Double.parseDouble(distance)*-1;
					
					totalLongitude = totalSouth+totalNorth;
					
					if(direction.equals("E"))
						totalEast += Double.parseDouble(distance);
					if(direction.equals("W"))
						totalWest += Double.parseDouble(distance)*-1;
					
					totalLatitude = totalEast+totalWest;
					
					System.out.println("The robot goes " + distance + " meters " + checkDirection());
					line = "";
				}

			}
			System.out.println("The robot is at " + totalLongitude + ", " + totalLatitude);
		}
			 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public int checkDirection(){
		if(direction.equals("W")){
			return WEST;
		}else if(direction.equals("E")){
			return EAST;
		}else if(direction.equals("N")){
			return NORTH;
		}else {
			return SOUTH;
		}
	}
	
}