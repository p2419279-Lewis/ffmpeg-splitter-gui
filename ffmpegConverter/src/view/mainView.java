package view;


import javafx.scene.layout.BorderPane;

public class mainView extends BorderPane {
	
	private mainPane mainPane;
	private mainMenu menu;

	public mainView() {
		
		mainPane = new mainPane();
		menu = new mainMenu();
		this.setTop(menu);
		this.setCenter(mainPane);
		
	}
	
	public mainMenu getMainMenu() {
		return menu;
	}
	
	public mainPane getMainPane() {
		return mainPane;
	}
	
}
