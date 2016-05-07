package great.circle.json;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreatCircle {

	public void printUsers() {
		Utils utils = new Utils();
		double officeLatitude = 53.3381985;
		double officeLongitude = -6.2592576;
		
		String fileUrl = File.listRoots()[0].getAbsolutePath() + File.separator + "Intercom" + File.separator  + "gistfile1.txt";
		List<ClientObject> clientObjectList = utils.getJson(fileUrl);
		Map<Integer, ClientObject> clientInviteObjectMap = new HashMap<Integer, ClientObject>();
		
		for (ClientObject clientObject : clientObjectList) {
			double clientDistance = coordDistance(officeLatitude, officeLongitude, clientObject.getLatitude(), clientObject.getLongitude());
			if (clientDistance <= 100.0) {
				clientInviteObjectMap.put(Integer.parseInt(clientObject.getUser_id()), clientObject);
			}
		}
		
		List<Integer> mapKeys = new ArrayList<Integer>(clientInviteObjectMap.keySet());
		Integer[] sortedId = new Integer[mapKeys.size()];
		
		for(int i = 0; i < mapKeys.size(); i++) {
			sortedId[i] = mapKeys.get(i);
		}
		
		Arrays.sort(sortedId);
		
		for (Integer key : sortedId) {
			System.out.println("USER_ID: " + key + " NAME: " + clientInviteObjectMap.get(key).getName());
		}		
	}
	
	private double coordDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
	    double earthRadius = 6371.0; // miles (or 6371.0 kilometers)
	    double dLat = Math.toRadians(latitude2-latitude1);
	    double dLng = Math.toRadians(longitude2-longitude1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2));
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    return dist;
	}
}