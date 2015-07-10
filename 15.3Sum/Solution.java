public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList();
		Arrays.sort(nums);
		if(nums==null||nums.length<3)
			return result;
        for(int i=0;i<nums.length-2;i++){
        	if(i>0&&nums[i]==nums[i-1])
        		continue;
        	int first = nums[i];
        	int left = i+1;
        	int right = nums.length-1;
        	while(left<right){
        		if(left>i+1&&nums[left]==nums[left-1]){
        			left++;
        			continue;
        		}
        		if(right<nums.length-1&&nums[right]==nums[right+1]){
        			right--;
        			continue;
        		}
        		if(nums[left]+nums[right]+first==0){
            		List<Integer> tmp= new ArrayList();
            		tmp.add(first);
            		tmp.add(nums[left]);
            		tmp.add(nums[right]);
            		result.add(tmp);
            		left++;
            		right--;
            	}else if(nums[left]+nums[right]+first>0){
            		right--;
            	}else{
            		left++;
            	}
        	}
        }
        return result;
    }
}
