package edu.stem.graph;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import edu.stem.space.Pos;

public class Point {
	private String id;
	private List<Pos> pos;

	public String getId() {
		return id;
	}

	@XmlAttribute(name = "id", namespace = "http://www.opengis.net/gml/3.2")
	public void setId(String id) {
		this.id = id;
	}

	public List<Pos> getPos() {
		return pos;
	}

	@XmlElement(name = "pos", namespace = "http://www.opengis.net/gml/3.2")
	public void setPos(List<Pos> pos) {
		this.pos = pos;
	}
}
