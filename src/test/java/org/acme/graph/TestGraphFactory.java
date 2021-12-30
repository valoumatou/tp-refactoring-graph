package org.acme.graph;

import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Vertex;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

public class TestGraphFactory {

	/**
	 * d / / a--b--c
	 * 
	 * @return
	 */
	public static Graph createGraph01() {
		Graph graph = new Graph();

		Vertex a = new Vertex();
		a.setId("a");
		a.setCoordinate(new Coordinate(0.0, 0.0));
		graph.getVertices().add(a);

		Vertex b = new Vertex();
		b.setId("b");
		b.setCoordinate(new Coordinate(1.0, 0.0));
		graph.getVertices().add(b);

		Vertex c = new Vertex();
		c.setId("c");
		c.setCoordinate(new Coordinate(2.0, 0.0));
		graph.getVertices().add(c);

		Vertex d = new Vertex();
		d.setId("d");
		d.setCoordinate(new Coordinate(1.0, 1.0));
		graph.getVertices().add(d);

		Edge ab = new Edge();
		ab.setId("ab");
		ab.setSource(a);
		ab.setTarget(b);
		ab.setGeometry(createLineString(a.getCoordinate(), b.getCoordinate()));
		graph.getEdges().add(ab);

		Edge bc = new Edge();
		bc.setId("bc");
		bc.setSource(b);
		bc.setTarget(c);
		bc.setGeometry(createLineString(b.getCoordinate(), c.getCoordinate()));
		graph.getEdges().add(bc);

		Edge ad = new Edge();
		ad.setId("ad");
		ad.setSource(a);
		ad.setTarget(d);
		ad.setGeometry(createLineString(a.getCoordinate(), d.getCoordinate()));
		graph.getEdges().add(ad);

		return graph;
	}

	/**
	 * Création d'une polyligne à deux points.
	 * 
	 * @param startPoint
	 * @param endPoint
	 * @return
	 */
	private static LineString createLineString(Coordinate startPoint, Coordinate endPoint) {
		GeometryFactory gf = new GeometryFactory();
		return gf.createLineString(new Coordinate[] { startPoint, endPoint });
	}

}
