package com.gamearcade.gamepublisher.tictactoe;

import java.util.Scanner;

public class Tictactoe {
	private String[][] board;
    private final int ROWS = 3;
    private final int COLUMNS = 3;
    private final String regex = "\\s{3}";

    public Tictactoe() {
        this.board = new String[ROWS][COLUMNS];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = "   ";
            }
        }
    }

    public void setPlay(int i, int j, String player) {
    	
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (i < 1 || i > ROWS || j < 1 || j > COLUMNS) {
                System.out.println("Invalid position. Please provide valid row and column numbers.");
                System.out.print("Enter row number (1-3): ");
                i = scanner.nextInt();
                System.out.print("Enter column number (1-3): ");
                j = scanner.nextInt();
                continue;
            }

            if (!board[i - 1][j - 1].matches(regex)) {
                System.out.println("Position already occupied. Please choose another position.");
                System.out.print("Enter row number (1-3): ");
                i = scanner.nextInt();
                System.out.print("Enter column number (1-3): ");
                j = scanner.nextInt();
                continue;
            }

            board[i - 1][j - 1] = " " + player + " ";
            break;
        }
    }

    public boolean isGameOver() {
        for (int i = 0; i < ROWS; i++) {
            if (!board[i][0].matches(regex) && allEqual(board[i])) {
                return true;
            }
        }

        for (int j = 0; j < COLUMNS; j++) {
            String[] column = new String[ROWS];
            for (int i = 0; i < ROWS; i++) {
                column[i] = board[i][j];
            }
            if (!column[0].matches(regex) && allEqual(column)) {
                return true;
            }
        }

        // Check diagonals
        String[] diagonal1 = new String[ROWS];
        String[] diagonal2 = new String[ROWS];
        for (int i = 0; i < ROWS; i++) {
            diagonal1[i] = board[i][i];
            diagonal2[i] = board[i][COLUMNS - i - 1];
        }
        if (!diagonal1[0].matches(regex) && allEqual(diagonal1)) {
            return true;
        }
        if (!diagonal2[0].matches(regex) && allEqual(diagonal2)) {
            return true;
        }

        return false;
    }

    private boolean allEqual(String[] array) {
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(array[0])) {
                return false;
            }
        }
        return true;
    }

    public String printBoard() {
        StringBuilder strBoard = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                strBoard.append(board[i][j]);
                if (j != COLUMNS - 1) {
                    strBoard.append("|");
                }
            }
            if (i != ROWS - 1) {
                strBoard.append("\n---+---+---\n");
            }
        }
        return strBoard.toString();
    }
}
