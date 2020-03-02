package IndoorGmlParse.MultiLayeredGraph;

import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Weight {
	private String content;
	public String getContent() {
		return content;
	}

	@XmlValue
	public void setContent(String content) {
		this.content = content;
	}
}
