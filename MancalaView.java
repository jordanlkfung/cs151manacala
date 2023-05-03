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
		pits.setLayout(new GridLayout(2,6));
		for(int i=userB.length-2;i>=0;i--) {
			JButton temp = new JButton();
			temp.setName("B"+i);
			userB[i]=temp;
			temp.addActionListener(e->{
				if(mData.getUser()==0) {
					//add check to see if row is empty?
					JButton a = (JButton)e.getSource();
					mData.move(a.getName());
				}
				updatePits();
			});
			pits.add(temp);

		}
		for(int i=0;i<userA.length-1;i++) {
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
		userA[6].setFocusPainted(false);
		userA[6].setPreferredSize(new Dimension(50,400));
		userA[6].addActionListener(e->updatePits());
		userB[userB.length-1]= new JButton();
		userB[6].addActionListener(e->updatePits());
		userB[6].setFocusPainted(false);
		userB[6].setPreferredSize(new Dimension(50,400));
		this.setLayout(new BorderLayout());
		this.add(pits,BorderLayout.CENTER);
		this.add(userA[userA.length-1],BorderLayout.EAST);
		this.add(userB[userB.length-1],BorderLayout.WEST);
		JButton top = new JButton("PLAYER B");
		top.setBorderPainted(false);
		this.add(top,BorderLayout.NORTH);
		JButton bottom = new JButton("PLAYER A");
		bottom.setBorderPainted(false);
		this.add(bottom,BorderLayout.SOUTH);
		updatePits();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		updatePits();
		
	}
	public void updatePits() {
		for(int i=0;i<userA.length;i++) {
//			userA[i].setIcon(new CircleIcon(4));
			userA[i].setIcon(new CircleIcon(mData.getPit(1, i)));
			userA[i].revalidate();
		}
		for(int i=0;i<userB.length;i++) {
//			userB[i].setIcon(new CircleIcon(4));
			userB[i].setIcon(new CircleIcon(mData.getPit(0, i)));
			userB[i].revalidate();
		}
		repaint();
	}
}
