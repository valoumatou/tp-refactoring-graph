package org.acme.graph.cli;

import java.io.File;
import java.util.List;

import org.acme.graph.io.GraphReader;
import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Vertex;
import org.acme.graph.routing.DijkstraPathFinder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Application en ligne de commande pour le calcul d'un plus chemin entre deux
 * points.
 * 
 * @author MBorne
 *
 */
public class FindPath {

	private static final Logger log = LogManager.getLogger(FindPath.class);

	public static void main(String[] args) throws Exception {
		if (args.length != 3) {
			System.err.println("Usage : <graph.path> <source> <target>");
			System.err.println("Vous pouvez configurer eclipse avec l'option suivante dans 'Program arguments' :");
			System.err.println("${project_loc}/src/main/resources/route500/idf/troncon_route.shp 1 9557");
			System.exit(1);
		}
		/* Récupération des paramètres */
		File graphFile = new File(args[0]);
		if (!graphFile.exists()) {
			log.fatal("graph file not found : {}", graphFile.getAbsolutePath());
			System.exit(1);
		}
		String originId = args[1];
		String destinationId = args[2];

		/* Chargement du graphe */
		GraphReader reader = new GraphReader();
		log.info("Loading graph from {}...", graphFile.getAbsolutePath());
		Graph graph = reader.read(graphFile);
		log.info("Graph loaded (num_vertices={}, num_edges={})", graph.getVertices().size(), graph.getEdges().size());

		Vertex source = graph.findVertex(originId);
		if (source == null) {
			log.error("origin vertex '{}' not found!", originId);
			System.exit(1);
		}
		Vertex target = graph.findVertex(destinationId);
		if (target == null) {
			log.error("destination vertex '{}' not found!", destinationId);
			System.exit(1);
		}

		DijkstraPathFinder pathFinder = new DijkstraPathFinder(graph);
		List<Edge> pathEdges = pathFinder.findPath(source, target);
		if (pathEdges == null) {
			log.info("Path not not found from {} to {}", originId, destinationId);
			return;
		}

		log.info("Path not found from {} to {} with {} edge(s)", originId, destinationId, pathEdges.size());
		for (Edge pathEdge : pathEdges) {
			log.debug("{} -> {}", pathEdge.getSource().getId(), pathEdge.getTarget().getId());
		}
	}
}
