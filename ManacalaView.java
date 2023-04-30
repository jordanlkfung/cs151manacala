import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
public class ManacalaView extends JPanel implements ChangeListener{
	JButton[] userA= new JButton[7];
	JButton[] userB= new JButton[7];
	ManacalaData mData;
	public ManacalaView() {
		JLabel pits = new JLabel();
		pits.setLayout(new GridLayout(0,6));
		for(int i=userB.length-2;i>=0;i--) {
			JButton temp = new JButton(" t");
			temp.setName("B"+i);
			userB[i]=temp;
			temp.addActionListener(e->{
				if(mData.getUser()==0) {
					//add check to see if row is empty?
					JButton a = (JButton)e.getSource();
					mData.move(a.getName());
					System.out.println(a.getName());
				}
			});
			pits.add(temp);

		}
		for(int i=0;i<userA.length-1;i++) {
			JButton temp = new JButton(" t");
			temp.setName("A"+i);
			userA[i]=temp;
			temp.addActionListener(e->{
				if(mData.getUser()==1) {
					JButton a = (JButton)e.getSource();
					mData.move(a.getName());
					System.out.println(a.getName());
				}
			});
			pits.add(temp);

		}
		this.setLayout(new BorderLayout());
		this.add(pits,BorderLayout.CENTER);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
//		repaint();
		
	}
	public void updatePits() {
		
	}
}
