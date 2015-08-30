public class Solution {
    public int divide(int dividend, int divisor) {
    	if(dividend==0){
    		return 0;
    	}
    	if(divisor==0){
    		return Integer.MAX_VALUE;
    	}
        boolean tag = true;
        if(dividend<0)
        	tag = !tag;
        if(divisor<0)
        	tag = !tag;
        long tmp = Math.abs((long)dividend);
        long tmp1 = Math.abs((long)divisor);
        long count = 1;
        while(tmp>tmp1){
        	tmp1 = tmp1<<1;
        	count = count<<1;
        }
        long result = 0;
        while(tmp>=Math.abs((long)divisor)){
        	while(tmp>=tmp1){
        		tmp -= tmp1;
        		result += count;
        	}
        	tmp1 = tmp1>>1;
        	count = count>>1;
        }
        if(tag)
        	if(result>Integer.MAX_VALUE)
        		return Integer.MAX_VALUE;
        	else 
        		return (int)result;
        return (int)-result;
    }     
}
