package imdb;


//import com.google.gson.stream.JsonReader;

public class ratings {

	private int UMovieRating ;
	private int CMovieRating ;
	
	public int getUserRating()
	{
		return UMovieRating;
	}
	public int getCriticsRating()
	{
		return CMovieRating;
	}
	public void setUserRating(int user) 
	{
		UMovieRating = user; 
	}
	
	public void setCriticsRating(int Critics)
	{
		CMovieRating = Critics;
	}
    
	
}


