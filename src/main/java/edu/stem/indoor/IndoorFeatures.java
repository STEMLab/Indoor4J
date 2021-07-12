package edu.stem.indoor;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.stem.graph.MultiLayeredGraph;
import edu.stem.space.BoundedBy;
import edu.stem.space.PrimalSpaceFeatures;

@XmlRootElement(name = "IndoorFeatures", namespace = "http://www.opengis.net/indoorgml/1.0/core")
public class IndoorFeatures implements Serializable  {
	private static final long serialVersionUID = 1L;
	private String id;
	private String schemaLocation;
	private BoundedBy boundedBy;
	private PrimalSpaceFeatures primalSpaceFeatures;
	private MultiLayeredGraph multiLayeredGraph;
	
	public IndoorFeatures() {

	}


	public String getId() {
		return id;
	}

	@XmlAttribute(name = "id",namespace = "http://www.opengis.net/gml/3.2")
	public void setId(String id) {
		this.id = id;
	}

	public String getSchemaLocation() {
		return schemaLocation;
	}

	@XmlAttribute(name = "schemaLocation", namespace = "http://www.w3.org/2001/XMLSchema-instance")
	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public BoundedBy getBoundedBy() {
		return boundedBy;
	}


	@XmlElement(name = "boundedBy",namespace = "http://www.opengis.net/gml/3.2")
	public void setBoundedBy(BoundedBy boundedBy) {
		this.boundedBy = boundedBy;
	}
	
	public PrimalSpaceFeatures getPrimalSpaceFeatures() {
		return primalSpaceFeatures;
	}
	
	@XmlElement(name = "primalSpaceFeatures",namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setPrimalSpaceFeatures(PrimalSpaceFeatures primalSpaceFeatures) {
		this.primalSpaceFeatures = primalSpaceFeatures;
	}

	
	public MultiLayeredGraph getMultiLayeredGraph() {
		return multiLayeredGraph;
	}

	@XmlElement(name = "multiLayeredGraph",namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setMultiLayeredGraph(MultiLayeredGraph multiLayeredGraph) {
		this.multiLayeredGraph = multiLayeredGraph;
	}


	@Override
	public String toString() {
		return "IndoorFeatures [id=" + id + ", schemaLocation=" + schemaLocation + ", boundedBy=" + boundedBy
				+ ", primalSpaceFeatures=" + primalSpaceFeatures + ", multiLayeredGraph=" + multiLayeredGraph + "]";
	}
	
	
	
}

