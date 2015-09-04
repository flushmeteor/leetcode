Next Permutation 

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

解题思路：

这个题并不难，重点在于是否知道字典序得到全排列这个方法

以前只知道用递归得到全排列，突然发现还有这么多方法，也是挺有意思。字典序法的步骤如下，根据步骤写代码即可。

设P是1～n的一个全排列:p=p1p2......pn=p1p2......pj-1pjpj+1......pk-1pkpk+1......pn

　　1）从排列的右端开始，找出第一个比右边数字小的数字的序号j（j从左端开始计算），即 j=max{i|pi<pi+1}
　　
　　2）在pj的右边的数字中，找出所有比pj大的数中最小的数字pk，即 k=max{i|pi>pj}（右边的数从右至左是递增的，因此k是所有大于pj的数字中序号最大者）（这里还要注意，如果有两个数都符合条件，这两个数值相同，那么要取索引值大的那一个）
　　
　　3）对换pi，pk
　　
　　4）再将pj+1......pk-1pkpk+1......pn倒转得到排列p'=p1p2.....pj-1pjpn.....pk+1pkpk-1.....pj+1，这就是排列p的下一个排列。
