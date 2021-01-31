package org.acme.graph.io;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Vertex;
import org.junit.Test;

public class XmlGraphReaderTest {

	@Test
	public void test01() throws Exception {
		File file = new File(getClass().getResource("/graph/01.xml").getPath());
		Graph graph = XmlGraphReader.read(file);

		// vertices
		{
			List<Vertex> vertices = graph.getVertices();
			assertEquals(4, vertices.size());

			int index = 0;
			{
				Vertex vertex = vertices.get(index++);
				assertEquals("a", vertex.getId());
			}
			{
				Vertex vertex = vertices.get(index++);
				assertEquals("b", vertex.getId());
			}
		}

		// edges
		{
			List<Edge> edges = graph.getEdges();
			assertEquals(3, edges.size());

			int index = 0;
			{
				Edge edge = edges.get(index++);
				assertEquals("ab", edge.getId());
				assertEquals("a", edge.getSource().getId());
				assertEquals("b", edge.getTarget().getId());
			}
			{
				Edge edge = edges.get(index++);
				assertEquals("bc", edge.getId());
			}
			{
				Edge edge = edges.get(index++);
				assertEquals("ad", edge.getId());
			}
		}
	}

}
