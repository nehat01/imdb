package imdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class insertR {
/*public static void main(String args[] ) throws IOException
{?
	//sqlfunc("abc", 10, 20);
}*/
	public void sqlfunc(String movieName, int userRating, int criticsRating) throws IOException  {
		// TODO Auto-generated method stub
		
		
				//System.out.println(movieName);
				//System.out.println(userRating);
				//System.out.println(criticsRating);
				 
				 
		try 
		{

		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdbdata","root","saroj");

		    Statement stmt = con.createStatement();

		    stmt.execute("create table if not exists AllRating ( Movies varchar(100) , UserRating int, CriticsRating int )");
		    stmt.executeUpdate("insert into AllRating values ('"+movieName+"', "+userRating+ ", "+criticsRating+" );");
		    System.out.println("Table Updated with " +movieName);
		    
		   /* ResultSet rs = stmt.executeQuery("select name from T1");
		    while (rs.next()) {
		        //int x = rs.getInt("a");
		        String s = rs.getString("name");
		        //float f = rs.getFloat("c");
		    System.out.println(s); }*/
	
	
		    
		    con.close();
		}
		    catch (Exception ex) {
			    ex.printStackTrace();
			}

}

	
}

