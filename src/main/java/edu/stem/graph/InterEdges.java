package edu.stem.graph;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import edu.stem.space.BoundedBy;

public class InterEdges {
	private String id;
	private BoundedBy boundedBy;
	private List<InterLayerConnectionMember> interLayerConnectionMember;

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

	public List<InterLayerConnectionMember> getInterLayerConnectionMember() {
		return interLayerConnectionMember;
	}

	@XmlElement(name = "interLayerConnectionMember", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setInterLayerConnectionMember(List<InterLayerConnectionMember> interLayerConnectionMember) {
		this.interLayerConnectionMember = interLayerConnectionMember;
	}

}
