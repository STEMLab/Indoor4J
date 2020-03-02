package IndoorGmlParse.MultiLayeredGraph;

import javax.xml.bind.annotation.XmlElement;

public class StateMember {
	private State state;

	public State getState() {
		return state;
	}
	
	@XmlElement(name = "State", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setState(State state) {
		this.state = state;
	}

}
