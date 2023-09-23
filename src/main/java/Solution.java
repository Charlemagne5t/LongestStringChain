import java.util.*;

public class Solution {
    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 1; i <= 16; i++) {
            map.put(i, new ArrayList<>());
        }
        int maxWordLength = 0;
        for (String word : words) {
            maxWordLength = Math.max(word.length(), maxWordLength);
            map.get(word.length()).add(word);
        }
        Set<String> memo = new HashSet<>();
        int[] max = {1};
        for (int i = 1; i <= maxWordLength; i++) {
            dfs(map, i, "", 0, max, memo, maxWordLength);
        }

        return max[0];
    }

    private void dfs(Map<Integer, List<String>> map, int i, String current, int currentScore, int[] max, Set<String> memo, int maxWordLength){
        if(i == maxWordLength + 1){
            max[0] = Math.max(currentScore, max[0]);
            return;
        }
        if(currentScore + (maxWordLength - i) < max[0]){
            return;
        }
        if (memo.contains(i + " " + current + " " + currentScore)){
            return;
        }
        max[0] = Math.max(currentScore, max[0]);
        for (int j = 0; j < map.get(i).size(); j++) {
            List<String> currentWords = map.get(i);
            for (int k = 0; k < currentWords.size(); k++) {
                String nextWord = currentWords.get(k);
                if(isPredecessor(current, nextWord)){
                    dfs(map, i + 1, nextWord, currentScore + 1, max, memo, maxWordLength);
                }
                dfs(map, i + 1,  nextWord, 1, max, memo, maxWordLength);
            }
        }
        memo.add(i + " " + current + " " + currentScore);
    }
    public boolean isPredecessor(String current, String next){
        if(current.isEmpty()){
            return true;
        }
        if (next.length() - current.length() > 1){
            return false;
        }

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
