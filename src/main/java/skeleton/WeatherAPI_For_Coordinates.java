/**
 * Created by rmanchi on 27/11/2016.
 */


package skeleton;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherAPI_For_Coordinates {
    @JsonProperty("lon")
    private double lon;
    @JsonProperty("lat")
    private double lat;
    public WeatherAPI_For_Coordinates()
    {

    }
    public double getLon() {
        return lon;
    }
    public void setLon(double lon) {
        this.lon = lon;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
}

