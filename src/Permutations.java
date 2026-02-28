import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permutations("ABCD").toString());
        System.out.println(permutations("ABCS").size());
    }
    public static List<String> permutations(String input) {
        List<String> result = new ArrayList<>();
        if (input.length() == 1) {
            result.add(String.valueOf(input.charAt(0)));
            return result;
        }
        List<String> subPermutations = permutations(input.substring(0,input.length()-1));
        String lastCharacter = String.valueOf(input.charAt(input.length()-1));
        System.out.println(subPermutations.toString());
        for (int i = 0; i < subPermutations.size(); i+=1) {
            String permutation = subPermutations.get(i);
            System.out.println("My permutation "+permutation);
            int permutationLength = permutation.length();
            for (int j = 0; j < permutationLength ; j +=1) {
                String firstPart = permutation.substring(0,j);
                String secondPart = permutation.substring(j,permutationLength);
                String finalPerm = firstPart.concat(lastCharacter).concat(secondPart);
                result.add(finalPerm);
            }
            String w = permutation.concat(lastCharacter);
            result.add(w);
        }

        return result;

    }
}
