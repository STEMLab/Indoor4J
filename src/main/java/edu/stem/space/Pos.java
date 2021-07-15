package edu.stem.space;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

import edu.stem.indoor4j.Point;

public class Pos {
	private String srsDimension;
	private String posValue;
	private Point point;

	public String getSrsDimension() {
		return srsDimension;
	}

	@XmlAttribute(name = "srsDimension")
	public void setSrsDimension(String srsDimension) {
		this.srsDimension = srsDimension;
	}

	public Point getPoint() {
		return point;
	}
	
	public String getPosValue() {
		return posValue;
	}

	@XmlValue
	public void setPosValue(String posValue) {
		this.posValue = posValue;
		double[] dots = Arrays.stream(posValue.split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
		this.point = new Point(dots[0], dots[1], dots[2]);
	}
}
