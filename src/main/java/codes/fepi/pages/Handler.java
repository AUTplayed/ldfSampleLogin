package codes.fepi.pages;

import codes.fepi.pages.models.UsernameHolder;
import spark.Request;
import spark.Response;

@codes.fepi.ldfspark.PageHandler
public class Handler {
	public static Object index() {
		return null;
	}

	public static Object header(Request req) {
		String username = req.session().attribute("username");
		if (username != null) {
			return new UsernameHolder(username);
		}
		return new UsernameHolder();
	}

	public static Object login() {
		return null;
	}

	public static Object profile(Request req, Response res) throws IllegalAccessException {
		String username = req.queryParams("username");
		Object loginUsername = req.session().attribute("username");
		if(username.equals(loginUsername)) {
			return new UsernameHolder(username);
		}
		res.status(403);
		throw new IllegalAccessException("No permissions to view this profile, please log in as the requested user");
	}
}
