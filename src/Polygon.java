import java.util.Locale;

public class Polygon extends Shape {
    private Point [] points;
    public Polygon(int nump,Style style){
        super (style);
        points=new Point [nump];
    }
    public void setP(int i,Point nw){
        points[i]=nw;
    }
    public void setA(Point []pts){
        points=pts;
    }

    public String toSvg(){
        String s="";
        for(Point p: points){
            s+=p.x+","+p.y+" ";
        }
        return String.format(Locale.ENGLISH,"<polygon points=\"%s\" style:\"%s\" />",s,toSvg());
    }

    public static Polygon square(Segment line,Style style){
        double x0,y0;
        x0=(line.getP1().x+line.getP2().x)/2;
        y0=(line.getP1().y+line.getP2().y)/2;
        Point center = new Point(x0,y0);
        Segment points[] = Segment.perpendicular(line,center, line.length()/2);
        Point vert[] = new Point[4];
        vert[0]=line.getP1();
        vert[1]=line.getP2();
        vert[2]=points[0].getP2();
        vert[3]=points[1].getP2();
        Polygon sq = new Polygon(4,style);
        sq.setA(vert);
        return sq;
    }
}