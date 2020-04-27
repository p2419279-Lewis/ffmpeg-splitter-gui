package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.mainMenu;
import view.mainPane;
import view.mainView;

public class mainController {
	
	//private mainModel model;
	private mainView view;
	private mainMenu menu;
	private mainPane mainpane;
	
	public mainController(mainView view) {
		
		//this.model = model;
		this.view = view;
		
		menu = view.getMainMenu();
		mainpane = view.getMainPane();
		
		this.attachEventHandlers();
		
	}
	
	private void attachEventHandlers() {
		
		mainpane.btnClick(new execute());
		
	}
	
	private class execute implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			String path = mainpane.getFilepath();
			if (path.charAt(0)=='"' ) {path=path.substring(1);}
			if (path.charAt(path.length()-1)=='"') {path=path.substring(0, path.length()-1);}
			String filetype = path.split("\\.")[path.split("\\.").length-1];
			if (mainpane.validateAll()) {
				try {
					Process process = Runtime.getRuntime().exec("ffmpeg -i \"" + path + "\" -vcodec copy -acodec copy -ss 00:00:00 -t " + mainpane.getTime()
							+ " -sn \"" + path + ".part1.\"" + filetype + " -vcodec copy -acodec copy -ss " + mainpane.getTime() + " -sn " + path + ".part2." + filetype);
					InputStream stdIn = process.getInputStream();
					InputStreamReader isr = new InputStreamReader(stdIn);
					BufferedReader br = new BufferedReader(isr);
					String line = null;
					while ((line = br.readLine()) != null) System.out.println(line);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
 	
}
