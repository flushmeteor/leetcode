public class Solution {
	public int reverse(int x) {
		boolean positive = true;
		if(x<0)
			positive = false;
		x = Math.abs(x);
		String s = x+"";
		String temp = "";
		for(int i=s.length()-1;i>=0;i--){
			temp += s.charAt(i);
		}
		if(positive)
			try {
				return Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				return 0;
			}
			
		else {
			try {
				return 0-Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				return 0;
			}
		}
	}

}
