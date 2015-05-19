public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int index1 = 0, index2 = 0;
		int total = nums1.length + nums2.length;
		int i = 0;
		// 判断是否有数组为空
		if (nums1.length == 0) {
			if (total % 2 != 0) {
				return nums2[total / 2];
			} else {
				return (double) (nums2[total / 2 - 1] + nums2[total / 2]) / 2;
			}
		}
		if (nums2.length == 0) {
			if (total % 2 != 0) {
				return nums1[total / 2];
			} else {
				return (double) (nums1[total / 2 - 1] + nums1[total / 2]) / 2;
			}
		}

		// 查到中位数前一位，之后根据这个位置找中位数
		// 这里需要注意某个数组有可能会越界
		for (i = 0; i < Math.ceil((double) total / 2) - 1
				&& index1 < nums1.length && index2 < nums2.length; i++) {
			if (nums1[index1] > nums2[index2])
				index2++;
			else
				index1++;
		}
		double result = 0;
		// 处理其中一个数组已经越界的情况
		if (index1 >= nums1.length) {// nums1越界
			if (total % 2 != 0)
				return (double) nums2[total / 2 - nums1.length];
			else {
				return (double) (nums2[(total / 2) - nums1.length - 1] + nums2[(total / 2)
						- nums1.length]) / 2;
			}
		} else if (index2 >= nums2.length) {// nums2越界
			if (total % 2 != 0) {
				return (double) nums1[total / 2 - nums2.length];
			} else {
				return (double) (nums1[(total / 2) - nums2.length - 1] + nums1[(total / 2)
						- nums2.length]) / 2;
			}
		}
		// 没有越界
		else {
			if (nums1[index1] > nums2[index2])
				result = nums2[index2++];
			else
				result = nums1[index1++];
			if (total % 2 != 0)
				return result;
			else {
				System.out.println(index1);
				System.out.println(index2);
				// 这里需要再次进行判断是否越界
				if (index1 >= nums1.length) {// index1越界
					return (double)(result + nums2[index2++])/2;
				} else if (index2 >= nums2.length) {// index2越界
					return (double)(result + nums1[index1++])/2;
				}
				// 无越界
				else if (nums1[index1] > nums2[index2])
					return (double)(result + nums2[index2++])/2;
				else
					return (double)(result + nums1[index1++])/2;
			}
		}

	}
}
