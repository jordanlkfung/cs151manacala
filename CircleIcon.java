import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class CircleIcon implements Icon {
        private int numCircles;
        private static final int CIRCLE_SIZE = 10;
        private static final int PADDING = 2;

        public CircleIcon(int numCircles) {
            this.numCircles = numCircles;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g;
            Random rand = new Random();
            int numRows = (int) Math.ceil(Math.sqrt(numCircles));
            int numCols = (int) Math.ceil((double) numCircles / numRows);
            int totalWidth = numCols * CIRCLE_SIZE + (numCols - 1) * PADDING;
            int totalHeight = numRows * CIRCLE_SIZE + (numRows - 1) * PADDING;
            int startX = x + (getIconWidth() - totalWidth) / 2;
            int startY = y + (getIconHeight() - totalHeight) / 2;

            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    if (numCircles == 0) {
                        break;
                    }
                    int centerX = startX + col * (CIRCLE_SIZE + PADDING) + CIRCLE_SIZE / 2;
                    int centerY = startY + row * (CIRCLE_SIZE + PADDING) + CIRCLE_SIZE / 2;
                    Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                    g2.setColor(color);
                    g2.fillOval(centerX - CIRCLE_SIZE / 2, centerY - CIRCLE_SIZE / 2, CIRCLE_SIZE, CIRCLE_SIZE);
                    numCircles--;
                }
            }
        }

        @Override
        public int getIconWidth() {
            int numRows = (int) Math.ceil(Math.sqrt(numCircles));
            int numCols = (int) Math.ceil((double) numCircles / numRows);
            return numCols * CIRCLE_SIZE + (numCols - 1) * PADDING;
        }

        @Override
        public int getIconHeight() {
            int numRows = (int) Math.ceil(Math.sqrt(numCircles));
            int numCols = (int) Math.ceil((double) numCircles / numRows);
            return numRows * CIRCLE_SIZE + (numRows - 1) * PADDING;
        }
}
