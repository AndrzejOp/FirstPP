import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SvgScene {
    private List<Polygon> l = new ArrayList<>();
    private double width=500,height=500;
    public void addPolygon(Polygon polygon){
        l.add(polygon);
    }
    public void save(String path){
        try{
            FileWriter file=new FileWriter(path);
            file.write("<html>\n<body>\n");
            file.write(String.format(Locale.ENGLISH,"<svg height=\"%f\" width=\"%f\"/",height,width));
            for(Polygon p:l)
            {
                file.write("\t"+p.toSvg());
            }
            file.write("</svg>\n</body>\n</html>");
        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}