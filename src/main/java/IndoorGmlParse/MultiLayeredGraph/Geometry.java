package IndoorGmlParse.MultiLayeredGraph;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import IndoorGmlParse.Pos;

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
