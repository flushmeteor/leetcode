public class Solution {
    public boolean isMatch(String s, String p) {
		if(p.length()==0){
			if(s.length()==0){
				return true;
			}else{
				return false;
			}
		}
		int prep = -1,pres=0;
		int currentp = 0,currents = 0;
		while(currents<s.length()){
			//如果p越界，而且p没有发现过*，那么返回false
			//如果，已经发现过*，说明可以回溯。若p的最后一位是*，比对成功返回；如果不是，回溯重新比
			if(currentp>=p.length()){
				if(prep==-1){
					return false;
				}else if(p.charAt(p.length()-1)=='*'){
					return true;
				}
				else{
					currentp = prep+1;
					currents = pres+1;
					pres++;
				}
			}else if(p.charAt(currentp)=='*'){
				//如果是*，说明前面已经比对成功，比对下一段
				pres = currents;
				prep = currentp;
				currentp++;
			}else{
				if(p.charAt(currentp)=='?'||p.charAt(currentp)==s.charAt(currents)){
					currentp++;
					currents++;
				}else{
				    if(prep==-1)
						return false;
					currentp = prep+1;
					currents = pres+1;
					pres++;
				}
			}
		}
		//p已经匹配到最后
		if(currentp==p.length()){
			return true;
		}else{
			//p没有匹配到最后，那么s一定是匹配到最后了，因为上面的循环退出了
			//这种情况下，如果p最后剩余部分全部是*，则匹配是成功的，否则匹配是不成功的
			while(currentp<p.length()){
				if(p.charAt(currentp)!='*')
					return false;
				currentp++;
			}
			return true;
		}
    }
}
