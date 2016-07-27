public class Solution {
    public int[] searchRange(int[] nums, int target) {
		int result[] = {-1,-1};
		int numsSize = nums.length;
	    if(numsSize<=0){
	        System.out.println("numsSize<=0");
	        return result;
	    }

	    if(target<nums[0]||target>nums[numsSize-1]){
	        System.out.println("target<nums[0]||target>nums[numsSize-1]");
	        return result;
	    }

	    int left = 0;
	    int right = numsSize-1;
	    int mid=(left+right)/2;
	    while(left<right){
	        if(nums[mid]==target)
	            break;
	        if(nums[mid]<target)
	            left=mid+1;
	        else
	            right=mid-1;

	        mid=(left+right)/2;
	    }
	    //没找到则返回[-1,-1]
	    if(nums[mid]!=target){
	        System.out.println("not found");
	        return result;
	    }

	    while(left<=mid){
	        if(nums[left]==target)
	            break;
	        left++;
	    }
	    while(right>=mid){
	        if(nums[right]==target)
	            break;
	        right--;
	    }
	    result[0]=left;
	    result[1]=right;
	    System.out.println("found");
	    return result;
	}
}
