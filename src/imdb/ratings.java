package imdb;


//import com.google.gson.stream.JsonReader;

public class ratings {

	private int UMovieRating ;
	private int CMovieRating ;
	public boolean isNull = false;
	
	public int getUserRating()
	{
		return UMovieRating;
	}
	
	public int getCriticsRating()
	{
		return CMovieRating;
	}
	
	public boolean getIsNull()
	{
		return isNull;
	}
	
	public void setUserRating(int user) 
	{
		UMovieRating = user; 
	}
	
	public void setCriticsRating(int Critics)
	{
		CMovieRating = Critics;
	}
    
	public void setNull(boolean input)
	{
		isNull = input;
	}
}





