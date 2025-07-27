import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();
    private static final ArrayList<String> log = new ArrayList<>();
    private static final ArrayList<String> history = new ArrayList<>();
    private static final ArrayList<int[]> userMoves = new ArrayList<>();
    private static final ArrayList<int[]> compMoves = new ArrayList<>();
    private static final String[][] board = new String[6][7];
    private static String user,comp;
    private static int user_choice;
    private static int comp_moves=0,total_moves=0,user_moves=0;
    private static int round=0,move=0;
    private static int game_count=0,draw_count=0,loss_count=0,win_count=0;
    private static int win_streak=0,loss_streak=0,draw_streak=0;
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
        System.out.println(" 1 2 3 4\u2004 5 6 7");
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
            System.out.println("To undo your last move, type 'undo' (without quotes)");
            System.out.print("Enter the column number to make a move: ");
            String input = sc.nextLine().trim().toLowerCase().replaceAll(" ", "");
            if(input.equals("undo")){
                undo();
                continue;
            }
            try{
                col = Integer.parseInt(input);
                if(col < 1 || col > 7){
                    System.out.println("Invalid column. Must be between 1 to 7");
                }
                else{
                    return col - 1;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Input must be an integer!");
            }
        }
    }
    public static void undo() {
        if(total_moves == 0){
            System.out.println("No moves to undo!");
            return;
        }
        total_moves--;
        if(move == 0){
            if (!userMoves.isEmpty()) {
                int[] lastMove = userMoves.removeLast();
                board[lastMove[0]][lastMove[1]] = "⚪";
                user_moves--;
                move = 1;
                System.out.println("Your last move has been undone.");
            }
            else{
                System.out.println("No user moves to undo.");
            }
        }
        else{
            if(!compMoves.isEmpty()){
                int[] lastMove = compMoves.removeLast();
                board[lastMove[0]][lastMove[1]] = "⚪";
                comp_moves--;
                move = 0;
                System.out.println("Computer's last move has been undone.");
            }
            else{
                System.out.println("No computer moves to undo.");
            }
        }
        print_board();
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
        for(int i=0;i<6;i++){
            for(int j=0;j<=3;j++){
                if(board[i][j].equals(symbol) && board[i][j+1].equals(symbol) &&
                        board[i][j+2].equals(symbol) && board[i][j+3].equals(symbol)){
                    return true;
                }
            }
        }
        for(int j=0;j<7;j++){
            for(int i=0;i<=2;i++){
                if(board[i][j].equals(symbol) && board[i+1][j].equals(symbol) &&
                        board[i+2][j].equals(symbol) && board[i+3][j].equals(symbol)){
                    return true;
                }
            }
        }
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                if((i<=2 && j<=3)&& board[i][j].equals(symbol) && board[i+1][j+1].equals(symbol)
                        && board[i+2][j+2].equals(symbol) && board[i+3][j+3].equals(symbol)){
                    return true;
                }
            }
        }
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
    public static void showMoves() {
        System.out.println("\n------------------------------");
        System.out.print("\nDo you wish to see a log of all moves in this round (Y/N): ");
        String log_ch = sc.nextLine().toLowerCase().trim();
        if(!log_ch.equals("y"))
            return;
        System.out.println("\nMoves made in this round by User: "+user_moves);
        System.out.println("Moves made in this round by Computer: "+comp_moves);
        System.out.println("\nMoves Log:");
        for (String move : Main.log) {
            System.out.println(move);
        }
    }
    public static void clearMoves(){
        log.clear();
        user_moves = 0;
        comp_moves = 0;
        total_moves = 0;
    }
    public static void getUser() throws InterruptedException {
        reset_board();
        System.out.println("\nSymbols: (1. \uD83D\uDD34)/(2. \uD83D\uDFE1)");
        System.out.print("Enter your preferred symbol choice (1/2): ");
        while(!isValid()){
            System.out.print("Enter a valid choice (1/2): ");
            sc.nextLine();
        }
        sc.nextLine();
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
        total_moves++;
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
    public static String time_convert(long start_dur, long end_dur) {
        long ts = (end_dur - start_dur) / 1000;
        long hours = (ts / 3600);
        long minutes = (ts % 3600) / 60;
        long seconds = ts % 60;
        StringBuilder time_display = new StringBuilder();
        if (ts >= 3600)
            time_display.append(hours).append("h ");
        if (ts >= 60)
            time_display.append(minutes).append("m ");
        time_display.append(seconds).append("s");
        return time_display.toString();
    }
    public static void user_move(){
        int col;
        long startTime = System.currentTimeMillis();
        col=get_valid_input();
        long endTime = System.currentTimeMillis();
        String timeTaken = time_convert(startTime, endTime);
        while(true){
            if(columnFull(col)){
                System.out.print("That column is full. Try another one: ");
                sc.nextLine();
                col=get_valid_input();
            }
            else
                break;
        }
        user_moves++;
        String move = "Move "+ total_moves + " at Column " + (col + 1) + " by User(" +user+")     " + " [" + timeTaken + "]";
        log.add(move);
        for(int row = 5; row >=0; row--){
            if(board[row][col].equals("⚪")){
                board[row][col]=user;
                userMoves.add(new int[]{row, col});
                System.out.println("You have made your move");
                System.out.println("You placed at Column "+(col+1));
                System.out.println("Time taken for this move: " + timeTaken);
                return;
            }
        }
    }
    public static void comp_move() throws InterruptedException {
        int col;
        long startTime = System.currentTimeMillis();
        Thread.sleep(1000);
        do {
            col = rand.nextInt(7);
        }
        while (columnFull(col));
        long endTime = System.currentTimeMillis();
        String timeTaken = time_convert(startTime, endTime);
        comp_moves++;
        String move = "Move "+ total_moves + " at Column " + (col + 1) + " by Computer(" +comp+") " + " [" + timeTaken + "]";
        log.add(move);
        for(int row = 5; row >=0; row--){
            if(board[row][col].equals("⚪")){
                board[row][col]=comp;
                compMoves.add(new int[]{row, col});
                System.out.println("Computer has made its move");
                System.out.println("Computer placed at Column "+(col+1));
                return;
            }
        }
    }
    public static void update_streak(char state) {
        if(state=='w') {
            win_streak++;
            loss_streak = 0;
            draw_streak = 0;
        }
        else if(state=='l') {
            loss_streak++;
            win_streak = 0;
            draw_streak = 0;
        }
        else if(state=='d') {
            draw_streak++;
            win_streak = 0;
            loss_streak = 0;
        }
    }
    public static void streak(){
        if(win_streak > 1)
            System.out.println("\nYou are on a win-streak of " + win_streak + " wins!");
        else if(loss_streak > 1)
            System.out.println("\nYou are on a loss-streak of " + loss_streak + " losses!");
        else if(draw_streak > 1)
            System.out.println("\nYou are on a draw-streak of " + draw_streak + " drawn games");
    }
    public static void start_game() throws InterruptedException {
        reset_board();
        first_move();
        String roundSummary;
        while(true) {
            if (move==0){
                System.out.println("Your move");
                total_moves++;
                user_move();
                print_board();
                if(hasWon(user)){
                    System.out.println("""
                            
                            ***************
                            *   \u001B[32mYOU WIN!\u001B[0m  *
                            ***************
                            """);
                    game_count++;
                    win_count++;
                    update_streak('w');
                    score(total_moves,'w');
                    streak();
                    roundSummary = "Round " + round + ": Winner - YOU in " + total_moves + " moves";
                    history.add(roundSummary);
                    showMoves();
                    break;
                }
                if(isDraw()){
                    System.out.println("It's a draw!");
                    draw_count++;
                    game_count++;
                    update_streak('d');
                    score(total_moves,'d');
                    streak();
                    roundSummary = "Round " + round + ": Draw in " + total_moves + " moves";
                    history.add(roundSummary);
                    showMoves();
                    break;
                }
                move=1;
            }
            if (move==1){
                System.out.println("Computer's move");
                total_moves++;
                comp_move();
                print_board();
                if(hasWon(comp)){
                    System.out.println("""
                            
                            ***************
                            *   \u001B[31mYou Lost!\u001B[0m *
                            ***************
                            """);
                    loss_count++;
                    game_count++;
                    update_streak('l');
                    score(total_moves,'l');
                    streak();
                    roundSummary = "Round " + round + ": Winner - Computer in " + total_moves + " moves";
                    history.add(roundSummary);
                    showMoves();
                    break;
                }
                if(isDraw()){
                    System.out.println("It's a draw!");
                    draw_count++;
                    game_count++;
                    update_streak('d');
                    score(total_moves,'d');
                    streak();
                    roundSummary = "Round " + round + ": Draw in " + total_moves + " moves";
                    history.add(roundSummary);
                    showMoves();
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
        char replay='y';
        while(replay=='y') {
            clearMoves();
            start_game();
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
        int win_perc = (win_count*100)/game_count;
        int loss_perc = (loss_count*100)/game_count;
        int draw_perc = (draw_count*100)/game_count;
        System.out.println("\n---------Statistics----------");
        System.out.println("Games Played: " + game_count);
        System.out.println("Wins: " + win_count + " (" + win_perc + "%)");
        System.out.println("Losses: " + loss_count + " (" + loss_perc + "%)");
        System.out.println("Draws: " + draw_count + " (" + draw_perc + "%)");
        System.out.println("\nGame History Log:");
        for (String roundSummary : history)
            System.out.println(roundSummary);
        System.out.println("------------------------------\n");
    }
    public static void main(String[] args) throws InterruptedException {
        instructions();
        getUser();
        run_game();
        stats();
    }
}