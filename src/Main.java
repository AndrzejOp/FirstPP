public class Main {

    public static void main(String[] args) {
        Segment seg = new Segment(new Point(0, 0), new Point(10, 10));
        System.out.println(seg.toSvg());

    }
}
