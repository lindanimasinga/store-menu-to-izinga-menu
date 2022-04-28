package co.za.izinga.menuupdater;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.io.IOException;
import java.util.Map;

public class LambdaHandler implements RequestHandler<Map<String,String>, String>{

    @Override
        public String handleRequest(Map<String,String> event, Context context)
        {
            try {
                Application.main(null);
            } catch (IOException e) {
                e.printStackTrace();
                return "500 Fail";
            }
            return "200 OK";
        }

}
