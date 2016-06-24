class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        maxmatch = 0 #最大匹配长度
        match = [False]*len(s)
        stack = []
        for i in range(len(s)):
            if s[i]=="(":
                stack.append(i)
            else:
                if len(stack)>0:
                    match[i]=True
                    match[stack.pop()]=True
        count=0
        for i in range(len(match)):
            if match[i]==True:
                count+=1
            else:
                maxmatch=max(maxmatch,count)
                count=0
        maxmatch=max(maxmatch,count)
            
        return maxmatch
                        
                        
if __name__=="__main__":
     obj = Solution()
     print(obj.longestValidParentheses("()"))
           
           
    
