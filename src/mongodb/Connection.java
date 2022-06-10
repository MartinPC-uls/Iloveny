package mongodb;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Connection {
	/*String password = "123";
	String uri = "mongodb+srv://Iloveny_dev:" + password + "@iloveny.hfkrx.mongodb.net/?retryWrites=true&w=majority";
    try (MongoClient mongoClient = MongoClients.create(uri)) {
        MongoDatabase database = mongoClient.getDatabase("Iloveny");
        MongoCollection<Document> collection = database.getCollection("articulo");
        Document doc = collection.find(eq("_id", 1)).first();
        System.out.println(doc.toJson());
    }*/
}
