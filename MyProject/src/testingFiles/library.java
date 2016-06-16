package testingFiles;

import java.util.ArrayList;
import java.util.List;

public class library {
	
	 public static int GetcountryName(int iteratorNumber)
		{
	    		     	
	    	List<String> countryName = new ArrayList<String>(); ;
	    	countryName.add("San Francisco");
	    	countryName.add("Los Angeles");
	    	countryName.add("Las Vegas");
	    	countryName.add("Chicago");
	    	int i;
	    	for(i = iteratorNumber; i <= countryName.size() - 1; i++){
	    		System.out.println("country name in iteration " + i + " is " + countryName.get(i) );
	    		break;
	    	}
			return iteratorNumber;
			
		}
	 
}
