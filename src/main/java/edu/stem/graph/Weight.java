package edu.stem.graph;

import javax.xml.bind.annotation.XmlValue;

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
