package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		int[] candidates = { 1 };
		List<List<Integer>> result = test.combinationSum2(candidates, 1);
		for (List<Integer> currentList : result) {
			for (Integer i : currentList) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList();
		List<Integer> currentList = new ArrayList();
		TreeMap<Integer, Integer> treeMap = new TreeMap();
		for (int i = 0; i < candidates.length; i++) {
			int key = candidates[i];
			if (treeMap.containsKey(key)) {
				treeMap.put(key, treeMap.get(key) + 1);
			} else {
				treeMap.put(key, 1);
			}
		}
		int[] newcandidates = new int[treeMap.size()];
		int index = 0;
		for (int a : treeMap.keySet()) {
			newcandidates[index] = a;
			index++;
		}
		subQuestion(result, currentList, treeMap, newcandidates, 0, target);
		return result;
	}

	public void subQuestion(List<List<Integer>> result, List<Integer> currentList, TreeMap<Integer, Integer> treeMap,
			int[] candidates, int startIndex, int target) {
		if (target == 0) {
			result.add(currentList);
			return;
		}else if(startIndex>=candidates.length){
			return;
		}else if (target < candidates[startIndex])
			return;
		
		
		// 不使用当前的数值
		subQuestion(result, currentList, treeMap, candidates, startIndex + 1, target);
		// 当前的数值分别使用1,2,3...n次
		for (int i = 0; i < treeMap.get(candidates[startIndex]) && target >= 0; i++) {
			List<Integer> newList = new ArrayList();
			newList.addAll(currentList);
			newList.add(candidates[startIndex]);
			currentList = newList;
			target -= candidates[startIndex];
			subQuestion(result, newList, treeMap, candidates, startIndex + 1, target);
		}
	}
}
