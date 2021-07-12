package edu.stem.space;

import javax.xml.bind.annotation.XmlElement;

public class Geometry3D {
	private Solid solid;

	public Solid getSolid() {
		return solid;
	}

	@XmlElement(name = "Solid", namespace = "http://www.opengis.net/gml/3.2")
	public void setSolid(Solid solid) {
		this.solid = solid;
	}

}
