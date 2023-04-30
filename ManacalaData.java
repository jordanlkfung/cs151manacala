import java.util.*;
import javax.swing.event.*;

public class ManacalaData{
	ArrayList<ChangeListener> listeners;
	
	int[][] board = new int[2][7];
//	int[] score = new int[2];//a=0, b=1
	int currentUser=0;//user a=0, user b =1
	public ManacalaData(int startingPitSize) {
		listeners = new ArrayList<>();
		for(int i=0;i<board.length;i++) {
			for(int j=0;i<board.length-1;j++) {
				board[i][j]=startingPitSize;
			}
		}
	}
	
	public void move(String pieceSelected) {
		//then with every move update view
		int spotsToMove = board[currentUser][Integer.valueOf(pieceSelected.substring(1))];
		int counter=Integer.valueOf(pieceSelected.substring(1));
		board[currentUser][counter]=0;
		int row = currentUser;
		while(spotsToMove>=0) {
			if(counter>6) {
				row=(row+1)%2;
				counter=0;
			}
			board[row][counter]=board[row][counter]+1;
			counter++;
			spotsToMove--;
		}
	}
	
	public void addChangeListener(ChangeListener a) {
		listeners.add(a);
	}
	public int[][] getBoard() {
		return board;
	}
	public int getUser() {
		return currentUser;
	}	
	public int getPit(int user,int number) {
		return board[user][number];
	}
}

