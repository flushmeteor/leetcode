public class Solution {
	public String longestPalindrome(String s) {
		int begin = 0;
		int maxlen = 0;
		int iterator = 0;
		// 找到中间位置，往两边扩展
		double indexleft = (double) s.length() / 2 - 0.5;
		double indexright = (double) s.length() / 2;
		while (indexleft >= 0 && indexright <= s.length() - 1) {
			//左侧查找
			while (Math.ceil(indexleft - iterator) >= 0 && Math.floor(indexleft + iterator) < s.length()) {
				if (s.charAt((int) Math.ceil(indexleft - iterator)) == s.charAt((int) Math.floor(indexleft + iterator))) {
					iterator++;
				} else {
					break;
				}
			}
			//查找结束后对变量进行处理
			if((int)(Math.floor(indexleft + iterator-1)-Math.ceil(indexleft - iterator+1)+1)>maxlen){
				maxlen = (int)(Math.floor(indexleft + iterator -1)-Math.ceil(indexleft - iterator+1))+1;
				begin = (int)Math.ceil(indexleft - iterator+1);
			}
			iterator = 0;
			indexleft -= 0.5;
			//右侧查找
			while (Math.ceil(indexright - iterator) >= 0 && Math.floor(indexright + iterator) < s.length()) {
				if (s.charAt((int) Math.ceil(indexright - iterator)) == s.charAt((int) Math.floor(indexright + iterator))) {
					iterator++;
				} else {
					break;
				}
			}
			if((int)(Math.floor(indexright + iterator-1)-Math.ceil(indexright - iterator+1)+1)>maxlen){
				maxlen = (int)(Math.floor(indexright + iterator -1)-Math.ceil(indexright - iterator+1))+1;
				begin = (int)Math.ceil(indexright - iterator+1);
			}
			iterator = 0;
			indexright += 0.5;
			
			//及时停止
			if(indexleft<maxlen/2)
				break;
		}
		if(maxlen<1){
			begin = 0;
			maxlen = 1;
		}
		return s.substring(begin, begin+maxlen);
	}
}
