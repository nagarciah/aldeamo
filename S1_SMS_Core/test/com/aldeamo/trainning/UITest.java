package com.aldeamo.trainning;

import static org.junit.Assert.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class UITest {

	@Test
	public void testEnvioOK() {
		open("http://localhost:8080/");
		$(By.id("messageBox")).setValue("Mensaje de prueba");
		$(By.id("phoneNumber")).setValue("310258369");
		$(By.id("submitButton")).click(); // Este id no existía
		
		$(By.id("resultado")).shouldHave(text("recibido"));
	}
	
	@Test
	public void testEnvioNumeroInvalido() {
		open("http://localhost:8080/");
		$(By.id("messageBox")).setValue("Mensaje de prueba");
		$(By.id("phoneNumber")).setValue("abcdef");
		$(By.id("submitButton")).click(); // Este id no existía
		
		$(By.id("resultado")).shouldHave(text("no es un número válido"));
	}

}
