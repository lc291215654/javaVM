import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        String strs = sc.nextLine();
        String words[] = strs.split(" ");
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String boi = sc.nextLine();
            String[] bois = boi.split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = bois[j].charAt(0);
            }
        }
        List<String> result = findWords(board,words);
        for(String s:result){
            System.out.println(s);
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<String>();
        for (String word : words) {
            if (isExsts(board, word)) {
                result.add(word);
            }
        }
        return new ArrayList<String>(result);
    }

    public static boolean isExsts(char[][] board, String words) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visit, int i, int j, String words, int k) {
        if (k == words.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visit[i][j] == true) {
            return false;
        }
        if (board[i][j] != words.charAt(k)) {
            return false;
        }
        visit[i][j] = true;
        if (dfs(board, visit, i - 1, j, words, k + 1) ||
                dfs(board, visit, i + 1, j, words, k + 1) ||
                dfs(board, visit, i, j - 1, words, k + 1) ||
                dfs(board, visit, i, j + 1, words, k + 1)) {
            return true;
        }
        visit[i][j] = false;
        return false;
    }
}
