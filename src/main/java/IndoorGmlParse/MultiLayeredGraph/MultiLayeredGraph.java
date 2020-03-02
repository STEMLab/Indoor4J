package IndoorGmlParse.MultiLayeredGraph;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import IndoorGmlParse.BoundedBy;

public class MultiLayeredGraph {
	private String id;
	private MultiLayeredGraph multiLayeredGraph;
	private BoundedBy boundedBy;
	private SpaceLayers spaceLayers;
	private InterEdges interEdges;

	public String getId() {
		return id;
	}

	@XmlAttribute(name = "id", namespace = "http://www.opengis.net/gml/3.2")
	public void setId(String id) {
		this.id = id;
	}

	public MultiLayeredGraph getMultiLayeredGraph() {
		return multiLayeredGraph;
	}

	@XmlElement(name = "MultiLayeredGraph", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setMultiLayeredGraph(MultiLayeredGraph multiLayeredGraph) {
		this.multiLayeredGraph = multiLayeredGraph;
	}

	public BoundedBy getBoundedBy() {
		return boundedBy;
	}

	@XmlElement(name = "boundedBy", namespace = "http://www.opengis.net/gml/3.2")
	public void setBoundedBy(BoundedBy boundedBy) {
		this.boundedBy = boundedBy;
	}

	public SpaceLayers getSpaceLayers() {
		return spaceLayers;
	}

	@XmlElement(name = "spaceLayers", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setSpaceLayers(SpaceLayers spaceLayers) {
		this.spaceLayers = spaceLayers;
	}

	public InterEdges getInterEdges() {
		return interEdges;
	}

	@XmlElement(name = "interEdges", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setInterEdges(InterEdges interEdges) {
		this.interEdges = interEdges;
	}

}
