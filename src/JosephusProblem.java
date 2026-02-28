import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        System.out.println(josephusProblem(input,4).toString());
    }
    public static List<Integer> josephusProblem(List<Integer> input,int k) {
        int lengthOfArray = input.size();
        List<Integer> result = new ArrayList<>();
        if (lengthOfArray == 1) {
            return input;
        }
        if ((k-1)<lengthOfArray) {
            List<Integer> newInput = returnANewListAfterRemovingTheElement(input,k);
            result = josephusProblem(newInput,k);
        } else {
            int position = (k-1)%lengthOfArray;
            List<Integer> newInput = returnANewListAfterRemovingTheElement(input,position+1);
            result = josephusProblem(newInput,k);
        }
        return result;
    }

    public static List<Integer> returnANewListAfterRemovingTheElement(List<Integer>input,int k) {
        int lengthOfArray = input.size();
        List<Integer> firstPart = input.subList(0,k-1);
        List<Integer> secondPart = input.subList(k,lengthOfArray);
        secondPart.addAll(firstPart);
        return secondPart;
    }
}
