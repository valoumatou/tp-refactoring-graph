package org.acme.graph.model;

import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;

public class EdgeTest {

    @Test
	public void defaultTestConstructor(){

        Vertex v1 = new Vertex(new Coordinate(1.0, 1.0), "1");
        Vertex v2 = new Vertex(new Coordinate(3.0, 1.0), "2");

		Edge e = new Edge(v1, v2);

		Assert.assertEquals(v1, e.getSource());
		Assert.assertEquals(v2, e.getTarget());
	}
    
}