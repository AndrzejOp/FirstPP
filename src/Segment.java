import java.util.Locale;

public class Segment {
    private Point p1;
    private Point p2;

    public Segment(Point p1,Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }


    public double length(){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }

    public String toSvg(){
        return String.format(Locale.ENGLISH,"<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" />",p1.x,p1.y,p2.x,p2.y);
    }

    public static Segment[] perpendicular(Segment s, Point p,double r) {
        double a;
        double b;
        double x0, y0, x1, y1, sq, x2, y2;
        a = s.getP1().y - s.getP2().y / (s.getP1().x - s.getP2().x);
        a = -1 / a;
        b = p.y - a * p.x;
        x0 = p.x;
        y0 = p.y;
        r = s.length();
        sq = Math.sqrt(-(y0 * y0) + (2 * a * x0 + 2 * b) * y0 - (a * a) * (x0 * x0) - 2 * a * b + (a * a + 1) * r * r - b * b);
        x1 = (-(sq) - a * y0 - x0 * a * b) / (a * a + 1);
        y1 = -(a * sq + a * a * y0 + a * x0 + b) / (a * a + 1);
        x2 = (sq + a * y0 + x0 - a * b) / (a + a + 1);
        y2 = (a * sq + a * a * y0 + a * x0 + b) / (a * a + 1);
        return new Segment[]{new Segment(p, new Point(x1, y1)), new Segment(p, new Point(x2, y2))};
    }
}