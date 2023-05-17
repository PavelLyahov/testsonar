package java17Features.record;


import java.util.List;

public class RecordCheck {

    public static void main(String[] args) {
        System.out.println(pointValidation(new SpasePoint(1, 2, 3)));
        System.out.println(pointValidation(new SpasePoint(-3, 2, 0)));
    }

    public record SpasePoint (int x, int y, int z) {}
//it will be like
//    public final int x;
//    public final int y;
//    public final int z;
//
//    public SpasePoint(int x, int y, int z) {
//        this.x = x;
//        this.y = y;
//        this.z = z;
//    }
//    plus equals, hashCode, toString

    public static boolean pointValidation(SpasePoint point) {
        if (point.x < 0 || point.y < 0 || point.z < 0) {
            return false;
        }
        return true;
    }


}
