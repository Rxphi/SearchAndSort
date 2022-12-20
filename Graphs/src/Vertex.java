import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	static int counter = 0;
	private T value;
	private int index;
	private List<Edge<T>> edges;

	Vertex(T value) {
		this.value = value;
		this.index = counter++;
		edges = new ArrayList<Edge<T>>();
	}

	public T getValue() {
		return value;
	}

	public int getIndex() {
		return index;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void addEdge(Edge<T> e) {
		edges.add(e);
	}

	public List<Vertex<T>> getNeighbours() {
		List<Vertex<T>> out = new ArrayList<Vertex<T>>();
		for (Edge<T> e : edges) {
			out.add(e.getTo());
		}
		return out;
	}
}
