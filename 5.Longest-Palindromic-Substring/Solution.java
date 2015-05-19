public class Solution {
	public String longestPalindrome(String s) {
		int begin = 0;
		int maxlen = 0;
		// 找到中间位置，往两边扩展
		double indexleft = (double) s.length() / 2 - 0.5;
		double indexright = (double) s.length() / 2;
		while (indexleft >= 0 && indexright <= s.length() - 1) {
			//左侧查找
			int leftlen = expandAroundCenter(s,indexleft);
			//查找结束后对变量进行处理
			if(leftlen>maxlen){
				maxlen = leftlen;
				begin = (int)Math.ceil(indexleft - maxlen/2);
			}
			indexleft -= 0.5;
			//右侧查找
			int rightlen = expandAroundCenter(s, indexright);
			if(rightlen>maxlen){
				maxlen = rightlen;
				begin = (int)Math.ceil(indexright - maxlen/2);
			}
			indexright += 0.5;
			//及时停止
			if(indexleft<maxlen/2)
				break;
		}
		if(maxlen<1){
			begin = 0;
			maxlen = 1;
		}
		System.out.println(begin);
		System.out.println(maxlen);
		return s.substring(begin, begin+maxlen);
	}
	private int expandAroundCenter(String s, double index){
		int iterator = 0;
		while (Math.ceil(index - iterator) >= 0 && Math.floor(index + iterator) < s.length()) {
			if (s.charAt((int) Math.ceil(index - iterator)) == s.charAt((int) Math.floor(index + iterator))) {
				iterator++;
			} else {
				break;
			}
		}
		return (int)(Math.floor(index + iterator-1)-Math.ceil(index - iterator+1)+1);
	}
}
