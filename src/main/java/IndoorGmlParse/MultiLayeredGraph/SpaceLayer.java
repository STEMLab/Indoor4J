package IndoorGmlParse.MultiLayeredGraph;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import IndoorGmlParse.BoundedBy;

public class SpaceLayer {
	private String id;
	private BoundedBy boundedBy;
	private Nodes nodes;
	private Edges edges;

	public String getId() {
		return id;
	}
	
	@XmlAttribute(name = "id", namespace = "http://www.opengis.net/gml/3.2")
	public void setId(String id) {
		this.id = id;
	}

	public BoundedBy getBoundedBy() {
		return boundedBy;
	}
	
	@XmlElement(name = "boundedBy", namespace = "http://www.opengis.net/gml/3.2")
	public void setBoundedBy(BoundedBy boundedBy) {
		this.boundedBy = boundedBy;
	}

	public Nodes getNodes() {
		return nodes;
	}
	@XmlElement(name = "nodes", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setNodes(Nodes nodes) {
		this.nodes = nodes;
	}

	public Edges getEdges() {
		return edges;
	}
	@XmlElement(name = "edges", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setEdges(Edges edges) {
		this.edges = edges;
	}

}
