package org.example.models;

import org.example.OnClickListner;

public class Light extends Thing {

    private boolean isLightOn = false;
    private OnClickListner lightChangeListner;


    @Override
    public String getTypeName() {
        return "Light";
    }

    @Override
    public String getDescription() {
        return "Light on = "+ isLightOn;
    }

    public boolean isLightOn() {
        return isLightOn;
    }

    public void setLightOn(boolean lightOn) {
        if (state == State.UNREACHABLE) return;
        isLightOn = lightOn;
        if (lightChangeListner != null) {
            lightChangeListner.onClick(this);
        }
    }
    public void click() {


    }

    public void setLightChangeListner(OnClickListner lightChangeListner) {
        this.lightChangeListner = lightChangeListner;
    }
}
