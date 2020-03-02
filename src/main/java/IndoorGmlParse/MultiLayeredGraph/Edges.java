package IndoorGmlParse.MultiLayeredGraph;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import IndoorGmlParse.BoundedBy;

public class Edges {
	private String id;
	private BoundedBy boundedBy;
	private List<TransitionMember> transitionMember;

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

	public List<TransitionMember> getTransitionMember() {
		return transitionMember;
	}
	
	@XmlElement(name = "transitionMember", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setTransitionMember(List<TransitionMember> transitionMember) {
		this.transitionMember = transitionMember;
	}

}
