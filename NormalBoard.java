/**
 * NormalBoard is a class that implements the DisplayStrategy interface. It displays the mancala board and
 * pits
 * @author Jordan Fung
 * @version 1.0
 */
import java.awt.*;
import javax.swing.JFrame;

public class NormalBoard implements DisplayStrategy {
	MancalaData data;
	/**
	 * Constructs a new NormalBoard object with the specified MancalaData object.
	 * 
	 * @param d the MancalaData object containing the game data
	 */
	public NormalBoard(MancalaData d) {
		data=d;
	}
	/**
	 * Displays the mancala board and pits.
	 */
	@Override
	public void display() {
		TopView top = new TopView(data);
		MancalaView view = new MancalaView(data);
		data.addChangeListener(view);
		data.addChangeListener(top);
		JFrame test = new JFrame();
		test.setLayout(new BorderLayout());
		test.add(view, BorderLayout.CENTER);
		test.add(top,BorderLayout.NORTH);
		test.setVisible(true);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(600,550);
//		test.setMaximumSize(new Dimension(600,550));
//		test.setMinimumSize(new Dimension(600,550));
	}
}
