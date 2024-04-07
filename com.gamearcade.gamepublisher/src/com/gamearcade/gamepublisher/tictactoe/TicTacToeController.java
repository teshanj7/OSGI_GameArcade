package com.gamearcade.gamepublisher.tictactoe;

import java.util.Scanner;

public class TicTacToeController {

	private final Scanner input;

    public TicTacToeController() {
        this.input = new Scanner(System.in);
    }

    public void startTicTacToe() {
    	
        System.out.println("==============================");
        System.out.println("TicTacToe started, Good Luck!!!");
        System.out.println("==============================\n");

        System.out.print("Enter name for player X: ");
        String playerXName = input.nextLine();
        System.out.print("Enter name for player O: ");
        String playerOName = input.nextLine();

        Tictactoe game = new Tictactoe();
        String currentPlayer = "X";

        do {
            System.out.println(game.printBoard());
            System.out.println("Enter row for " + getPlayerName(currentPlayer, playerXName, playerOName) + " or -1 to exit: ");
            int row = input.nextInt();
            if (row == -1)
                break;
            System.out.println("Enter column for " + getPlayerName(currentPlayer, playerXName, playerOName) + ": ");
            int column = input.nextInt();
            game.setPlay(row, column, currentPlayer);
            if (game.isGameOver()) {
                System.out.println(game.printBoard() + "\n" + getPlayerName(currentPlayer, playerXName, playerOName) + " wins!");
                break;
            }
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        } while (true);

        System.out.println("Goodbye!..");
    }

    private String getPlayerName(String currentPlayer, String playerXName, String playerOName) {
        return currentPlayer.equals("X") ? playerXName : playerOName;
    }
}
