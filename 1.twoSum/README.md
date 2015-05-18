题目：

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9

Output: index1=1, index2=2


答案：

O(n2) runtime, O(1) space – Brute force:

The brute force approach is simple. Loop through each element x and find if there is another value that equals to target – x.
As finding another value requires looping through the rest of array, its runtime complexity is O(n2).

O(n) runtime, O(n) space – Hash table:

We could reduce the runtime complexity of looking up a value to O(1) using a hash map that maps a value to its index.

笔记：

第一个答案是比较简单就能想到的方法

第二个答案是借用了倒排索引的思想。先将数组的内容作为key，数组的索引值作为value放在hashmap中。对于数组内容会出现重复的问题，将它们的索引值用list保存。之后的思想和第一个方案一样。
