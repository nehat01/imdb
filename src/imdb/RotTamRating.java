package imdb;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import imdb.ratings;
import imdb.insertR;

public class RotTamRating {
	
	static private BufferedReader obj;
	static List<String> movieList;
	static private File inputFile;
	private static ratings rt;
	public static List<ratings> lstRatings;
	public static insertR ins;
	
	RotTamRating()
	{
		lstRatings = new ArrayList<ratings>();
		
		
	}
	
	public static void main(String args[])  throws IOException
	{
	
		String value;
		String MovieName;
		int userRating;
		int criticsRating;
		
		
		inputFile = new File("movies.txt");
		ins = new insertR();
		obj = new BufferedReader(new FileReader(inputFile));
		movieList = new ArrayList<String>();
		
		while((value = obj.readLine()) != null)
		{
			if(value.isEmpty())
				continue;
			movieList.add(value);
		}
		
		for(String MovName : movieList)
		{
			//String MoviName = "The Lord of the Rings: The Fellowship of the Ring";
			MovieName = MovName.replace(' ', '+');
			System.out.println(MovieName);
			//movielist 
			ratings rt1 = MName(MovieName);
			
			if (rt1.getIsNull())
				continue;
			
			userRating = rt1.getUserRating();
			criticsRating = rt1.getCriticsRating();
	   
			ins.sqlfunc(MovName, userRating, criticsRating);	
		}
	}
	
    public static ratings MName ( String MovieName ) throws IOException
    {
    	rt = new ratings();
    	 URL url = new URL("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=gxufgzuy2keerwajtuvket5r&q="+MovieName+"&page_limit=1");
 	
 		try (InputStream is = url.openStream();
 		       JsonReader rdr = Json.createReader(is)) {
 		 
 		      JsonObject obj = rdr.readObject();
 		 
 		      JsonArray results = obj.getJsonArray("movies");
 		
 		      for (JsonObject result : results.getValuesAs(JsonObject.class)) {
 		    	  JsonObject rate = result.getJsonObject("ratings");
 		    	 rt.setUserRating(rate.getInt("audience_score"));
 		    	 System.out.println("Audience rating " +rate.getInt("audience_score"));
 		    	  
 		        rt.setCriticsRating(rate.getInt("critics_score"));
	    	    System.out.println("Critics rating " +rate.getInt("critics_score")+"Audience rating " +rate.getInt("audience_score")+"\n");                                    }
 		}
 		catch (Exception e)
 		{
 			System.out.println(e.getMessage());
 			rt.setNull(true);
 			return rt;
 		}
 		return rt;
    }
}
