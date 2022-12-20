
public class Edge<T> {
	public static final int DEFAULT_EDGE_WEIGHT = 1;

	private boolean marked;
	private boolean weighted;
	private int weight = DEFAULT_EDGE_WEIGHT;
	private Vertex<T> from;
	private Vertex<T> to;

	Edge(Vertex<T> startVertex, Vertex<T> endVertex) {
		from = startVertex;
		to = endVertex;
		from.addEdge(this);
	}

	Edge(Vertex<T> startVertex, Vertex<T> endVertex, int weight) {
		from = startVertex;
		to = endVertex;
		weighted = true;
		this.weight = weight;
		from.addEdge(this);
	}

	// Marked
	public void mark() {
		marked = true;
	}

	public void unmark() {
		marked = false;
	}

	public boolean isMarked() {
		return marked;
	}

	// Weight
	public boolean isWeighted() {
		return weighted;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	// From
	public Vertex<T> getFrom() {
		return from;
	}

	public void setFrom(Vertex<T> from) {
		this.from = from;
	}

	// To
	public Vertex<T> getTo() {
		return to;
	}

	public void setTo(Vertex<T> to) {
		this.to = to;
	}
}