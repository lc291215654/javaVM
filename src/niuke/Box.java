package niuke;

/**
 * Created by licheng on 12/6/17.
 */
public class Box {
    public int getHeight(int[] w, int[] l, int[] h, int n) {
    /*
     * 按照宽度从大到小排序，定maxH[i]为从0开始到放入第i-1个箱子（第i-1个一定被放入），满足长宽条件的最大高度
     * 从第1个开始为h[0]，初始maxH[i] = h[i]，tmax记录放入第i-1个箱子时可达到的最大高度
     * 伪码如下：
     * maxH[0] = h[0];
     * res = maxH[0];
     * for i = 1:n
     *  maxH[i] = h[i];
     *  tmax = 0;
     *  for j = i-1 : 0
     *      if l[j] > l[i] && w[j] > w[i]//看能放下当前i箱子的情况下，选择高度最大的那种
     *          tmax = max(tmax, maxH[j]);
     *   maxH[i] += tmax;
     *   res = max(res, maxH[i]);//res仅存到放入第i-1个箱子为止，出现过的高度最大值
     *  end for;
     *  return res;
     */
        if (n <= 0) {
            return 0;
        }
        //sort
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (w[i] < w[j]) {
                    swap(w, i, j);
                    swap(l, i, j);
                    swap(h, i, j);
                }
            }
        }
        //get height
        int[] maxH = new int[n];
        maxH[0] = h[0];
        int res = maxH[0];
        for (int i = 1; i < n; i++) {
            maxH[i] = h[i];
            int tmax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (w[j] > w[i] && l[j] > l[i]) {
                    tmax = (tmax > maxH[j]) ? tmax : maxH[j];
                }
            }
            maxH[i] += tmax;
            res = res > maxH[i] ? res : maxH[i];
        }
        return res;
    }

    private void swap(int[] mat, int x, int y) {
        // TODO Auto-generated method stub
        int tmp = mat[x];
        mat[x] = mat[y];
        mat[y] = tmp;
    }
}
