import java.awt.*;
import javax.swing.*;

public class MainTest{
	public static void main(String args[]) {
		ManacalaView view = new ManacalaView();
		JFrame test = new JFrame();
//		JPanel view = new JPanel();
//		view.setLayout(new FlowLayout());
		test.setLayout(new BorderLayout());
//		view.add(new JButton("TA"));
		test.add(new JButton("A"),BorderLayout.EAST);
		test.add(view, BorderLayout.CENTER);

		test.setVisible(true);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(400,400);
	}
}