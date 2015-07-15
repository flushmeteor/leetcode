public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		if(nums.length==3)
			return nums[0]+nums[1]+nums[2];
		int result = 0;
		int minDistence = Integer.MAX_VALUE;
		int currentdifference = Integer.MAX_VALUE;
		int currentSum = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
        	int left = i+1;
        	int right = nums.length-1;
        	while(left<right){
        		currentSum = nums[i]+nums[left]+nums[right];
        		currentdifference = currentSum-target;
        		if(currentdifference<0)
        			left++;
        		else if(currentdifference>0)
        			right--;
        		else 
        			return target;
        		if(Math.abs(currentdifference)<minDistence){
        			result = currentSum;
        			minDistence = Math.abs(currentdifference);
        		}
        	}
        }
        return result;
    }
}
