package com.gamearcade.gamepublisher.minesweeper;

import java.util.Scanner;

public class MinesweeperController {

    Field field;
    int size, nMines;

    public void startGame() {
        initGame();
        gameLoop();
    }

    private void initGame() {
        System.out.println("=================================");
        System.out.println("Minesweeper started, Good Luck!!!");
        System.out.println("=================================\n");

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter the Field size (> 0) : ");
            this.size = sc.nextInt();
        } while (size <= 0);

        do {
            System.out.print("Number of mines (Less than field size and >= 1) :  ");
            this.nMines = sc.nextInt();
        } while (nMines >= size || nMines < 1);

        this.field = new Field(size, nMines);
    }

    private void gameLoop() {
        while (!field.minesRevealed) {
            field.printField();
            field.makeGuess();
            field.checkMarkedMines();

            if (field.allMinesMarked) {
                break;
            }
        }

        if (field.minesRevealed) {
            field.printField();
            System.out.println("You lost!");
        } else {
            field.printField();
            System.out.println("You found all the mines!");
        }
    }
}
