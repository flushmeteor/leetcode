public class Solution{
		public int[] twoSum(int[] nums, int target) {
			//这个叫做brute force算法（BF）
			int[] result = new int[2];
			for (int i = 0; i < nums.length; i++) {
				int minus = target - nums[i];
				for(int j=i+1;j<nums.length;j++){
					if(nums[j]==minus){
						result[0] = i+1;
						result[1] = j+1;
						break;
					}
				}
			}
			return result;
	    }
	
	
}
