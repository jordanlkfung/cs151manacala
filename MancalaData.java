import java.util.*;
import javax.swing.event.*;

public class MancalaData{
	private ArrayList<ChangeListener> listeners;
	private int[][] board;
	private int[][] lastBoard;
	private boolean undoPressed=false;
	private int undoPressedCount=0;
	private int currentUser=1;//user a=1, user b =0
	public MancalaData() {
		listeners = new ArrayList<>();
		board=new int[2][7];
		lastBoard=new int[2][7];
	}
	public void setStartingSize(int startingPitSize) {
		for(int i=0;i<2;i++) {
			for(int j=0;j<6;j++) {
				board[i][j]=startingPitSize;
			}
		}
		update();
	}
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
			if(spotsToMove==1&&counter!=6&&row==currentUser&&board[row][counter]==0&&board[(row+1)%2][counter]!=0) {
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
	public void addChangeListener(ChangeListener a) {
		listeners.add(a);
	}
	public int getUser() {
		return currentUser;
	}	
	public int getPit(int user,int number) {
		return board[user][number];
	}
	private void update() {
		for(ChangeListener l : listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
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
	private void getScore() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length-1;j++) {
				board[i][6]+=board[i][j];
				board[i][j]=0;
			}
		}
	}
	public boolean undoPossible() {
		return !undoPressed&&undoPressedCount<3;
	}
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
	public void showBoard(DisplayStrategy strategy) {
		strategy.display();
	}
}

