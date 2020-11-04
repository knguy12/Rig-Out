package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SampleController {
	
	@FXML Label weatherUI;
	@FXML ImageView pantsView;
	@FXML ImageView shirtView;

	//Sets the weather in the UI
	public void setWeather() throws IOException {
		weatherUI.setText(new weatherChecker().getTemp());
	}
	
	//Displays only one set of outfits
	//TODO allow for users to add into their clothes into image file and let application pick shirt and pants randomly 
	public void showOutfit() {
		pantsView.setVisible(true);
		shirtView.setVisible(true);
	}
}
