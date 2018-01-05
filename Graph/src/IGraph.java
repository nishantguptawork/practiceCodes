
public interface IGraph {
	public void addEdge(int sourceV, int destV, int aWeight) throws GraphIndexOutOfBoundsException;
	public void removeEdge(int sourceV, int destV) throws GraphIndexOutOfBoundsException;
	public void displayAdjacencyMatrix();
	public void DFS(int startVertex);
	public void BFS(int startVertex);
	public void DFSTraversal();
	public void BFSTraversal();
}
