把给的整数反序，比对得到的整数和原数是否相等即可知道是否对称。如果在反序的过程中产生了溢出，那么肯定不是对称的，因为给的整数肯定不是越界的，反序之后越界了，说明两个数不相同，所以也就不对称了。

可以用简单的思路：得到整数的位数。然后比对对称位置上的数。
- public boolean isPalindrome(int x) {
-  if (x < 0) return false;
-  int div = 1;
-  while (x / div >= 10) {
-  div *= 10;
-  }
-  while (x != 0) {
-  int l = x / div;
-  int r = x % 10;
-  if (l != r) return false;
-  x = (x % div) / 10;
-  div /= 100;
-  }
-  return true;
- }
