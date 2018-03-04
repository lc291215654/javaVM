package MyCode05;

/**
 * Created by licheng on 3/4/18.
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight,Node from,Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
