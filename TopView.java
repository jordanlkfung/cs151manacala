import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
public class TopView extends JPanel implements ChangeListener{
	MancalaData data;
	JLabel text = new JLabel();
	JPanel selection = new JPanel();
	public TopView(MancalaData ref) {
		JButton question = new JButton("How many pieces per pit?");
		JButton undoButton = new JButton("undo");
		question.setBorderPainted(false);
//		JButton one = new JButton("1");
//		JButton two = new JButton("2");
//		JButton three = new JButton("3");
//		JButton four = new JButton("4");
		selection.setLayout(new GridLayout(0,1));
		JLabel choices = new JLabel();
		for(int i=1;i<5;i++) {
			JButton temp = new JButton(String.valueOf(i));
			temp.addActionListener(e->{this.removeAll();
			this.add(text);
			this.add(undoButton);
			this.revalidate();
//			text.setText("PLAYER A'S TURN");
			});
			choices.add(temp);
		}
		choices.setLayout(new GridLayout(1,0));
//		choices.add(one);
//		choices.add(two);
//		choices.add(three);
//		choices.add(four);
		selection.add(question);
		selection.add(choices);
		data=ref;
		this.setLayout(new FlowLayout());
		undoButton.addActionListener(e->{});
		undoButton.setFocusPainted(false);
//		this.add(text);
//		this.add(undoButton);
		this.add(selection);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		if(data.getUser()==1)
			text.setText("PLAYER A'S TURN");
		else
			text.setText("PLAYER B'S TURN");
	}

}
