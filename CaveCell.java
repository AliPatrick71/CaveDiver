/**
 * Cave Diver Project
 * Author: 
 * Date: 9th October 2024
 * 
 * The CaveCell class represents a single cell in the underwater cave grid. 
 * Each cell contains information about its location, depth, and whether it's part of the escape route.
 */
public class CaveCell {
    private int row, col;  // The row and column of the cell in the grid.
    private int depth;     // The depth of the cell.
    private boolean isEscapeRoute;  // Whether the cell is part of the escape route.

    /**
     * Constructs a CaveCell object.
     * 
     * @param row The row location of the cell in the grid.
     * @param col The column location of the cell in the grid.
     * @param depth The depth value of the cave cell.
     */
    public CaveCell(int row, int col, int depth) {
        this.row = row;
        this.col = col;
        this.depth = depth;
        this.isEscapeRoute = false;
    }

    /**
     * Marks the cave cell as part of the escape route.
     */
    public void markAsEscapeRoute() {
        this.isEscapeRoute = true;
    }

    /**
     * Returns whether the cell is part of the escape route.
     * 
     * @return true if the cell is part of the escape route, false otherwise.
     */
    public boolean isEscapeRoute() {
        return isEscapeRoute;
    }

    /**
     * Gets the depth of the cell.
     * 
     * @return the depth of the cave cell.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Gets the row location of the cell.
     * 
     * @return the row location of the cell in the grid.
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column location of the cell.
     * 
     * @return the column location of the cell in the grid.
     */
    public int getCol() {
        return col;
    }
}
