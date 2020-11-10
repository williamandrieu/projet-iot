package org.example;

import org.example.core.Conf;
import org.example.core.Template;
import org.example.middlewares.LoggerMiddleware;
import org.example.models.HomeSystem;
import org.example.models.Light;
import spark.Spark;

import java.util.HashMap;

public class App {




    public static void main(String[] args) {
        initialize();

        HomeSystem homeSystem = HomeSystem.getInstance();
        Light light = new Light();
        light.setName("Room");
        light.setLightChangeListner(HomeSystem.getInstance());
        homeSystem.addThings(light);

        light = new Light();
        light.setName("Bedroom");
        light.setLightChangeListner(HomeSystem.getInstance());
        homeSystem.addThings(light);

        HomeSystemController home = new HomeSystemController();
        ThingController thing = new ThingController();

        Spark.get("/", (req, res) -> {
            return Template.render("home.html", new HashMap<>());
        });

        Spark.get("/home", (request, response) -> home.list(request, response));


        Spark.get("/thing/:id", (request, response) ->  thing.detail(request, response));


    }

    static void initialize() {
        Template.initialize();

        // Display exceptions in logs
        Spark.exception(Exception.class, (e, req, res) -> e.printStackTrace());

        // Serve static files (img/css/js)
        Spark.staticFiles.externalLocation(Conf.STATIC_DIR.getPath());

        // Configure server port
        Spark.port(Conf.HTTP_PORT);
        final LoggerMiddleware log = new LoggerMiddleware();
        Spark.before(log::process);
    }
}
