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
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;
public class WeatherApi {
    public static String response=null;
    public static int totalRowNumber;
    @Test(dataProvider="Data")

    public void getResponse(String ID, String APPID, String API)
    {


        Response resp=given().

            param("id", ID).
            param("APPID",APPID).
            when().
            get(API);

     
        int statusCode=resp.getStatusCode();
        System.out.println(resp.getStatusCode());
       Assert.assertEquals(statusCode, 200);
        if(statusCode==200)
        {
            response=resp.asString();
            System.out.println(response);
            JsonPath v=new JsonPath(response);
            Assert.assertEquals("76", v.getString("list[1].main.humidity"));
        }else
        {
            response=null;
        }


    }

    @AfterTest

    public void writeResponseInExcel(){
        try {


        GetData config= new GetData("C:\\Users\\bhagyashri.l.wagaj\\Desktop\\API_Excel\\TestData.xlsx", 0);
        for(int i=0; i<totalRowNumber; i++)
        {

                config.setCellData(response, i, 4);

        }
        }catch (Exception e) {
            System.out.println("Exception is there: "+e.getMessage());
        }

    }

@DataProvider(name="Data")
public String[][] Takedata()
{
    GetData config= new GetData("C:\\Users\\bhagyashri.l.wagaj\\Desktop\\API_Excel\\TestData.xlsx", 0);
    totalRowNumber=config.rowcount(0);

    String[][] data=new String[totalRowNumber][3];

  for(int i=0; i<totalRowNumber; i++)
  {
      data[i][0]=config.getValue(i, 0);
      data[i][1]=config.getValue(i, 1);
      data[i][2]=config.getValue(i, 2);
  }
    return data;
}

}
