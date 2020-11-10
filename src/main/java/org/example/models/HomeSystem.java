package org.example.models;

import org.example.OnClickListner;

import java.util.ArrayList;
import java.util.List;

public class HomeSystem implements OnClickListner {

    private static HomeSystem instance;

    public static HomeSystem getInstance() {
        if (instance == null) {
            instance = new HomeSystem();
        }
        return instance;
    }

    private HomeSystem() {
        things = new ArrayList<>();
        logs = new ArrayList<>();
    }


    private final List<Thing> things;

    public List<String> getLogs() {
        return logs;
    }

    private final List<String> logs;

    public boolean addThings(Thing thing) {
        return things.add(thing);
    }

    public boolean addLogs(String message) {
        return logs.add(message);
    }


    public List<Thing> getThings() {
        return things;
    }


    @Override
    public void onClick(Light light) {
        System.out.println("CLICK LIGHT");
        this.addLogs("Light " + light.name + "update. Now light is on =" + light.isLightOn());
    }
}
