package uk.gov.verify;

import spark.Spark;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.lang.System.getenv;
import static spark.Spark.post;

public class LocalMatchingService {

    public static final int DEFAULT_PORT = 50130;

    public static void main(String[] args) {
        String port = getenv().getOrDefault("LMS_PORT", valueOf(DEFAULT_PORT));
        System.out.println("Listening on port: " + port);
        Spark.port(parseInt(port));
        addRoutes();
    }

    private static void addRoutes() {
        post("/local-matching/match", (req, res) -> {
            System.out.println(req.body());
            res.type("application/json");
            return "{\"result\":\"match\"}";
        });
        post("/local-matching/create-user", (req, res) -> {
            System.out.println(req.body());
            res.type("application/json");
            return "{\"result\":\"success\"}";
        });
    }

    public static void shutdown() {
        Spark.stop();
    }
}
