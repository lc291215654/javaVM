package MyCode05;


import java.util.*;

//undirected graph only

/**
 * Kruskal算法，最小生成树算法，考察边的值
 */

public class C05_Kruskal {

    // Union-Find Set

    /**
     * 并查集
     */
    public static class UnionFind {
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> rankMap;

        public UnionFind() {
            fatherMap = new HashMap<Node, Node>();
            rankMap = new HashMap<Node, Integer>();
        }

        private Node findFather(Node n) {
            Node father = fatherMap.get(n);
            if (father != n) {
                father = findFather(father);
            }
            fatherMap.put(n, father);
            return father;
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            rankMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                rankMap.put(node, 1);
            }
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aFather = findFather(a);
            Node bFather = findFather(b);
            if (aFather != bFather) {
                int aFrank = rankMap.get(aFather);
                int bFrank = rankMap.get(bFather);
                if (aFrank <= bFrank) {
                    fatherMap.put(aFather, bFather);
                    rankMap.put(bFather, aFrank + bFrank);
                } else {
                    fatherMap.put(bFather, aFather);
                    rankMap.put(aFather, aFrank + bFrank);
                }
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskalMST(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());


        /**
         * 构造边的优先级队列
         */
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }


        Set<Edge> result = new HashSet<Edge>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }


    public static void main(String args[]) {

        Integer[][] grapharr = {{1, 2, 4}, {1, 3, 5}, {2, 3, 4}, {2, 4, 7}, {2, 5, 2}, {3, 5, 10}, {3, 6, 8}, {4, 5, 3}, {5, 6, 6}};

        Graph graph = GraphGenerator.createGraph(grapharr);
        Set<Edge> result = kruskalMST(graph);


        for (Edge edge : result) {

            System.out.println(edge.from.value + "++" + edge.to.value);
        }
        System.out.println("++++++++++++++++++++++++++++++++");



        result = C06_Prim.primMST(graph);

        for (Edge edge : result) {

            System.out.println(edge.from.value + "++" + edge.to.value);
        }
    }
}
