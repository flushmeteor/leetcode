借用了String来实现，把int转成String，倒叙组成字符串然后转化成int，如果出现异常，说明是溢出了，直接捕获异常返回0

这种方式不够优雅。下面的方法更好一些：

-public int reverse(int x) {
-   int ret = 0;
-   while (x != 0) {
-     if(Math.abs(ret)>214748364){\
-       return 0;
-     }
-     ret = ret * 10 + x % 10;
-     x /= 10;
-   }
-   return ret;
- }

这里面没有记录符号，是因为负数除以10取余数得到的就是负数。
