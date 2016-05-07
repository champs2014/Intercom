package great.circle.json;

public class ClientObject {

	private double latitude;
	private double longitude;
	private String name;
	private String user_id;
	
	public ClientObject() {
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.name = "";
		this.user_id = "";
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
