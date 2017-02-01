package uk.gov.ida;

import spark.Spark;

import static spark.Spark.post;

public class LocalMatchingService {

    public static void main(String[] args) {
        Spark.port(50130);
        addRoutes();
    }

    private static void addRoutes() {
        post("/stub-matching/matching-service/POST", (req, res) -> {
            res.type("application/json");
            return "{\"result\":\"match\"}";
        });
        post("/stub-matching/unknown-user/POST", (req, res) -> {
            res.type("application/json");
            return "{\"result\":\"success\"}";
        });
    }

    public static void shutdown(){
        Spark.stop();
    }
}
