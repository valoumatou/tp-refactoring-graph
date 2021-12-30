package org.acme.graph.errors;

import org.springframework.http.HttpStatus;

/**
 * [spring] Modèle pour le renvoi des erreurs via l'API
 */
public class JsonError {
	/**
	 * Code HTTP
	 */
	private HttpStatus status;
	/**
	 * Message d'erreur
	 */
	private String message;

	public JsonError(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getCode() {
		return status;
	}

	public void setCode(HttpStatus code) {
		this.status = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
