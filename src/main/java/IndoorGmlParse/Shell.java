package IndoorGmlParse;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlElementWrapper;

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
