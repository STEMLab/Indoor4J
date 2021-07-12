package edu.stem.debug;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import edu.stem.graph.Nodes;
import edu.stem.graph.StateMember;
import edu.stem.graph.TransitionMember;
import edu.stem.indoor.IndoorFeatures;
import edu.stem.space.CellSpace;
import edu.stem.space.CellSpaceMember;
import edu.stem.space.Pos;
import edu.stem.space.PrimalSpaceFeatures;
import edu.stem.space.SurfaceMember;

public class Main {

	public static void main(String[] args) throws JAXBException, IOException {
		// TODO Auto-generated method stub
		String sourceGML = "../../../sample-3D.gml";

		IndoorFeatures indoorFeatures = unmarshall(sourceGML);
		
		// Demonstraion of readling "sample-3d.gml"
		// Before run this sample code, check sample data with text viewer.

		PrintAllOfCellSpaces3D(indoorFeatures);
		//PrintAllOfCellSpaces2D(indoorFeatures);

		PrintAllOfLandmarks(indoorFeatures);
		PrintAllOfSafety(indoorFeatures);
		PrintAllOfNetworks(indoorFeatures);
	}
	
	// (3D) A cellspace consists of polygons.
		private static void PrintAllOfCellSpaces3D(IndoorFeatures indoorFeatures) {
			PrimalSpaceFeatures primalFeatures = indoorFeatures.getPrimalSpaceFeatures().getPrimalSpaceFeatures();
			System.out.println(primalFeatures.getId());

			List<CellSpaceMember> cellSpaceMembers = primalFeatures.getCellSpaceMember();
			for (CellSpaceMember cellSpaceMember : cellSpaceMembers) {
				CellSpace cellSpace = cellSpaceMember.getCellSpace();
				String cellSpaceID = cellSpace.getId();
				String cellSpaceDescription = cellSpace.getDescription();
				String cellSpaceName = cellSpace.getName();
				
				System.out.println(String.format("ID)%s Name)%s Description)%s", cellSpaceID, cellSpaceName, cellSpaceDescription));
				List<SurfaceMember> cellSpaceSurfaceMembers = cellSpace.getCellSpaceGeometry().getGeometry3d().getSolid().getExterior().getShell().getSurfaceMembers();
				for (SurfaceMember cellSpaceSurfaceMember : cellSpaceSurfaceMembers) {
					List<Pos> cellSpacePos3DList = cellSpaceSurfaceMember.getPolygon().getExterior().getPos();
					System.out.println(String.format("\tPolygon ID: %s", cellSpaceSurfaceMember.getPolygon().getId()));
					for (Pos cellSpacePos2D : cellSpacePos3DList) {
						System.out.println("\t\t" + cellSpacePos2D.getVector());
					}					
				}
			}
		}

		// (2D) A cellspace has a polygon.
		// 2D geometry structure is different from 3D data type.
		private static void PrintAllOfCellSpaces2D(IndoorFeatures indoorFeatures) {
			PrimalSpaceFeatures primalFeatures = indoorFeatures.getPrimalSpaceFeatures().getPrimalSpaceFeatures();
			System.out.println(primalFeatures.getId());

			List<CellSpaceMember> cellSpaceMembers = primalFeatures.getCellSpaceMember();
			for (CellSpaceMember cellSpaceMember : cellSpaceMembers) {
				CellSpace cellSpace = cellSpaceMember.getCellSpace();
				String cellSpaceID = cellSpace.getId();
				String cellSpaceDescription = cellSpace.getDescription();
				String cellSpaceName = cellSpace.getName();
				
				System.out.println(String.format("ID)%s Name)%s Description)%s", cellSpaceID, cellSpaceName, cellSpaceDescription));
				List<Pos> cellSpacePos2DList = cellSpace.getCellSpaceGeometry().getGeometry2d().getPolygon().getExterior().getPos();
				for (Pos cellSpacePos2D : cellSpacePos2DList) {
					System.out.println("\t" + cellSpacePos2D.getVector());
				}
			}
		}

		// Landmark layer of 'sample-3d.gml' has points(states) only.
		private static void PrintAllOfLandmarks(IndoorFeatures indoorFeatures) {
			System.out.println(indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember().get(2).getSpaceLayer().getId());
			Nodes nodes = indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember().get(2).getSpaceLayer().getNodes();
			List<StateMember> landmarkPOIs = nodes.getStateMember();
			for (StateMember stateMember : landmarkPOIs) {
				String poiID = stateMember.getState().getId();
				String poiName = stateMember.getState().getName().getContent();
				String poiDesc = stateMember.getState().getDescription();
				
				String poiLocation = stateMember.getState().getGeometry().getPoint().getPos().get(0).getVector();
				
				System.out.println(String.format("1)%s : 2)%s : 3)%s : 4)%s", poiID, poiName, poiDesc, poiLocation));
			}
		}
		
		// Safety layer of 'sample-3d.gml' has points(states) only.
		private static void PrintAllOfSafety(IndoorFeatures indoorFeatures) {
			System.out.println(indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember().get(3).getSpaceLayer().getId());
			Nodes nodes = indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember().get(3).getSpaceLayer().getNodes();
			List<StateMember> landmarkPOIs = nodes.getStateMember();
			for (StateMember stateMember : landmarkPOIs) {
				String poiID = stateMember.getState().getId();
				String poiName = stateMember.getState().getName().getContent();
				String poiDesc = stateMember.getState().getDescription();
				
				String poiLocation = stateMember.getState().getGeometry().getPoint().getPos().get(0).getVector();
				
				System.out.println(String.format("1)%s : 2)%s : 3)%s : 4)%s", poiID, poiName, poiDesc, poiLocation));
			}
		}

		// Network layer of 'sample-3d.gml' has points(states) as well as lines(transitions).
		private static void PrintAllOfNetworks(IndoorFeatures indoorFeatures) {
			System.out.println(indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember().get(1).getSpaceLayer().getId());
			
			// 1. Print All Of "states"
			Nodes nodes = indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember().get(1).getSpaceLayer().getNodes();
			List<StateMember> networkPOIs = nodes.getStateMember();
			for (StateMember stateMember : networkPOIs) {
				String poiID = stateMember.getState().getId();
				String poiName = stateMember.getState().getName().getContent();
				String poiDesc = stateMember.getState().getDescription();
				
				String poiLocation = stateMember.getState().getGeometry().getPoint().getPos().get(0).getVector();
				
				System.out.println(String.format("1)%s : 2)%s : 3)%s : 4)%s", poiID, poiName, poiDesc, poiLocation));
			}

			// 2. Print All "transitions" with related "pos"
			List<TransitionMember> edges = indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember().get(1).getSpaceLayer().getEdges().getTransitionMember();
			for (TransitionMember edge : edges) {
				String transitionID = edge.getTransition().getId();
				String transitionName = edge.getTransition().getName().getContent();

				System.out.println(String.format("ID)%s Name)%s ", transitionID, transitionName));
				
				List<Pos> networkEdgePosList = edge.getTransition().getGeometry().getLineString().getPos();

				for (Pos  networkEdgePos : networkEdgePosList) {
					System.out.println("\t" + networkEdgePos.getVector());
				}
			}
		}
	
	public static IndoorFeatures unmarshall(String filePath) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(IndoorFeatures.class);
		return (IndoorFeatures) context.createUnmarshaller().unmarshal(new FileReader(filePath));
	}
}
