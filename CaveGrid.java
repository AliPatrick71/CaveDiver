import java.awt.*;
import javax.swing.*;

/**
 * Cave Diver Project
 * Author:
 * Date: 9th October 2024
 * 
 * The CaveGrid class represents the underwater cave grid and handles the display of the cave 
 * and the recursive search for an escape route.
 */
public class CaveGrid extends JPanel {
    private CaveCell[][] cave;  // The 10x10 grid of CaveCell objects.

    /**
     * Constructs the CaveGrid and generates a new cave.
     */
    public CaveGrid() {
        generateNewCave();
    }

    /**
     * Generates a new random cave by assigning random depths to each cell in the grid.
     */
    public void generateNewCave() {
        cave = new CaveCell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int depth = (int) (Math.random() * 100); // Random depth between 0 and 100.
                cave[i][j] = new CaveCell(i, j, depth);
            }
        }
        repaint();  // Repaint the grid with the new cave.
    }

    /**
     * Recursively searches for an escape route from the top-left (0,0) to the bottom-right (9,9) 
     * of the cave within the given depth and air limits.
     * 
     * @param x The current row position.
     * @param y The current column position.
     * @param airLeft The remaining units of air.
     * @param maxDepth The maximum depth the diver can handle.
     * @return true if an escape route is found, false otherwise.
     */
    public boolean findEscapeRoute(int x, int y, int airLeft, int maxDepth) {
        // Base case: Reached the bottom-right corner.
        if (x == 9 && y == 9) {
            cave[x][y].markAsEscapeRoute();
            return true;
        }
        
        // Check if the current cell is within the air limit and depth rating.
        if (airLeft <= 0 || cave[x][y].getDepth() > maxDepth) {
            return false;
        }

        // Try moving right.
        if (x + 1 < 10 && findEscapeRoute(x + 1, y, airLeft - 1, maxDepth)) {
            cave[x][y].markAsEscapeRoute();
            return true;
        }

        // Try moving down.
        if (y + 1 < 10 && findEscapeRoute(x, y + 1, airLeft - 1, maxDepth)) {
            cave[x][y].markAsEscapeRoute();
            return true;
        }

        return false;
    }

    /**
     * Paints the cave grid and colors each cell based on its depth. If a cell is part of the escape route, 
     * it is painted red.
     * 
     * @param g The Graphics object used to draw the grid.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CaveCell cell = cave[i][j];
                g.setColor(getColorBasedOnDepth(cell.getDepth()));
                g.fillRect(j * 50, i * 50, 50, 50);

                // If part of the escape route, paint it red.
                if (cell.isEscapeRoute()) {
                    g.setColor(Color.RED);
                    g.fillRect(j * 50, i * 50, 50, 50);
                }
            }
        }
    }

    /**
     * Returns a color based on the depth of the cell.
     * 
     * @param depth The depth of the cell.
     * @return The color representing the depth.
     */
    private Color getColorBasedOnDepth(int depth) {
        int blueShade = 255 - depth * 2; // Adjust color shade based on depth.
        return new Color(0, 0, Math.max(0, blueShade));
    }
}
