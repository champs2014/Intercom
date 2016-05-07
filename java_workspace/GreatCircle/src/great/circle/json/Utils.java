package great.circle.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Utils {

	public List<ClientObject> getJson(String fileUrl) {
		Gson gson = new Gson();
		List<ClientObject> clientObjectList = new ArrayList<ClientObject>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileUrl));
    		String line = "";
    		
    		while((line = br.readLine()) != null) {
    			String trimmed = line.trim();
    			ClientObject clientObject = gson.fromJson(trimmed, ClientObject.class);
    			clientObjectList.add(clientObject);
    		}    	 
	     } catch (FileNotFoundException e) {
    		e.printStackTrace();
    	 } catch (IOException e) {
    		e.printStackTrace();
    	 }
		
		return clientObjectList;
	}	
}
