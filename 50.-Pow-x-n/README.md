直接连续乘法，复杂度太高。

可以二分进行乘法，进行递归，如果是奇数，就多乘一个x。(Solution1.java)

接触了一个新的方法，参考自http://blog.csdn.net/fengbingyang/article/details/12236121
very interesting，可以以2为基数对n进行划分，然后迭代对x进行乘法，免去了递归的空间消耗(Solution2.java)

注意一些特殊情况
