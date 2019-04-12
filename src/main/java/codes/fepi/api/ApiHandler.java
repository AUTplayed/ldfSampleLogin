package codes.fepi.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;
import spark.Spark;

import java.io.IOException;

public class ApiHandler {

	private ObjectMapper mapper;

	public ApiHandler() {
		mapper = new ObjectMapper();
	}

	public void register() {
		Spark.post("/login", this::login);
		Spark.post("/logout", this::logout);
	}

	private Object login(Request req, Response res) throws IOException {
		JsonNode reqJson = mapper.readTree(req.body());
		String username = reqJson.get("username").asText();
		req.session().attribute("username", username);
		return "ok";
	}

	private Object logout(Request req, Response res) {
		req.session().removeAttribute("username");
		return "ok";
	}

}
