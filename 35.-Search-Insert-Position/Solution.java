public class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if(length<1)
        	return 0;
        if(target<nums[0])
        	return 0;
        if(target>nums[length-1])
        	return length;
        
        int left = 0;
        int right = length-1;
        int mid = (left+right)/2;
        
        while(left<right){
        	if(nums[mid]==target)
        		return mid;
        	if(nums[mid]<target){
        		left = mid+1;
        	}
        	if(nums[mid]>target){
        		right = mid-1;
        	}
        	mid = (left+right)/2;
        }
        //有两种情况，左右两个指针合并或者是左指针大于右指针
        //两个指针合并的时候，如果当前值小于目标值，那么目标值插入在该指针右侧
        if(right==left){
        	if(nums[left]<target){
        		return left+1;
        	}
        }
        //两个指针合并的时候，如果当前值大于目标值，那么目标值插入在该指针位置
        //左指针大于右指针的时候，直接返回左指针
        return left;
    }
}
