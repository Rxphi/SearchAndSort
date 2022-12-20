import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Graph<T> {
	private List<Vertex<T>> vertices;
	private List<Edge<T>> edges;

	Graph() {
		vertices = new ArrayList<Vertex<T>>();
		edges = new ArrayList<Edge<T>>();
	}

	public List<Vertex<T>> getVertices() {
		return vertices;
	}

	public List<Edge<T>> getEdges() {
		return edges;
	}

	public void addVertex(Vertex<T> v) {
		vertices.add(v);
	}

	public void addEdge(Edge<T> e) {
		edges.add(e);
	}

	public int numOfVertices() {
		return vertices.size();
	}

	public int numOfEdges() {
		return edges.size();
	}
}
