package edu.stem.space;

import javax.xml.bind.annotation.XmlAttribute;

public class XmlLink {
	private String href;

	public XmlLink() {
		// TODO Auto-generated constructor stub
	}

	public XmlLink(String href) {
		// TODO Auto-generated constructor stub
		this.href = href;
	}

	public String getHref() {
		return href;
	}
	
	@XmlAttribute(name = "href",namespace = "http://www.w3.org/1999/xlink")
	public void setHref(String href) {
		this.href = href;
	}

}
