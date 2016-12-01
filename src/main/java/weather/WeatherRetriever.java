package weather;

import skeleton.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.ClientProtocolException;

public class WeatherRetriever {

    public static WeatherApiJsonResponse weatherApiJsonResponse = null;
    public static String retrieveByCity(String city) throws ClientProtocolException, IOException {

        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=a2ea2eae40341c8a0df500593c0d1fd8");
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;

        //use Jackson map weather Json response
        String weatherJsonString =  IOUtils.toString(in, encoding);
        ObjectMapper objectMapper = new ObjectMapper();
        weatherApiJsonResponse = objectMapper.readValue(weatherJsonString, WeatherApiJsonResponse.class);
        //get city name
        String cityName = weatherApiJsonResponse.getName();
        //get city Id
        String cityId = weatherApiJsonResponse.getCityId();
        //get longtitude
        double longtitude = weatherApiJsonResponse.getCoord().getLon();
        //get latitude
        double latitude = weatherApiJsonResponse.getCoord().getLat();
        //get country
        String country = weatherApiJsonResponse.getSys().getCountry();
        //get sun rise time
        long sunrise = weatherApiJsonResponse.getSys().getSunrise();
        //get sun set time
        long sunset = weatherApiJsonResponse.getSys().getSunset();
        //get weather response
        WeatherApiJsonWeather[] weatherObject=weatherApiJsonResponse.getWeather();
        System.out.println( "Weather Object : "+weatherObject.toString());
        //get main weather
       String mainweather=weatherObject[0].getMain();

        //get main pressure
        String pressure=String.valueOf(weatherApiJsonResponse.getMain().getPressure());
        //get main Temperature
        double tempValue = ((float)weatherApiJsonResponse.getMain().getTemp()) - 273.15f;
        String temp = String.valueOf(tempValue);
        //get main Humudity
        String humudity=String.valueOf(weatherApiJsonResponse.getMain().getHumidity());

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        //System.out.println( sdf.format(cal.getTime()) );


        String weatherData = cityName+"|"+latitude+","+longtitude+"|"+ sdf.format(cal.getTime()) +"|"+mainweather+"|"+temp+"|"+pressure+"|"+humudity;

        return weatherData;
    }


}