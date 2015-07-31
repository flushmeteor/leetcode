public class Solution {
    List<String> result = new ArrayList();
    public List<String> generateParenthesis(int n) {
        int threshold = 0;//增加一个左括号此数加1，增加一个右括号此数减一，如果此数小于等于0，不可加右括号
        int leftParentheses = 0;//为左括号计数
        geterateProcess(n,threshold,leftParentheses,"");
        return result;
    }
	
	public void geterateProcess(int n,int threshold,int leftParentheses,String current){
		if(leftParentheses==n){//左括号不可加，直接一直加右括号
			for(int i=current.length();i<2*n;i++){
				current += ")";
			}
			result.add(current);
		}else{
			//可以加左括号
			geterateProcess(n,threshold+1,leftParentheses+1,current+"(");
			//检查当前是否可以加右括号
			if(threshold>0){
				geterateProcess(n,threshold-1,leftParentheses,current+")");
			}
		}
	}
}
