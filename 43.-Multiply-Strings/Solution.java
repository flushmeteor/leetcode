public class Solution {
	public String multiply(String num1, String num2) {
		int []result = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
        	for(int j=num2.length()-1;j>=0;j--){
        		store(result.length-2-i-j,(num1.charAt(i)-'0')*(num2.charAt(j)-'0'),result);
        	}
        }
       
        int maxIndex = result.length-1;
        //索引越界判断放在最前面，这样当越界的时候就不会检查后面的条件，也就不会发生越界了
        while(maxIndex>-1&&result[maxIndex]==0)
        	maxIndex--;
        
        if(maxIndex==-1)
        	return "0";
        StringBuffer sb = new StringBuffer();
        while(maxIndex>-1){
        	sb.append(result[maxIndex]);
        	maxIndex--;
        }
        return sb.toString();
        
    }
	
	public void store(int i,int num,int []result){
		int currentsum = result[i]+num;
		if(currentsum/10==0){
			result[i]=currentsum;
		}else{
			result[i]=currentsum%10;
			store(i+1,currentsum/10,result);
		}
	}
}
