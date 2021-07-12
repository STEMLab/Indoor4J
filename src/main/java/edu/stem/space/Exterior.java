package edu.stem.space;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Exterior {
	private Shell shell;
	private List<Pos> pos;

	public Shell getShell() {
		return shell;
	}

	@XmlElement(name = "Shell", namespace = "http://www.opengis.net/gml/3.2")
	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public List<Pos> getPos() {
		return pos;
	}

	@XmlElementWrapper(name = "LinearRing", namespace = "http://www.opengis.net/gml/3.2")
	@XmlElement(name = "pos", namespace = "http://www.opengis.net/gml/3.2")
	public void setPos(List<Pos> pos) {
		this.pos = pos;
	}

}
