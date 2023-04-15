import java.awt.*;
import javax.swing.*;

public class main{
	public static void main(String args[]) {
		manacalaData data = new manacalaData();
		manacalaView view = new manacalaView(data);
		data.addChangeListener(view);
	}
}