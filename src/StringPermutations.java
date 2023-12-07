import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutations {
    public static List<String> permutationsIterative(String inputStr) {
        List<String> result = new ArrayList<>();
        result.add("");

        for (char c : inputStr.toCharArray()) {
            List<String> newPermutations = new ArrayList<>();
            for (String perm : result) {
                for (int i = 0; i <= perm.length(); i++) {
                    newPermutations.add(perm.substring(0, i) + c + perm.substring(i));
                }
            }
            result = newPermutations;
        }

        return result;
    }

    public static List<String> permutationsRecursive(String inputStr) {
        List<String> result = new ArrayList<>();

        if (inputStr.length() <= 1) {
            result.add(inputStr);
        } else {
            char firstChar = inputStr.charAt(0);
            String remainingString = inputStr.substring(1);
            List<String> perms = permutationsRecursive(remainingString);

            for (String perm : perms) {
                for (int i = 0; i <= perm.length(); i++) {
                    result.add(perm.substring(0, i) + firstChar + perm.substring(i));
                }
            }
        }

        return result;
    }

    public static boolean arePermutationsEqual(String str1, String str2) {
        List<String> permsIterative = permutationsIterative(str1);
        List<String> permsRecursive = permutationsRecursive(str2);

        Set<String> setIterative = new HashSet<>(permsIterative);
        Set<String> setRecursive = new HashSet<>(permsRecursive);

        return setIterative.equals(setRecursive);
    }

    public static void main(String[] args) {
        String string1 = "abc";
        String string2 = "bccs";

        boolean result = arePermutationsEqual(string1, string2);

        System.out.println("Permutations of '" + string1 + "' and '" + string2 + "' are equal: " + result);
    }
}
