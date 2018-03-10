package ProgrammingProblem;

/**
 * Created by licheng on 3/7/18.
 */
public class CountNum {

    public static void main(String args[]) {
        int[] arr = {1, 2, 2,2, 3, 3, 3,  3, 3,3,4, 5};
        int result = getCount(arr,3);
        System.out.println(result);

        result = getCount2(arr,3);
        System.out.println(result);


    }

    public static int getCount(int[] arr, int p) {
        int left = findLeft(arr, p);
        int right = findRight(arr, p);
        System.out.println(right);
        return (right - left) +1;
    }

    public static int getCount2(int[] arr, int p) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] == p) {
                while (l-1 >=0 && arr[l-1] == arr[l]){
                    l--;
                }
                r = l;
                while (r+1 <=arr.length-1 && arr[r+1] == arr[r]){
                    r++;
                }
                System.out.println(r + "--------" + l);
                return r - l + 1;
            }
            int mid = (l + r) / 2;
            if (arr[mid] > p) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return -1;
    }

    public static int findLeft(int[] arr, int p) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            if (l-1 >= 0 && arr[l] == p && arr[l-1] < arr[l]) {
                return l;
            }
            int mid = (l + r) / 2;
            if (arr[mid] >= p) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int findRight(int[] arr, int p) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            if (r+1 < arr.length && arr[r] == p && arr[r+1] > arr[r]) {
                return r;
            }
            int mid = (l + r) / 2;
            if (arr[mid] > p) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return -1;
    }
}
