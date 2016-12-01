/**
 * Created by rmanchi on 27/11/2016.
 */


package skeleton;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherAPI_For_Main_Weather {
@JsonProperty("all")
private int all;

public WeatherAPI_For_Main_Weather() {

}

public int getAll() {
    return all;
}

public void setAll(int all) {
    this.all = all;
}

}

