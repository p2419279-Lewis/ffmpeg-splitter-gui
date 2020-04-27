package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.mainView;

import java.io.File;

import controller.mainController;

public class ApplicationLoader extends Application {

	private mainView view;
	private int w = 525, h = 200;
	
	@Override
	public void init() {
		//create view and model and pass their references to the controller
		view = new mainView();
		//initialise models here "Model model = new Model();"
		new mainController(view);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setMinWidth(w); 
		stage.setMinHeight(h);
		stage.setX(Screen.getPrimary().getBounds().getWidth() / 2 - (w/2));
		stage.setY(Screen.getPrimary().getBounds().getHeight() / 2 - (h/2));
		stage.setTitle("FFMPEG Splitter");
		Scene scene = new Scene(view);
		stage.setScene(scene);
		//stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
		
		scene.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                } else {
                    event.consume();
                }
            }
        });
		
        scene.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    success = true;
                    String filePath = null;
                    for (File file:db.getFiles()) {
                        filePath = file.getAbsolutePath();
                        view.getMainPane().setFilepath(filePath);
                    }
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
