import org.junit.Assert;
import org.junit.Test;

public class GraphTest {
    @Test
    public void GraphClassTest1() {
        int n = 4;
        int[][] edges = {
                {0, 2, 5},
                {0, 1, 2},
                {1, 2, 3},
                {3, 0, 3}
        };
        Graph graph = new Graph(n, edges);
        Assert.assertEquals(6, graph.shortestPath(3, 2));
        Assert.assertEquals(-1, graph.shortestPath(0, 3));
        graph.addEdge(new int[]{1, 3, 4});
        Assert.assertEquals(6, graph.shortestPath(0, 3));
    }
}
