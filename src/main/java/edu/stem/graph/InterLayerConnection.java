package edu.stem.graph;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import edu.stem.space.BoundedBy;
import edu.stem.space.XmlLink;

public class InterLayerConnection {
	private String id;
	private BoundedBy boundedBy;
	private String typeOfTopoExpression;
	private List<XmlLink> interConnects;
	private List<XmlLink> connectedLayers;

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

	public String getTypeOfTopoExpression() {
		return typeOfTopoExpression;
	}

	@XmlElement(name = "typeOfTopoExpression", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setTypeOfTopoExpression(String typeOfTopoExpression) {
		this.typeOfTopoExpression = typeOfTopoExpression;
	}

	public List<XmlLink> getInterConnects() {
		return interConnects;
	}

	@XmlElement(name = "interConnects", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setInterConnects(List<XmlLink> interConnects) {
		this.interConnects = interConnects;
	}

	public List<XmlLink> getConnectedLayers() {
		return connectedLayers;
	}

	@XmlElement(name = "ConnectedLayers", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setConnectedLayers(List<XmlLink> connectedLayers) {
		this.connectedLayers = connectedLayers;
	}

}
