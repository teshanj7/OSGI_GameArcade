package com.gamearcade.gamepublisher;

import java.util.Scanner;

import com.gamearcade.gamepublisher.minesweeper.MinesweeperController;
import com.gamearcade.gamepublisher.tictactoe.TicTacToeController;
import com.gamearcade.gamepublisher.tictactoe.Tictactoe;

public class GamePublisherImpl implements IGamePublisher{
	
	Scanner input = new Scanner(System.in);

	@Override
	public void selectGame() {
	    boolean validInput = false;
	    
	    while (!validInput) {
	        System.out.println("========================================");
	        System.out.println("Please Enter the number to play the Game");
	        System.out.println("========================================\n");
	        
	        System.out.println("1 - Tictactoe");
	        System.out.println("2 - Minesweeper");
	        System.out.println("Enter -1 to exit\n");
	        
	        System.out.println("Enter a number : ");
	        String selection = input.next();
	        
	        if (selection.equals("1")) {
	        	startTicTacToe();
	            validInput = true;
	        } else if (selection.equals("2")) {
	        	startMinesweeper();
	            validInput = true;
	        } else if (selection.equals("-1")) {
	            System.out.println("Exit the program");
	            validInput = true;
	        } else {
	            System.out.println("Please enter a valid number!");
	        }
	    }
	}
	
	@Override
	public void startTicTacToe() {
		
		TicTacToeController tictactoe = new TicTacToeController();
		tictactoe.startTicTacToe();
		selectGame();
		
	}

	@Override
	public void startMinesweeper() {
		
		MinesweeperController minessweeper = new MinesweeperController();
		minessweeper.startGame();
		selectGame();
		
	}

}

