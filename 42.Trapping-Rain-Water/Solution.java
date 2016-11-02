package test;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		int[] candidates = { 5, 3,6 };
		System.out.println(test.trap(candidates));
	}

	public int trap(int[] height) {
		if (height.length < 3)
			return 0;
		// 先找打最大值，
		// 然后对最大值左侧依次找极大值，而且要求后找到的极大值比之前的都要大，这样能保证计算的数值不会在两个更大的数据中间
		// 右侧同理
		int result = 0;
		int max = height[0];
		int indexofMax = 0;
		for (int i = 1; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
				indexofMax = i;
			}
		}
		int previousLocalMax = 0;
		int previousIndex = 0;
		// 左侧
		if (indexofMax >= 2) {
			// 找到第一个极大值
			int i = 1;
			for (; i < indexofMax && height[i] >= height[i - 1]; i++) {
			}
			// 左侧不是单调递增，也就是：结束条件不是i==indexofMax就可以计算
			if (height[i] < height[i - 1]) {
				previousLocalMax = height[i - 1];
				previousIndex = i - 1;

				// 找到下一个比当前值大的值，进行计算
				int middlesum = 0;// 记录两个极值之间的柱状图占用的面积
				for (; i < indexofMax; i++) {
					if (height[i] > previousLocalMax) {
						result = result + previousLocalMax * (i - previousIndex - 1) - middlesum;
						previousIndex = i;
						previousLocalMax = height[i];
						middlesum = 0;
						continue;
					}
					middlesum += height[i];
				}
				// 把最后包括最大值的部分计算出来
				if (i - previousIndex > 1)
					result = result + previousLocalMax * (i - previousIndex - 1) - middlesum;

			}
		}

		// 右侧
		if (height.length-indexofMax > 2) {
			// 找到第一个极大值
			int i = height.length-2;
			for (; i > indexofMax && height[i] >= height[i + 1]; i--) {
			}
			// 右侧不是单调递减，也就是：结束条件不是i==indexofMax就可以计算
			if (height[i] < height[i + 1]) {
				previousLocalMax = height[i+1];
				previousIndex = i+1;

				// 找到下一个比当前值大的值，进行计算
				int middlesum = 0;// 记录两个极值之间的柱状图占用的面积
				for (; i > indexofMax; i--) {
					if (height[i] > previousLocalMax) {
						result = result + previousLocalMax * (previousIndex -i- 1) - middlesum;
						previousIndex = i;
						previousLocalMax = height[i];
						middlesum = 0;
						continue;
					}
					middlesum += height[i];
				}
				// 把最后包括最大值的部分计算出来
				if (previousIndex-i > 1)
					result = result + previousLocalMax * (previousIndex -i- 1) - middlesum;
			}
		}
		return result;
	}

}
