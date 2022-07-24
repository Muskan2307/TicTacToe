
Muskan
Entry No. 2020CSB1100
Here is the Readme file for Lab2 - TicTacToe Game in java

Description of Game:-

First the current state i.e. empty playBoard will get printed on screen and then the description to help user to tell that which number is associated with which position on the playBoard.
Then the user will be instructed to give the input accordingly for which version he wants to enter in(player vs player or player vs computer).
Player vs Player version:-
In this Player1 will get the first chance to make a move and its move will always be represented with 'X' and then the second player with representation 'O' and the game will continue until 
someone wins or no blank spaces available on the board i.e. tie.
Player vs Computer version
In this player will be given the first chance to make a move always with representation 'X' and then the computer with representation 'O' will always move optimally according to the
minimax algorithm and therefore the game will either end in tie or the computer will win due to optimal play of the computer.

Style of Coding :-
To create this game I had made a TicTacToe class which is responsible for the entire process.
I had created 11 helper classes under the TicTacToe class which are private along with the main to perform the different functionalities accordingly and help the TicTacToe class to operate smoothly.

import java.util.Scanner;
public class TicTacToe {
        // Main function of Tic Tac Toe Class
        public static void main(String[] args)

        // TicTaeMode is to enable user to play in whichever mode the user wants accordingly
        private static void TicTacToeMode(Scanner sc, int option)

        // To give description of board to user i.e. to tell the user to press which number (1-9) for each move
        private static void desc(char[][] playBoard)

        // Returning true if the asked player has won the game
        private static boolean hasWon(char[][] playBoard, char val)

        // To return true if either of the two has one the game or the playBoard has no empty spaces left
        private static boolean isGameOver(char[][] playBoard)

        // To check if the player requesting for a move is an empty one i.e. valid one or not
        private static boolean isValid(char[][] playBoard, int pos)

        // Asking the player for a move and doing things accordingly
        private static void playerTurn(char[][] playBoard, Scanner sc,int numPlayer)

        // Placing either 'X' or 'O' as demanded in the given position on board
        private static void place(char[][] playBoard, int pos, char ref)

        // To print the current state of playBoard
        private static void printplayBoard(char[][] playBoard)

        // Asking the player to move in player vs computer version of game
        private static void playerTurnInComp(char[][] playBoard, Scanner sc)

        // For computer to make a move optimally
        private static void compTurn(char[][] playBoard)

        // To help compTurn in deciding the optimal move with the help of implementation of minimax algorithm
        private static int minimax(char[][] playBoard, boolean isMaximising)

Submission and running:-
I am submitting the file as a targzipped archive with 2020CSB1000.tar and the java file as TicTacToe.java and class file as TicTacToe.class.
I am following the same convention and file names as instructed so you can run it in any way i.e. through command line argument or any other way you want it should run.
