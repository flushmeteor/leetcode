import java.util.HashMap;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 
        int begin = 0, maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            Character character = s.charAt(end);
            if (!map.containsKey(character)) {
                map.put(character, 1);
            } else {
                map.put(character, map.get(character) + 1);
            }
 
            if (map.get(character) == 2) {
                while (map.get(s.charAt(begin)) <= 1) {
                    map.put(s.charAt(begin), map.get(s.charAt(begin)) - 1);
                    begin++;
                }
                map.put(s.charAt(begin), map.get(s.charAt(begin)) - 1);
                begin++;
            }
            if ((end - begin + 1) >= maxLength) {
                maxLength = end - begin + 1;
            }
        }
 
        return maxLength;
    }
}
