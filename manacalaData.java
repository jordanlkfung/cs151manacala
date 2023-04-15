import java.util.*;
import javax.swing.event.*;

public class manacalaData{
	ArrayList<ChangeListener> listeners;
	
	int[] bRow = new int[7];
	int[] aRow = new int[7];
	public manacalaData(int startingPit) {
		listeners = new ArrayList<>();
	}
	
	public void move(int pieceSelected) {
		//check if player can actually place that piece
		//then with every move update view
	}
	
	public void addChangeListener(ChangeListener a) {
		listeners.add(a);
	}
}

