public class Solution {
	public boolean isPalindrome(int x) {
	//负数不是对称的
		if(x<0)
			return false;
			//通过得到整数的反序来比对。如果反序溢出的话，那么肯定不是对称的，因为原数不溢出，反序溢出了。
		int maxDiv10 = Integer.MAX_VALUE/10;
		int tmp = x;
		int reverse = 0;
		while(tmp!=0){
			if(reverse>maxDiv10)
				return false;
			reverse = reverse*10+tmp%10;
			tmp/=10;
		}
		System.out.println(reverse);
		if(reverse == x){
			return true;
		}else
			return false;
	}
}
