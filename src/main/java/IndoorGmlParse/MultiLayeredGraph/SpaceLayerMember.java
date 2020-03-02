package IndoorGmlParse.MultiLayeredGraph;

import javax.xml.bind.annotation.XmlElement;

public class SpaceLayerMember {
	private SpaceLayer spaceLayer;

	public SpaceLayer getSpaceLayer() {
		return spaceLayer;
	}

	@XmlElement(name = "SpaceLayer", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setSpaceLayer(SpaceLayer spaceLayer) {
		this.spaceLayer = spaceLayer;
	}

}
