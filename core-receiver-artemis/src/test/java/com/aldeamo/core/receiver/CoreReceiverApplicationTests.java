package com.aldeamo.core.receiver;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.aldeamo.core.receiver.dto.SMSMessage;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoreReceiverApplication.class)
@WebAppConfiguration
public class CoreReceiverApplicationTests {

	@Autowired
	private WebApplicationContext context;

	@Before
	public void restAssureSetup() {
		RestAssuredMockMvc.webAppContextSetup(context);
	}

	@After
	public void restAssureReset() {
		RestAssuredMockMvc.reset();
	}

	@Test
	public void testSendSMS() {
		SMSMessage sms = new SMSMessage("3101111111", "3102222222", "Mensaje de prueba");
		
		given()
			.body(sms)
		.when()
			.post("/sms/")
		.then()
			.log().body()
			.statusCode(200)
			.body("id", not(equalTo(0)));
	}
}
