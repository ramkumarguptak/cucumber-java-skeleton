/**
 * Created by rmanchi on 27/11/2016.
 */
package skeleton;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiJsonWind {
    @JsonProperty("speed")
    private double speed;
    @JsonProperty("deg")
    private double deg;
    public WeatherApiJsonWind()
    {

    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getDeg() {
        return deg;
    }
    public void setDeg(double deg) {
        this.deg = deg;
    }
}
