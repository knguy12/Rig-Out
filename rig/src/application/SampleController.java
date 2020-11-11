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
	
	//Checks which box was checked and picks and outfit with that label. If not casual is defaulted
	public String checkEvent() {
		String chosenEvent = "casual";
		if(formal.isSelected()) {
			chosenEvent = "formal";
		}
		if(casual.isSelected()) {
			chosenEvent = "casual";
		}
		if(lounge.isSelected()) {
			chosenEvent = "lounge";
		}
		return chosenEvent;
	}
	//Displays set of clothes based on if the user select formal, casual, lounge
	//TODO allow for users to add into their clothes into image file and let application pick shirt and pants randomly 
	public void showOutfit() {
		Image pantsImage = new Image("file:..\\..\\clothesImages\\pants_blue_casual_hot_1.png");
		Image shirtImage = new Image("file:..\\..\\clothesImages\\shirt_white_"+ checkEvent() +"_hot_1.jpg");
		Image shoeImage = new Image("file:..\\..\\clothesImages\\shoes_black_casual_hot_1.jpg");
		Image apparelImage = new Image("file:..\\..\\clothesImages\\watch_white_formal_hot_1.jpg");
		pantsView.setImage(pantsImage);
		shirtView.setImage(shirtImage);
		apparelView.setImage(apparelImage);
		shoeView.setImage(shoeImage);
	}
	
}
