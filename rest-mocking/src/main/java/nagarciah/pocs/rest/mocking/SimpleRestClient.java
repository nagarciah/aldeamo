package nagarciah.pocs.rest.mocking;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SimpleRestClient {

	private String baseUrl = "http://localhost:8080";
	private String methodURL = "/doSomething";
	
	public SimpleRestClient() {

	}

	public SimpleRestClient(String methodURL) {
		if (methodURL != null) {
			this.methodURL = methodURL;
		}
	}

	public String callService() throws UnirestException {
		// Simula un GET
		String response = RestAssured
				.given()
					.accept("text/xml")
					//.log().all()
				.when()
					.get(this.baseUrl + methodURL)
					.andReturn()
					.asString();
		
		// Y luego simula un POST con base en la ifrmación del GET (Flujo típico)
		RestAssured
			.given()
				.log().all()
				.accept("text/xml")
				.contentType("text/xml")
				.body("<message>1234</message>")  //Recordar que aquí mejor se debe usar un objeto
			.post(this.baseUrl + methodURL + "/a1234")
			.then()
				.log().all();
		
		return response;
	}
}
