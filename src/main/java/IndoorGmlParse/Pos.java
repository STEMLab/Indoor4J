package IndoorGmlParse;

import javax.xml.bind.annotation.*;

public class Pos {
	private String srsDimension;
	private String vector;

	public String getSrsDimension() {
		return srsDimension;
	}

	@XmlAttribute(name = "srsDimension")
	public void setSrsDimension(String srsDimension) {
		this.srsDimension = srsDimension;
	}

	public String getVector() {
		return vector;
	}

	@XmlValue
	public void setVector(String vector) {
		this.vector = vector;
	}

}
