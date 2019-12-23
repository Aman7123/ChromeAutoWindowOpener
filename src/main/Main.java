package main;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		try {
			GUI frame = new GUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
