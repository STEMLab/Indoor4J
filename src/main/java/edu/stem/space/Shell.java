package edu.stem.space;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Shell {
	
	private List<SurfaceMember> surfaceMembers;

	public List<SurfaceMember> getSurfaceMembers() {
		return surfaceMembers;
	}
	
	@XmlElement(name = "surfaceMember", namespace = "http://www.opengis.net/gml/3.2")
	public void setSurfaceMembers(List<SurfaceMember> surfaceMembers) {
		this.surfaceMembers = surfaceMembers;
	}

}
