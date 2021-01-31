package org.acme.graph;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.github.ulisesbocchio.jar.resources.JarResourceLoader;

/**
 * Application spring permettant de démarrer l'API
 * 
 * http://localhost:8080/find-path?origin=a&destination=b
 * 
 * @author MBorne
 */
@SpringBootApplication
public class Application {

	/**
	 * ${project_loc}/src/test/resources/graph/route500/idf/troncon_route.shp
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Permet d'accéder facilement aux resources en mode jar.
		 * 
		 * @see https://stackoverflow.com/a/37202883
		 */
		new SpringApplicationBuilder()
			.sources(Application.class)
			.resourceLoader(new JarResourceLoader())
			.run(args)
		;
	}

}