package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution test = new Solution();
		int []candidates = {2,3,6,7};
		List<List<Integer>> result = test.combinationSum(candidates, 7);
		for(List<Integer> currentList:result){
			for(Integer i:currentList){
				System.out.print(i+"\t");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList();
		List<Integer> currentList = new ArrayList();
		Arrays.sort(candidates); 
		subQuestion(result,currentList,candidates,0,target);
		return result;
    }
	
	public void subQuestion(List<List<Integer>> result,List<Integer> currentList,int[] candidates,int startIndex,int target){
		if(target==0){
			result.add(currentList);
			return;
		}else if(target<candidates[startIndex])
			return;
		
		List<Integer> newList = new ArrayList();
		newList.addAll(currentList);
		newList.add(candidates[startIndex]);
		subQuestion(result, newList, candidates, startIndex, target-candidates[startIndex]);
		if(startIndex+1<candidates.length)
			subQuestion(result, currentList, candidates, startIndex+1, target);
			
	}

}
