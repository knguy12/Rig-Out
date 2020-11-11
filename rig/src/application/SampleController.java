package application;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SampleController {
	
	@FXML Label weatherUI;
	@FXML ImageView pantsView;
	@FXML ImageView shirtView;
	@FXML ImageView shoeView;
	@FXML ImageView apparelView;
	@FXML ImageView weatherIcon;
	@FXML CheckBox formal;
	@FXML CheckBox casual;
	@FXML CheckBox lounge;

	//Sets the weather in the UI
	public void setWeather() throws IOException {
		weatherUI.setText(new weatherChecker().getTemp());
		System.out.print(new weatherChecker().getTemp());
		weatherUI.setVisible(true);
		weatherIcon.setVisible(true);
	}
	
	//Checks which boxes were not checked and removes those pieces of clothing from being an option
	public void checkEvent() {
		eventRecognizer event = new eventRecognizer();
		if(!formal.isSelected()) {
			event.removeFormalOutfits();
		}
		if(!casual.isSelected()) {
			event.removeCasualOutfits();
		}
		if(!lounge.isSelected()) {
			event.removeLoungeWear();
		}
	}
	//Displays only one set of outfits
	//TODO allow for users to add into their clothes into image file and let application pick shirt and pants randomly 
	public void showOutfit() {
		Image shirtImage = new Image("file:..\\..\\clothesImages\\pants_blue_1.png");
		Image pantsImage = new Image("file:..\\..\\clothesImages\\shirt_white_1.jpg");
		Image shoeImage = new Image("file:..\\..\\clothesImages\\shoes_black_casual_hot_1.jpg");
		Image apparelImage = new Image("file:..\\..\\clothesImages\\watch_white_formal_hot_1.jpg");
		pantsView.setImage(pantsImage);
		shirtView.setImage(shirtImage);
		apparelView.setImage(apparelImage);
		shoeView.setImage(shoeImage);
	}
	
}
