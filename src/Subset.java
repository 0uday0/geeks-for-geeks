import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        System.out.println(findAllTheSubsequences("abcde").toString());
    }
    public static List<String> findAllTheSubsequences(String st) {
        List<String> s = new ArrayList<>();
        if (st.isEmpty() || st.isBlank() ) {
            s.add("");
            return s;
        }
        int lengthOfString = st.length();
        List<String> resultOfSubstrings = findAllTheSubsequences(st.substring(1,lengthOfString));
        for (String subsequence : resultOfSubstrings) {
            subsequence += "";
            s.add(subsequence);
            subsequence += st.charAt(0);
            s.add(subsequence);
        }
        return s;
    }
}
