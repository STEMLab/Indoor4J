package edu.stem.indoor4j.extension;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import edu.stem.graph.InterLayerConnectionMember;
import edu.stem.graph.SpaceLayer;
import edu.stem.graph.SpaceLayerMember;
import edu.stem.graph.StateMember;
import edu.stem.graph.Transition;
import edu.stem.graph.TransitionMember;
import edu.stem.indoor4j.IndoorFeatures;
import edu.stem.indoor4j.Point;
import edu.stem.space.CellSpace;
import edu.stem.space.CellSpaceGeometry;
import edu.stem.space.CellSpaceMember;
import edu.stem.space.Pos;
import edu.stem.space.SurfaceMember;
import edu.stem.space.XmlLink;

@SuppressWarnings("serial")
public class IndoorFeaturesExtension {
	private IndoorFeatures indoorFeatures;
	private Graph graph;
	
	public IndoorFeaturesExtension(IndoorFeatures indoorFeatures) {
		super();
		this.indoorFeatures = indoorFeatures;
		this.graph = null;
	}
	
	public IndoorFeaturesExtension(String filePath) {
		super();
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(IndoorFeatures.class);
			this.indoorFeatures = (IndoorFeatures) context.createUnmarshaller().unmarshal(new FileReader(filePath));
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.graph = null;
	}
	
	public IndoorFeaturesExtension(FileReader file) {
		super();
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(IndoorFeatures.class);
			this.indoorFeatures = (IndoorFeatures) context.createUnmarshaller().unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void setIndoorFeatures(IndoorFeatures indoorFeatures) {
		this.indoorFeatures = indoorFeatures;
	}
	
	public void initGraph(String layerId) {
		SpaceLayer spaceLayer  = getSpaceLayer(layerId);
		
		List<StateMember> stateMembers = spaceLayer.getNodes().getStateMember();
		List<TransitionMember> transitionMembers = spaceLayer.getEdges().getTransitionMember();
		

		HashMap<String, Point> state = new HashMap<String, Point>();
		HashMap<String, List<Vertex>> vertices = new HashMap<String, List<Vertex>>();
		
		for (StateMember stateMember : stateMembers) {
			List<Pos> pos = stateMember.getState().getGeometry().getPoint().getPos();			
			state.put(stateMember.getState().getId(), pos.get(0).getPoint());
		}
		
		for (TransitionMember transitionMember : transitionMembers) {
			Transition transition = transitionMember.getTransition();
			if (!transition.getId().contains("REVERSE")) {
				List<XmlLink> connects =  transition.getConnects();
				if (connects.size() != 2) continue;
				
				List<String> stateIds = new ArrayList<String>();
				
				for (XmlLink connect : connects) {
					String stateId = connect.getHref().replaceAll("#", "");
					if (state.containsKey(stateId)) {
						stateIds.add(stateId);
					}
				}
				
				if(stateIds.size() != 2) continue;
				
				String firstStateId = stateIds.get(0);
				String secondStateId = stateIds.get(1);
								
				double distance = state.get(firstStateId).getZ() == state.get(secondStateId).getZ() ? state.get(firstStateId).getDistance(state.get(secondStateId)) : Double.MIN_VALUE; 
				
				Vertex newVertex = new Vertex(secondStateId, distance);
				
				if (vertices.putIfAbsent(firstStateId, new ArrayList<Vertex>() {{add(newVertex);}}) != null) {
					List<Vertex> newVertices = vertices.get(firstStateId);
					newVertices.add(newVertex);
					vertices.replace(firstStateId, newVertices);
				}
				
				if (vertices.putIfAbsent(secondStateId, new ArrayList<Vertex>() {{add(new Vertex(firstStateId, distance));}}) != null) {
					List<Vertex> newVertices = vertices.get(secondStateId);
					newVertices.add(new Vertex(firstStateId, distance));
					vertices.replace(secondStateId, newVertices);
				}
				
			}
		}
		this.graph = new Graph();
		
		for (String stateId : vertices.keySet()) {
			graph.addVertex(stateId, vertices.get(stateId));
		}
	}
	
	public HashMap<String, Double> getMeterRadiusOfPoint(String layerId, Point point, double minDetectDistance) {
		SpaceLayer spaceLayer = getSpaceLayer(layerId);
		if (spaceLayer == null) return null;
		
		List<StateMember> stateMembers = spaceLayer.getNodes().getStateMember();
		
		HashMap<String, Double> state = new HashMap<String, Double>();
		
		for (StateMember stateMember : stateMembers) {
			List<Pos> pos = stateMember.getState().getGeometry().getPoint().getPos();
			
			if(pos.get(0).getPoint().getZ() == point.getZ()) {
				double distanceFromPoint = point.getDistance(pos.get(0).getPoint());
				if (distanceFromPoint <= minDetectDistance) {
					state.put(stateMember.getState().getId(), distanceFromPoint);
				}
			}
		}
		
		return state.size() > 0 ? state : null;
	}
	
	public String getCellSpaceNameWhereExistPoint(String layerId, Point point) {
		if(indoorFeatures == null) return null;
		String currentLocationStateId = getCurrentLocation(layerId, point);
		CellSpace containedCellSpace = getContainedCellSpace(currentLocationStateId);
		
		return isInside(containedCellSpace.getId(), point) == true ? containedCellSpace.getName() : null;
	}

	private boolean isInside(String cellSpaceId, Point point) {
		List<CellSpaceMember> cellSpaceMembers = indoorFeatures.getPrimalSpaceFeatures().getPrimalSpaceFeatures().getCellSpaceMember();
		List<SurfaceMember> surfaceMembers = null;
		
		for (CellSpaceMember cellSpaceMember : cellSpaceMembers) {
			if (cellSpaceMember.getCellSpace().getId().equals(cellSpaceId)) {
				CellSpaceGeometry cellSpaceGeometry = cellSpaceMember.getCellSpace().getCellSpaceGeometry();
				
				if (cellSpaceGeometry.getGeometry2d() != null) {
					surfaceMembers = cellSpaceGeometry.getGeometry2d().getPolygon().getExterior().getShell().getSurfaceMembers();
				} else if (cellSpaceGeometry.getGeometry3d() != null) {
					surfaceMembers = cellSpaceGeometry.getGeometry3d().getSolid().getExterior().getShell().getSurfaceMembers();
				}
				
				break;
			}
		}
		
		if (surfaceMembers != null) {
			SurfaceMember bottomOfSurfaceMember = surfaceMembers.get(0);
			List<Pos> bottomOfPolygonOfPosList = bottomOfSurfaceMember.getPolygon().getExterior().getPos();
			
			List<Point> points = new ArrayList<Point>();
			for (Pos pos : bottomOfPolygonOfPosList) {
				points.add(pos.getPoint());
			}
			
			Point[] bottomOfPolygon = points.stream().toArray(Point[]::new);
			return GFG.isInside(bottomOfPolygon, bottomOfPolygon.length, point);
		}
		
		return false;
	}
	
	public Point getStatePoint(String stateId) {
		if(indoorFeatures == null) return null;
		Point statePoint = null;
		List<SpaceLayerMember> spaceLayerMembers = indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember();
		for (SpaceLayerMember spaceLayerMember : spaceLayerMembers) {
			List<StateMember> stateMembers = spaceLayerMember.getSpaceLayer().getNodes().getStateMember();
			for (StateMember stateMember : stateMembers) {
				if (stateMember.getState().getId().equals(stateId)) {
					List<Pos> poss = stateMember.getState().getGeometry().getPoint().getPos();
					statePoint = poss.get(0).getPoint();
					break;
				}
			}
		}
		return statePoint;
	}
	
	public CellSpace getContainedCellSpace(String stateId) {
		if(indoorFeatures == null) return null;
		
		String interConnectedWithState = getInterConnectedWithState("contains",stateId);
		
		if(interConnectedWithState == null) return null;

		CellSpace cellSpace = getCellSpace(getDualityOfState(interConnectedWithState));		

		return cellSpace;
	}
	
	public String getCurrentLocation(String layerId, Point point) {
		SpaceLayer spaceLayer  = getSpaceLayer(layerId);
		
		List<StateMember> stateMembers = spaceLayer.getNodes().getStateMember();
		
		HashMap<String, Point> state = new HashMap<String, Point>();
		
		for (StateMember stateMember : stateMembers) {
			List<Pos> pos = stateMember.getState().getGeometry().getPoint().getPos();
			
			if(pos.get(0).getPoint().getZ() == point.getZ()) state.put(stateMember.getState().getId(), pos.get(0).getPoint());
		}
		
		String mostCloseStateId = null;
		Double mostCloseDistance = Double.MAX_VALUE;
		
		for (String stateId : state.keySet()) {
			double tempDistance = Math.sqrt(Math.pow(point.getX() - state.get(stateId).getX(), 2) + Math.pow(point.getY() - state.get(stateId).getY(), 2));
			if (mostCloseDistance > tempDistance) {
				mostCloseStateId = stateId;
				mostCloseDistance = tempDistance;
			}
		}
		
		return mostCloseStateId;
	}
	
	private String getDualityOfState(String stateId) {
		String dualityId = null;
		List<SpaceLayerMember> spaceLayerMembers = indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember();
		for (SpaceLayerMember spaceLayerMember : spaceLayerMembers) {
			List<StateMember> stateMembers = spaceLayerMember.getSpaceLayer().getNodes().getStateMember();
			for (StateMember stateMember : stateMembers) {
				if (stateMember.getState().getId().equals(stateId)) {
					dualityId = stateMember.getState().getDuality().getHref().replaceAll("#", "");
					break;
				}
			}
		}
		return dualityId;
	}
	
	private String getInterConnectedWithState(String typeOfTopoExpression, String stateId) {
		String interConnectedStateWithState = null;
		List<InterLayerConnectionMember> interLayerConnectionMembers = indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getInterEdges().getInterLayerConnectionMember();

		for (InterLayerConnectionMember interLayerConnectionMember : interLayerConnectionMembers) {
			if (interLayerConnectionMember.getInterLayerConnection().getTypeOfTopoExpression().toUpperCase().equals(typeOfTopoExpression.toUpperCase())) {
				List<XmlLink> interConnects =  interLayerConnectionMember.getInterLayerConnection().getInterConnects();
				if (interConnects.get(1).getHref().equals("#"+stateId)) {					
					interConnectedStateWithState = interConnects.get(0).getHref().replaceAll("#", "");
					break;
				}
			}
		}
		return interConnectedStateWithState;
	}
	
	private CellSpace getCellSpace(String cellSpaceId) {
		CellSpace cellSpace = null;
		List<CellSpaceMember> cellSpaceMembers = indoorFeatures.getPrimalSpaceFeatures().getPrimalSpaceFeatures().getCellSpaceMember();
		for (CellSpaceMember cellSpaceMember : cellSpaceMembers) {
			if (cellSpaceMember.getCellSpace().getId().equals(cellSpaceId)) {
				cellSpace = cellSpaceMember.getCellSpace();
				break;
			}
		}
		return cellSpace;
	}
	
	private SpaceLayer getSpaceLayer(String layerId) {
		SpaceLayer spaceLayer  = null;
		List<SpaceLayerMember> spaceLayerMembers = indoorFeatures.getMultiLayeredGraph().getMultiLayeredGraph().getSpaceLayers().getSpaceLayerMember();
		for (SpaceLayerMember spaceLayerMember : spaceLayerMembers) {
			if (spaceLayerMember.getSpaceLayer().getId().equals(layerId)) {
				spaceLayer = spaceLayerMember.getSpaceLayer();
			}
		}
		return spaceLayer;
	}
}
