int jump(int* nums, int numsSize) {
    if(numsSize==1)
        return 0;
	//其实，这个就是去找当到达下一个位置的时候，步数所能辐射到的范围最大
    int count = 0;//记录总步数
    int currentStartIndex = 0;//当前出发的位置
    int currentSteps = *(nums+currentStartIndex);//当前出发位置的数字
    int optimizeStep = 0;//记录下一步最好的选择,即走出多远的距离
    int optimizeNum = 0;//记录下一步最好的选择，所对应的能辐射出去的范围值

    int i=0;
    while(i<numsSize){
        if(currentSteps+currentStartIndex>=numsSize-1)
        	return count+1;

        for(int j=1;j<=currentSteps;j++){
        	int region = j+*(nums+currentStartIndex+j);
        	if(region>optimizeNum){
        		optimizeStep = j;
        		optimizeNum = region;
        	}
        }
        currentStartIndex = currentStartIndex + optimizeStep;
        currentSteps = *(nums+currentStartIndex);
        count++;
        optimizeStep = 0;
        optimizeNum = 0;
    }
    return count;
}
