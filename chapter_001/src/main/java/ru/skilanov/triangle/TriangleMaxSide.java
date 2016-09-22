/**
 * Find max side of the triangle.
 */
public class TriangleMaxSide {
    public double max(double first, double second, double third){
        double result = 0;

        if (first > second && first > third){
            result = first;
        } else if (second > first && second > third){
            result = second;
        } else if (third > first && third > second){
            result = third;
        }
        return result;
    }
}