public double myPow(double x, int n) {
		if(n<0){
			if(n==Integer.MIN_VALUE)
				return 1/(iter(x,Integer.MAX_VALUE)*x);
			return 1/iter(x,-n);
		}
		return iter(x,n);
		
    }
	public double iter(double x,int n){
		if(n==1)
			return x;
		else if(n==0)
			return 1;
		double tmp = myPow(x,n/2);
        if(n%2==0){
        	return tmp*tmp;
        }else{
        	return tmp*tmp*x;
        }
	}
