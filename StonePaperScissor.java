package stonePaperScissor;
import java.util.*;

public class StonePaperScissor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] choices = { "Stone", "Paper", "Scissor" };

		System.out.println("Enter 0 for Stone, \n 1 for Paper, \n 2 for Scissor");

		int user;
		while (true) {
			try {
				user = scan.nextInt();
				if (user >= 0 && user <= 2) {	
					break;
				} else {					
					System.out.println("Invalid input. Please enter 0, 1, or 2.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scan.nextLine(); // Clear the input buffer
			}
		}

		Random ran = new Random();
		int bot = ran.nextInt(3);

		System.out.println("Bot's Choice: " + choices[bot]);

		if (user == bot) {
			System.out.println("Draw");
		} else if (user == 0 && bot == 2 || user == 2 && bot == 1 || user == 1 && bot == 0) {
			System.out.println("User Wins");
		} else {
			System.out.println("Bot Wins");
		}
		
		scan.close();
	}
}
