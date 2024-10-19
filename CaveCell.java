

public class CaveCell {
    int row, col;
    int depth;
    boolean isEscapeRoute;

    public CaveCell(int row, int col, int depth) {
        this.row = row;
        this.col = col;
        this.depth = depth;
        this.isEscapeRoute = false;
    }

    public void markAsEscapeRoute() {
        this.isEscapeRoute = true;
    }

    public boolean isEscapeRoute() {
        return isEscapeRoute;
    }

    public int getDepth() {
        return depth;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
