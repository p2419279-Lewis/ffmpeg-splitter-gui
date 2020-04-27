package view.widget;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class vboxCenter extends VBox {
	
	public vboxCenter(Node child) {
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().add(child);
		
	}
	
}
