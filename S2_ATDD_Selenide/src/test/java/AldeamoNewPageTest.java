package test.java;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.junit.ScreenShooter;

public class AldeamoNewPageTest {
	@Rule
	public ScreenShooter photographer = ScreenShooter.failedTests().succeededTests();
	
	@Test
	public void testIsContactVisible() {
		open("http://www.aldeamo.com/");
		$("#cssmenu").find(By.partialLinkText("Contáctenos")).shouldBe(visible);
	}
	
	@Test
	public void testSearchForSMSi() {
		open("http://www.aldeamo.com/");
		$("#cajaBuscador").setValue("smsi").pressEnter();
		$$(".article-list ol li").shouldHaveSize(10);
		/*
		 $$(".article-list ol li").shouldHave(
		 
				texts(
						"Case Studies 11/12/2014 Más información", 
						"Interactive Menus 19/02/2015 Más información", 
						"Intelligent SMS 19/02/2015 Más información"));
		*/
	}

	@Ignore("Página fallando")
	@Test
	public void testChatWithJuanJuzga() {		
		open("http://www.aldeamo.com/es/ayuda");
		$("#mostrar").click();
		$(By.name("name")).setValue("Nelson García");
		$(By.id("id")).setValue("nelson.garcia@aldeamo.com");
		$(By.name("message")).setValue("Prueba automatizada de interfaz de usuario.");
		$("#content").shouldHave(text("Gracias por ponerse en contacto con nosotros. El operador estara con usted en breve..."));
	}
	
	@Ignore("Sin finalizar")
	@Test
	public void testJuanJuzgaIsSleeping() {
		open("http://www.aldeamo.com/es/ayuda");
		$("#mostrar").click();
		$("body").findElement(By.className("mmimg"));
		//..shouldHave(text("Lo sentimos, en este momento no hay operador disponible."));
	}
}
