package io.github.lpedrosa;

import static spark.Spark.*;

public class Application {

	public static void main(String[] args) {
		get("hello/world/:name", (req, res) -> {
			return "Hello World, " + req.params(":name") + "!";
		});
	}
}
