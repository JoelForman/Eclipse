import java.util.Scanner;
import java.util.Stack;



public class Question {

	static Scanner userAnswer = new Scanner(System.in);
	
	static Stack<Question> questions = new Stack<Question>();
	
	String question, answer;
	
	static Question question1;

	static String answerCheck;
	
	public static void main(String[] args){
		questions.push(question1 = new Question("What is nine + seven", "sixteen"));
		System.out.println(question1.question);
		answerCheck = userAnswer.nextLine();
		if(answerCheck.equals(question1.answer)){
			System.out.println("You got it right!");
		}else
			System.out.println("You are wrong!");
	}
	
	public Question(String q, String a){
		question = q;
		answer = a;
		
	}
	
}
