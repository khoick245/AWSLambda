package fitnessapp;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class BodypartFunction implements RequestHandler<Request, Response> {

    @Override
    public Response handleRequest(Request input, Context context) {
        //context.getLogger().log("Input: " + input);

    		final AmazonDynamoDBClient client = new AmazonDynamoDBClient(new EnvironmentVariableCredentialsProvider());
        client.withRegion(Regions.US_WEST_2); 
        final DynamoDB dynamoDB = new DynamoDB(client);

        final Table table = dynamoDB.getTable("bodypart");
        final Index index = table.getIndex("partname-index");
        final ItemCollection<QueryOutcome> items = index.query("partname", input.getPartname());

        final Response response = new Response();
        for (final Item item : items) {
            final BodyPartInfor bodyPartInfor = new BodyPartInfor();
            bodyPartInfor.setExercisename(item.getString("exercisename"));
            bodyPartInfor.setPartname(item.getString("partname"));
            response.getBodyPartInfors().add(bodyPartInfor);
        }
        return response;
    }

}
