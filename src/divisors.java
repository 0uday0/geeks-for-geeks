import java.util.ArrayList;
import java.util.List;

public class divisors {
    public static List<Integer> divisorList(Integer givenInteger) {
        List<Integer> result = new ArrayList<>();
        int positionAtWhichLowestNumberOfThePairWasAddedLast = -1;
       for (int i = 1; i*i <= givenInteger; i+=1) {
           if (givenInteger % i == 0) {
               positionAtWhichLowestNumberOfThePairWasAddedLast += 1;
               result.add(positionAtWhichLowestNumberOfThePairWasAddedLast,i);
               if (i != givenInteger /i) {
                   result.add(positionAtWhichLowestNumberOfThePairWasAddedLast+1,givenInteger/ i);
               }


           }

       }
       return result;
    }
}
