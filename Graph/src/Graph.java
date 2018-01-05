import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.designpatterns.abstractfactory.*;
import com.designpatterns.factory.*;

public class Graph implements IGraph {
	private int V;
	private int E;
	private int[][] adjMatrix;
	private int[] visited;

	public Graph() {
		this.V = 0;
		this.E = 0;
		this.adjMatrix = null;
		this.visited = new int[this.V];
		for (int i = 0; i < this.V; ++i) {
			visited[i] = -1;
		}
	}

	public Graph(int aV, int aE, int[][] aAdjMatrix) {
		this.V = aV;
		this.E = aE;
		this.adjMatrix = new int[this.V][this.V];
		for (int i = 0; i < this.V; ++i) {
			this.adjMatrix[i] = aAdjMatrix[i];
		}
	}

	/**
	 * @return the v
	 */
	public int getV() {
		return V;
	}

	/**
	 * @param v
	 *            the v to set
	 */
	public void setV(int v) {
		V = v;
	}

	/**
	 * @return the e
	 */
	public int getE() {
		return E;
	}

	/**
	 * @param e
	 *            the e to set
	 */
	public void setE(int e) {
		E = e;
	}

	@Override
	public void addEdge(int sourceV, int destV, int aWeight) throws GraphIndexOutOfBoundsException {
		if (sourceV > this.V || destV > this.V) {
			throw (new GraphIndexOutOfBoundsException("Index Out of Bounds for the given Graph"));
		}
		this.adjMatrix[sourceV][destV] = aWeight;
	}

	@Override
	public void removeEdge(int sourceV, int destV) throws GraphIndexOutOfBoundsException {
		if (sourceV > this.V || destV > this.V) {
			throw (new GraphIndexOutOfBoundsException("Index Out of Bounds for the given Graph"));
		}
		this.adjMatrix[sourceV][destV] = 0;
	}

	@Override
	public void displayAdjacencyMatrix() {
		for (int i = 0; i < this.V; ++i) {
			for (int j = 0; j < this.V; ++j) {
				System.out.print(" " + this.adjMatrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	@Override
	public void DFS(int startVertex) {
		visited[startVertex] = 0;
		ArrayList<Integer> adjacentNodes = findAdjacentNodes(startVertex);
		Iterator<Integer> adjacentNodesIterator = adjacentNodes.iterator();
		while (adjacentNodesIterator.hasNext()) {
			int current = adjacentNodesIterator.next();
			if (visited[current] == -1) {
				DFS(current);
			}
		}
	}

	@Override
	public void DFSTraversal() {
		reInitializeVisited();
		for (int i = 0; i < V; ++i) {
			if (visited[i] == -1) {
				DFS(i);
			}
		}
	}

	@Override
	public void BFS(int startVertex) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startVertex);
		while (!q.isEmpty()) {
			int current = q.remove();
			visited[current] = 0;
			ArrayList<Integer> adjacentNodes = findAdjacentNodes(startVertex);
			Iterator<Integer> adjacentNodesIterator = adjacentNodes.iterator();
			while (adjacentNodesIterator.hasNext()) {
				int nextNode = adjacentNodesIterator.next();
				if (visited[nextNode] != -1)
					q.add(nextNode);
			}
		}
	}

	@Override
	public void BFSTraversal() {
		reInitializeVisited();
		for (int i = 0; i < V; ++i) {
			if (visited[i] == -1) {
				BFS(i);
			}
		}
	}

	public int searchDFS(int aValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int searchBFS(int aValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void reInitializeVisited() {
		for (int i = 0; i < this.V; ++i) {
			visited[i] = -1;
		}
	}

	private ArrayList<Integer> findAdjacentNodes(int vertex) {
		ArrayList<Integer> adjacentNodesList = new ArrayList<Integer>();
		for (int i = 0; i < this.V; ++i) {
			if (i == vertex) {
				for (int j = 0; j < this.V; ++j) {
					if (this.adjMatrix[i][j] != 0)
						adjacentNodesList.add(j);
				}
			}
		}
		return adjacentNodesList;
	}

}
