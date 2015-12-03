package aldeamo.trainning.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitSamplesTest {
	
	@Before
	public void prepareTest(){
		System.out.println("Ejecutando método @Before");
	}

	@After
	public void endSample(){
		System.out.println("Ejecutando método @After");
	}

	@BeforeClass
	public static void prepareClass(){
		System.out.println("Ejecutando método @BeforeClass");
	}

	@AfterClass
	public static void endClass(){
		System.out.println("Ejecutando método @AfterClass");
	}

	/**
	 * Verifica que un método retorne lo esperado
	 */
	@Test
	public void testSayHello() {
		// Arrange (preparar)
		JUnitSamples samples = new JUnitSamples();
		String result;
		
		// Act (ejecutar)
		result = samples.sayHello("Emiliano");
		
		// Assert (verificar)
		assertEquals("Saludo a Emiliano", "Hola Emiliano", result);
	}
	
	/**
	 * Verifica que un método lanze la excepción esperada
	 */
	@Test(expected=ArithmeticException.class)
	public void testExceptionDividingByZero(){
		JUnitSamples samples = new JUnitSamples();
		
		samples.divide(5, 0);
	}
}
