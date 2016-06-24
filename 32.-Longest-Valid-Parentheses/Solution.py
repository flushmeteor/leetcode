class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s=="":
            return 0
        maxmatch = 0 #最大匹配长度
        match = [0]*len(s)
        i=len(s)-2
        while(i>=0):
            if s[i]=='(' and (i+1+match[i+1])<len(s):
                if s[i+1+match[i+1]]==')':
                    match[i]=match[i+1]+2
                    if i+match[i+1]+2<len(s):
                        match[i]=match[i]+match[i+match[i+1]+2]                    
            i=i-1
            
        return max(match)
                        
                        
if __name__=="__main__":
     obj = Solution()
     print(obj.longestValidParentheses("(((()(()"))
           
           
    
