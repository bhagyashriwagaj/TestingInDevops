package Com.Api.Service.api.weather;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class NewTest {
  @Test
  public void fun() {
      Response resp=given().
          auth().basic("USPandharpur", "password1").
          header("Content-Type","application/json").
          header("HIG_USERID","higGuid=054DECEB-CC56-B77C-8BCD-6489EE2D94C4,OU=People,OU=CIS,DC=thehrtford,DC=com").
          when().
          get("https://ltq-business.thehartford.com/api/billing/summaries");
      System.out.println(resp.getStatusCode());
      int statusCode=resp.getStatusCode();
  }

   /* @Test
    public void f(){

    }*/
}
