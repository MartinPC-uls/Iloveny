package mongodb;

import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Connection {
	
	private String password = "123";
	private String uri = "mongodb+srv://Iloveny_dev:" + password + "@iloveny.hfkrx.mongodb.net/?retryWrites=true&w=majority";
	
	public boolean tryConnection() {
	    try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase("Iloveny");
	        MongoCollection<Document> collection = database.getCollection("articulo");
	        @SuppressWarnings("unused")
	        Document doc = collection.find(eq("_id", 1)).first();
	        return true;
	    } catch (Exception e){
	    	return false;
	    }
 	}
}
