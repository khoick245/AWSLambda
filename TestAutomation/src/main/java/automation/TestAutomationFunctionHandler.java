package automation;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class TestAutomationFunctionHandler implements RequestHandler<Message, Return> {

    @Override
    public Return handleRequest(Message input, Context context) {
        //context.getLogger().log("Input: ");
    		Return a = new Return();
    		a.setMessage("Hello from Lambda!" + input.getMessage());
        // TODO: implement your handler
        return a;
    }

}
