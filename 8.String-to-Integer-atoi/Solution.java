import org.omg.CORBA.PRIVATE_MEMBER;

public class Solution {
	public int myAtoi(String str) {
		// 将字符串两端的空格和tab去掉
		str = str.trim();
		if (str.isEmpty())
			return 0;
		int maxDiv10 = Integer.MAX_VALUE/10;
		int sign = 1;
		int start = 0;
		if (str.charAt(0) == '-') {
			sign = -1;
			start++;
		} else if (str.charAt(0) == '+') {
			start++;
		}

		int result = 0;
		for (int i = start; i < str.length(); i++) {
			char currentchar = str.charAt(i);
			// 当前字符不是数字，返回第一个非数字字符前面的数字
			if (!Character.isDigit(currentchar)) {
				break;
			}
			// 检测是否越界，如果越界，输出当前符号下的极限值
			if(result>maxDiv10||result==maxDiv10&&Character.getNumericValue(currentchar)>=8)
				return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
			
			result = result * 10 + Character.getNumericValue(currentchar);
		}
		return sign * result;
	}

}
