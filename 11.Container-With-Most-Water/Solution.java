public class Solution {
	public int maxArea(int[] height) {
		int result = 0;
		int l = 0,r = height.length-1;
		while(l<r){
			int currentArea = Math.min(height[l], height[r])*(r-l);
			result = currentArea>result?currentArea:result;
			if(height[l]<height[r]){
				int k=l;
				while(k<r&&height[k]<=height[l]){
					k++;
				}
				l=k;
			}else{
				int k=r;
				while(k>l&&height[k]<=height[r]){
					k--;
				}
				r=k;
			}
		}
		return result;
    }
	
}
