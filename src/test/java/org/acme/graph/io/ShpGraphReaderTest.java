package org.acme.graph.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.URL;

import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Vertex;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Test de la lecture d'un graphe au format SHP
 * 
 * @author MBorne
 *
 */
public class ShpGraphReaderTest {

	private File getResourceFile(String name) {
		URL url = getClass().getResource(name);
		Assert.assertNotNull("resource not found : " + name, url);
		File file = new File(url.getPath());
		return file;
	}

	@Test
	public void testRoute500() throws Exception {
		File file = getResourceFile("/route500/idf/troncon_route.shp");
		Assert.assertTrue(file.exists());

		Graph graph = ShpGraphReader.read(file);
		for (Vertex vertex : graph.getVertices()) {
			assertNotNull(vertex.getId());
			assertNotNull(vertex.getCoordinate());
		}

		for (Edge edge : graph.getEdges()) {
			assertNotNull(edge.getId());
			assertNotNull(edge.getSource());
			assertNotNull(edge.getTarget());
		}

		assertEquals(19207, graph.getVertices().size());
		assertEquals(49536, graph.getEdges().size());

		Vertex vertex1 = graph.findVertex("1");
		assertNotNull(vertex1);
	}

}
