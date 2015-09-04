public class Solution {
	public void nextPermutation(int[] nums) {
		if (nums.length < 2)
			return;
		if (nums.length == 2) {
			int tmp = nums[0];
			nums[0] = nums[1];
			nums[1] = tmp;
			return;
		}
		// 从右向左找到第一个升序位置
		int i = nums.length - 2;
		while (i >= 0) {
			if (nums[i] < nums[i + 1])
				break;
			i--;
		}
		// 如果i>=0，则需要进行下面的操作
		// 如果i<0，说明整个序列已经是最终序列，按照要求直接对整体进行反序即可
		if (i >= 0) {
			// 找到i之后比nums[i]大的数中最小的一个，并记录位置
			int j = i + 1;
			for (int k = j; k < nums.length; k++) {
				if (nums[k] > nums[i] && nums[k] <= nums[j]) {
					j = k;
				}
			}
			// 交换i和j位置的数
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
		// 将i位置之后的数反序
		for (int k = 1; k < Math.ceil((double) (nums.length - i) / 2); k++) {
			int temp = nums[i + k];
			nums[i + k] = nums[nums.length - k];
			nums[nums.length - k] = temp;
		}
	}
}
