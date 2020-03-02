package IndoorGmlParse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;

public class CellSpace {
	private String id;
	private String description;
	private String name;
	private BoundedBy boundedBy;
	private CellSpaceGeometry cellSpaceGeometry;
	//@XmlList
	private List<XmlLink> duality;
	//@XmlList
	private List<XmlLink> partialboundedBy;

	public CellSpace() {
		// TODO Auto-generated constructor stub
	}

	public CellSpace(String id, String description, String name, BoundedBy boundedBy) {
		this.id = id;
		this.description = description;
		this.name = name;
		this.boundedBy = boundedBy;
		this.duality = new ArrayList<XmlLink>();
		this.partialboundedBy = new ArrayList<XmlLink>();
		this.cellSpaceGeometry = new CellSpaceGeometry();
	}

	public String getId() {
		return id;
	}

	@XmlAttribute(name = "id", namespace = "http://www.opengis.net/gml/3.2")
	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement(name = "description", namespace = "http://www.opengis.net/gml/3.2")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "name", namespace = "http://www.opengis.net/gml/3.2")
	public void setName(String name) {
		this.name = name;
	}

	public BoundedBy getBoundedBy() {
		return boundedBy;
	}

	@XmlElement(name = "boundedBy", namespace = "http://www.opengis.net/gml/3.2")
	public void setBoundedBy(BoundedBy boundedBy) {
		this.boundedBy = boundedBy;
	}

	public CellSpaceGeometry getCellSpaceGeometry() {
		return cellSpaceGeometry;
	}

	@XmlElement(name = "cellSpaceGeometry", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setCellSpaceGeometry(CellSpaceGeometry cellSpaceGeometry) {
		this.cellSpaceGeometry = cellSpaceGeometry;
	}

	public List<XmlLink> getDuality() {
		return duality;
	}
	
	@XmlElement(name = "duality", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setDuality(List<XmlLink> duality) {
		this.duality = duality;
	}

	@XmlElement(name = "partialboundedBy", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setPartialboundedBy(List<XmlLink> partialboundedBy) {
		this.partialboundedBy = partialboundedBy;
	}
	
	public List<XmlLink> getPartialboundedBy() {
		return partialboundedBy;
	}
}
