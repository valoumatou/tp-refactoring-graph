package org.acme.graph.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.acme.graph.errors.NotFoundException;
import org.locationtech.jts.geom.Coordinate;
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
	private List<Vertex> vertices = new ArrayList<>();

	/**
	 * Liste des arcs
	 */
	private List<Edge> edges = new ArrayList<>();

	/**
	 * Récupération de la liste sommets
	 * 
	 * @return
	 */
	public Collection<Vertex> getVertices() {
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
		throw new NotFoundException(String.format("Vertex '%s' not found", id));
	}

	/**
	 * Recherche d'un sommet par égalité stricte de coordonnées
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
		throw new NotFoundException(String.format("Vertex not found at [%s,%s]", coordinate.x, coordinate.y));
	}

	/**
	 * Récupération ou création d'un sommet en assurant l'unicité
	 * 
	 * @param graph
	 * @param coordinate
	 * @return
	 */
	public Vertex getOrCreateVertex(Coordinate coordinate) {
		Vertex vertex;
		try {
			vertex = findVertex(coordinate);
		} catch (NotFoundException e) {
			String id = Integer.toString(getVertices().size());
			vertex = new Vertex(coordinate, id);
			vertices.add(vertex);
		}
		return vertex;
	}

	/**
	 * Récupération de la liste des arcs
	 * 
	 * @return
	 */
	public Collection<Edge> getEdges() {
		return edges;
	}

	/**
	 * Recherche des arcs sortant d'un sommet
	 * 
	 * @param vertex
	 * @return
	 */
	public List<Edge> getInEdges(Vertex vertex) {
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

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public Vertex createVertex(Coordinate coordinate, String id) {

		Vertex vertex = new Vertex(coordinate, id);
		this.vertices.add(vertex);

		return vertex;
	}


	public Edge createEdge(Vertex source, Vertex target, String id) {

		Edge edge = new Edge(source, target);
		edge.setId(id);
		this.edges.add(edge);

		return edge;
	}

}
