package nagarciah.pocs.rest.mocking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Imports para WireMock 
 */
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RestMokingTest {

	/**
	 * WireMock ships with some JUnit rules to manage the server’s lifecycle and
	 * setup/tear-down tasks. To start and stop WireMock per-test case, add the
	 * following to your test class (or a superclass of it):
	 * (No-args constructor defaults to port 8080)
	 */
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8080);
	
	
	/**
	 * Establece todos los stubs de los endpoints a probar. Antes de cada test, se borra 
	 * la memoria de requests/responses del servidor de WireMock
	 */
	@Before
	public void resetStubs(){
		reset();
		
	    // Tambien se puede usar "givenThat" en lugar de "stubFor", que es menos BDD 
		stubFor(get(urlPathEqualTo( "/doSomething" ))
	            .withHeader("Accept", equalTo("text/xml"))	// Sólo acepta peticiones que tengan headers identicos
	            .willReturn(aResponse()
	                .withStatus(200)
	                .withHeader("Content-Type", "text/xml")
	                .withBody("<response>Some content on the fly</response>")
	                )
	            );
		stubFor(post(urlPathMatching( "/doSomething/[a-z0-9]+" ))
	            .withHeader("Accept", equalTo("text/xml"))
	            .willReturn(aResponse()
	                .withStatus(200)
	                .withHeader("Content-Type", "text/xml")
	                .withBody("<response>Some content on the fly</response>")
	                )
	            );

	    // Tambien se puede usar "givenThat" en lugar de "stubFor", que es menos BDD 
		stubFor(get(urlPathEqualTo( "/doSomethingFromFile" ))
	            .withHeader("Accept", equalTo("text/xml"))	// Sólo acepta peticiones que tengan headers identicos
	            .willReturn(aResponse()
	                .withStatus(200)
	                .withHeader("Content-Type", "text/xml")
	                .withBodyFile("doSomething.xml")
	                )
	            );
		stubFor(post(urlPathMatching( "/doSomethingFromFile/[a-z0-9]+" ))
	            .withHeader("Accept", equalTo("text/xml"))
	            .willReturn(aResponse()
	                .withStatus(200)
	                .withHeader("Content-Type", "text/xml")
	                .withBodyFile("doSomething.xml")
	                )
	            );
	}
	

	@Test
	public void testResponseOnTheFly() throws Exception {
		// Ejecuta una peticion al servicio ...
	    SimpleRestClient restClient = new SimpleRestClient();
	    String result = restClient.callService();

	    // y verifica el resultado del procesamiento
	    assertNotNull(result);
	    assertTrue(result.contains("on the fly"));

	    // También verifica que en el procesamiento intermedio, se haya hehco por lo menos un POST específico
	    verify(postRequestedFor(urlMatching("/doSomething/[a-z0-9]+"))
	            .withRequestBody(matching(".*<message>1234</message>.*"))
	            .withHeader("Content-Type", notMatching("application/json"))
	            );
	}

	
	@Test
	public void testResponseFromFile() throws Exception {
	    SimpleRestClient restClient = new SimpleRestClient("/doSomethingFromFile");
	    String result = restClient.callService();

	    assertNotNull(result);
	    assertTrue(result.contains("from file"));

	    verify(postRequestedFor(urlPathMatching("/doSomethingFromFile/[a-z0-9]+"))
	            .withRequestBody(matching(".*<message>1234</message>.*"))
	            .withHeader("Content-Type", notMatching("application/json"))
            );
	}
	
}
