/**
 * Created by rmanchi on 27/11/2016.
 */
package skeleton;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiJsonResponse {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String cityId;
    @JsonProperty("dt")
    private long dt;
    @JsonProperty("cod")
    private int cod;
    @JsonProperty("base")
    private String base;
    @JsonProperty("coord")
    private WeatherAPI_For_Coordinates coord;
    @JsonProperty("sys")
    private WeatherApiJsonSys sys;

    @JsonProperty("weather")
    @JsonDeserialize(contentUsing = SkipWrapperObjectDeserializer.class)
    @SkipWrapperObject("wrapper")
    private WeatherApiJsonWeather[] weather;


    public WeatherApiJsonWeather[] getWeather() {
        return weather;
    }

    public void setWeather(WeatherApiJsonWeather[] weather) {
        this.weather = weather;
    }

    @JsonProperty("main")
    private WeatherApiJsonMain main;
    @JsonProperty("wind")
    private WeatherApiJsonWind wind;
    @JsonProperty("clouds")
    private WeatherAPI_For_Main_Weather clouds;
    public WeatherAPI_For_Coordinates getCoord() {
        return coord;
    }

    public void setCoord(WeatherAPI_For_Coordinates coord) {
        this.coord = coord;
    }

    public WeatherApiJsonSys getSys() {
        return sys;
    }

    public void setSys(WeatherApiJsonSys sys) {
        this.sys = sys;
    }



    public WeatherApiJsonMain getMain() {
        return main;
    }

    public void setMain(WeatherApiJsonMain main) {
        this.main = main;
    }

    public WeatherApiJsonWind getWind() {
        return wind;
    }

    public void setWind(WeatherApiJsonWind wind) {
        this.wind = wind;
    }

    public WeatherAPI_For_Main_Weather getClouds() {
        return clouds;
    }

    public void setClouds(WeatherAPI_For_Main_Weather clouds) {
        this.clouds = clouds;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }


    public WeatherApiJsonResponse()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
