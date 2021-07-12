package edu.stem.space;

import javax.xml.bind.annotation.XmlAttribute;

public class BoundedBy {
	private boolean nil;
	
	public BoundedBy() {
		this.nil = true;
	}
	public boolean isNil() {
		return nil;
	}
	
	@XmlAttribute(name = "nil",namespace = "http://www.w3.org/2001/XMLSchema-instance")
	public void setNil(boolean nil) {
		this.nil = nil;
	}
}
