package MyCode.MyCode05;

import java.util.ArrayList;

/**
 * Created by licheng on 3/4/18.
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
    }

}
