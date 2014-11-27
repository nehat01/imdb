package ParseTextFilesPackage;

import java.io.*;
import java.util.*;

public class OutputMovieNameList {
	
	static private File inputFile;
	static private File outputFile;
	static private BufferedReader obj;
	static private BufferedWriter obj1;
	static private HashMap<Integer, String> map;
	static private int capacity = 300;
	static private String line;
	
	public static void main(String args[])
	{
		String value;
		int i = 1;
		Set<String> set;
		try{
				
				map = new  HashMap<Integer, String>(capacity);
				inputFile = new File("input.txt");
				outputFile = new File("output.txt");
				obj = new BufferedReader(new FileReader(inputFile));  
				obj1 = new BufferedWriter(new FileWriter(outputFile));
				
				while((line = obj.readLine()) != null)
				{
					value = line;
					map.put(i, value);
					i++;
				}
				
				for(String s : map.values())
				{
					int ParanthesisIndex;
					String output;
					int SpaceIndex = s.indexOf(" ", 30);
					String sub = s.substring(SpaceIndex);
					
					if(sub.indexOf("(") != -1)
					{
						ParanthesisIndex = sub.indexOf("(");
						output = (String) sub.subSequence(0, ParanthesisIndex);
					}
					else
						output = sub.trim(); 
					
					System.out.println(output.trim());
					obj1.write(output.trim());
					obj1.newLine();
				}
				
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				obj.close();
				obj1.close();
			}
			catch (Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	}

}
