
public class Style {
    public final String fillColor;
    public final String strokeColor;
    public final double strokeWidth;

    Style(String fillColor, String strokeColor, double strokeWidth){
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public String toSvg(){
        String basic;
        if(fillColor != null)
        {
            basic = "fill: "+fillColor;
        }
        else
        {
            basic = "fill: transparent";
        }
        if(strokeColor != null)
        {
            basic += "stroke:"+strokeColor;
        }
        else
        {
            basic += "stroke:black";
        }
        if(strokeWidth != 0)
        {
            basic += "stroke-width:"+strokeWidth;
        }
        else
        {
            basic += "stroke-width:1";
        }
        return basic;
    }
}