package IndoorGmlParse.MultiLayeredGraph;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import IndoorGmlParse.BoundedBy;

public class Nodes {
	private String id;
	private BoundedBy boundedBy;
	private List<StateMember> stateMember;

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

	public List<StateMember> getStateMember() {
		return stateMember;
	}
	
	@XmlElement(name = "stateMember", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setStateMember(List<StateMember> stateMember) {
		this.stateMember = stateMember;
	}

}
