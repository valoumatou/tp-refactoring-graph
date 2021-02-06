package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;

/**
 * 
 * Un graphe matérialisé par une liste de sommets et d'arcs
 * 
 * @author MBorne
 *
 */
public class Graph {
	/**
	 * Liste des sommets
	 */
	private List<Vertex> vertices = new ArrayList<Vertex>();

	/**
	 * Liste des arcs
	 */
	private List<Edge> edges = new ArrayList<Edge>();

	/**
	 * Récupération de la liste sommets
	 * 
	 * @return
	 */
	public List<Vertex> getVertices() {
		return vertices;
	}

	/**
	 * Récupération de la liste arcs
	 * 
	 * @return
	 */
	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}

	/**
	 * Recherche d'un sommet par identifiant
	 * 
	 * @param id
	 * @return
	 */
	public Vertex findVertex(String id) {
		for (Vertex vertex : vertices) {
			if (vertex.getId().equals(id)) {
				return vertex;
			}
		}
		return null;
	}

	/**
	 * Recherche d'un sommet par coordonnées
	 * 
	 * @param coordinate
	 * @return
	 */
	public Vertex findVertex(Coordinate coordinate) {
		for (Vertex vertex : vertices) {
			Coordinate candidate = vertex.getCoordinate();
			if (candidate != null && candidate.equals(coordinate)) {
				return vertex;
			}
		}
		return null;
	}

	/**
	 * Récupération de la liste des arcs
	 * 
	 * @return
	 */
	public List<Edge> getEdges() {
		return edges;
	}

	/**
	 * Recherche des arcs sortant d'un sommet
	 * 
	 * @param vertex
	 * @return
	 */
	public List<Edge> getInEdges(Vertex vertex){
		List<Edge> result = new ArrayList<>();
		for (Edge candidate : edges) {
			if (candidate.getTarget() != vertex) {
				continue;
			}
			result.add(candidate);
		}
		return result;
	}
	
	/**
	 * Recherche des arcs sortant d'un sommet
	 * 
	 * @param vertex
	 * @return
	 */
	public List<Edge> getOutEdges(Vertex vertex) {
		List<Edge> result = new ArrayList<>();
		for (Edge candidate : edges) {
			if (candidate.getSource() != vertex) {
				continue;
			}
			result.add(candidate);
		}
		return result;
	}

	/**
	 * Définition de la liste des arcs
	 * 
	 * @param edges
	 */
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

}
