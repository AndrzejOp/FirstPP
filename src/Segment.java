import java.util.Locale;

public class Segment {
    private Point a;
    private Point b;

    public Segment(Point a, Point b)
    {
        this.a=a;
        this.b=b;
    }
    public Point getA() {
        return a;
    }

    //public void setA(Point a) {
    //    this.a = a;
    //}

    public Point getB() {
        return b;
    }

    //public void setB(Point b) {
    //    this.b = b;
    //}

    public double length()
    {
        return Math.sqrt(((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)));
    }

    public String getSVG() {
        return String.format(Locale.ENGLISH, "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:black\" />", a.x, a.y, b.x, b.y);
    }

    static public Segment[] perpendicular(Segment segment, Point point){
        double a, b, x0, y0, x1, y1, x2, y2, sq, r;
        a = (segment.getA().y - segment.getB().y) / (segment.getA().x - segment.getB().x);
        b = point.y - a * point.x;
        x0 = point.x;
        y0 = point.y;
        r = segment.length();
        sq = Math.sqrt(-(y0*y0)+(2*a*x0+2*b)*y0-(a*a)*(x0*x0)-2*a*b*x0+(a*a+1)*r*r-b*b);
        x1 = (-(sq)-a*y0-x0+a*b)/(a*a+1);
        y1 = -(a*sq+a*a*y0+a*x0+b)/(a*a+1);
        x2 = (sq+a*y0+x0-a*b)/(a*a+1);
        y2 = (a*sq+a*a*y0+a*x0+b)/(a*a+1);
        return new Segment[]{new Segment(point,new Point(x1,y1)),new Segment(point,new Point(x2,y2))};

    }
}