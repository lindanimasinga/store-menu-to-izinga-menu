package co.za.izinga.menuupdater;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.io.IOException;
import java.util.Map;

public class StreamLambdaHandler implements RequestHandler<Map<String,String>, String> {

    @Override
    public String handleRequest(Map<String,String> event, Context context)
    {
        LambdaLogger logger = context.getLogger();
        String response = new String("200 OK");
        try {
            Application.main(new String[]{});
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            logger.log("ERROR:" + e.getMessage());
        }
        return response;
    }
}