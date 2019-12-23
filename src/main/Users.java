package main;

public class Users {
	
	private String profileName;
	private String pathToUser;
	
	public Users() {
		
	}
	
	public Users(String name, String path) {
		profileName = name;
		pathToUser = path;
	}
	
	public String toString() {
		String toReturn = "{Profile Name: " + profileName + ", Path: " + pathToUser + "}";
		return toReturn;
	}
	
	public String getProfileName() {
		return profileName;
	}
	
	public String getPathToUser() {
		return pathToUser;
	}
}
