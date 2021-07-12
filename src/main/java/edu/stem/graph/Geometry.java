package edu.stem.graph;

import javax.xml.bind.annotation.XmlElement;

public class Geometry {
	private Point point;
	private LineString lineString;
	
	public Point getPoint() {
		return point;
	}

	@XmlElement(name = "Point", namespace = "http://www.opengis.net/gml/3.2")
	public void setPoint(Point point) {
		this.point = point;
	}

	public LineString getLineString() {
		return lineString;
	}
	
	@XmlElement(name = "LineString", namespace = "http://www.opengis.net/gml/3.2")
	public void setLineString(LineString lineString) {
		this.lineString = lineString;
	}
	
	
}
