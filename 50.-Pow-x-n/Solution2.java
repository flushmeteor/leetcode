public class Solution {
    public double myPow(double x, int n) {
		if(n<0){
			if(n==Integer.MIN_VALUE)
				return 1/(iter(x,Integer.MAX_VALUE)*x);
			return 1/iter(x,-n);
		}
		return iter(x,n);
		
    }
	public double iter(double x,int n){
		double result = 1;
		
		while(n>0){
			if(n%2==1)
				result = result*x;
			x = x*x;
			n = n/2;
		}
		return result;
	}
}
