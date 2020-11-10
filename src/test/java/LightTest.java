import org.example.models.Light;
import org.example.models.Thing;
import org.junit.Assert;
import org.junit.Test;

public class LightTest {


    @Test
    public void setLightOnReachableSucces(){
        Light light = new Light();
        Assert.assertFalse(light.isLightOn());
        Assert.assertEquals(Thing.State.REACHABLE, light.getState());
        light.setLightOn(true);

        Assert.assertTrue(light.isLightOn());

    }


    @Test
    public void setLightOnUnreachableSucces(){
        Light light = new Light();
        Assert.assertFalse(light.isLightOn());
        light.setState(Thing.State.UNREACHABLE);
        light.setLightOn(true);

        Assert.assertFalse(light.isLightOn());

    }
}
