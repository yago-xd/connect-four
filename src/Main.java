import java.util.Scanner;
import java.util.Random;
public class Main {
    static final Scanner sc = new Scanner(System.in);
    static final Random rand = new Random();
    static String[][] board = new String[6][7];
    static String user,comp;
    static int user_choice;
    static int round=0,move=0;
    static char replay='y';
    static int game_count=0,draw_count=0,loss_count=0,win_count=0;
    public static void reset_board(){
        int i,j;
        for(i=0;i<6;i++){
            for(j=0;j<7;j++){
                board[i][j]="⚪";
            }
        }
    }
    public static void print_board(){
        int i,j;
        System.out.println("----------------");
        System.out.println(" 1 2 3 4\u2006 5 6 7");
        for(i=0;i<6;i++){
            for(j=0;j<7;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean isValid(){
        if(sc.hasNextInt()){
            user_choice =sc.nextInt();
            return (user_choice == 1 || user_choice == 2);
        }
        return false;
    }
    public static void instructions(){
        System.out.println("\nWelcome to Connect Four!");
        System.out.println("The game is played on a 6x7 grid.");
        System.out.println("Players take turns dropping their colored discs into one of the columns.");
        System.out.println("The first player to connect four of their discs in a row (horizontally, vertically, or diagonally) wins.");
        System.out.println("If the grid is full and no player has connected four, the game ends in a draw.");
    }
    public static int get_valid_input(){
        int col;
        while(true){
            System.out.print("Enter the column number to make a move: ");
            if(sc.hasNextInt()){
                col=sc.nextInt();
                if(col<1 || col>7) {
                    System.out.println("Invalid column. Must be between 1 to 7");
                    sc.nextLine();
                }
                else
                    break;
            }
            else{
                System.out.println("Input must be an integer!");
                sc.next();
            }
        }
        return col-1;
    }
    public static boolean columnFull(int col){
        return !board[0][col].equals("⚪");
    }
    public static boolean isDraw(){
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                if(board[i][j].equals("⚪"))
                    return false;
            }
        }
        return true;
    }
    public static boolean hasWon(String symbol){
        //horizontal
        for(int i=0;i<6;i++){
            for(int j=0;j<=3;j++){
                if(board[i][j].equals(symbol) && board[i][j+1].equals(symbol) &&
                        board[i][j+2].equals(symbol) && board[i][j+3].equals(symbol)){
                    return true;
                }
            }
        }
        //vertical
        for(int j=0;j<7;j++){
            for(int i=0;i<=2;i++){
                if(board[i][j].equals(symbol) && board[i+1][j].equals(symbol) &&
                        board[i+2][j].equals(symbol) && board[i+3][j].equals(symbol)){
                    return true;
                }
            }
        }
        //main diagonal
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                if((i<=2 && j<=3)&& board[i][j].equals(symbol) && board[i+1][j+1].equals(symbol)
                        && board[i+2][j+2].equals(symbol) && board[i+3][j+3].equals(symbol)){
                    return true;
                }
            }
        }
        //the other diagonal
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                if((i<=2 && j>=3)&& board[i][j].equals(symbol) && board[i+1][j-1].equals(symbol)
                        && board[i+2][j-2].equals(symbol) && board[i+3][j-3].equals(symbol)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void getUser() throws InterruptedException {
        reset_board();
        System.out.println("\nSymbols: (1. \uD83D\uDD34)/(2. \uD83D\uDFE1)");
        System.out.print("Enter your preferred symbol choice (1/2): ");
        while(!isValid()){
            System.out.print("Enter a valid choice (1/2): ");
            sc.nextLine();
        }
        if(user_choice == 1) {
            user="\uD83D\uDD34";
            comp="\uD83D\uDFE1";
        }
        else {
            comp="\uD83D\uDD34";
            user="\uD83D\uDFE1";
        }
        System.out.println("Symbol chosen by you: "+user);
        System.out.println("Computer symbol: "+comp);
        System.out.print("Loading Game...");
        Thread.sleep(1000);
        System.out.println("\rGame Loaded\n");
    }
    public static void first_move() throws InterruptedException{
        round++;
        print_board();
        System.out.println("\nRound "+round);
        System.out.print("\nThe first move will be made by: ");
        int first= rand.nextInt(1,3)-1;
        Thread.sleep(1500);
        if(first==0){
            System.out.println("You");
            user_move();
            move=1;
        }
        else if(first==1){
            System.out.println("Computer");
            comp_move();
            move=0;
        }
        print_board();
    }
    public static void user_move(){
        int col;
        col=get_valid_input();
        while(true){
            if(columnFull(col)){
                System.out.print("That column is full. Try another one: ");
                sc.nextLine();
                col=get_valid_input();
            }
            else
                break;
        }
        for(int row = 5; row >=0; row--){
            if(board[row][col].equals("⚪")){
                board[row][col]=user;
                System.out.println("You have made your move");
                System.out.println("You placed at Column "+(col+1));
                return;
            }
        }
    }
    public static void comp_move() throws InterruptedException {
        int col;
        Thread.sleep(1000);
        do {
            col = rand.nextInt(7);
        }
        while (columnFull(col));
        for(int row = 5; row >=0; row--){
            if(board[row][col].equals("⚪")){
                board[row][col]=comp;
                System.out.println("Computer has made its move");
                System.out.println("Computer placed at Column "+(col+1));
                return;
            }
        }
    }
    public static void start_game() throws InterruptedException {
        reset_board();
        first_move();
        int moves=1;
        while(true) {
            if (move==0){
                System.out.println("Your move");
                user_move();
                moves++;
                print_board();
                if(hasWon(user)){
                    System.out.println("You won!");
                    game_count++;
                    win_count++;
                    score(moves,'w');
                    break;
                }
                if(isDraw()){
                    System.out.println("It's a draw!");
                    draw_count++;
                    game_count++;
                    score(moves,'d');
                    break;
                }
                move=1;
            }
            if (move==1){
                System.out.println("Computer's move");
                comp_move();
                moves++;
                print_board();
                if(hasWon(comp)){
                    System.out.println("Computer won!");
                    loss_count++;
                    game_count++;
                    score(moves,'l');
                    break;
                }
                if(isDraw()){
                    System.out.println("It's a draw!");
                    draw_count++;
                    game_count++;
                    score(moves,'d');
                    break;
                }
                move=0;
            }
        }
    }
    public static void score(int moves, char state){
        int score=(57-moves)*2;
        if(state=='w')
            score*=2;
        else if(state=='l')
            score/=2;
        else if(state=='d')
            score-=10;
        score = Math.max(score, 0);
        System.out.println("Number of moves made in this round: " + moves);
        System.out.println("Score for this round: " + score);
    }
    public static void run_game() throws InterruptedException {
        replay='y';
        while(replay=='y') {
            start_game();
            sc.nextLine();
            System.out.println("\n------------------------------");
            System.out.print("\nDo you wish to play again? (Y/N): ");
            String replay_input=sc.nextLine().trim().toLowerCase();
            if(!replay_input.isEmpty())
                replay=replay_input.charAt(0);
            else {
                System.out.println("No input! Assuming no.");
                replay = 'n';
            }
            if (replay != 'y' && replay != 'n'){
                System.out.println("Invalid input! Assuming no.");
                replay = 'n';
            }
            System.out.println();
        }
        System.out.println("Thanks for playing!");
    }
    public static void stats(){
        System.out.println("\n------------Statistics-------------");
        System.out.println("Games Played: " + game_count);
        System.out.println("Wins: " + win_count);
        System.out.println("Losses: " + loss_count);
        System.out.println("Draws: " + draw_count);
        System.out.println("------------------------------\n");
    }
    public static void main(String[] args) throws InterruptedException {
        instructions();
        getUser();
        run_game();
        stats();
    }
}