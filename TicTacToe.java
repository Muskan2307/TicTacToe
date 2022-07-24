import java.util.Scanner;
public class TicTacToe {
        // Main function of Tic Tac Toe Class
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Press1 for player vs player version and 2 for player vs computer version.");
            int option = sc.nextInt();
            TicTacToeMode(sc,option);
        }
        // TicTaeMode is to enable user to play in whichever mode the user wants accordingly
        private static void TicTacToeMode(Scanner sc, int option)
        {
        char[][] playBoard = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        System.out.println("Here is your 3*3 board for TicTacToe !!");
        printplayBoard(playBoard);
        System.out.println("Here is the description of number you have to enter to fill the requires location you want.");
        desc(playBoard);
        if (option == 1) {
            while (true) {
                System.out.println("Player1 its your turn!!");
                playerTurn(playBoard, sc, 1);
                printplayBoard(playBoard);
                if (isGameOver(playBoard)) {
                    if(hasWon(playBoard,'X'))
                    {
                        System.out.println("Congrats !! PLayer1 Won :)");
                    }
                    else if(hasWon(playBoard,'O'))
                    {
                        System.out.println("Congrats !! Player2 Won :)");
                    }
                    else
                    {
                        System.out.println("The game ended in tie :|");
                    }
                    break;
                }
                System.out.println("Player2 its your turn!!");
                playerTurn(playBoard, sc, 2);
                printplayBoard(playBoard);
                if (isGameOver(playBoard)) {
                    if(hasWon(playBoard,'X'))
                    {
                        System.out.println("Congrats !! PLayer1 Won :)");
                    }
                    else if(hasWon(playBoard,'O'))
                    {
                        System.out.println("Congrats !! Player2 Won :)");
                    }
                    else
                    {
                        System.out.println("The game ended in tie :|");
                    }
                    break;
                }
            }
        }
        else if (option == 2)
        {

            while(true)
            {
                System.out.println("Player its your turn!!");
                playerTurnInComp(playBoard,sc);
                printplayBoard(playBoard);
                if(isGameOver(playBoard))
                {
                    if(hasWon(playBoard,'X'))
                    {
                        System.out.println("Congrats !! PLayer Won :)");
                    }
                    else if(hasWon(playBoard,'O'))
                    {
                        System.out.println("Sry! Computer Wins :(");
                    }
                    else
                    {
                        System.out.println("The game ended in tie :|");
                    }
                    break;
                }
                compTurn(playBoard);
                printplayBoard(playBoard);
                if(isGameOver(playBoard))
                {
                    if(hasWon(playBoard,'X'))
                    {
                        System.out.println("Congrats !! PLayer Won :)");
                    }
                    else if(hasWon(playBoard,'O'))
                    {
                        System.out.println("Sry! Computer Wins :(");
                    }
                    else
                    {
                        System.out.println("The game ended in tie :|");
                    }
                    break;
                }
            }
        }
        }
        // To give description of board to user i.e. to tell the user to press which number (1-9) for each move
        private static void desc(char[][] playBoard)
        {
            char count='1';
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    playBoard[i][j]=count;
                    count++;
                }
            }
            printplayBoard(playBoard);
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    playBoard[i][j]=' ';
                }
            }
        }
        // Returning true if the asked player has won the game
        private static boolean hasWon(char[][] playBoard, char val)
        {
            if((playBoard[0][0] == val && playBoard[0][1] == val && playBoard[0][2] == val)
                    ||(playBoard[1][0] == val && playBoard[1][1] == val && playBoard[1][2] == val)
                    ||(playBoard[2][0] == val && playBoard[2][1] == val && playBoard[2][2] == val)
                    ||(playBoard[0][0] == val && playBoard[1][0] == val && playBoard[2][0] == val)
                    ||(playBoard[0][1] == val && playBoard[1][1] == val && playBoard[2][1] == val)
                    ||(playBoard[0][2] == val && playBoard[1][2] == val && playBoard[2][2] == val)
                    ||(playBoard[0][0] == val && playBoard[1][1] == val && playBoard[2][2] == val)
                    ||(playBoard[0][2] == val && playBoard[1][1] == val && playBoard[2][0] == val))
            {
                return true;
            }
            return false;
        }
        // To return true if either of the two has one the game or the playBoard has no empty spaces left
        private static boolean isGameOver(char[][] playBoard)
        {
            if(hasWon(playBoard,'X'))
            {
                return true;
            }
            if(hasWon(playBoard,'O'))
            {
                return true;
            }
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(playBoard[i][j]==' ')
                        return false;
                }
            }
            return true;
        }
        // To check if the player requesting for a move is an empty one i.e. valid one or not
        private static boolean isValid(char[][] playBoard, int pos)
        {
            switch(pos)
            {
                case 1:
                    return (playBoard[0][0] == ' ');
                case 2:
                    return (playBoard[0][1] == ' ');
                case 3:
                    return (playBoard[0][2] == ' ');
                case 4:
                    return (playBoard[1][0] == ' ');
                case 5:
                    return (playBoard[1][1] == ' ');
                case 6:
                    return (playBoard[1][2] == ' ');
                case 7:
                    return (playBoard[2][0] == ' ');
                case 8:
                    return (playBoard[2][1] == ' ');
                case 9:
                    return (playBoard[2][2] == ' ');
                default:
                    return false;
            }
        }
        // Asking the player for a move and doing things accordingly
        private static void playerTurn(char[][] playBoard, Scanner sc,int numPlayer)
        {
            int pos;
            while(true)
            {
                System.out.println("Where you would like to place a move(1,9)?");
                pos = sc.nextInt();
                if(isValid(playBoard,pos))
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid move :(");
                }
            }

            if(numPlayer==1)
                place(playBoard,pos,'X');
            else
                place(playBoard,pos,'O');

        }
        // Placing either 'X' or 'O' as demanded in the given position on board
        private static void place(char[][] playBoard, int pos, char ref)
        {
            switch(pos)
            {
                case 1:
                    playBoard[0][0] = ref;
                    break;
                case 2:
                    playBoard[0][1] = ref;
                    break;
                case 3:
                    playBoard[0][2] = ref;
                    break;
                case 4:
                    playBoard[1][0] = ref;
                    break;
                case 5:
                    playBoard[1][1] = ref;
                    break;
                case 6:
                    playBoard[1][2] = ref;
                    break;
                case 7:
                    playBoard[2][0] = ref;
                    break;
                case 8:
                    playBoard[2][1] = ref;
                    break;
                case 9:
                    playBoard[2][2] = ref;
                    break;
            }
        }
        // To print the current state of playBoard
        private static void printplayBoard(char[][] playBoard)
        {
            System.out.println(playBoard[0][0]+"|"+playBoard[0][1]+"|"+playBoard[0][2]);
            System.out.println("-+-+-");
            System.out.println(playBoard[1][0]+"|"+playBoard[1][1]+"|"+playBoard[1][2]);
            System.out.println("-+-+-");
            System.out.println(playBoard[2][0]+"|"+playBoard[2][1]+"|"+playBoard[2][2]);
        }
        // Asking the player to move in player vs computer version of game
        private static void playerTurnInComp(char[][] playBoard, Scanner sc)
        {
        int pos=-1;
        while(true)
        {
            System.out.println("Where you would like to place a move(1,9)?");
            pos = sc.nextInt();
            if(isValid(playBoard,pos))
            {
                break;
            }
            else
            {
                System.out.println("Invalid move :(");
            }
        }
        place(playBoard,pos,'X');

    }
        // For computer to make a move optimally
        private static void compTurn(char[][] playBoard)
        {
        int bestScore = -1000;
        int pos = -1;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(playBoard[i][j]==' ')
                {
                    playBoard[i][j]='O';
                    int score = minimax(playBoard,false);
                    playBoard[i][j]=' ';
                    if(score > bestScore)
                    {
                        bestScore = score;
                        if(i==0)
                        {
                            if(j==0)
                                pos=1;
                            else if(j==1)
                                pos=2;
                            else
                                pos=3;
                        }
                        else if(i==1)
                        {
                            if(j==0)
                                pos=4;
                            else if(j==1)
                                pos=5;
                            else
                                pos=6;
                        }
                        else if(i==2)
                        {
                            if(j==0)
                                pos=7;
                            else if(j==1)
                                pos=8;
                            else
                                pos=9;
                        }
                    }
                }
            }
        }
        place(playBoard, pos ,'O');
    }
        // To help compTurn in deciding the optimal move with the help of implementation of minimax algorithm
        private static int minimax(char[][] playBoard, boolean isMaximising)
        {
        if(hasWon(playBoard,'X'))
            return -10;
        else if(hasWon(playBoard,'O'))
            return 10;
        else if(isGameOver(playBoard))
        {
            return 0;
        }
        int bestScore=0;
        if(isMaximising)
        {
            bestScore = -1000;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(playBoard[i][j] == ' ') {
                        playBoard[i][j] = 'O';
                        int score = minimax(playBoard, false);
                        playBoard[i][j]=' ';
                        if(score>bestScore)
                        {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
        else
        {
            bestScore = 1000;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(playBoard[i][j] == ' ') {
                        playBoard[i][j] = 'X';
                        int score = minimax(playBoard, true);
                        playBoard[i][j]=' ';
                        if(score<bestScore)
                        {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
    }

}
