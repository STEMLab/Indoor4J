package IndoorGmlParse.MultiLayeredGraph;

import javax.xml.bind.annotation.XmlElement;

public class InterLayerConnectionMember {
	private InterLayerConnection interLayerConnection;

	public InterLayerConnection getInterLayerConnection() {
		return interLayerConnection;
	}

	@XmlElement(name = "InterLayerConnection", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setInterLayerConnection(InterLayerConnection interLayerConnection) {
		this.interLayerConnection = interLayerConnection;
	}

}
