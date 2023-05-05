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
		selection.setLayout(new GridLayout(0,1));
		JLabel choices = new JLabel();
		for(int i=3;i<5;i++) {
			JButton temp = new JButton(String.valueOf(i));
			temp.addActionListener(e->{
				JButton a = (JButton)e.getSource();
				data.setStartingSize(Integer.valueOf(a.getText()));
				this.removeAll();
				this.add(text);
				this.add(undoButton);
				this.revalidate();
			});
			choices.add(temp);
		}
		choices.setLayout(new GridLayout(1,0));
		selection.add(question);
		selection.add(choices);
		data=ref;
		this.setLayout(new FlowLayout());
		undoButton.addActionListener(e->{
			if(data.undoPossible()) 
				data.undo();
		});
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
