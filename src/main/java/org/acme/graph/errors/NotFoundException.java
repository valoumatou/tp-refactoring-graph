package org.acme.graph.errors;

/**
 * Exception lancée en cas d'échec dans une recherche (ex : sommet par identifiant)
 *
 * @author mborne
 */
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = -5822621858093017924L;

	public NotFoundException(String message) {
		super(message);
	}

}
