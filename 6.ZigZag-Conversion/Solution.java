import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String convert(String s, int numRows) {
    	//只分成了一列，返回字符串和原字符串相同;只有一行，返回字符串和原字符串相同
    	if(s.length()<=numRows||numRows==1){
    		return s;
    	}
        Map<Integer, StringBuffer> zigzag = new HashMap<>();
        int model = 2*numRows-2;
        //把原字符串中的字符分到map的numRows+1个key中。不是numRows而是numRows+1，这是因为特殊列的字符也用一个key保存，这个key=0
        for(int i=0;i<s.length();i++){
        	int currentkey = numRows-1-Math.abs(numRows-1-(i)%model);
        	if(!zigzag.containsKey(currentkey)){
        		zigzag.put(currentkey, new StringBuffer(s.charAt(i)+""));
        	}else{
        		zigzag.get(currentkey).append(s.charAt(i));
        	}
        }
        StringBuffer result = new StringBuffer();
        for(int i=0;i<numRows;i++){
        	result.append(zigzag.get(i));
        }
        return result.toString();
    }
}
