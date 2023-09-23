import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 1; i <= 16; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            map.get(word.length()).add(word);
        }

        return 0;
    }
    public boolean isPredecessor(String current, String next){
        int j = 0;
        for (int i = 0; i < next.length(); i++) {
            if(next.charAt(i) == current.charAt(j)){
                j++;
                if(j == current.length()){
                    return true;
                }
            }
            if(i - j > 1){
                return false;
            }
        }
        return false;
    }
}
