package org.acme.graph.model;

import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;

public class VertexTest {

    @Test
	public void defaultTestConstructor(){

        Vertex v = new Vertex(new Coordinate(1.0, 1.0), "1");
        
		Assert.assertEquals("1", v.getId());
	} 
    
}