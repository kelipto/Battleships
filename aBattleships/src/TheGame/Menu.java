package TheGame;

import java.util.Scanner;

public class Menu {

	public String printMenu() {
		String output;
		output = menuOptions(0);
		
		return output;
	}
	
public static String menuOptions (int option) {
	
	do {
		//contsruct output
		System.out.println("Welcome to the Battleships Game! \n");
		System.out.println("Please select one of the menu options \n");
		System.out.println("1 - Start The Game \n"); //start the game in debug mode
		System.out.println("2 - View Highscores \n"); //view table of highscores
		System.out.println("3 - Load Game \n"); //load previous state of play
		System.out.println("4 - Exit \n");
	
		Scanner input = new Scanner(System.in);
		System.out.print("Please input option number: ");
		option = input.nextInt();
		 
		
		if(option == 1) {
			System.out.println("You selected option 1! Your game will start soon! \n\n");
			 Game game = new Game();
	            game.startGame();
			}
		
			
		if (option == 2) {
			System.out.println ("Here are the highscores");
			
			System.out.println ("Highscores table will be available in next update!\n\n");
		}
		if (option == 3) {
			System.out.println ("Save and load option will be available in next update! \n\n");
		}
		
		
	} while(option != 4);
	return "";
	}



}


