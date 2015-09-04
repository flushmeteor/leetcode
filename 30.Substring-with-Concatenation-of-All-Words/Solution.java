import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if(s.length()<1||words.length<1)
			return result;
		int step = words[0].length();
		//先把words里的字符串放在hashmap中
		HashMap<String, Integer> wordMap = new HashMap<>();
		for(int i=0;i<words.length;i++){
			String currentWord = words[i];
			if(wordMap.containsKey(currentWord)){
				wordMap.put(currentWord, wordMap.get(currentWord)+1);
			}else{
				wordMap.put(currentWord, 1);
			}
		}
		
		//对字符串s遍历比对
		int index = 0;
		int count = 0;
		String sub;
		for(int i=0;i<=s.length()-words.length*step;i++){
			index = i;
			count = 0;
			sub = s.substring(index,index+step);
			while(wordMap.containsKey(sub)&&wordMap.get(sub)>0){
				wordMap.put(sub,wordMap.get(sub)-1);
				index += step;
				count++;
				if(count>=words.length)break;
				sub = s.substring(index, index+step);
			}
			if(count==words.length)
				result.add(i);
			
			//从一个点查找完，都需要对hashmap进行还原
			if(count>0){
				wordMap.clear();
				for(int j=0;j<words.length;j++){
					String currentWord = words[j];
					if(wordMap.containsKey(currentWord)){
						wordMap.put(currentWord, wordMap.get(currentWord)+1);
					}else{
						wordMap.put(currentWord, 1);
					}
				}
			}
			
		}
        return result;
    }
}
