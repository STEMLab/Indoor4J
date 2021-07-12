package edu.stem.space;

import javax.xml.bind.annotation.XmlElement;

public class SurfaceMember {
	private Polygon polygon;
	
	public Polygon getPolygon() {
		return polygon;
	}
	
	@XmlElement(name = "Polygon", namespace = "http://www.opengis.net/gml/3.2")
	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}
	
	
}
