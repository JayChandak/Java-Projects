package ticTacToe;
import java.util.Scanner;

public class Practice{

	public static void main(String []args) {
		
		char [][] board = new char[3][3];
		char player = 'X';		
		boolean gameOver = false;
		Scanner scan = new Scanner(System.in);
		
		initialize(board);
    
//		If we don't want to initialize the board with blank space 
//		then comment the function call for initialize
//		By Default it will have null 
		
		int row,col;
		while(!gameOver) {
			printBoard(board);
			System.out.println("Player "+player +" Enter: ");
			
			while(true) {
				while(!scan.hasNextInt()) {
					System.out.println("Invalid input! Please enter an integer.");
					scan.next();
				}
				row = scan.nextInt();
				
				while(!scan.hasNextInt()) {
					System.out.println("Invalid input! Please enter an integer.");
					scan.next();
				}
				col = scan.nextInt();
				
				
			if(row >= 0 && row < 3 && col >= 0 && col < 3) {
//				 Check if the cell is empty
				
//		If the board is initialized with blank spaces, use the condition:
				if(board[row][col] == ' ') {										    
					
//		If the board is kept with default values (null for characters), use the condition:
//				if (board[row][col] == '\u0000') {	
		
//		In either case, if the cell is empty, we can proceed with the user's input
					break;
					
				} else {
                    System.out.println("Cell already occupied! Enter different indices.");
				}
            } 
			else {
                   System.out.println("Invalid indices! Enter indices between 0 and 2.");
            }
									
			board[row][col] = player;
			gameOver = haveWon(board,player);
		
			if(gameOver) {
				System.out.println("Player " + player + " has won");
			}else {
				player = (player == 'X') ? 'O' : 'X';
			}
		}							
	}	
		printBoard(board);
		scan.close();
	}
	
	public static void printBoard(char[][] board) {
		for(int rows = 0; rows < board.length;rows++) {
			for(int col = 0; col < board[rows].length;col++) {
				System.out.print(board[rows][col]+" | ");
			}
			System.out.println();
		}
	}
	public static void initialize(char[][] board) {
		for(int rows = 0; rows < board.length;rows++) {
			for(int col = 0; col < board[rows].length;col++) {
				board[rows][col] = ' ';
			}	
		}
	}
	public static boolean haveWon(char[][] board,char player) {
	
		for(int row = 0; row < board.length;row++) {
			if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		
		for(int col = 0; col < board.length;col++) {
			if(board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}
	
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}				
		
		return false;
	}
}
