题目：

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8

答案：

Keep track of the carry using a variable and simulate digits-by-digits sum from the head
of list, which contains the least-significant digit.
Take extra caution of the following cases:
- When one list is longer than the other.
- The sum could have an extra carry of one at the end, which is easy to forget. (e.g.,
(9 -> 9) + (1) = (0 -> 0 -> 1))

笔记：

题目并不难，但是需要考虑的特殊情况比较多，上面答案中已经指出。
