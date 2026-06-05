import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

  public class Adj_List_Graph{
    int n;  // no of nodes
    ArrayList<ArrayList<Integer>> adj; 
    int dist[];
    int npath[];
    
    
    //constructor taking as the single parameter the number of nodes
    Adj_List_Graph(int no_nodes) {
      n = no_nodes;
      adj =  new ArrayList<ArrayList<Integer> >(n);
      for (int i = 0; i < n; i++)
        adj.add(new ArrayList<Integer>());
       dist = new int[n];
       npath = new int[n];
      
    }
    
    
    // A utility function to add an edge in an
    // undirected graph; for directed graph remove the second line
    public void addEdge(int u, int v)
    {
      adj.get(u).add(v);
      adj.get(v).add(u);
    }


    
    // A utility function to print the adjacency list
    // representation of graph
    
    public void printGraph(){
      for (int i = 0; i < n; i++) {
        System.out.println("\nAdjacency list of vertex " + i);
        System.out.print("head");
        for (int j = 0; j < adj.get(i).size(); j++) {
          System.out.print(" -> "+adj.get(i).get(j));
        }
        System.out.println();
      }
    }


  public void BFS(int s) {
    Queue<Integer> q = new LinkedList<>();
  
     for (int i = 0; i < n; i++) {
      dist[i] = -1;
      npath[i] = 0;
  }

  dist[s] = 0;
  npath[s] = 1;

  q.add(s);

  while (!q.isEmpty()) {
      int u = q.poll();

      for (int v : adj.get(u)) {

          // First time visiting v
          if (dist[v] == -1) {
              dist[v] = dist[u] + 1;
              npath[v] = npath[u];
              q.add(v);
          }

          // If there is another shortest path 
          else if (dist[v] == dist[u] + 1) {
              npath[v] += npath[u];
          }
      }
  }
}



    public static void main(String[] args) {

      int V = 8; // number of vertices
      Adj_List_Graph graph = new Adj_List_Graph(V);

      // Graph 1
      graph.addEdge(1, 2);
      graph.addEdge(1, 3);
      graph.addEdge(1, 4);
      graph.addEdge(2, 5);
      graph.addEdge(3, 5);
      graph.addEdge(4, 6);
      graph.addEdge(5, 7);
      graph.addEdge(5, 6);
      graph.addEdge(6, 5);
      graph.addEdge(6, 7);


      // Print adjacency list
      graph.printGraph();
  }


    
  }
  
  
