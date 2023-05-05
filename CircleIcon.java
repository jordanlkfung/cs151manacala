import javax.swing.*;
import java.awt.*;
/**
 * An implementation of the Icon interface that displays a grid of circles.
 * The number of circles in the grid is specified by the constructor argument.
 * @author Jordan Fung
 */
public class CircleIcon implements Icon {

    private int numCircles;
    private static final int CIRCLE_SIZE = 10;
    private static final int PADDING = 2;

    /**
     * Creates a new CircleIcon object with the specified number of circles.
     *
     * @param numCircles the number of circles to display in the icon
     */
    public CircleIcon(int numCircles) {
        this.numCircles = numCircles;
    }

    /**
     * Paints the icon on the specified component.
     *
     * @param c the component on which to paint the icon
     * @param g the graphics context to use for painting
     * @param x the x-coordinate at which to paint the icon
     * @param y the y-coordinate at which to paint the icon
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
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
                Color color = new Color(65, 105, 225);
                g2.setColor(color);
                g2.fillOval(centerX - CIRCLE_SIZE / 2, centerY - CIRCLE_SIZE / 2, CIRCLE_SIZE, CIRCLE_SIZE);
                numCircles--;
            }
        }
    }

    /**
     * Returns the width of the icon.
     *
     * @return the width of the icon
     */
    @Override
    public int getIconWidth() {
        int numRows = (int) Math.ceil(Math.sqrt(numCircles));
        int numCols = (int) Math.ceil((double) numCircles / numRows);
        return numCols * CIRCLE_SIZE + (numCols - 1) * PADDING;
    }

    /**
     * Returns the height of the icon.
     *
     * @return the height of the icon
     */
    @Override
    public int getIconHeight() {
        int numRows = (int) Math.ceil(Math.sqrt(numCircles));
        int numCols = (int) Math.ceil((double) numCircles / numRows);
        return numRows * CIRCLE_SIZE + (numRows - 1) * PADDING;
    }
}
