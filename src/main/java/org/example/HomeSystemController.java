package org.example;

import org.example.core.Template;
import org.example.models.HomeSystem;
import org.example.models.Light;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class HomeSystemController {

    public String list(Request request, Response response){




        Map<String, Object> map = new HashMap<>();

        map.put("things", HomeSystem.getInstance().getThings());

        return Template.render("homeSystem.html", map);
    }
}
