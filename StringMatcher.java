import java.util.List;
import java.util.*;

public class StringMatcher{
    
    StringMatcher(){
        
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> result = new ArrayList<Integer>();

        int stringNum = 0;
        for (String q: queries) {
            result.add(0);
            for (String s : strings) {
                if (q.equals(s)) {
                    result.set(stringNum, result.get(stringNum) + 1);
                }
            }
            stringNum++;
        }

        return result;

    }



    public static void main(String[] args) {
        StringMatcher stringMatcher = new StringMatcher();

        var inputString = new ArrayList<String>();
        inputString.add("abc");
        inputString.add("abd");
        inputString.add("abe");
        var queryString = new ArrayList<String>();
        queryString.add("abc");
        queryString.add("abd");
        queryString.add("abe");
        stringMatcher.matchingStrings(inputString, queryString);
    }
}
