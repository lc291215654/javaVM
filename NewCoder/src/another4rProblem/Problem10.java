package another4rProblem;

public class Problem10 {
    static class Solution {

    }

    private static void calHepler(int[] result, int index, int[] curnums) {
        if(index >= curnums.length - 1){
            if((curnums[index - 1] % curnums[index]) == 0){
                result[0]++;
            }
            return ;
        }
        if(index > 0 && (curnums[index - 1] % curnums[index]) != 0){
            return ;
        }
        if(curnums[index] == 1){
            result[0]++;
            return ;
        }
        index++;
        for(int i=curnums[0];i>=1;i--) {
            curnums[index] = i;
            calHepler(result,index,curnums);
        }
    }
}