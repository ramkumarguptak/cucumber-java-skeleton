package skeleton;

import weather.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.String.format;
import static org.hamcrest.core.IsNot.not;

public class Stepdefs {
    private WebDriver driver;
    private String baseUrl;
    private WeatherApiJsonResponse weatherApiJsonResponse;

    @Given("^Accessing Information Without API Key Should Fail$")
    public void Accessing_Information_Without_API_Key_Should_Fail() throws Throwable {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\rmanchi\\Desktop\\Selenium Interview Prep\\Drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();
//        baseUrl = "http://openweathermap.org/current";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get(baseUrl);
//        driver.navigate().to("http://api.openweathermap.org/data/2.5/weather?q=Sydney&appid=invalid");
//        WebElement webElement=driver.findElement(By.tagName("pre"));
//        WeatherApiResponse weatherApiResponse=new WeatherApiResponse();
//        String ExpectedString= "{\"cod\":401, \"message\": \"Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.\"}";
//        System.out.println("ExpectedString is: " +ExpectedString);
//        String DisplayedString=webElement.getText();
//        System.out.println("DisplayedString is: " +DisplayedString);
//        org.junit.Assert.assertTrue(DisplayedString.equals(ExpectedString));
//        driver.close();
//        driver.quit();
    }

    @Given("^Weather Page Is Open$")
    public void Weather_Page_Is_Open() throws Throwable {
        /*System.setProperty("webdriver.gecko.driver", "C:\\Users\\rmanchi\\Desktop\\Selenium Interview Prep\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://openweathermap.org/current";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
    }

    @When("^Weather API Information Is Called For City (.*)$")
    public void Weather_API_Information_Is_Called_For_City(String city) throws Throwable {
        //driver.navigate().to(format("http://api.openweathermap.org/data/2.5/weather?q=%scd&appid=a2ea2eae40341c8a0df500593c0d1fd8", city));
        //WebElement webElement = driver.findElement(By.tagName("pre"));
        //use Jackson map weather Json response
        //String weatherJsonString = webElement.getText();
        //ObjectMapper objectMapper = new ObjectMapper();
        //weatherApiJsonResponse = objectMapper.readValue(weatherJsonString, WeatherApiJsonResponse.class);
        String outputString = WeatherRetriever.retrieveByCity(city);
        weatherApiJsonResponse = WeatherRetriever.weatherApiJsonResponse;

        File f=new File(".\\reports\\test-report\\Output.txt");
        if (!f.exists())
            f.createNewFile();

        //Writing to a file
        FileWriter w=new FileWriter(".\\target\\Output.txt", true);
        BufferedWriter out=new BufferedWriter(w);
        out.write(outputString);
        out.newLine();
        out.flush();

        System.out.println("Output : "+outputString);
    }

    @Then("^Weather API Should Return Current City (.*)$")
    public void Weather_API_Should_Return_Current_City(String city) throws Throwable {
        //get city name
        String cityName=weatherApiJsonResponse.getName();
        //get city Id
        String cityId=weatherApiJsonResponse.getCityId();
        //get longtitude
        double longtitude=weatherApiJsonResponse.getCoord().getLon();
        //get latitude
        double latitude=weatherApiJsonResponse.getCoord().getLat();
        //get country
        String country=weatherApiJsonResponse.getSys().getCountry();
        //get sun rise time
        long sunrise=weatherApiJsonResponse.getSys().getSunrise();
        //get sun set time
        long sunset=weatherApiJsonResponse.getSys().getSunset();
        //get weather response
        //ArrayList weatherObject=weatherApiJsonResponse.getWeather();
        //get main weather
       //String mainweather=weatherObject.get(0).getMain();
        //get date time
        long dt=weatherApiJsonResponse.getDt();
        //print all other information
        System.out.println("Country Name is: " +country);
        //System.out.println("Sun rise " + ConvertUnixTime.UnixTimeToDateTime(sunrise) + " Sun Set " + ConvertUnixTime.UnixTimeToDateTime(sunset));
        //System.out.println("Current Date Time is   " + ConvertUnixTime.UnixTimeToDateTime(dt));
        //System.out.println("Main weather is " + mainweather);
        System.out.println("City Name is: " +cityName);
        System.out.println("City Id is: " +cityId);
        System.out.println("City coordinate" + longtitude + "Longtitude "  + latitude + " Latitude");

        org.junit.Assert.assertEquals(cityName, city);
        /*driver.close();
        driver.quit();*/
    }

    @Then("^Weather API Temperature Should Be Dynamic$")
    public void Weather_API_Temperature_Should_Be_Dynamic() throws Throwable{
        WeatherApiJsonWeather[] weatherObject=weatherApiJsonResponse.getWeather();
        System.out.println("Address:" +weatherObject);
       /* driver.close();
        driver.quit();*/
    }




}
