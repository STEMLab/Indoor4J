@XmlSchema(namespace = "http://www.opengis.net/indoorgml/1.0/core",elementFormDefault = XmlNsForm.QUALIFIED, xmlns = {
		@XmlNs(namespaceURI = "http://www.opengis.net/gml/3.2", prefix = "gml"),
		@XmlNs(namespaceURI = "http://www.w3.org/1999/xlink", prefix = "xlink"),
		@XmlNs(namespaceURI = "http://www.opengis.net/indoorgml/1.0/core", prefix = "core"),
		@XmlNs(namespaceURI = "http://www.opengis.net/indoorgml/1.0/navigation", prefix = "navi"),
		@XmlNs(namespaceURI = "http://indoorgml.net/repository/NonNaviSpace", prefix = "nonnavi"),
		@XmlNs(namespaceURI = "http://indoorgml.net/extensions/textureext", prefix = "ns6"),
		@XmlNs(namespaceURI = "http://indoorgml.net/extensions/PSExt", prefix = "ns7"),
		@XmlNs(namespaceURI = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi") })

package edu.stem.space;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;