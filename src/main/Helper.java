package main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Helper {
	
	private Users[] UserArrays;
	private Users[] SelectedUsers;
	
	public void Run(String Website, int tabs) {
		try {
			for(int x=0;tabs>x;x++) {
				File chrome = getChromeDirectory();
				Process p = Runtime.getRuntime().exec(chrome + " --profile-directory=\" " + x +" \" \" "+ Website + " \"");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private File getChromeDirectory() {
		File chromeLoc = new File("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		return chromeLoc;
	}
	
	public String getUserDirectory() {
		return System.getProperty("user.home");
	}
	
	public void userSetup() {
		countUsers();
		createUsers();
		System.out.println(Arrays.toString(UserArrays));
	}
	
	private void countUsers() {
		File file = new File(getUserDirectory() + "\\AppData\\Local\\google\\Chrome\\User Data");
		int x = 0;
		for (File f : file.listFiles()) {
			String path = f.getPath() + "\\Google Profile.ico";
			File newFile = new File(path);
		    if (newFile.exists()) {
		        x++;
		    }        
		}
        UserArrays = new Users[x];
	}
	
	private void createUsers() {
		int x = 0;
		File file = new File(getUserDirectory() + "\\AppData\\Local\\google\\Chrome\\User Data");
		for (File f : file.listFiles()) {
			String path = f.getPath() + "\\Google Profile.ico";
			File newFile = new File(path);
		    if (newFile.exists()) {
		        Users nT = new Users(f.getName(), f.getPath());
		        UserArrays[x] = nT;
		        x++;
		    }        
		}
	}
	
	public Users[] getUserArray() {
		return UserArrays;
	}
	
	public void NewRun(String Website, int tabs, int startPosX, int StartPosY, int sizeX, int sizeY) {
		try {
			for(int x=0;tabs>x;x++) {
				File chrome = getChromeDirectory();
				Process p = Runtime.getRuntime().exec(chrome + " --profile-directory=\" " + x +" \" " +
															   " --window-position=\" " + x +" \" " +
																 " \" "+ Website + " \" ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
