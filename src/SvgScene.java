import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SvgScene {
    private List<Polygon> list = new ArrayList<>();
    private int width=500;
    private int height=500;
    public void addPolygon(Polygon polygon){
        list.add(polygon);
    }

    public void save(String filepath){
        try
        {
            FileWriter file = new FileWriter(filepath);
            file.write("<html>\n<body>\n<svg width = \""+width+"\" height = \""+height+"\">");
            for (Polygon p: list){
                file.write("\t"+p.toSvg());
            }
            file.write("\n</svg>\n</body>\n</html>");
            file.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}