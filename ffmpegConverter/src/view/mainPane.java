package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import view.widget.*;

public class mainPane extends GridPane {
	
	private TextField filepath = new TextField(), splitTime = new TextField("00:00:00");
	private Button btnExecute = new Button("Execute");
	
	public mainPane() {

		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10, 10, 10, 10));
		
		//content		
		GridPane fields = new GridPane();
		fields.setVgap(5);
		fields.add(new lblRight("File path: "), 0, 0);
		filepath.setMinWidth(400);
		fields.add(filepath, 1, 0);
		fields.add(new lblRight("Split at: "), 0, 1);
		splitTime.setOnMouseClicked(e -> splitTime.selectAll());
		splitTime.setOnKeyReleased(e -> {
			if (splitTime.getCaretPosition()>7) {splitTime.setText(splitTime.getText().substring(0,8));splitTime.positionCaret(8);}
			if (splitTime.getText().length()==2||splitTime.getText().length()==5) {
				splitTime.setText(splitTime.getText()+":");
				splitTime.positionCaret(splitTime.getText().length());
			}
		});
		fields.add(splitTime, 1, 1);
		
		//add content
		this.add(fields, 0, 0);
		this.add(new vboxCenter(btnExecute), 0, 1);
		
	}
	
	public void setFilepath(String path) {
		filepath.setText(path);
	}
	
	public void btnClick(EventHandler<ActionEvent> handler) {
		btnExecute.setOnAction(handler);
	}
	
	public String getFilepath() {
		return this.filepath.getText();
	}
	
	public String getTime() {
		return this.splitTime.getText();
	}
	
	public void setFilepathColor(String hexcode) {
		filepath.setStyle("-fx-control-inner-background: "+hexcode);
	}

	
	public void setTimestampColor(String hexcode) {
		splitTime.setStyle("-fx-control-inner-background: "+hexcode);
	}
	
	public boolean validateAll() {
		int tmp = 0;
		if (filepath.getText().isEmpty()) {
			this.setFilepathColor("#ffeeee");
			tmp++;
		}
		if (splitTime.getText().equals("00:00:00") || splitTime.getText().length()!=8 || splitTime.getText().charAt(2)!=':' || splitTime.getText().charAt(5)!=':') {
			this.setTimestampColor("#ffeeee");
			tmp++;
		}
		if (tmp>0) {
			return false;
		} else {
			splitTime.setStyle("#ffffff");
			filepath.setStyle("#ffffff");
			return true;
		}
	}
	
}
