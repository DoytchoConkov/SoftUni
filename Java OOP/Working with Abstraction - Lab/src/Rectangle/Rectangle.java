package Rectangle;


public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains( Point point) {
        boolean isContain;
        isContain = point.getX() >= this.bottomLeft.getX() && point.getX() <= this.topRight.getX() && point.getY() >= this.bottomLeft.getY() && point.getY() <= this.topRight.getY();
        return isContain;
    }
}
