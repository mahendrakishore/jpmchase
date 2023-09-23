package steps;

import io.restassured.response.Response;
import org.junit.internal.runners.InitializationError;
import org.junit.runner.Request;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private static final String RESPONSE = "RESPONSE";
    private static final String REQUEST = "RESPONSE";

    private static final String BASEURI = "BASEURI";
    ThreadLocal<Map<String,Object>> localThread = ThreadLocal.withInitial(HashMap::new);

    private  Map<String,Object>  testContextMap(){
        return localThread.get();
    }


    public void set(String key,Object value) {
        testContextMap().put(key,value);
    }
    public Object get(String key) {
        return testContextMap().get(key);
    }
    public <T> T get(String key, Class<T> clz ) {
        return clz.cast(testContextMap().get(key));
    }

    public void setResponse(Object val){
        set(RESPONSE,val);
    }
    public Response getResponse(String key){
     return (Response) get(RESPONSE);
    }

    public void setRequest(Object val){
        set(REQUEST,val);
    }

    public String getRequest(){
       return (String) get(REQUEST);
    }

    public void setUrl(String val){
        set(BASEURI,val);
    }

    public String getUrl(){
        return (String) get(BASEURI);
    }

}
