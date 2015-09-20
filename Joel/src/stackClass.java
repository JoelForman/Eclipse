import java.util.Scanner;
import java.util.Stack;


public class stackClass {

	String s = " ";
	
	Scanner wordScanner = new Scanner(System.in);
	
	Stack<String> word = new Stack<String>();
	
	public static void main(String[] args){
		new stackClass();
		
	}
	
	public stackClass(){
		System.out.println("Enter a word: ");
		String newWord = wordScanner.nextLine();
		for(int i = 0; i<newWord.length(); i++){
			word.push(s+newWord.charAt(i));
			System.out.println(word.pop());
		}
	}
	
}
