public class Solution {
	public boolean isMatch(String s, String p) {
		StringBuilder sBuilder = new StringBuilder();
		for(int i=0;i<p.length();i++){
			//出现".*"的时候，将后面带* 的字符都合并为.*
			if(p.charAt(i)=='.'&&i+1<p.length()&&p.charAt(i+1)=='*'){
				sBuilder.append(".*");
				i+=2;
				while(i+1<p.length()&&p.charAt(i+1)=='*'){
					i += 2;
				}
				i--;
			}else {
				sBuilder.append(p.charAt(i));
			}
		}
		p = sBuilder.toString();
		sBuilder = new StringBuilder();
		for(int i=p.length()-1;i>=0;i--){
			//出现".*"的时候，将前面带* 的字符都合并为.*
			if(p.charAt(i)=='*'&&i-1>=0&&p.charAt(i-1)=='.'){
				sBuilder.append("*.");
				i-=2;
				while(i-1>=0&&p.charAt(i)=='*'){
					i -= 2;
				}
				i++;
			}else {
				sBuilder.append(p.charAt(i));
			}
		}
		p = sBuilder.reverse().toString();
		
		// 出现这种格式，可以匹配所有类型
		if (p.equals(".*"))
			return true;

		int index1 = s.length() - 1;
		int index2 = p.length() - 1;
		char currentpattern;
		while (index1 >= 0 && index2 >= 0) {
			currentpattern = p.charAt(index2);
			if (currentpattern == '*') {
				index2--;
				currentpattern = p.charAt(index2);
				//如果是.*  拿p的当前位置以前的部分和s当前位置之前的所有情况进行比对，如果比对成功，返回true；否则返回false
				if (currentpattern == '.') {
					index2--;
					if (index2 < 0)
						return true;
					currentpattern = p.charAt(index2);
					while (index1 >= 0) {
						if (s.charAt(index1) != currentpattern&& currentpattern != '.')
							index1--;
						else {
							if (isMatch(s.substring(0, index1),p.substring(0, index2))) {
								return true;
							} else {
								index1--;
							}
						}
					}
					return false;
				} 
				//出现类似a*的时候，将连着的带*字符都进行匹配，然后遇到非*字符的时候开始递归匹配
				else {
					int starIndex = index1;
					//先对a*字符进行匹配，看能够在哪部分字符串中进行变动
					while(index1 >= 0 && index2 >= 0){
						while (index1 >= 0) {
							if (s.charAt(index1) != currentpattern)
								break;
							index1--;
						}
						index2--;
						if(index2>=0)
							currentpattern = p.charAt(index2);
						if(index2<0||currentpattern!='*')
							break;
						index2--;
						if(index2>=0)
							currentpattern = p.charAt(index2);
					}
					//下面这种情况是遇到了非*字符，而且还没匹配完；如果出现某个字符串越界，会跳出当前循环由最后的代码处理。
					//在这种情况下，递归进行匹配
					if(index1>=0&&index2>=0){
						for(int i = index1;i<=starIndex;i++){
							if(isMatch(s.substring(0,i+1), p.substring(0,index2+1)))
								return true;
						}
						return false;
					}else if(index1<0&&index2>=0){
						//递归匹配
						if(p.charAt(index2+1)=='*'){
							index2--;
							while (index2>=0){
								if(p.charAt(index2)!='*')
									break;
								index2 -= 2;
							}
						}
						if(index2<0){
							return true;
						}else {
							for(int i = 0;i<=starIndex;i++){
								if(isMatch(s.substring(0,i+1), p.substring(0,index2+1)))
									return true;
							}
						}
					}else if(index1>=0&&index2<0){
						return false;
					}else if(index1<0&&index2<0){
						return true;
					}
				}
			} else if (currentpattern == '.'
					|| s.charAt(index1) == currentpattern) {
				index1--;
				index2--;
			} else {
				return false;
			}
		}
		if (index1 >= 0) {
			return false;
		}
		while (index2 >= 0) {
			if (p.charAt(index2) != '*')
				break;
			index2 -= 2;
		}
		if(index2>=0)
			return false;
		return true;
	}
}
