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
		weatherUI.setVisible(true);
		weatherIcon.setVisible(true);
	}
	//Checks if the weather is currently hot or cold
	public String hotOrCold() throws NumberFormatException, IOException {
		weatherChecker weather = new weatherChecker();
		if(Double.parseDouble(weather.getTemp()) < 70.0)
			return "cold";
		return "hot";
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
	//Displays set of clothes based on if the user select formal, casual, lounge and whether it is hot or cold
	//TODO Add in way to detect color and determine outfits based on that
	public void showOutfit() throws NumberFormatException, IOException{
		Image pantsImage = new Image("file:..\\..\\clothesImages\\Pants\\pants_white_" + checkEvent() + "_" + hotOrCold() + "_1.jpg");
		Image shirtImage = new Image("file:..\\..\\clothesImages\\Shirts\\shirt_blue_" + checkEvent() +"_" + hotOrCold() + "_1.jpg");
		Image shoeImage = new Image("file:..\\..\\clothesImages\\Shoes\\shoe_blue_" + checkEvent() + "_1.jpg");
		Image apparelImage = new Image("file:..\\..\\clothesImages\\Apparel\\apparel_white_1.jpg");
		pantsView.setImage(pantsImage);
		shirtView.setImage(shirtImage);
		apparelView.setImage(apparelImage);
		shoeView.setImage(shoeImage);
	}
	
}
