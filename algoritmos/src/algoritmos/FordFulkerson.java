package algoritmos;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
	private int[] parent;
    private Queue<Integer> queue;
    private int numerodeVertices;
    private boolean[] visited;
    private int[][]resultGraph;
 
    public FordFulkerson(int numberOfVertices)
    {
        this.numerodeVertices = numberOfVertices;
        this.queue = new LinkedList<Integer>();
        parent = new int[numberOfVertices + 1];
        visited = new boolean[numerodeVertices + 1];		
    }
 //Busqueda de caminos
    public boolean existecamino(int source, int fuente, int graph[][])
    {
        boolean pathFound = false;
        int destination, element;
 
        for(int vertice = 0; vertice < numerodeVertices; vertice++)
        {
            parent[vertice] = -1;
            visited[vertice] = false;
        }
 
        queue.add(source);
        parent[source] = -1;
        visited[source] = true;
 
        while (!queue.isEmpty())
        { 
            element = queue.remove();
            destination = 0;
 
            while (destination < numerodeVertices)
            {
                if (graph[element][destination] > 0 &&  !visited[destination])
                {
                    parent[destination] = element;
                    queue.add(destination);
                    visited[destination] = true;
                }
                destination++;
            }
        }
        if(visited[fuente])
        {
            pathFound = true;
        }
        return pathFound;
    }
    public int[][] getResidualGrapH()
    {
    	 return resultGraph;
    	
    }
    public int fordFulkerson(int graph[][], int source, int destination)
    {
        int u, v;
        int maxFlujo = 0;
        int rutaFlujo;
 
        int[][] residualGraph = new int[numerodeVertices][numerodeVertices];
        for (int sourceVertice = 0; sourceVertice < numerodeVertices; sourceVertice++)
        {
            for (int destinationVertex = 0; destinationVertex < numerodeVertices; destinationVertex++)
            {
                residualGraph[sourceVertice][destinationVertex] = graph[sourceVertice][destinationVertex];
            }
        }
 
        while (existecamino(source ,destination, residualGraph))
        {
        	rutaFlujo = Integer.MAX_VALUE;
            for (v = destination; v != source; v = parent[v])
            {
                u = parent[v];
                rutaFlujo = Math.min(rutaFlujo, residualGraph[u][v]);
            }
            for (v = destination; v != source; v = parent[v])
            {
                u = parent[v];
                residualGraph[u][v] -= rutaFlujo;
                residualGraph[v][u] += rutaFlujo;
            }
            maxFlujo += rutaFlujo;	
        }
        resultGraph=residualGraph;
        return maxFlujo;

    	}
    }
