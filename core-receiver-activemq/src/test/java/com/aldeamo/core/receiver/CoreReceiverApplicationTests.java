package com.aldeamo.core.receiver;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.aldeamo.core.receiver.entity.SMSMessage;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;


public class CoreReceiverApplicationTests {

	@Test
	public void testSendSMS() {
		// Arrange
		SMSMessage sms = new SMSMessage(0L, "3101111111", "3102222222", "Mensaje de prueba");
		
		given()
			.body(sms)
			.contentType("application/json")
		.when()
			.post("http://localhost:8888/sms/")
		.then()
			.log().body()
			.statusCode(200)
			.body("id", not(equalTo(0)));
	}
}
