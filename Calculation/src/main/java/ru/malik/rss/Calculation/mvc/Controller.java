package ru.malik.rss.Calculation.mvc;

public class Controller {
	private static Controller controller;
	public static Controller getInstace(){
		if(controller == null){
			controller = new Controller(); 
		}
		return controller;
	}
}
