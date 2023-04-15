import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
public class manacalaView extends JPanel implements ChangeListener{

	@Override
	public void stateChanged(ChangeEvent e) {
		repaint();
		
	}

}
