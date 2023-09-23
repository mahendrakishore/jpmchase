package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Steps {
    private static final Adapter ADAPTER = new Adapter();

    @Given("User set the uri")
    public void setUri()  {
        ADAPTER.intialSetUp();
    }
    @Given("User make a post with below data")
    public void makePosts(DataTable dt) throws JsonProcessingException {
        List<Map<String, String>> dtlm = dt.asMaps(String.class,String.class);
       ADAPTER.creatPost(dtlm);
    }

    @When("User make a posts")
    public void postAPost(){
        ADAPTER.postRestPost();
    }
}
