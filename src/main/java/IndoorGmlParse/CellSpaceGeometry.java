package IndoorGmlParse;

import javax.xml.bind.annotation.XmlElement;

public class CellSpaceGeometry {
	private Geometry3D geometry3d;
	private Geometry2D geometry2d;

	public CellSpaceGeometry() {
		this.geometry3d = new Geometry3D();
	}

	public Geometry3D getGeometry3d() {
		return geometry3d;
	}

	@XmlElement(name = "Geometry3D", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setGeometry3d(Geometry3D geometry3d) {
		this.geometry3d = geometry3d;
	}

	public Geometry2D getGeometry2d() {
		return geometry2d;
	}

	@XmlElement(name = "Geometry2D", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setGeometry2d(Geometry2D geometry2d) {
		this.geometry2d = geometry2d;
	}

}
