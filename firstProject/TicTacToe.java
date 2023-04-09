package com.firstProject;

import java.util.Scanner;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        initializeBoard();

        boolean gameWon = false;
        while (!gameWon) {
            printBoard();

            boolean validMove = false;
            while (!validMove) {
                try {
                    System.out.print("Player " + currentPlayer + ", enter row (1-3): ");
                    int row = scanner.nextInt() - 1;
                    System.out.print("Player " + currentPlayer + ", enter column (1-3): ");
                    int col = scanner.nextInt() - 1;

                    if (row < 0 || row > 2 || col < 0 || col > 2) {
                        throw new Exception("Invalid input. Please enter a number between 1 and 3.");
                    }

                    if (board[row][col] != '-') {
                        throw new Exception("That spot is already taken. Please choose a different spot.");
                    }

                    board[row][col] = currentPlayer;
                    validMove = true;

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                }
            }

            gameWon = checkForWin();
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        printBoard();
        System.out.println("Player " + currentPlayer + " wins!");
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean checkForWin() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }

        // check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return true;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return true;
        }

        return false;
    }
}
