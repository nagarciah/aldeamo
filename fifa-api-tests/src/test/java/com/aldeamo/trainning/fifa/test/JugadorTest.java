package com.aldeamo.trainning.fifa.test;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;
import com.jayway.restassured.http.ContentType;


public class JugadorTest {
	
	String url = "http://localhost:8080/jugador";

	@Test
	public void consultaJugadores() {
		given()
		.when()
			.get(url)
		.then()
			.log().all()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("nombre", hasSize(greaterThan(0)))
			.body("nombre", hasItems("Claudio Bravo", "Douglas Pereira", "Manuel Neuer"));
	}
}
