package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.logging.LoggerFactory;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Adapter {

    private static final Context CONTEXT = new Context();
    private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    private static final String USERNAME = "TOOLSQA-Test";
    private static final String PASSWORD = "Test@@123";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;


    public void intialSetUp() {
        CONTEXT.setUrl("https://jsonplaceholder.typicode.com/");

    }

    public void creatPost(List<Map<String, String>> dtl) throws JsonProcessingException {
        PostPojoClass postPojoClass = new PostPojoClass();
        for (int i = 0; i < dtl.size(); i++) {
            postPojoClass.setUserId(dtl.get(i).get("userId"));
            postPojoClass.setId(dtl.get(i).get("id"));
            postPojoClass.setTitle(dtl.get(i).get("title"));
            postPojoClass.setBody(dtl.get(i).get("body"));
        }
        ObjectMapper om = new ObjectMapper();
        String postString = om.writeValueAsString(postPojoClass);
        CONTEXT.setRequest(postString);
    }


    public void postRestPost(){
        Response response = null;
        String uri = CONTEXT.getUrl()+"posts";
        RestAssured.baseURI = uri;
        System.out.println(uri);
        //String requestBody = CONTEXT.getRequest().toString();
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type","application/json");
        //requestSpecification.body(requestBody);
       // response = requestSpecification.post();
        response = requestSpecification.get();
        System.out.println(response.prettyPrint());
    }



    }


