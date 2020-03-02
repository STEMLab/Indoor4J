package IndoorGmlParse;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;

//@XmlRootElement(name = "Solid",namespace = "http://www.opengis.net/gml/3.2")
public class Solid {
	private String id;
	private Exterior exterior;
	
	public Solid() {
		// TODO Auto-generated constructor stub
	}
	
	public Solid(String id) {
		this.id = id;
	}

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
