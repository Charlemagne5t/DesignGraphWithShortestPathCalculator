import java.util.*;

public class Graph {
    Map<Integer, List<int[]>> adjacencyList = new HashMap<>();

    public Graph(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            addEdge(edge);
        }

    }

    public void addEdge(int[] edge) {
        List<int[]> neighbours = adjacencyList.get(edge[0]);
        neighbours.add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.pathCost));
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(node1, 0);
        priorityQueue.offer(new Node(node1, 0));
        while (!priorityQueue.isEmpty()){
            Node current = priorityQueue.poll();
            int currentNode = current.nodeNumber;
            int currentPathCost = current.pathCost;

            if(currentNode == node2){
                return currentPathCost;
             }

            for (int i = 0; i < adjacencyList.get(currentNode).size(); i++) {
                int[] path = adjacencyList.get(currentNode).get(i);
                if(visited.containsKey(path[0])){
                    int knownCost = visited.get(path[0]);
                    int candidateCost = currentPathCost + path[1];
                    if(candidateCost >= knownCost){
                        continue;
                    }
                }
                priorityQueue.offer(new Node(path[0], currentPathCost + path[1]));
                visited.put(path[0], currentPathCost + path[1]);
            }
        }
        return -1;
    }
}
class Node{
    int nodeNumber;
    int pathCost;


    public Node(int nodeNumber, int pathCost) {
        this.nodeNumber = nodeNumber;
        this.pathCost = pathCost;
    }
}
