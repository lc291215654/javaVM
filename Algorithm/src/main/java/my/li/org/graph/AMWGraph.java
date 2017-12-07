package my.li.org.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 邻接矩阵模型类
 */

public class AMWGraph {
    public ArrayList vertexList; //存储点的链表
    public int[][] edges; //邻接矩阵，用来存储边
    public int numOfEdges; //边的数目
    boolean[] isVisited;

    public AMWGraph(int n) {
        //初始化矩阵，一维数组，和边的数目
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //插入结点
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(), vertex);
    }

    //插入边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        numOfEdges++;
    }

    //删除边
    public void deleteEdge(int v1, int v2) {
        edges[v1][v2] = 0;
        numOfEdges--;
    }

    //返回结点i的数据
    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }


    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 递归深度优先遍历
     */
    private void depthFirstSearch(int i) {
        //首先访问该结点，在控制台打印出来
        System.out.print(getValueByIndex(i) + "  ");
        //置该结点为已访问
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                depthFirstSearch(w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 深度优先遍历
     */
    public void depthFirstSearch() {
        for (int i = 0; i < vertexList.size(); i++) {
            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
            if (!isVisited[i]) {
                depthFirstSearch(i);
            }
        }
    }

    /**
     * 非递归广度优先遍历
     */
    private void broadFirstSearch(int i) {
        int u, w;
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "  ");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = ((Integer) queue.removeFirst()).intValue();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "  ");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    //对外公开函数，广度优先遍历
    public void broadFirstSearch() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                broadFirstSearch(i);
            }
        }
    }

    public static void main(String args[]) {
        int n=8,e=9;//分别代表结点个数和边的数目
        String labels[]={"1","2","3","4","5","6","7","8"};//结点的标识
        AMWGraph graph=new AMWGraph(n);
        for(String label:labels) {
            graph.insertVertex(label);//插入结点
        }
        //插入九条边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);
        graph.insertEdge(7, 3, 1);
        graph.insertEdge(7, 4, 1);
        graph.insertEdge(6, 2, 1);
        graph.insertEdge(5, 2, 1);
        graph.insertEdge(6, 5, 1);

        System.out.println("深度优先搜索序列为：");
        graph.depthFirstSearch();
        System.out.println();
        System.out.println("广度优先搜索序列为：");
        graph.broadFirstSearch();
    }




}
