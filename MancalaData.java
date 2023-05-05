import java.util.*;
import javax.swing.event.*;
/**
 * The MancalaData class represents the data model of a Mancala game. It keeps track of the state of the game board, 
 * the current player, and whether or not the game is over. It also provides methods for making moves, undoing moves, 
 * getting the score, and displaying the game board.
 * @author jordan fung
 */
public class MancalaData{
	/** The listeners for this data model */
	private ArrayList<ChangeListener> listeners;
	
	/** The current state of the game board */
	private int[][] board;
	
	/** The state of the game board before the last move */
	private int[][] lastBoard;
	
	/** A flag indicating whether the undo button has been pressed */
	private boolean undoPressed = false;
	
	/** The number of times the undo button has been pressed in a row */
	private int undoPressedCount = 0;
	
	/** The current player (0 = Player A, 1 = Player B) */
	private int currentUser = 1;
	
	/**
	 * Constructs a new MancalaData object.
	 */
	public MancalaData() {
		listeners = new ArrayList<>();
		board=new int[2][7];
		lastBoard=new int[2][7];
	}
	/**
	 * Sets the starting size of all the pits on the board.
	 * @param startingPitSize the starting size of the pits
	 */
	public void setStartingSize(int startingPitSize) {
		for(int i=0;i<2;i++) {
			for(int j=0;j<6;j++) {
				board[i][j]=startingPitSize;
			}
		}
		update();
	}
	/**
	 * Moves the pieces on the board according to the selected pit.
	 * @param pieceSelected the selected pit to move
	 */
	public void move(String pieceSelected) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				lastBoard[i][j]=board[i][j];
			}
		}
		undoPressed=false;
		undoPressedCount=0;
		//then with every move update view
		boolean freeTurn=false;
		int spotsToMove = board[currentUser][Integer.valueOf(pieceSelected.substring(1))];
		int counter=Integer.valueOf(pieceSelected.substring(1));
		board[currentUser][counter]=0;
		int row = currentUser;
		counter++;
		while(spotsToMove>0) {
			freeTurn=false;
			if(spotsToMove==1&&counter!=6&&row==currentUser&&board[row][counter]==0&&board[(row+1)%2][5-counter]!=0) {
				//capture opposite side
				board[row][6]=board[(row+1)%2][5-counter]+board[row][6]+1;
				board[(row+1)%2][5-counter]=0;
				spotsToMove--;
			}
			else if(counter==6) {
				if(row==currentUser) {//checking if it is users home pit
					//adding to home pit/score
					board[row][counter]=board[row][counter]+1;
					spotsToMove--;
					freeTurn=true;
				}
				row=(row+1)%2;
				counter=0;
			}
			else {//regular moving
				board[row][counter]=board[row][counter]+1;
				counter++;
				spotsToMove--;
			}
			update();
		}
		if(!freeTurn)//checking if user has free turn
			currentUser=(currentUser+1)%2;
		if(gameOver()) {
			getScore();
		}
		update();
	}
	/**
	 * adds a change listener to the data model
	 * @param a the change listener to add
	 */
	public void addChangeListener(ChangeListener a) {
		listeners.add(a);
	}
	/**
	 * returns the curremt user
	 * @return 1 for A, 0 for B
	 */
	public int getUser() {
		return currentUser;
	}	
	/**
	 * gets value of entered pit
	 * @param user what side the pit is on
	 * @param number the pit number
	 * @return the number of pieces in the pit
	 */
	public int getPit(int user,int number) {
		return board[user][number];
	}
	/**
	 * Updates the state of the game by notifying all registered ChangeListeners of a state change.
	 */
	private void update() {
		for(ChangeListener l : listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
	/**
	 *Checks if the game is over.
	 *@return true if the game is over, false otherwise.
	 */
	private boolean gameOver() {
		for(int i=0;i<board.length;i++) {
			int counter=0;
			for(int j=0;j<board[i].length-1;j++) {
				counter+=board[i][j];
			}
			if(counter==0)
				return true;
		}
		return false;
	}
	/**
	 * is called when the game is over, moves all remaining pieces into the correct pits
	 */
	private void getScore() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length-1;j++) {
				board[i][6]+=board[i][j];
				board[i][j]=0;
			}
		}
	}
	/**
	 * Checks if an undo operation is possible.
	 * @return true if an undo operation is possible, false otherwise.
	 */
	public boolean undoPossible() {
		return !undoPressed&&undoPressedCount<3;
	}
	/**
	 *Undoes the last move made by the current player.
	 *If an undo operation is performed, it switches the current player to the previous one.
	 */
	public void undo() {
		undoPressed=true;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=lastBoard[i][j];
			}
		}
		currentUser=(currentUser+1)%2;
		undoPressedCount++;
		update();
	}
	/**
	 * shows the board based on the strategy
	 * @param strategy display strategy being used
	 */
	public void showBoard(DisplayStrategy strategy) {
		strategy.display();
	}
}

