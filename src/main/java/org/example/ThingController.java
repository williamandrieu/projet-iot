package org.example;

import org.example.core.Template;
import org.example.models.HomeSystem;
import org.example.models.Light;
import org.example.models.Thing;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThingController {


    public String detail(Request request, Response response){

        List<Thing> thingList =  HomeSystem.getInstance().getThings();
        Integer idThing = Integer.parseInt(request.params(":id"));
        Integer index = idThing - 1;

        Light light = (Light) thingList.get(index);


        //Handle toggle

        String action =  request.queryParamOrDefault("action", "");
        if (action.equals("toggle")) {
            light.setLightOn(!light.isLightOn());
            light.click();
        }

        System.out.println(thingList);


        Map<String, Object> map = new HashMap<>();

        map.put("id",idThing);
        map.put("light", light);

        return Template.render("thing.html", map);
    }
}
