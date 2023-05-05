/**
 * ColoredBoard is a class that implements the DisplayStrategy interface. It displays the mancala board and
 * pits using a colored background.
 * @author Jordan Fung
 * @version 1.0
 */
import java.awt.*;
import javax.swing.JFrame;

public class ColoredBoard implements DisplayStrategy {
	MancalaData data;
	/**
	 * Constructs a new ColoredBoard object with the specified MancalaData object.
	 * 
	 * @param d the MancalaData object containing the game data
	 */
	public ColoredBoard(MancalaData d) {
		data=d;
	}
	/**
	 * Displays the mancala board and pits using a colored background.
	 */
	@Override
	public void display() {
		TopView top = new TopView(data);
		MancalaView view = new MancalaView(data);
		view.setBackground(Color.blue);
		view.setOpaque(true);
		top.setBackground(view.getBackground());
		view.setOpaque(true);
		data.addChangeListener(view);
		data.addChangeListener(top);
		JFrame test = new JFrame();
		test.setLayout(new BorderLayout());
		test.add(view, BorderLayout.CENTER);
		test.add(top,BorderLayout.NORTH);
		test.setVisible(true);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(600,550);
//		test.setMaximumSize(new Dimension(400,400));
//		test.setMinimumSize(new Dimension(400,400));
	}
}
