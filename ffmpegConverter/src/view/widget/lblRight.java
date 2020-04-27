package view.widget;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class lblRight extends Label {
	
	public lblRight(String label) {
		
		this.setText(label);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setAlignment(Pos.CENTER_RIGHT);
        this.setPadding(new Insets(0, 5, 0, 0));
		
	}
	
}
