package BattleShip;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int turns = 0;
        LeaderBoard leaders = new LeaderBoard() {
            @Override
            public ArrayList recordLeaders(String name, int i) {
                return super.recordLeaders(name, i);
            }
        };
        //creates player and computer boards

        String[][][]playerBoard = new String[3][10][10];
        String[][][]boardComputer = new String[3][10][10];
        intFillBoard(playerBoard,0);
        intFillBoard(boardComputer,1);


//    5 Aircraft Carrier --- a: Icon: Anchor "\u2693"
//    4 Battleship --------- b: Icon: Sailboat "\u26F5"
//    3 Destroyer ---------- c: Icon: Speedboat "\uD83D\uDEA4"
//    3 Submarine ---------- d: Icon: Canoe "\uD83D\uDEF6"
//    2 Tug Boat ----------- e: Icon: Ship "\uD83D\uDEE5"

//        Player myPlayer = new Player() {
//            @Override
//            public String sayName(String name) {
//                return name;
//            }
//        };
        System.out.println("Please enter Your Name");
        Scanner PlayerName = new Scanner(System.in);
        String name1 = PlayerName.nextLine();
//        System.out.println(name1);
//        System.out.println(name1);
        Player LambdaPlayer = (name) -> {
            //System.out.println(name1);
            return name1;
        };
        //creates history of moves made by user and the Computer
        ArrayList<Move> moveHistComputer= new ArrayList<Move>();
        ArrayList<String> playersShips= new ArrayList<String>();
        ArrayList<String> computerShips= new ArrayList<String>();
        shipLeftFill(playersShips);
        shipLeftFill(computerShips);
        Scanner enter = new Scanner(System.in);
        space();

        System.out.print("Welcome to Battleship " + LambdaPlayer.sayName(name1) + " \u2693 \u2693 \u2693 \u2693. Sink The Computer Ships to Win The Game.\n\n\n");
        printBoard(playerBoard,0);

        System.out.print("\nPress enter to begin!");
        String wait = enter.nextLine();

        CompInputShips.autoFill(boardComputer);
        PlayerShips.PlayerFill(playerBoard);
        int hit=-1;
        boolean gameWon=false;

        for(int z = 0;z<10;z++){
            for(int c = 0; c<10;c++){
                boardComputer[2][z][c]=boardComputer[0][z][c];
                playerBoard[2][z][c]=playerBoard[1][z][c];
            }
        }

        while(!gameWon){
            turns++;
            hit=PlayerGuess.PlayerInput(playerBoard,boardComputer,playersShips,computerShips,moveHistComputer,hit);
            if(computerShips.size()==0){
                gameWon= true;
            }
            if(!gameWon){
                ComputerPlayer.ComputerPlayerMove(playerBoard,boardComputer,playersShips,computerShips,moveHistComputer);
                if(playersShips.size()==0){
                    leaders.recordLeaders(name1, turns);
                    leaders.getLeaders();
                    turns = 0;
                    gameWon= true;
                }
            }
        }
    }


    //Lays Out Board
    public static void intFillBoard(String[][][] grid, int e){
        for(int z = 0;z<10;z++){
            for(int c = 0; c<10;c++){
                grid [e][z][c] = " - ";
            }
        }
    }

    // Coordinates for side of board
    public static void printBoard(String[][][] grid, int a){
        for(int z = 0;z<10;z++){
            System.out.print(10-z +"   ");
            if(z!=0){
                System.out.print(" ");
            }
            for(int c = 0; c<10;c++){
                System.out.print(grid[a][z][c] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n      1   2   3   4   5   6   7   8   9   10");
    }

    // Space Between Actions
    public static void space(){
        for (int i=1;i<=15;i++){
            System.out.print("\n");
        }
    }
    public static void shipLeftFill(ArrayList<String> list){
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
    }
    public static int gTOaX(int graphX){
        return graphX-1;
    }
    public static int gTOaY(int graphY){
        return 10-graphY;
    }
}
