public class Main {

    public static void main(String[] args) {
        // write your code here
        Segment seg = new Segment(new Point(4,5 ),new Point(5,19 ));
        Segment arr[]=Segment.perpendicular(seg,new Point(5,15));
        System.out.println(arr[1].getSVG());
    }
}