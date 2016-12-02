package ticktacktoe;

/**
 * Created by Dell on 13-11-2016.
 */
public class TickTackToe {

        protected char[] board; //9 positions in the board
        protected char userMarker; //user's marker O or X
        protected char aiMarker; // Computer's marker O or X
        protected char winner;
        protected char currentMarker; // marker is currently on whom? user or Comp

    public TickTackToe(char playerToken, char aiMarker){
        this.userMarker = playerToken;
        this.aiMarker = aiMarker;
        this.winner = '-';
        this.board = setBoard();
        this.currentMarker = userMarker;

    }

    /**
     * setting up a new empty board
     */
    public char[] setBoard(){
        char[] board= new char[9];
        for(int i=0;i<9; i++)
            board[i] = '-';
        return board;
    }

    public boolean playTurn(int spot) {
        boolean isValid = withinRange(spot) && !isSpotTaken(spot);
        if (isValid) {
            board[spot - 1] = currentMarker;
            currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
        }
        return isValid;
    }
    // Check if spot is taken
    public boolean withinRange(int number){
        return number > 0 && number < board.length + 1;
    }

    //Check if spot is taken or not?
    public boolean isSpotTaken(int number){
        return board[number-1] != '-';
    }

    public void printBoard(){
        // Attempting to create
        // | - | - | -
        // ------------
        // | - | - | -
        // ------------
        // | - | - | -

        System.out.println("");
        for(int i = 0; i<board.length; i++){
            if(i%3 == 0 && i!=0){
                System.out.println();
                System.out.println("------------");
            }
            System.out.print(" | " + board[i]);
        }
        System.out.println();
    }
    public static void printIndexBoard(){
        // Attempting to create
        // | - | - | -
        // ------------
        // | - | - | -
        // ------------
        // | - | - | -

        System.out.println("");
        for(int i = 0; i<9; i++){
            if(i%3 == 0 && i!=0){
                System.out.println();
                System.out.println("------------");
            }
            System.out.print(" | " + (i+1));
        }
        System.out.println();
    }

    public boolean isThereAWinner(){
        boolean diagonalsAndMiddles = (rightDi() || leftDi() || middleRow() || secondCol()) && board[4] != '-';
        boolean topAndFirst = (topRow() || firstCol()) && board[0] != '-';
        boolean bottomAndThird = (bottomRow() || thirdCol()) && board[8] != '-';

        if(diagonalsAndMiddles){
            this.winner = board[4];
        }
        if(topAndFirst){
            this.winner = board[0];
        }
        if(bottomAndThird){
            this.winner = board[8];
        }

        return diagonalsAndMiddles || topAndFirst || bottomAndThird;
    }

    public boolean topRow() {
        return board[0] == board[1] && board[0] == board[1];
    }
    public boolean middleRow() {
        return board[3] == board[4] && board[4] == board[5];
    }
    public boolean bottomRow() {
        return board[6] == board[7] && board[7] == board[8];
    }
    public boolean firstCol() {
        return board[0] == board[3] && board[3] == board[6];
    }
    public boolean secondCol() {
        return board[1] == board[4] && board[4] == board[7];
    }
    public boolean thirdCol() {
        return board[2] == board[5] && board[5] == board[8];
    }
    public boolean rightDi() {
        return board[0] == board[4] && board[4] == board[8];
    }
    public boolean leftDi() {
        return board[2] == board[4] && board[4] == board[6];
    }

    public boolean isTheBoardFilled() {
        for(int i =0; i< board.length ; i++){
            if (board[i] == '-'){
                return false;
            }
        }
        return true;
    }

    public String gameOver(){
        boolean didSomeoneWin = isThereAWinner();
        if (didSomeoneWin){
            return "We have a winner! The winner is - " + this.winner + "'s";
        }
        else if(isTheBoardFilled()){
            return "Draw: Game Over";
        }
        else{
            return "notOver";
        }
    }
}
