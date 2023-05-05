import javax.swing.*;
import java.awt.*;
public class MainTest{
	public static void main(String args[]) {
		MancalaData data = new MancalaData();
		JFrame option = new JFrame();
		option.setLayout(new GridLayout(0,1));
		JButton question = new JButton("Pick a style");
		JButton normal = new JButton("Normal");
		normal.addActionListener(e->{
			data.showBoard(new NormalBoard(data));
			option.setVisible(false);
		});
		JButton colorful = new JButton("Colorful");
		colorful.addActionListener(e->{
			data.showBoard(new ColoredBoard(data));
			option.setVisible(false);});
		option.add(question);
		JPanel holder = new JPanel();
		holder.setLayout(new GridLayout(1,0));
		holder.add(normal);
		holder.add(colorful);
		option.add(holder);
		option.setSize(200, 100);
		option.setVisible(true);
		option.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}