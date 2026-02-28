import java.util.ArrayList;
import java.util.List;

class solution {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int discriminant = ((b*b)-(4*a*c));
        if (discriminant<0) {
            result.add(-1);
            return result;
        }
        double mySqrt = Math.sqrt(discriminant);
        int negB= -1 * (b);
        int rootOne =(int) Math.floor((negB + mySqrt)/(2*a));
        int rootTwo =(int) Math.floor((negB - mySqrt)/(2*a));
        result.add(Math.max(rootOne,rootTwo));
        result.add(Math.min(rootOne,rootTwo));
        return result;
    }
}