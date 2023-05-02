import java.util.*;
import javax.swing.event.*;

public class ManacalaData{
	ArrayList<ChangeListener> listeners;
	
	int[][] board = new int[2][7];
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
		counter++;
		while(spotsToMove>0) {
			if(spotsToMove==1&&row==currentUser&&board[row][counter]==0) {
				//capture opposite side
				board[row][6]=board[(row+1)%2][counter]+board[row][6]+1;
				board[(row+1)%2][counter]=0;
			}
			else if(counter==6) {
				if(row==currentUser) {
					//adding to home pit/score
					board[row][counter]=board[row][counter]+1;
					spotsToMove--;
				}
				row=(row+1)%2;
				counter=0;
			}
			else {
				board[row][counter]=board[row][counter]+1;
				counter++;
				spotsToMove--;
			}
		}
		if(counter!=6)
			currentUser=(currentUser+1)%2;
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

