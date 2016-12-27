import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class TesnMango {

	public static void main(String[] args) throws IOException {
		MongoClientURI uri = new MongoClientURI("mongodb://sonu.hooda:Sandeep#1234@ds021895.mlab.com:21895/sandeepdb");
		MongoClient client = new MongoClient(uri);
		DB db = client.getDB(uri.getDatabase());
		DBCollection table = db.getCollection("test");
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("atestkey", "sanhooHooda");

		DBObject myDoc  = table.findOne();

		System.out.println(myDoc.get("atestkey"));
		
		String httpsURL = "https://api.mlab.com/api/1/databases/sandeepdb/collections/test?apiKey=soblgT7uxiAE6RsBOGwI9ZuLmcCgcvh_&f={\"atestkey\":1,\"_id\":0}";
	    URL myurl = new URL(httpsURL);
	    HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
	    InputStream ins = con.getInputStream();
	    InputStreamReader isr = new InputStreamReader(ins);
	    BufferedReader in = new BufferedReader(isr);

	    String inputLine;

	    while ((inputLine = in.readLine()) != null)
	    {
	    	System.out.println(" inputLine "+inputLine);
	      System.out.println(inputLine.replaceAll("\\[", "").replaceAll("]", ""));
	    }

	    in.close();

	}

}
