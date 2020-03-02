package IndoorGmlParse.MultiLayeredGraph;

import javax.xml.bind.annotation.XmlElement;

public class TransitionMember {
	private Transition transition;

	public Transition getTransition() {
		return transition;
	}
	
	@XmlElement(name = "Transition", namespace = "http://www.opengis.net/indoorgml/1.0/core")
	public void setTransition(Transition transition) {
		this.transition = transition;
	}
	
}
