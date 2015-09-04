Substring with Concatenation of All Words

You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).


思路：
最直接的想法是对s进行遍历，从每一个位置开始看当前位置后面的字符串是否和给定的能匹配。对于每一个位置开始的匹配，依次往后读取和给定匹配字符串等长的字符串，去数组中比对，如果有匹配的就继续往后读取进行比对。

需要小心的是，words中的字符串有可能有多个是相同的；所以一开始采用的方法是对数组中的每一位用int中的一位来表示，如果曾经比对过数组索引i处的字符串，即使再次匹配上也不能算作匹配，还需继续对words遍历，看是否有其它字符串能再次匹配。结果忽略了int的表示范围，出错了。


后来，干脆采用hashmap将words数组中的元素保存起来，key是字符串，value是该字符串在words中出现的次数。然后依然对s从每一位开始遍历。对于从index开始的比对，每次匹配上之后，对map中的value值减1，value小于0或者map中没有要找的字符串说明匹配失败。每匹配一个字符串，计数加1。如果从index开始的匹配使得计数等于word.length，那么将该index保存。继续从index+1处再次开始匹配。

可能会引起超时的地方：
1.循环的结束条件应该是i<=s.length()-words.length*step，而不是i<=s.length()
2.在开始位置添加对s和words为空的判断，否则也会超时
