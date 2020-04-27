package view.widget;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class lblCenter extends Label {
	
	public lblCenter(String label) {
		
		this.setText(label);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(0, 5, 0, 0));
		
	}
	
}
