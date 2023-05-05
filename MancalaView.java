import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
public class MancalaView extends JPanel implements ChangeListener{
	JButton[] userA= new JButton[7];
	JButton[] userB= new JButton[7];
	MancalaData mData;
	public MancalaView(MancalaData d) {
		mData=d;
		JLabel pits = new JLabel();
		JPanel labelB = new JPanel();
		labelB.setLayout(new GridLayout(0,6));
		JPanel labelA = new JPanel();
		labelA.setLayout(new GridLayout(0,6));
		pits.setLayout(new GridLayout(0,6));
		for(int i=userB.length-2;i>=0;i--) {
			JButton label = new JButton("B"+(i+1));
			label.setBorderPainted(false);
			label.setSize(10, 5);
			label.setMaximumSize(label.getSize());
			labelB.add(label);
			JButton temp = new JButton();
			temp.setName("B"+i);
			userB[i]=temp;
			temp.addActionListener(e->{
				if(mData.getUser()==0) {
					JButton a = (JButton)e.getSource();
					mData.move(a.getName());
				}
				updatePits();
			});
			pits.add(temp);

		}
		for(int i=0;i<userA.length-1;i++) {
			JButton label = new JButton("A"+(i+1));
			label.setBorderPainted(false);
			labelA.add(label);
			JButton temp = new JButton();
			temp.setName("A"+i);
			userA[i]=temp;
			temp.addActionListener(e->{
				if(mData.getUser()==1) {
					JButton a = (JButton)e.getSource();
					mData.move(a.getName());
				}
				updatePits();
			});
			pits.add(temp);
		}
		userA[userA.length-1]= new JButton();
		userA[userA.length-1].setText("<html>M<br>a<br>n<br>c<br>a<br>l<br>a<br><br>A</html>");
		userA[userA.length-1].setVerticalTextPosition(SwingConstants.BOTTOM);
		userA[userA.length-1].setHorizontalTextPosition(SwingConstants.RIGHT);
		userA[6].setFocusPainted(false);
		userA[6].setPreferredSize(new Dimension(80,100));
		userA[6].addActionListener(e->updatePits());
		userB[userB.length-1]= new JButton();
		userB[userA.length-1].setText("<html>M<br>a<br>n<br>c<br>a<br>l<br>a<br><br>B</html>");
		userB[userA.length-1].setVerticalTextPosition(SwingConstants.BOTTOM);
		userB[userA.length-1].setHorizontalTextPosition(SwingConstants.LEFT);
		userB[6].addActionListener(e->updatePits());
		userB[6].setFocusPainted(false);
		userB[6].setPreferredSize(new Dimension(80,100));
		userB[6].setSize(70, 300);

		this.setLayout(new BorderLayout());
		JPanel pitLayout = new JPanel();
		pitLayout.setLayout(new BorderLayout());
		pitLayout.add(labelB,BorderLayout.NORTH);
		pitLayout.add(pits,BorderLayout.CENTER);
		pitLayout.add(labelA,BorderLayout.SOUTH);
		this.add(pitLayout,BorderLayout.CENTER);
		this.add(userA[userA.length-1],BorderLayout.EAST);
		this.add(userB[userB.length-1],BorderLayout.WEST);
		updatePits();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		updatePits();
		
	}
	public void updatePits() {
		for(int i=0;i<userA.length;i++) {
			userA[i].setIcon(new CircleIcon(mData.getPit(1, i)));
		}
		for(int i=0;i<userB.length;i++) {
			userB[i].setIcon(new CircleIcon(mData.getPit(0, i)));
		}
		repaint();
	}
}
