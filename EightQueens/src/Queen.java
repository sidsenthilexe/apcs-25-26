public class Queen {
    private final int x;
    private final int y;

    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean squareThreatened(Queen other) {
        if (this.x == other.getX()) return true;

        if (this.y == other.getY()) return true;

        if ( Math.abs( (this.y - other.getY()) ) == Math.abs( (this.x - other.getX()) )) return true;

        return false;
    }

}
