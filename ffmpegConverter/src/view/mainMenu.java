package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;


public class mainMenu extends MenuBar {

	private MenuItem loadItem, saveItem, exitItem;

	public mainMenu() { 

		//temp var for menus and menu items within this MenuBar
		Menu menu;
		menu = new Menu("_File");
		loadItem = new MenuItem("_Load Student Data");
			loadItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
		menu.getItems().add(loadItem);
		saveItem = new MenuItem("_Save Student Data");
			saveItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
		menu.getItems().add(saveItem);
		menu.getItems().add( new SeparatorMenuItem());
		exitItem = new MenuItem("E_xit");
			exitItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
		menu.getItems().add(exitItem);
		this.getMenus().add(menu); 
		
	}

	//these methods allow handlers to be externally attached to this menubar and used by the controller
	public void addLoadHandler(EventHandler<ActionEvent> handler) {
		loadItem.setOnAction(handler);
	}

	public void addSaveHandler(EventHandler<ActionEvent> handler) {
		saveItem.setOnAction(handler);
	}

	public void addExitHandler(EventHandler<ActionEvent> handler) {
		exitItem.setOnAction(handler);
	}

}
