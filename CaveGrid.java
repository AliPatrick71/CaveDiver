

import javax.swing.*;
import java.awt.*;

public class CaveGrid extends JPanel {
    private CaveCell[][] cave;

    public CaveGrid() {
        generateNewCave();
    }

    public void generateNewCave() {
        cave = new CaveCell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int depth = (int) (Math.random() * 100); // Random depth
                cave[i][j] = new CaveCell(i, j, depth);
            }
        }
        repaint();
    }

    public boolean findEscapeRoute(int x, int y, int airLeft, int maxDepth) {
        if (x == 9 && y == 9) {
            cave[x][y].markAsEscapeRoute();
            return true;
        }
        if (airLeft <= 0 || cave[x][y].getDepth() > maxDepth) {
            return false;
        }

        if (x + 1 < 10 && findEscapeRoute(x + 1, y, airLeft - 1, maxDepth)) {
            cave[x][y].markAsEscapeRoute();
            return true;
        }

        if (y + 1 < 10 && findEscapeRoute(x, y + 1, airLeft - 1, maxDepth)) {
            cave[x][y].markAsEscapeRoute();
            return true;
        }

        return false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CaveCell cell = cave[i][j];
                g.setColor(getColorBasedOnDepth(cell.getDepth()));
                g.fillRect(j * 50, i * 50, 50, 50);

                if (cell.isEscapeRoute()) {
                    g.setColor(Color.RED);
                    g.fillRect(j * 50, i * 50, 50, 50);
                }
            }
        }
    }

    private Color getColorBasedOnDepth(int depth) {
        int blueShade = 255 - depth * 2; 
        return new Color(0, 0, Math.max(0, blueShade));
    }
}
