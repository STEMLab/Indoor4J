package edu.stem.space;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Polygon {
	private String id;
	private Exterior exterior;

	public String getId() {
		return id;
	}

	@XmlAttribute(name = "id", namespace = "http://www.opengis.net/gml/3.2")
	public void setId(String id) {
		this.id = id;
	}

	public Exterior getExterior() {
		return exterior;
	}

	@XmlElement(name = "exterior", namespace = "http://www.opengis.net/gml/3.2")
	public void setExterior(Exterior exterior) {
		this.exterior = exterior;
	}

}
