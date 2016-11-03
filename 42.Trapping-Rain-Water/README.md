这个问题直接的思路是找极值，然后两极值之间求面积。
但是问题就在于：找到的两个极值有可能会被外侧比他俩大的极值包围，然后就会少计算了一些面积。

所以从宏观上来看，所有的小极值直接剔除，最后的极值分布是有规律的，是一个先递增后递减的序列。

那么思路就简单了： 
1、先找到最大值，然后将数组按照最大值的位置分为左右两侧。
2、左侧：找到第一个极大值，然后找第二个极大值（要比第一个极大值大），计算中间能储存的雨水量；按照这个顺序依次找到最大值的位置为止。
3、右侧：和左侧相同，不过要倒着查找。
3、所有的雨水量加起来就是要求的结果