import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.sun.org.apache.xml.internal.utils.IntVector;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Solution{
		public int[] twoSum(int[] nums, int target) {
	    	//一次遍历，将数组进行倒排索引，用hashmap保存
	    	//第二次遍历，用给的target分别减每个数，hashmap中找对应的数，如果存在，就输出；否则，对下一个数执行相同操作
		   int [] result = new int[2];
	    	Map<Integer, ArrayList<Integer>> reverseMap = new HashMap<Integer, ArrayList<Integer>>();
	    	for(int i=0;i<nums.length;i++){
	    		if(!reverseMap.containsKey(nums[i])){
	    			ArrayList<Integer> al = new ArrayList<Integer>();
	    			al.add(i+1);
	    			reverseMap.put(nums[i], al);
	    		}else{
	    			reverseMap.get(nums[i]).add(i+1);
	    		}
	    	}
	    	for(int i=0;i<nums.length;i++){
	    		if((target-nums[i])!=nums[i]){
	    			if(reverseMap.containsKey(target-nums[i])){
	    				result[0] = i+1;
	    				result[1] = reverseMap.get(target-nums[i]).get(0);
	    				break;
	    			}
	    		}else if(reverseMap.get(target-nums[i]).size()<2)
	    			continue;
	    		else{
	    			result[0] = i+1;
    				result[1] = reverseMap.get(target-nums[i]).get(1);
    				break;
	    		}
	    	}
	        return result;
	    }
	
	
}
