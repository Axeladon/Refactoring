package org.game;

import java.util.Arrays;
import java.util.Scanner;
@SuppressWarnings("java:S106")

public class GameProcessor {
    private final char[] box;
    private final GameBoxConsoleOutput gameConsoleOutput;
    private GameState gameState;

    public GameProcessor() {
        box = new char[9];
        Arrays.fill(box, ' ');
        gameConsoleOutput = new GameBoxConsoleOutput();
        gameState = GameState.IN_PROGRESS;
    }

    public void runGame() {
        System.out.println("Enter box number to select. Enjoy!\n");
        gameConsoleOutput.printInitialBox();

        while (gameState == GameState.IN_PROGRESS) {
            makePlayerTurn();

            if (isPlayerWon()) {
                gameState = GameState.PLAYER_WON;
            } else if (isDraw()){
                gameState = GameState.DRAW;
            } else {
                makeComputerTurn();



                if (isComputerWon()) {
                    gameState = GameState.COMPUTER_WON;
                }
            }

            gameConsoleOutput.printBox(box);
        }
    }

    public void printGameResult() {
        if(gameState == GameState.PLAYER_WON){
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if(gameState == GameState.COMPUTER_WON){
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if(gameState == GameState.DRAW){
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }

    private void makeComputerTurn() {
        while (true) {
            byte rand = (byte) (Math.random() * (9 + 1) - 1);
            if (box[rand] == ' ') {
                box[rand] = 'O';
                return;
            }
        }
    }

    private void makePlayerTurn() {
        Scanner scan = new Scanner(System.in);
        boolean isInputNeeded = true;

        while (isInputNeeded) {
            String playerInput = scan.nextLine();

            if (playerInput.matches("[1-9]")) {
                int enteredNumber = Integer.parseInt(playerInput);
                if (box[enteredNumber - 1] != ' ')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[enteredNumber - 1] = 'X';
                    isInputNeeded = false;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    private boolean isPlayerWon() {
        return (box[0] == 'X' && box[1] == 'X' && box[2] == 'X') || (box[3] == 'X' && box[4] == 'X' && box[5] == 'X')
                || (box[6] == 'X' && box[7] == 'X' && box[8] == 'X') || (box[0] == 'X' && box[3] == 'X' && box[6] == 'X')
                || (box[1] == 'X' && box[4] == 'X' && box[7] == 'X') || (box[2] == 'X' && box[5] == 'X' && box[8] == 'X')
                || (box[0] == 'X' && box[4] == 'X' && box[8] == 'X') || (box[2] == 'X' && box[4] == 'X' && box[6] == 'X');
    }

    private boolean isComputerWon() {
        return (box[0] == 'O' && box[1] == 'O' && box[2] == 'O') || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O')
                || (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') || (box[0] == 'O' && box[3] == 'O' && box[6] == 'O')
                || (box[1] == 'O' && box[4] == 'O' && box[7] == 'O') || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O')
                || (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O');
    }

    private boolean isDraw() {
        for (char c : box) {
            if (c == ' ') {
                return false;
            }
        }
        return true;
    }
}
