package com.aldeamo.trainning;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class SparkDemo {
	public static void main(String[] args) {
		port(8080);

		// Ruta basica
		get("/hello", (req, res) -> "Hello World");

		// Ruta de servicio web Json (con transformer)
		get("/hello_rest", "application/json", (request, response) -> {
			return new Person("Jaime", 45, true);
		} , new JsonTransformer());

		// Ruta que carga una plantilla Thymeleaf
		Map map = new HashMap();
		map.put("name", "Sam");

		// hello.html file is in resources/templates directory
		get("/hello2", (rq, rs) -> new ModelAndView(map, "hello_template"), new ThymeleafTemplateEngine());
		
		
		// Angular
		get("/bets", 
				(rq, rs) -> new ModelAndView(map, "betsPage"), 
				new ThymeleafTemplateEngine());
		
		post("/bets", 
				(rq, rs) -> {
					System.out.println("Post del formulario");
					new Gson().fromJson(rq.body(), Person.class);
					map.put("message", "ok");
					return new ModelAndView(map, "betsPage");
				}, 
				new ThymeleafTemplateEngine());

	}
}
