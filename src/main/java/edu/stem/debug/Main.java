package edu.stem.debug;

import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import edu.stem.indoor.IndoorFeatures;

public class Main {

	public static void main(String[] args) throws JAXBException, IOException {
		// TODO Auto-generated method stub
		String sourceGML = "../../../sample-3D.gml";

		IndoorFeatures indoorFeatures = unmarshall(sourceGML);
		
//		System.out.println(indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember());
		System.out.println(indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getId());
	}
	
	public static IndoorFeatures unmarshall(String filePath) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(IndoorFeatures.class);
		return (IndoorFeatures) context.createUnmarshaller().unmarshal(new FileReader(filePath));
	}
}
