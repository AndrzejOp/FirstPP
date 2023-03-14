import java.util.Locale;

public class Ellipse extends Shape {
    private Point centerOfE;
    private double r1,r2;
    public Ellipse(Style style){
        super (style);
    }
    public String toSvg(){
        return String.format(Locale.ENGLISH,"<ellipse cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\"\n" +
                "  style=\"%s\"/>",centerOfE.x,centerOfE.y,r1,r2,style.toSvg());
    }
}