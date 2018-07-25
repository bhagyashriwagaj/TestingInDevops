package Com.Api.Service.api.weather;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.*;
public class WeatherApiDemo {
    public static String response=null;
    public static int totalRowNumber;
  @Test

    public void getResponse()
    {
      Response resp=given().
          header("Content-Type","application/json").
          param("id","524901" ).
          param("APPID","bee9c46f47d6097760537d0eff29a3b2").
          when().
          get("http://api.openweathermap.org/data/2.5/forecast");


        System.out.println(resp.getStatusCode());
        int statusCode=resp.getStatusCode();

        if(statusCode==200)
        {
            response=resp.asString();
            System.out.println(response);
            JsonPath v=new JsonPath(response);
            Assert.assertEquals("52", v.getString("list[1].main.humidity"));

        }else
        {
            response=null;
        }

    }
}
