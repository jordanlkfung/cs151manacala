import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class NormalBoard implements DisplayStrategy {
	MancalaData data;
	public NormalBoard(MancalaData d) {
		data=d;
	}
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
