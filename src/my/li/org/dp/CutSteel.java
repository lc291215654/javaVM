package my.li.org.dp;

/**
 * Created by licheng on 12/6/17.
 */
public class CutSteel {
    static int priceList[] = {0,1, 5, 8, 9,10,17,17,20,24,30};

    public static void main(String args[]) {
        System.out.println(ButtomUpCutRod(priceList,8));
    }



    //********算法导论，动态规划，钢条分割，P205
    //自底向上，仅记录最优解结果
    static int ButtomUpCutRod(int priceList[], int n) {
        int highest[] = new int[n+1]; //记录每个长度对应的最优解
        highest[0] = 0;             //长度为0的最优解（最大利润）为0
        int j = 0;
        for (j = 1; j <= n; j++) {
            int highest_j = -1;     //长度为j的最优解
            for (int i = 1; i < priceList.length && i <= j; i++) {
                //长度为i的最优解为不切割时，或者为切割长度为i的利润加上长度为j-i的最优解
                highest_j = Math.max(highest_j, priceList[i] + highest[j - i]);
            }
            highest[j] = highest_j;  //记录长度为j的最优解值
        }
        return highest[n];
    }
}
