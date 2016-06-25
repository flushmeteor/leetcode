class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums)==0:
            return -1
        if len(nums)==1:
            if target==nums[0]:
                return 0
            else:
                return -1
        if target==nums[0]:
            return 0
        elif target>nums[0]:
            i=1
            while(i<len(nums)):
                if target==nums[i]:
                    return i
                if target<nums[i]:
                    return -1
                if nums[i]<nums[i-1]:
                    return -1
                i+=1
            return -1
        else:
            i=len(nums)-1
            while(i>0):
                if target==nums[i]:
                    return i
                if target>nums[i]:
                    return -1
                if nums[i]<nums[i-1]:
                    return -1
                i-=1
            return -1  
                        
if __name__=="__main__":
     obj = Solution()
     print(obj.search([1,3],1))
           
           
    
