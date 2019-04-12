package codes.fepi;

import codes.fepi.api.ApiHandler;
import codes.fepi.ldfspark.LdfSpark;
import spark.Spark;

public class Main {
	public static void main(String[] args) {
		Spark.port(8080);
		LdfSpark.start();
		ApiHandler api = new ApiHandler();
		Spark.path("/api", api::register);
		Spark.exception(Exception.class, (exception, request, response) -> {
			response.body(exception.getCause().getMessage());
		});
	}
}
