import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ColoredBoard implements DisplayStrategy {
	MancalaData data;
	public ColoredBoard(MancalaData d) {
		data=d;
	}
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
		test.setSize(400,400);
		test.setMaximumSize(new Dimension(400,400));
		test.setMinimumSize(new Dimension(400,400));
	}
}
