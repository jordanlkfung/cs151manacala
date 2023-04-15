import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class manacalaController{
	manacalaData data;
	public manacalaController(manacalaData ref) {
		data=ref;
		JButton undoButton = new JButton("undo");
		undoButton.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

					}

				});
		
		ActionListener pitAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

}
