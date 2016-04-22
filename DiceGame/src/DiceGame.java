//Glajummy Blain 													 //
//																	 //
//This is a simple game. The rules are such: each player rolls a die //
//(random number from 1 to 6). If the roll is between 2 and 6, the   //
//number is added to the player's score. If the player rolls a 1,    //
//the score is reset to 0. First to reach at least 30 wins. 		 //

import java.util.*;

public class DiceGame {

	protected boolean gO = false; //gameover
	protected int round = 1;
	protected char playAgain;
	protected int numOfPlayers =4;
	public static Die dice;
	protected int[] score = new int[numOfPlayers];
	protected int amount; //dice roll
	protected int winCondition = 30; //score needed to win
	private Scanner reader;

	
	
	public DiceGame(){
		
		dice = new Die();
		
	}
		
	public void setPlayers (int i){
		numOfPlayers = i;
	}
	
	public int getPlayers(){ 
		return numOfPlayers;
	}
	
	
	public boolean gameOver() {
		return gO;
	}

	
	public void startGame () {
		
		System.out.println("Welcome to Dice " + winCondition + ". Here are the rules:");
		System.out.println("Each player rolls the die multiple times and adds their roll to their score.");
		System.out.println("You can stop rolling at anytime. If you roll a one, your turn is over and you reset your score to 0. First to " + winCondition + " wins. \n");

		System.out.println("How many players are there? Enter an integer from 2 to 4.");
		
		reader = new Scanner(System.in);
		int n = reader.nextInt();
		
		while (n < 2 || n > 4) {
			
			System.out.println("Please enter an integer within the proper range.");
			n = reader.nextInt();
		}
			
		
		this.setPlayers(n);
	
	}
	
	public void playRound () {
		
		System.out.println("Round " + round + " Current scores:");
		for (int j = 0; j < numOfPlayers; j++) {
			System.out.println("Player " + (j+1) + ": " + score[j]);
		}
		
		for (int i = 0; i < numOfPlayers; i++) {
			
			System.out.println("Player " + (i+1) + "'s turn: " );
			
			amount = dice.diceRoll();
			
			if (amount == 1) {
				
				System.out.println("You rolled a 1. Your score is being reset.");
				score[i] = 0;
			}
			
				
			else {
				
				System.out.println("You rolled a " + amount);
				score[i] = score[i] + amount;
			
				
				System.out.println("Player " + (i+1) + "'s current score is: " + score[i]);
				
				if (score[i] >= winCondition) {
					System.out.println("You win!");
					gO = true;
					return;
				}
				
				System.out.println("Do you want to roll again? Y or N ");
				reader = new Scanner(System.in);
				playAgain = reader.next().charAt(0);
					
				if(playAgain == 'Y' || playAgain =='y')
					i--;	//decrement so it stays on current player
				}
			
			
			}
		
			round++;
		}
		
	public static void main (String[] args) {
		

		DiceGame simple = new DiceGame();
		
		simple.startGame();
	
		while(!simple.gameOver()) {
			simple.playRound();
		}
	}
	
}


