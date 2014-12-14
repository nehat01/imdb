package imdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class insertR extends RotTamRating{
/*public static void main(String args[] ) throws IOException
{?
	//sqlfunc("abc", 10, 20);
}*/
	public void sqlfunc(String movieName, int userRating, int criticsRating , String date) throws IOException  {
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
		    System.out.println("Table AllRating Updated with " +movieName);
		    
		    stmt.execute("create table if not exists dates ( Movies varchar(100) , dates varchar(100) )");
		    if(!date.isEmpty())
		    {
		    	stmt.executeUpdate("insert into dates values ('"+movieName+"', '"+date+"' );");
		    	System.out.println("Table dates Updated with " +movieName);
		    }
		    else
		    {
		    	super.datesCount++;
		    }
		    
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

