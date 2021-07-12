package edu.stem.graph;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import edu.stem.space.BoundedBy;
import edu.stem.space.XmlLink;

public class Transition {
	private String id;
	private String description;
	private Name name;
	private BoundedBy boundedBy;
	private Weight weight;
	private List<XmlLink> connects;
	private Geometry geometry;

	public String getId() {
		return id;
	}

	@XmlAttribute(name = "id", namespace = "http://www.opengis.net/gml/3.2")
	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement(name = "description", namespace = "http://www.opengis.net/gml/3.2")
	public void setDescription(String description) {
		this.description = description;
	}

	public Name getName() {
		return name;
	}

	@XmlElement(name = "name", namespace = "http://www.opengis.net/gml/3.2")
	public void setName(Name name) {
		this.name = name;
	}

	public BoundedBy getBoundedBy() {
		return boundedBy;
	}

	@XmlElement(name = "boundedBy", namespace = "http://www.opengis.net/gml/3.2")
	public void setBoundedBy(BoundedBy boundedBy) {
		this.boundedBy = boundedBy;
	}

	public Weight getWeight() {
		return weight;
	}
	
	@XmlElement(name = "weight", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setWeight(Weight weight) {
		this.weight = weight;
	}
	
	public List<XmlLink> getConnects() {
		return connects;
	}
	
	@XmlElement(name = "connects", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setConnects(List<XmlLink> connects) {
		this.connects = connects;
	}


	public Geometry getGeometry() {
		return geometry;
	}

	@XmlElement(name = "geometry", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

}
