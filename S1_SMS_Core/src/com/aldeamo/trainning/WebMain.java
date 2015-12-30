package com.aldeamo.trainning;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class WebMain {
	
	public static void main(String[] args) {
		ThymeleafTemplateEngine thymeleaf = new ThymeleafTemplateEngine();
		
		// Establece el puerto
		port(8080);
		
		// Ruta que carga una plantilla Thymeleaf
		get("/", (req, res) -> {
			return new ModelAndView(new HashMap<String, String>(), "smsi_page");
		}, thymeleaf);
		
		// Ruta para procesar el envío del formulario
		post("/", WebMain::procesarFormulario, thymeleaf);
		

		/* Código sin lambdas para compiladores < JDK8

		// Ruta que carga una plantilla Thymeleaf
		get("/", new TemplateViewRoute() {
			public ModelAndView handle(Request req, Response res) throws Exception {
				return new ModelAndView(new HashMap<String, String>(), "smsi_page");
			}
		}, thymeleaf);
		
		// Ruta para procesar el envío del formulario
		post("/", new TemplateViewRoute() {
			public ModelAndView handle(Request req, Response res) throws Exception {
				return procesarFormulario(req, res);
			}
		}, thymeleaf);
		*/
		
	}
	
	public static ModelAndView procesarFormulario(Request req, Response res){
		String destino = req.queryParams("phoneNumber");
		String contenido = req.queryParams("messageBox");
		MensajeSMS sms = new MensajeSMS("web", destino, contenido);
		
		System.out.println("Mensaje recibido: \n"+ sms.toString());
		
		MensajeSMS respuesta = new ProcesadorSMS().procesar(sms);
		
		Map<String, String> variables = new HashMap<String, String>();
		variables.put("resultado", "El estado del mensaje es: " + respuesta.getEstado());			
		return new ModelAndView(variables, "smsi_page");
	};

}
