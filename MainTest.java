import java.awt.*;
import javax.swing.*;

public class MainTest{
	public static void main(String args[]) {
		MancalaData data = new MancalaData(1);
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
		test.setSize(400,400);
		test.setMaximumSize(new Dimension(400,400));
		test.setMinimumSize(new Dimension(400,400));

	}
}