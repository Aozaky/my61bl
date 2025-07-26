import javax.sound.sampled.Port;

/** A class that represents a path via pursuit curves. */
public class Path {
    private Point curr;
    private Point next;

    public Path(double x, double y) {
        this.next = new Point(x, y);
        this.curr = new Point();
    }

    public double getCurrX() {
        return this.curr.getX();
    }

    public double getCurrY() {
        return this.curr.getY();
    }

    public double getNextX() {
        return this.next.getX();
    }

    public double getNextY() {
        return this.next.getY();
    }

    public Point getCurrentPoint() {
        return this.curr;
    }

    public void setCurrentPoint(Point curr) {
        this.curr = curr;
    }

    public void iterate(double dx, double dy) {
        this.setCurrentPoint(this.next);
        this.next = new Point(this.getCurrX()+dx, this.getCurrY()+dy);
    }
}
