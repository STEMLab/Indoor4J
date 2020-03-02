package IndoorGmlParse;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class CellSpaceMember {
	private CellSpace cellSpace;
	public CellSpaceMember() {
		// TODO Auto-generated constructor stub
	}
	
	public CellSpaceMember(CellSpace cellSpace) {

	}

	public CellSpace getCellSpace() {
		return cellSpace;
	}

	@XmlElement(name = "CellSpace", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setCellSpace(CellSpace cellSpace) {
		this.cellSpace = cellSpace;
	}
}
