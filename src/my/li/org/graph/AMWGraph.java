package my.li.org.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 邻接矩阵模型类
 */

public class AMWGraph {
    public ArrayList vertexList;//存储点的链表
    public int[][] edges;//邻接矩阵，用来存储边
    public int numOfEdges;//边的数目
    boolean[] isVisited;

    public AMWGraph(int n) {
        //初始化矩阵，一维数组，和边的数目
        edges=new int[n][n];
        vertexList=new ArrayList(n);
        numOfEdges=0;
        isVisited = new boolean[50];
    }

    //插入结点
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(),vertex);
    }

    //插入边
    public void insertEdge(int v1,int v2,int weight) {
        edges[v1][v2]=weight;
        numOfEdges++;
    }

    //删除边
    public void deleteEdge(int v1,int v2) {
        edges[v1][v2]=0;
        numOfEdges--;
    }

    //返回结点i的数据
    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }


    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        for(int j=0;j<vertexList.size();j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public int getNextNeighbor(int v1,int v2) {
        for (int j=v2+1;j<vertexList.size();j++) {
            if (edges[v1][j]>0) {
                return j;
            }
        }
        return -1;
    }

    //私有函数，深度优先遍历
    private void depthFirstSearch(boolean[] isVisited,int  i) {
        //首先访问该结点，在控制台打印出来
        System.out.print(getValueByIndex(i)+"  ");
        //置该结点为已访问
        isVisited[i]=true;

        int w=getFirstNeighbor(i);//
        while (w!=-1) {
            if (!isVisited[w]) {
                depthFirstSearch(isVisited,w);
            }
            w=getNextNeighbor(i, w);
        }
    }
    //对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public void depthFirstSearch() {
        for(int i=0;i<vertexList.size();i++) {
            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
            if (!isVisited[i]) {
                depthFirstSearch(isVisited,i);
            }
        }
    }

    //私有函数，广度优先遍历
    private void broadFirstSearch(boolean[] isVisited,int i) {
        int u,w;
        LinkedList queue = new LinkedList();

        //访问结点i
        System.out.print(getValueByIndex(i)+"  ");
        isVisited[i]=true;
        //结点入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u=((Integer)queue.removeFirst()).intValue();
            w=getFirstNeighbor(u);
            while(w!=-1) {
                if(!isVisited[w]) {
                    //访问该结点
                    System.out.print(getValueByIndex(w)+"  ");
                    //标记已被访问
                    isVisited[w]=true;
                    //入队列
                    queue.addLast(w);
                }
                //寻找下一个邻接结点
                w=getNextNeighbor(u, w);
            }
        }
    }

    //对外公开函数，广度优先遍历
    public void broadFirstSearch() {
        for(int i=0;i<numOfEdges;i++) {
            if(!isVisited[i]) {
                broadFirstSearch(isVisited, i);
            }
        }
    }


}
